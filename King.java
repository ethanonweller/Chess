
public class King extends Piece{

	public King(int color) {
		this.color = color;
	}
	
	boolean isValidMove(Move move, Board board) {
		
		// rules for white king
		if (board.board[move.sr][move.sc].color == 1) { 
			
			// prevents moving more than one space forward
			if (move.sr - move.dr > 1)
				return false;
			
			// prevents moving left/right more than one spot
			if (move.sc - move.dc > 1 || move.dc - move.sc > 1)
				return false;
			
			// prevents moving backwards more than one spot
			if (move.dr - move.sr > 1) 
				return false;
		
			// prevents moving more than one spot diagonally right
			if (move.sr - move.dr > 1 && move.dc - move.sc > 1)
				return false;
			
			// prevents moving more than one spot diagonally left
			if (move.sr - move.dr > 1 && move.sc - move.dc > 1)
				return false;
			
			// prevents capturing white pieces
			if (board.board[move.dr][move.dc] != null)
				if (board.board[move.dr][move.dc].color == 1)
					return false;
	
			return true;
		}
			
		// rules for black king
		if (board.board[move.sr][move.sc].color == 2) { 
			// prevents moving more than one space forward
			if (move.dr - move.sr > 1)
				return false;
			
			// prevents moving left/right more than one spot
			if (move.sc - move.dc > 1 || move.dc - move.sc > 1)
				return false;
			
			// prevents moving backwards more than one spot
			if (move.sr - move.dr > 1) 
				return false;
		
			// prevents moving more than one spot diagonally right
			if (move.dr - move.sr > 1 && move.sc - move.dc > 1)
				return false;
			
			// prevents moving more than one spot diagonally left
			if (move.dr - move.sr > 1 && move.dc - move.sc > 1)
				return false;
			
			// prevents capturing black pieces
			if (board.board[move.dr][move.dc] != null)
				if (board.board[move.dr][move.dc].color == 2)
					return false;
					
		}
		return true;
	}
}
