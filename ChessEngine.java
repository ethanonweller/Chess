/***************************************/
/* Ethan Moran-Onweller
/* CIS 163 02
/* 03/04/2022
/* Knight was not working during demo, fixed.
/***************************************/
public class ChessEngine {
	View view = new View();
	Board board = new Board();
	int turn = 0;
	int currentPlayer;
	
	public ChessEngine() {
		board.placeAllPieces();
		view.showIntroText();
		gameLoop();
	}
	
	public static void main(String[] args) {
		ChessEngine engine = new ChessEngine();
		engine.gameLoop();
	}
	
	public void gameLoop() { // TODO loop game using checkmate condition
		
		while (true) {
			view.displayBoard(board);
			if (turn == 0 || turn % 2 == 0)
				currentPlayer = Piece.WHITE;
			else
				currentPlayer = Piece.BLACK;
			
			Move m = view.getMove();
//			
//			while(board.isCheck(currentPlayer, m, board)) {
//			board.showMSG();
//			view.getMove();
//			}
			while(!board.isValidMove(m, currentPlayer)) {	// if invalid move based on non-piece specific logic: is space empty or are you moving opponent's piece
				board.showMSG();
				view.getMove();
			}

			while (!board.movePiece(m, board)) {			// if invalid move based on piece specific logic
				board.showMSG();
				view.getMove();
			}
			
			System.out.println("\n\n\n\n\n\n\n");
			turn++;											// changes to other player's turn
		}
	}
}
