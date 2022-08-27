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

package battle.network.protocol.REQ;

import core.enums.*;
import battle.controllers.*;
import battle.models.*;

public class REQUEST_PRESTART_PLAYER_REQ extends battle.network.protocol.BattlePacketREQ
{
	protected int roomId;
	protected int slot;
    public REQUEST_PRESTART_PLAYER_REQ(int opcode)
    {
        super(opcode);
    }
	@Override
	public void readImpl()
	{
		roomId = ReadD();
		slot = ReadD();
	}
	@Override
	public void runImpl()
	{
		Room r = RoomController.gI().getRoom(roomId);
		if (r != null)
		{
			Player p = r.getPlayer(slot);
			if (p != null)
			{
				p.state = SlotState.BATTLE;
				if (r.leader == slot)
				{
					//System.out.println(" Room " + r.id + " prepared. [" + r.map_name + "]");
				}
			}
		}
	}
}