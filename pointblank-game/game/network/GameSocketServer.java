/*
 * PointBlank Java Server
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Authors: Henrique Rodrigues
 * Copyright (C) 2015-2017
 */

package game.network;

import game.network.client.*;
import io.netty.bootstrap.*;
import io.netty.channel.*;
import io.netty.channel.nio.*;
import io.netty.channel.socket.*;
import io.netty.channel.socket.nio.*;
import io.netty.handler.logging.*;

import java.net.*;

import core.models.*;
import static io.netty.channel.ChannelOption.*;

public class GameSocketServer implements Runnable
{
	protected int id;
	protected SocketComplement sc;
	public GameSocketServer()
	{
	}
	public GameSocketServer configure(int id, SocketComplement sc) throws Exception
	{
		this.id = id;
		this.sc = sc;
		System.out.println(" ServerBootstrap bind " + sc.getAddr());
		System.out.flush();
		return this;
	}
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				NioEventLoopGroup group = new NioEventLoopGroup(sc.boss);
				NioEventLoopGroup child = new NioEventLoopGroup(sc.work);
				try
				{
					ServerBootstrap server = new ServerBootstrap();
					server.option(TCP_NODELAY, false).
					childOption(TCP_NODELAY, false).
					group(group, child).
					channel(NioServerSocketChannel.class).
					childHandler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						public void initChannel(SocketChannel channel) throws Exception
						{
							channel.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG), new GameClient(channel, id));
						}
					}).
					bind(new InetSocketAddress(InetAddress.getByName(sc.addr), sc.port)).sync().channel().closeFuture().sync();
					Thread.sleep(5000);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					try
					{
						group.shutdownGracefully().sync();
						child.shutdownGracefully().sync();
					}
					catch (Exception e)
					{
					}
				}
				System.out.println(" ServerBootstrap is trying to reconnect to " + sc.getAddr() + "... ");
				System.out.flush();
			}
		}
		catch (Exception e)
		{
		}
	}
}