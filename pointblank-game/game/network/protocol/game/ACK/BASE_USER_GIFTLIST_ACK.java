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

package game.network.protocol.game.ACK;

import game.network.protocol.*;

public class BASE_USER_GIFTLIST_ACK extends GamePacketACK
{
	public BASE_USER_GIFTLIST_ACK()
	{
		super(true);
	}
	@Override
	public void writeImpl()
	{
		WriteD(date.getDateTime());
		WriteD(0);
		WriteD(0);
		WriteD(1);
		WriteD(0);
	}
}