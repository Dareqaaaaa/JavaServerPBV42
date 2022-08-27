package game.network.protocol.game.ACK;

public class MESSENGER_NOTE_SEND_ACK extends game.network.protocol.GamePacketACK
{
	protected int error;
	public MESSENGER_NOTE_SEND_ACK(int error)
	{
		super(true);
		this.error = error;
	}
	@Override
	public void writeImpl()
	{
		WriteD(error);
	}
}