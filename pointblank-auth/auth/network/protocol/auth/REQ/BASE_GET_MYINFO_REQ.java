/*
 * Point Blank Emulador
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Authors: Henrique Rodrigues
 * Copyright (C) 2016-2018
 */

package auth.network.protocol.auth.REQ;

import core.models.*;
import core.network.*;
import auth.manager.*;
import auth.network.protocol.auth.ACK.*;
import auth.network.protocol.game.ACK.*;

public class BASE_GET_MYINFO_REQ extends auth.network.protocol.AuthPacketREQ
{
	public BASE_GET_MYINFO_REQ(int opcode)
	{
		super(opcode);
	}
	@Override
	public void readImpl()
	{
	}
	@Override
	public void runImpl()
	{
		try
		{
			Player p = client.player;
			if (p != null)
			{
				AccountManager ac = AccountManager.gI();
				if (ac.WAITING.containsKey(client.id))
					ac.WAITING.replace(client.id, client);
				else
					ac.WAITING.put(client.id, client);
				if (!ac.receivered)
				{
					Connection c = GameServerManager.gI().conn;
					if (c != null)
						c.sendPacket(new RECEIVE_PLAYER_CHANNEL_ACK());
					ac.receivered = true;
				}
				sendPacket(new BASE_GET_MYINFO_ACK(p, 0));
			}
			else
			{
				sendPacket(new BASE_GET_MYINFO_ACK(null, 0x80000000));
			}
		}
		catch (Exception e)
		{
			sendPacket(new BASE_GET_MYINFO_ACK(null, 0x80000000));
		}
	}
}