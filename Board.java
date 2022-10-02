
public class Board {
	Piece[][] board = new Piece[8][8];
	
	public boolean isValidMove(Move move, int currentPlayer) {
		// checks that move is not null and is the right color
		
		// if sr/sc is an empty space
	if (board[move.sr][move.sc] == null) {
		System.out.println("There is no piece at this position");
		return false;
	}
	
		// if selected piece is not current player's color
	if (board[move.sr][move.sc] != null && board[move.sr][move.sc].color != currentPlayer) {
		System.out.println("Other player's turn");
		return false;
	}
	
		// if dr/dc is player's own piece
	if (board[move.dr][move.dc] != null && board[move.dr][move.dc].color == currentPlayer) {
		System.out.println("Cannot capture your own piece");
		return false;
	}

	return true;
}
	public boolean isPathClear(Move move, int currentPlayer) {
		int deltaR = computeDeltaR(move.sr,move.dr);
		int deltaC = computeDeltaC(move.sc,move.dc);
		int row = move.sr;
		int col = move.sc;
		
		// if move is up and to the right
		if (deltaR == 1 && deltaC == 1)
			while(row != move.dr && col != move.dc) {
				row--;
				col++;
				if (board[row][col] != null) {
					if (row != move.dr && col != move.dc) {
						return false;
					}
				}
			}
			
		// if move is up 
		if (deltaR == 1 && deltaC == 0) 
			while (row != move.dr) {
				row--;
				if (board[row][move.sc] != null) 
					if (board[row][move.sc] != board[move.dr][move.dc]) 
						return false;
			}
		
		// if move is up and to the left
		if (deltaR == 1 && deltaC == - 1) 
			while (row != move.dr && col != move.dc) {
				row--;
				col--;
				if (board[row][col] != null)
					if (board[row][col] != board[move.dr][move.dc])
					return false;
			}
		
		
		// if move is down and to the right
		if (deltaR == -1 && deltaC == 1) 
			while (row != move.dr && col != move.dc) {
				row++;
				col++;
				if (board[row][col] != null) 
					if (board[row][col] != board[move.dr][move.dc])
					return false;
			}
			
		// if move is down
		if (deltaR == -1 && deltaC == 0) 
			while (row != move.dr) {
				row++;
				if (board[row][move.sc] != null) 
					if (board[row][move.sc] != board[move.dr][move.dc])
					return false;
			}
		
		
		// if move is down and to the left
		if (deltaR == -1 && deltaC == -1) 
			while(row != move.dr && col != move.dc) {
				row++;
				col--;
				if (board[row][col] != null) 
					if (board[row][col] != board[move.dr][move.dc])
					return false;
			}
		
		// if move is to the right
		if (deltaR == 0 && deltaC == 1) 
			while(col != move.dc) {
				col++;
				if (board[move.sr][col] != null) 
					if (board[move.sr][col] != board[move.dr][move.dc])
					return false;
			}
		
		// if move is to the left
		if (deltaR == 0 && deltaC == -1) 
			while(col != move.dc) {
				col--;
				if (board[move.sr][col] != null) 
					if (board[move.sr][col] != board[move.dr][move.dc])
					return false;
			}
		
		return true;
	}
	
	// checks to see the direction of row movement: up, down, or none
	public int computeDeltaR(int sr, int dr) {
		// checks to see if path is moving up the board
		if (sr-dr >= 1)
			return 1;
		// checks to see if path is not moving up or down
		if (sr-dr == 0)
			return 0;
		// checks to see if path is moving down the board
		if (sr-dr < 0)
			return -1;
		
		return 3;
	}

	// checks to see the direction of column movement: left, right, or none
	public int computeDeltaC(int sc, int dc) {
		// checks to see if path is moving right
		if (sc-dc < 0)
			return 1;
		// checks to see if path is not moving left or right
		if (sc-dc == 0)
			return 0;
		// checks to see if path is moving left
		if (sc-dc >= 1)
			return -1;
		
		return 3;
	}
	
	public void showMSG() {
		System.out.println("Invalid move, try again");
	}
	
