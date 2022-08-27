package game.network.protocol.game.ACK;

import core.utils.*;

public class OUTPOST_AWARD_ACK extends game.network.protocol.GamePacketACK
{
	protected int sucess;
	public OUTPOST_AWARD_ACK(int sucess)
	{
		super(true);
		this.sucess = sucess;
	}
	@Override
	public void writeImpl()
	{
		WriteD(sucess);
		WriteB(NetworkUtil.hexStringToByteArray("05 e8 03 00 00 00 01 00 00 00 01 c5 98 00 fa 00 00 00 fa 00 00 00 01 01 00 00 00 f6 ad 98 00 fa 00 00 00 fa 00 00 00 02 01 00 00 00 c2 a5 98 00 fa 00 00 00 fa 00 00 00 03 01 00 00 00 c9 ac 98 00 fa 00 00 00 fa 00 00 00 04 01 00 00 00 16 b1 98 00 fa 00 00 00 fa 00 00 00 05 01 00 00 00 45 a9 98 00 fa 00 00 00 fa 00 00 00 00 02 00 00 00 75 b1 98 00 fa 00 00 00 fa 00 00 00 01 02 00 00 00 c2 c9 c9 01 fa 00 00 00 fa 00 00 00 02 02 00 00 00 f2 ad 98 00 fa 00 00 00 fa 00 00 00 03 02 00 00 00 bd a5 98 00 fa 00 00 00 fa 00 00 00 04 02 00 00 00 22 a6 98 00 fa 00 00 00 fa 00 00 00 05 02 00 00 00 12 b1 98 00 fa 00 00 00 fa 00 00 00 00 03 00 00 00 35 b4 98 00 fa 00 00 00 fa 00 00 00 02 03 00 00 00 99 b4 98 00 fa 00 00 00 fa 00 00 00 03 03 00 00 00 5d a5 98 00 fa 00 00 00 fa 00 00 00 04 03 00 00 00 c1 a5 98 00 fa 00 00 00 fa 00 00 00 06 03 00 00 00 15 b1 98 00 fa 00 00 00 fa 00 00 00 07 03 00 00 00 19 da 98 00 fa 00 00 00 fa 00 00 00 03 01 00 00 00 c9 ac 98 00 00 00 00 00 00 00 00 00 02 02 00 00 00 f2 ad 98 00 00 00 00 00 00 00 00 00 05 02 00 00 00 12 b1 98 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 05 e8 03 00 00 00 01 00 00 00 c3 89 93 03 fa 00 00 00 fa 00 00 00 01 01 00 00 00 b5 d9 98 00 fa 00 00 00 fa 00 00 00 02 01 00 00 00 f2 ad 98 00 fa 00 00 00 fa 00 00 00 03 01 00 00 00 fe 35 31 01 fa 00 00 00 fa 00 00 00 06 01 00 00 00 32 b4 98 00 fa 00 00 00 fa 00 00 00 07 01 00 00 00 a2 b2 98 00 fa 00 00 00 fa 00 00 00 00 02 00 00 00 79 98 98 00 fa 00 00 00 fa 00 00 00 01 02 00 00 00 b7 e5 f5 05 fa 00 00 00 fa 00 00 00 02 02 00 00 00 f2 34 2c 04 fa 00 00 00 fa 00 00 00 03 02 00 00 00 17 b1 98 00 fa 00 00 00 fa 00 00 00 04 02 00 00 00 be a5 98 00 fa 00 00 00 fa 00 00 00 05 02 00 00 00 25 d8 98 00 fa 00 00 00 fa 00 00 00 00 03 00 00 00 36 b4 98 00 fa 00 00 00 fa 00 00 00 01 03 00 00 00 9a b4 98 00 fa 00 00 00 fa 00 00 00 02 03 00 00 00 1d 93 93 03 fa 00 00 00 fa 00 00 00 03 03 00 00 00 f7 ad 98 00 fa 00 00 00 fa 00 00 00 05 03 00 00 00 db 98 98 00 fa 00 00 00 fa 00 00 00 09 03 00 00 00 21 c8 98 00 fa 00 00 00 fa 00 00 00 00 01 00 00 00 c3 89 93 03 00 00 00 00 00 00 00 00 01 01 00 00 00 b5 d9 98 00 00 00 00 00 00 00 00 00 02 01 00 00 00 f2 ad 98 00 00 00 00 00 00 00 00 00 03 01 00 00 00 fe 35 31 01 00 00 00 00 00 00 00 00 04 01 00 00 00 03 fa f5 05 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 05 e8 03 00 00 00 01 00 00 00 19 da 98 00 fa 00 00 00 fa 00 00 00 01 01 00 00 00 79 98 98 00 fa 00 00 00 fa 00 00 00 02 01 00 00 00 85 af 98 00 fa 00 00 00 fa 00 00 00 04 01 00 00 00 52 25 2c 04 fa 00 00 00 fa 00 00 00 05 01 00 00 00 25 d8 98 00 fa 00 00 00 fa 00 00 00 06 01 00 00 00 f2 eb f5 05 fa 00 00 00 fa 00 00 00 02 02 00 00 00 19 2f 2c 04 fa 00 00 00 fa 00 00 00 03 02 00 00 00 39 35 31 01 fa 00 00 00 fa 00 00 00 05 02 00 00 00 de 98 98 00 fa 00 00 00 fa 00 00 00 07 02 00 00 00 79 95 93 03 fa 00 00 00 fa 00 00 00 08 02 00 00 00 f4 b6 98 00 fa 00 00 00 fa 00 00 00 09 02 00 00 00 0f c3 98 00 fa 00 00 00 fa 00 00 00 00 03 00 00 00 85 93 93 03 fa 00 00 00 fa 00 00 00 02 03 00 00 00 ad d2 98 00 fa 00 00 00 fa 00 00 00 04 03 00 00 00 fb b4 98 00 fa 00 00 00 fa 00 00 00 06 03 00 00 00 d5 c3 98 00 fa 00 00 00 fa 00 00 00 08 03 00 00 00 2b c6 98 00 fa 00 00 00 fa 00 00 00 09 03 00 00 00 37 c4 98 00 fa 00 00 00 fa 00 00 00 01 02 00 00 00 52 8b 93 03 00 00 00 00 00 00 00 00 00 03 00 00 00 85 93 93 03 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"));
	}
}