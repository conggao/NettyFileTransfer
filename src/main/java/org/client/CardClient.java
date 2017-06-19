package org.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class CardClient {
    public void connect(int port, String host, final String filePath) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    // ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                    // ch.pipeline().addLast(new StringEncoder());
                    // ch.pipeline().addLast(new FixedLengthFrameDecoder(100));
                    // ch.pipeline().addLast(new ChunkedWriteHandler());
                    // ch.pipeline().addLast(new StringDecoder());
                    // ch.pipeline().addLast(new CardClientHandler());
                    // ch.pipeline().addLast(new
                    // LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                    // ch.pipeline().addLast(new LengthFieldPrepender(4,false));
                    ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(null)));
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new CardClientHandler(filePath));
                }
            });
            ChannelFuture f = b.connect(host, port).sync();
            for (int i = 0; i < 10; i++) {

            }
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 7766;
        try {
            String filePath = "D://test.xlsx";
            new CardClient().connect(port, "127.0.0.1", filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
