import java.util.Scanner;

public class View	{
	Move move = new Move();
	Board board = new Board();
	
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK = "\u001B[30m";

	// intro text
	public void showIntroText() {
		System.out.println("Welcome to Chess\nP1 is white, P2 is Black\nGood luck!\n");
	}

	// gets move from player in the format of: "piece, place to move piece" Ex: "d2 e2"
	public Move getMove() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter move: ");
		String moveString = input.nextLine();
		makeMove(moveString);
		return move;
	}

	// converts the user entered string to move sr, sc, dr, dc format
	public void makeMove(String moveString) { // TODO get rid of whitespace in string
		// converts source column char to int
		switch(moveString.charAt(0)) {
		case 'a': move.sc = 0;
			break;
		case 'b': move.sc = 1;
			break;
		case 'c': move.sc = 2;
			break;
		case 'd': move.sc = 3;
			break;
		case 'e': move.sc = 4;
			break;
		case 'f': move.sc = 5;
			break;
		case 'g': move.sc = 6;
			break;
		case 'h': move.sc = 7;
			break;
		default: System.out.println("Your sc was an Invalid position");
			break;
		}
		// converts source row to true location in array
		switch(Integer.parseInt(String.valueOf(moveString.charAt(1)))) {
		case 8 : move.sr = 0;
			break;
		case 7 : move.sr = 1;
			break;
		case 6 : move.sr = 2;
			break;
		case 5 : move.sr = 3;
			break;
		case 4 : move.sr = 4;
			break;
		case 3 : move.sr = 5;
			break;
		case 2 : move.sr = 6;
			break;
		case 1 : move.sr = 7;
			break;
		default: System.out.println("Your sr was an Invalid position");
			break;
		}
		// converts destination column char to int 
		switch(moveString.charAt(2)) {
		case 'a': move.dc = 0;
			break;
		case 'b': move.dc = 1;
			break;
		case 'c': move.dc = 2;
			break;
		case 'd': move.dc = 3;
			break;
		case 'e': move.dc = 4;
			break;
		case 'f': move.dc = 5;
			break;
		case 'g': move.dc = 6;
			break;
		case 'h': move.dc = 7;
			break;
		default: System.out.println("Your dc was an Invalid position");
			break;
		}
		// converts destination row to true location in array
		switch(Integer.parseInt(String.valueOf(moveString.charAt(3)))) {
		case 8 : move.dr = 0;
			break;
		case 7 : move.dr = 1;
			break;
		case 6 : move.dr = 2;
			break;
		case 5 : move.dr = 3;
			break;
		case 4 : move.dr = 4;
			break;
		case 3 : move.dr = 5;
			break;
		case 2 : move.dr = 6;
			break;
		case 1 : move.dr = 7;
			break;
		default: System.out.println("Your dr was an Invalid position");
			break;
		}
	}
	// displays the board and colors each piece accordingly
	public void displayBoard(Board board) {
		char letterCol;
		int numberRow = 8;
		System.out.print(" ");
		
		for (letterCol = 'a'; letterCol <= 'h'; ++letterCol) // prints row of letters
			System.out.print(" " + letterCol);
		
		System.out.println("\n");
		
		for(int rows = 0; rows < 8; rows++) {				 // prints column of numbers
			System.out.print(numberRow);
			numberRow--;
			System.out.print(" ");
			for (int cols = 0; cols < 8; cols++) {
				if (board.board[rows][cols] == null)
					System.out.print(". ");
				
				// if piece is a pawn
				if (board.board[rows][cols] instanceof Pawn) {
					if (board.board[rows][cols].color == 1)
					System.out.print("\u001B[37mP ");		// white colored piece
					System.out.print("\033[0m");			// reset ANSI color
					if (board.board[rows][cols].color == 2)
					System.out.print("\u001B[30mP ");		// black colored piece
					System.out.print("\033[0m");			// reset ANSI color
				}
				// if piece is a rook
				if (board.board[rows][cols] instanceof Rook) {
					if (board.board[rows][cols].color == 1)
					System.out.print("\u001B[37mR ");
					System.out.print("\033[0m");
					if (board.board[rows][cols].color == 2)
					System.out.print("\u001B[30mR ");
					System.out.print("\033[0m");
				}
				// if piece is a knight
				if (board.board[rows][cols] instanceof Knight) {
					if (board.board[rows][cols].color == 1)
					System.out.print("\u001B[37mN ");
					System.out.print("\033[0m");
					if (board.board[rows][cols].color == 2)
					System.out.print("\u001B[30mN ");
					System.out.print("\033[0m");
				}
				// if piece is a bishop
				if (board.board[rows][cols] instanceof Bishop) {
					if (board.board[rows][cols].color == 1)
					System.out.print("\u001B[37mB ");
					System.out.print("\033[0m");
					if (board.board[rows][cols].color == 2)
					System.out.print("\u001B[30mB ");
					System.out.print("\033[0m");
				}
				// if piece is a king
				if (board.board[rows][cols] instanceof King) {
					if (board.board[rows][cols].color == 1)
					System.out.print("\u001B[37mK ");
					System.out.print("\033[0m");
					if (board.board[rows][cols].color == 2)
					System.out.print("\u001B[30mK ");
					System.out.print("\033[0m");
				}
				// if piece is a queen
				if (board.board[rows][cols] instanceof Queen) {
					if (board.board[rows][cols].color == 1)
					System.out.print("\u001B[37mQ ");
					System.out.print("\033[0m");
					if (board.board[rows][cols].color == 2)
					System.out.print("\u001B[30mQ ");
					System.out.print("\033[0m");
				}
						
			}
			System.out.println("\n");
		}
	}
}