	/* public boolean isCheck(int currentPlayer, Move move, Board b) {
		Piece[][] tempBoard = new Piece[8][8];
		for (int row = 0; row <= tempBoard.length - 1; row++)
			for (int col = 0; col <= tempBoard.length - 1; col++) {
				tempBoard[row][col] = board[row][col];
			}
		Piece atkPiece;
		Move tempMove = new Move(move);
		currentPlayer = tempBoard[tempMove.sr][tempMove.sc].color;
		tempBoard[tempMove.dr][tempMove.dc] = tempBoard[tempMove.sr][tempMove.sc];
	    tempBoard[tempMove.sr][tempMove.sc] = null;
	    
	    // stores location of white king and black king
	    int wKingRow = 0;
	    int wKingCol = 0;
	    int bKingRow = 0;
	    int bKingCol = 0;
	    
		for (int row = 0; row <= tempBoard.length - 1; row++)
			for (int col = 0; col <= tempBoard.length - 1; col++) {
				if (tempBoard[row][col] instanceof King) {
					if (tempBoard[row][col].color == Piece.WHITE) {
						wKingRow = row;
						wKingCol = col;
					}
					if (tempBoard[row][col].color == Piece.BLACK) {
						bKingRow = row;
						bKingCol = col;
					}
						
				}
			}	
		
		if (currentPlayer == Piece.WHITE) {
			for (int row = 0; row <= tempBoard.length - 1; row++)
				for (int col = 0; col <= tempBoard.length - 1; col++) {
					if (tempBoard[row][col] != null) {
						if (tempBoard[row][col].color == Piece.BLACK) {
							atkPiece = tempBoard[row][col];
							tempMove.sr = row;
							tempMove.sc = col;
							tempMove.dr = wKingRow;
							tempMove.dc = wKingCol;
							if (atkPiece.isValidMove(tempMove, b)) {
								System.out.println("You cannot put yourself in check white, try again");
								return true;
							}
		
						}
					}
					if (tempBoard[row][col] != null) {
						if (tempBoard[row][col].color == Piece.WHITE) {
							atkPiece = tempBoard[row][col];
							tempMove.sr = row;
							tempMove.sc = col;
							tempMove.dr = bKingRow;
							tempMove.dc = bKingCol;
							if (atkPiece.isValidMove(tempMove, b)) {
								System.out.print("Black king is in check");
						  }
					  }
				 }
			}
		}
		
		if (currentPlayer == Piece.BLACK) {
			for (int row = 0; row <= tempBoard.length - 1; row++)
				for (int col = 0; col <= tempBoard.length - 1; col++) {
					
					if (tempBoard[row][col] != null)
						if (tempBoard[row][col].color == Piece.WHITE) {
							atkPiece = tempBoard[row][col];
							tempMove.sr = row;
							tempMove.sc = col;
							tempMove.dr = bKingRow;
							tempMove.dc = bKingCol;
							if (atkPiece.isValidMove(tempMove, b)) {
								System.out.print("You cannot put yourself in check black, try again");
								return true;
							}
						}
					if (tempBoard[row][col] != null)
						if (tempBoard[row][col].color == Piece.BLACK) {
							atkPiece = tempBoard[row][col];
							tempMove.sr = row;
							tempMove.sc = col;
							tempMove.dr = wKingRow;
							tempMove.dc = wKingCol;
							if (atkPiece.isValidMove(tempMove, b)) {
								System.out.print("White king is in check");
							}
						}
				}
		}
	return false;
	}*/
	
	// sends board move
	public boolean movePiece(Move move, Board b) {
		  if (board[move.sr][move.sc] == null) // if youre trying to move a piece from a space that is empty
			  return false;
		  
		  Piece p = board[move.sr][move.sc];
		  if ( p.isValidMove(move, b) ) {
			  	if (!(board[move.sr][move.sc] instanceof Knight))	{	
				  if (!isPathClear(move, 0)) 
					  return false; 
				  
			  	
//				  if (isCheck(0, move, b)) 
//					   return false; // still in check, move again
			 
			  	  board[move.dr][move.dc] = board[move.sr][move.sc];
			  	  board[move.sr][move.sc] = null;
				  return true;
			  	}
			  	board[move.dr][move.dc] = board[move.sr][move.sc];
			  	board[move.sr][move.sc] = null;
			  	return true;
		  }
		 return false;
} 
	
	public void placeAllPieces() {
		// black side first row
		board[0][0] = new Rook(Piece.BLACK);
		board[0][1] = new Knight(Piece.BLACK);
		board[0][2] = new Bishop(Piece.BLACK);
		board[0][3] = new King(Piece.BLACK);
		board[0][4] = new Queen(Piece.BLACK);
		board[0][5] = new Bishop(Piece.BLACK);
		board[0][6] = new Knight(Piece.BLACK);
		board[0][7] = new Rook(Piece.BLACK);
		// black side pawn row
		for (int i = 0; i < 8; i++)
			board[1][i] = new Pawn(Piece.BLACK);
	
		// white side first row
		board[7][0] = new Rook(Piece.WHITE);
		board[7][1] = new Knight(Piece.WHITE);
		board[7][2] = new Bishop(Piece.WHITE);
		board[7][3] = new King(Piece.WHITE);
		board[7][4] = new Queen(Piece.WHITE);
		board[7][5] = new Bishop(Piece.WHITE);
		board[7][6] = new Knight(Piece.WHITE);
		board[7][7] = new Rook(Piece.WHITE);
		// white side pawn row
		for (int i = 0; i < 8; i++)
			board[6][i] = new Pawn(Piece.WHITE);
	}
}
