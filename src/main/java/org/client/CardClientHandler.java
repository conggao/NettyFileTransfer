package org.client;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.commen.entity.EchoFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardClientHandler extends ChannelDuplexHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CardClientHandler.class);
    private int dataLength = 1024;
    public RandomAccessFile randomAccessFile;
    private int sumCountpackage = 0;
    private String filePath;

    public CardClientHandler(String filePath) {
        this.filePath = filePath;
    }

    //发送数据包
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        EchoFile msgFile = uploadFile();
        for (int i = 0; i < 5; i++) {
            ctx.writeAndFlush(msgFile);
        }
    }

    private EchoFile uploadFile() {
        try {
            File file = new File(filePath);

            randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(0);

            if ((randomAccessFile.length() % dataLength) == 0) {
                sumCountpackage = (int) (randomAccessFile.length() / dataLength);
            } else {
                sumCountpackage = (int) (randomAccessFile.length() / dataLength) + 1;
            }
            byte[] bytes = new byte[dataLength];

            LOGGER.debug("文件总长度:" + randomAccessFile.length());
            if (randomAccessFile.read(bytes) != -1) {
                EchoFile msgFile = new EchoFile();
                msgFile.setSumCountPackage(sumCountpackage);
                msgFile.setCountPackage(1);
                msgFile.setBytes(bytes);
                msgFile.setFile_md5(file.getName());
                return msgFile;


            } else {
                System.out.println("文件已经读完");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return null;
    }

    //处理服务端响应
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        if (msg instanceof EchoFile) {
            EchoFile msgEchoFile = (EchoFile) msg;
            int countPackage = msgEchoFile.getCountPackage();
            randomAccessFile.seek(countPackage * dataLength - dataLength);
            int byteLength = 0;
            // 剩余的文件长度
            long remainderFileCount = randomAccessFile.length()
                    - randomAccessFile.getFilePointer();

            LOGGER.debug("剩余文件长度:" + remainderFileCount);

            if (remainderFileCount < dataLength) {
                LOGGER.debug("小于固定长度：" + remainderFileCount);
                byteLength = (int) remainderFileCount;

            } else {
                byteLength = dataLength;
            }
            byte[] bytes = new byte[byteLength];
            if (randomAccessFile.read(bytes) != -1 && remainderFileCount > 0) {

                msgEchoFile.setCountPackage(countPackage);

                msgEchoFile.setBytes(bytes);

                ctx.writeAndFlush(msgEchoFile);
            } else {
                randomAccessFile.close();
                ctx.close();
                System.out.println("文件已经读完--------" + remainderFileCount);
            }

        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        try {
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.debug("服务器断开连接");
        randomAccessFile.close();
    }
}
