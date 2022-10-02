
public class Rook extends Piece{

	public Rook(int color) {
		this.color = color;
	}
	
	boolean isValidMove(Move move, Board board) { //TODO make black rook rules / finish rook
		// rules for rooks
		// if moving up
		if (move.sr > move.dr && move.sc == move.dc)
			return true;
		
		// if moving down
		if (move.sr < move.dr && move.sc == move.dc)
			return true;
		
		// if moving left
		if (move.sr == move.dr && move.sc > move.dc)
			return true;
		
		// if moving right
		if (move.sr == move.dr && move.sc < move.dc )
			return true;
		
		return false;
	}
}
