
public class Bishop extends Piece {

	public Bishop(int color) {
		this.color = color;
	}
	
	boolean isValidMove(Move move, Board board) {
		
		int row = move.sr;  // lets us increment move.sr without changing user input
		int col = move.sc;	// lets us increment move.sc without changing user input
		int maxMoves = 0;	// loop variable that attemps to get from sr/sc to dr/dc in max possible number of moves, 8.
		
		// rules for bishops
		// prevents moving backwards in a straight line
		if (move.sr > move.dr && move.sc == move.dc)
			return false;
		
		// prevents moving forwards in a straight line
		if (move.sr < move.dr && move.sc == move.dc)
			return false;
		
		// prevents moving left
		if (move.sr == move.dr && move.sc < move.dc)
			return false;
		
		// prevents moving right
		if (move.sr == move.dr && move.sc > move.dc)
			return false;
		
		// if move is going up and to the right is there a diagonal path from sr/sc to dr/dc?
		if (move.sr > move.dr && move.sc < move.dc)
		while (maxMoves <= 8) {
			row--;
			col++;
			if (row == move.dr && col == move.dc) 
				return true;
			maxMoves++;
		}
	
		// if move is going up and to the left is there a diagonal path from sr/sc to dr/dc
		if (move.sr > move.dr && move.sc > move.dc)
		while (maxMoves <= 8) {
			row--;
			col--;
			if (row == move.dr && col == move.dc) 
				return true;
			maxMoves++;
		}
		
		// if move is going down and to the right is there a diagonal path from sr/sc to dr/dc
		if (move.sr < move.dr && move.sc < move.dc)
		while (maxMoves <= 8) {
			row++;
			col++;
			if (row == move.dr && col == move.dc) 
				return true;
			maxMoves++;
		}
		
		// if move is going down and to the left is there a diagonal path from sr/sc to dr/dc
		if (move.sr < move.dr && move.sc > move.dc)
		while (maxMoves <= 8) {
			row++;
			col--;
			if (row == move.dr && col == move.dc) 
				return true;
			maxMoves++;
		}
			
	return false;
	}		
}