
public class Pawn extends Piece{
	
	public Pawn(int color) {
		this.color = color;
	}
	
	public boolean isValidMove(Move move, Board board){ 
		
		// rules for white pawns
		if (board.board[move.sr][move.sc].color == 1) { 
			
			// prevents moving more than one space forward or moving sideways
			if (move.sr - move.dr > 1 || move.sr - move.dr == 0 || move.dr - move.sr == 0) 
				return false;
			
			// prevents moving backwards
			if (move.sr < move.dr) 
				return false;
		
			// prevents moving diagonally right if space is null
			if (move.sr - move.dr == 1 && move.dc - move.sc == 1 && board.board[move.dr][move.dc] == null)
				return false;
			
			// prevents moving diagonally left if space is null
			if (move.sr - move.dr == 1 && move.sc - move.dc == 1 && board.board[move.dr][move.dc] == null)
				return false;
			
			// prevents capturing white pieces
			if (board.board[move.dr][move.dc] != null)
				if (board.board[move.dr][move.dc].color == 1)
					return false;
	
			// prevents moving on top of any piece when moving forward
			if (board.board[move.dr][move.dc] != null && move.sr - move.dr > 0 && move.sc - move.dc == 0) 
				return false;
		
			return true;
		}
			
		// rules for black pawns
		if (board.board[move.sr][move.sc].color == 2) { 
			// prevents moving more than one space forward or moving sideways
			if (move.dr - move.sr > 1 || move.dr - move.sr == 0 || move.sr - move.dr == 0)
				return false;
						
			// prevents moving backwards
			if (move.dr < move.sr) 
				return false;
					
			// prevents moving diagonally right if space is null
			if (move.dr - move.sr == 1 && move.sc - move.dc == 1 && board.board[move.dr][move.dc] == null)
				return false;
						
			// prevents moving diagonally left if space is null
			if (move.dr - move.sr == 1 && move.dc - move.sc == 1 && board.board[move.dr][move.dc] == null)
				return false;
						
			// prevents capturing black pieces
			if (board.board[move.dr][move.dc] != null)
				if (board.board[move.dr][move.dc].color == 2)
					return false;
				
			// prevents moving on top of any piece when moving forward
			if (board.board[move.dr][move.dc] != null && move.dr - move.sr > 0 && move.dc - move.sc == 0) 
				return false;
		}
		return true;
	}
}
