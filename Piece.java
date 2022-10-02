
abstract public class Piece {

	// 1 is white, 2 is black
	Integer color;
	
	public static final int WHITE = 1;
	public static final int BLACK = 2;
	
	abstract boolean isValidMove(Move move, Board board);

}
