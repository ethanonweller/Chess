
public class Knight extends Piece{
	
	public Knight(int color) {
		this.color = color;
	}
	
	boolean isValidMove(Move move, Board board) {
		
		int row = move.sr;
		int col = move.sc;
		int maxMoves = 0;
		
		// rules for knight
		// if move is up and left
		if (Math.abs(move.sr - move.dr) == 2 && (move.sc - move.dc == 1))
			while(maxMoves <= 4) {
				if (row == move.sr)
					col--;
				row--;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is up and right
		if (Math.abs(move.sr - move.dr) == 2 && (move.dc - move.sc == 1))
			while(maxMoves <= 4) {
				if (row == move.sr)
					col++;
				row--;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is down and left
		if (Math.abs(move.sr - move.dr) == 2 && (move.sc - move.dc == 1))
			while(maxMoves <= 4) {
				if (row == move.sr)
					col--;
				row++;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is down and right
		if (Math.abs(move.sr - move.dr) == 2 && Math.abs(move.sc - move.dc) == 1)
			while(maxMoves <= 4) {
				if (row == move.sr)
					col++;
				row++;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is left and up
		if (Math.abs(move.sr - move.dr) == 1 && Math.abs(move.sc - move.dc) == 2)
			while(maxMoves <= 4) {
				if (col == move.sc)
					row--;
				col++;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is left and down
		if (Math.abs(move.sr - move.dr) == 1 && Math.abs(move.sc - move.dc) == 2)
			while(maxMoves <= 4) {
				if (col == move.sc)
					row++;
				col--;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is right and up
		if (Math.abs(move.sr - move.dr) == 1 && Math.abs(move.sc - move.dc) == 2)
			while(maxMoves <= 4) {
				if (col == move.sc)
					row--;
				col++;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		maxMoves = 0;
		row = move.sr;
		col = move.sc;
		// if move is right and down
		if (Math.abs(move.sr - move.dr) == 1 && Math.abs(move.sc - move.dc) == 2)
			while(maxMoves <= 4) {
				if (col == move.sc)
					row++;
				col++;
				if (row == move.dr && col == move.dc)
					return true;
				maxMoves++;
			}
		
	return false;
	}

}
