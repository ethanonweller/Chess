import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChessTest {

	@Test
	void test_pawn() {
		Piece p = new Pawn(Piece.WHITE);
		Piece b = new Pawn(Piece.BLACK);
		Move move = new Move();
		Board board = new Board();
		
		/* WHITE PAWN TESTS */
		
		// move white pawn forward one space
		board.board[6][0] = p;
		move.sr = 6;
		move.sc = 0;
		move.dr = 5;
		move.dc = 0;
		assertEquals(true, p.isValidMove(move, board));
		
		// move white pawn forward with white piece in front
		board.board[5][0] = p;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn forward with black piece in front
		board.board[5][0] = b;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn one space to the right
		move.dr = 5;
		move.dc = 1;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn one space to the left
		board.board[5][1] = p;
		move.dr = 5;
		move.dc = 0;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn backwards one space
		move.dr = 7;
		move.dc = 0;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn backwards 2 spaces
		board.board[5][0] = p;
		move.sr = 5;
		move.sc = 0;
		move.dr = 7;
		move.dc = 0;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn diagonal right without there being a piece to capture
		move.dr = 4;
		move.dc = 1;
		assertEquals(false, p.isValidMove(move, board));
		
		
		// move white pawn diagonal right with piece of same color in capture position
		board.board[4][1] = p;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn diagonal right with black piece in capture position
		board.board[4][1] = b;
		assertEquals(true, p.isValidMove(move, board));
		
		// move white pawn diagonal left without there being a piece to capture
		board.board[6][1] = p;
		move.sr = 6;
		move.sc = 1;
		move.dr = 5;
		move.sc = 0;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn diagonal left with piece of same color in capture postion
		board.board[5][0] = p;
		assertEquals(false, p.isValidMove(move, board));
		
		// move white pawn diagonal left with black piece in capture position
		board.board[5][0] = b;
		assertEquals(false, p.isValidMove(move, board));
		
		/* BLACK PAWN TESTS */
		
		// move black pawn forward one space
		board.board[1][0] = b;
		move.sr = 1;
		move.sc = 0;
		move.dr = 2;
		move.dc = 0;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black pawn forward with white piece in front
		board.board[2][0] = p;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn forward with white piece in front
		board.board[5][0] = p;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn one space to the right
		move.dr = 5;
		move.dc = 1;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn one space to the left
		board.board[5][1] = b;
		move.dr = 5;
		move.dc = 0;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn backwards one space
		move.dr = 7;
		move.dc = 0;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn backwards 2 spaces
		board.board[5][0] = b;
		move.sr = 5;
		move.sc = 0;
		move.dr = 7;
		move.dc = 0;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn diagonal right without there being a piece to capture
		move.dr = 4;
		move.dc = 1;
		assertEquals(false, b.isValidMove(move, board));
		
		
		// move black pawn diagonal right with piece of same color in capture position
		board.board[1][1] = b;
		board.board[2][2] = b;
		move.dr = 2;
		move.dc = 2;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn diagonal right with white piece in capture position
		board.board[2][2] = p;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black pawn diagonal left without there being a piece to capture
		board.board[1][1] = b;
		move.sr = 1;
		move.sc = 1;
		move.dr = 2;
		move.dc = 0;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black pawn diagonal left with piece of same color in capture postion
		board.board[5][0] = b;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black pawn diagonal left with white piece in capture position
		board.board[5][0] = p;
		assertEquals(true, b.isValidMove(move, board));
	}
	
	@Test
	void test_king() {
		Piece k = new King(Piece.WHITE);
		Piece b = new King(Piece.BLACK);
		Move move = new Move();
		Board board = new Board();
		
		/* WHITE KING TESTS */
		// move white king forward one space
		board.board[1][4] = k;
		move.sr = 1;
		move.sc = 4;
		move.dr = 2;
		move.dc = 4;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king right one space
		move.dr = 1;
		move.dc = 5;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king down one space
		move.dr = 0;
		move.dc = 4;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king left one space
		move.dr = 1;
		move.dc = 3;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king diagonal up left
		move.dr = 2;
		move.dc = 3;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king diagonal up right
		move.dr = 2;
		move.dc = 5;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king diagonal down left
		move.dr = 0;
		move.dc = 3;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king diagonal down right
		move.dr = 0;
		move.dc = 5;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king up 2 spots
		move.dr = 3;
		move.dc = 4;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king left 2 spots
		move.dr = 1;
		move.dc = 1;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king right 2 spots
		move.dr = 1;
		move.dc = 6;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king forward 1 spot to attack piece of same color
		board.board[2][4] = k;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king forward 1 spot to attack piece of opposite color
		board.board[2][4] = b;
		move.dr = 2;
		move.dc = 4;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king right 1 spot to attack piece of same color
		board.board[1][5] = k;
		move.dr = 1;
		move.dc = 5;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king right 1 spot to attack piece of opposite color
		board.board[1][5] = b;
		move.dr = 1;
		move.dc = 5;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king left 1 spot to attack piece of same color
		board.board[1][3] = k;
		move.dr = 1;
		move.dc = 3;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king left 1 spot to attack piece of opposite color
		board.board[1][3] = b;
		move.dr = 1;
		move.dc = 3;
		assertEquals(true, k.isValidMove(move, board));
		
		// move white king down 1 spot to attack piece of same color
		board.board[0][4] = k;
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, k.isValidMove(move, board));
		
		// move white king down 1 spot to attack piece of opposite color
		board.board[0][4] = b;
		move.dr = 0;
		move.dc = 4;
		assertEquals(true, k.isValidMove(move, board));
		
		/* BLACK KING TESTS */
		
		// move black king forward one space
		board.board[1][4] = b;
		move.sr = 1;
		move.sc = 4;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king right one space
		move.dr = 1;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king down one space
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king left one space
		move.dr = 1;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king diagonal up left
		move.dr = 2;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king diagonal up right
		move.dr = 2;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king diagonal down left
		move.dr = 0;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king diagonal down right
		move.dr = 0;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king up 2 spots
		move.dr = 3;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king left 2 spots
		move.dr = 1;
		move.dc = 1;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king right 2 spots
		move.dr = 1;
		move.dc = 6;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king forward 1 spot to attack piece of same color
		board.board[2][4] = b;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king forward 1 spot to attack piece of opposite color
		board.board[2][4] = k;
		move.dr = 2;
		move.dc = 4;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king right 1 spot to attack piece of same color
		board.board[1][5] = b;
		move.dr = 1;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king right 1 spot to attack piece of opposite color
		board.board[1][5] = k;
		move.dr = 1;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king left 1 spot to attack piece of same color
		board.board[1][3] = b;
		move.dr = 1;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king left 1 spot to attack piece of opposite color
		board.board[1][3] = k;
		move.dr = 1;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black king down 1 spot to attack piece of same color
		board.board[0][4] = b;
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black king down 1 spot to attack piece of opposite color
		board.board[0][4] = k;
		move.dr = 0;
		move.dc = 4;
		assertEquals(true, b.isValidMove(move, board));
	}

	@Test
	void test_rook() {
		Piece r = new Rook(Piece.WHITE);
		Piece b = new Rook(Piece.BLACK);
		Move move = new Move();
		Board board = new Board();
		
		/* WHITE ROOK TESTS */
		
		// move white rook up 3 spaces
		board.board[4][4] = r;
		move.sr = 4;
		move.sc = 4;
		move.dr = 1;
		move.dc = 4;
		assertEquals(true, r.isValidMove(move, board));
		
		// move white rook down 3 spaces
		move.dc = 7;
		move.dr = 4;
		assertEquals(true, r.isValidMove(move, board));
		
		// move white rook left 3 spaces
		move.dr = 4;
		move.dc = 0;
		assertEquals(true, r.isValidMove(move, board));
		
		// move white rook right 3 spaces
		move.dr = 4;
		move.dc = 7;
		assertEquals(true, r.isValidMove(move, board));
		
		// move white rook diagonal up left
		move.dr = 3;
		move.dc = 3;
		assertEquals(false, r.isValidMove(move, board));
		
		// move white rook diagonal up right
		move.dr = 3;
		move.dc = 5;
		assertEquals(false, r.isValidMove(move, board));
		
		// move white rook diagonal down left
		move.dr = 5;
		move.dc = 3;
		assertEquals(false, r.isValidMove(move, board));
		
		// move white rook diagonal down right
		move.dr = 5;
		move.dc = 5;
		assertEquals(false, r.isValidMove(move, board));
		
		// move white rook up 3 with piece in path
		board.board[3][4] = r;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move white rook left 3 with piece in path
		board.board[4][2] = r;
		move.dr = 1;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move white rook right 3 with piece in path
		board.board[4][6] = r;
		move.dr = 4;
		move.dc = 7;
		assertEquals(false, board.isPathClear(move, 0));

		// move white rook down 3 with piece in path
		board.board[1][4] = r;
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		/* BLACK ROOK TESTS */
		
		// move black rook up 3 spaces
		board.board[4][4] = b;
		move.sr = 4;
		move.sc = 4;
		move.dr = 1;
		move.dc = 4;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black rook down 3 spaces
		move.dc = 7;
		move.dr = 4;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black rook left 3 spaces
		move.dr = 4;
		move.dc = 0;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black rook right 3 spaces
		move.dr = 4;
		move.dc = 7;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black rook diagonal up left
		move.dr = 3;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black rook diagonal up right
		move.dr = 3;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black rook diagonal down left
		move.dr = 5;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black rook diagonal down right
		move.dr = 5;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black rook up 3 with piece in path
		board.board[3][4] = b;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move black rook left 3 with piece in path
		board.board[4][2] = b;
		move.dr = 1;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move black rook right 3 with piece in path
		board.board[4][6] = b;
		move.dr = 4;
		move.dc = 7;
		assertEquals(false, board.isPathClear(move, 0));

		// move black rook down 3 with piece in path
		board.board[1][4] = b;
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
	}

	@Test
	void test_queen() {
		Piece q = new Queen(Piece.WHITE);
		Piece b = new Queen(Piece.BLACK);
		Move move = new Move();
		Board board = new Board();
		
		/* WHITE QUEEN RULES */
		
		// move white queen up 3 spaces
		board.board[4][4] = q;
		move.sr = 4;
		move.sc = 4;
		move.dr = 1;
		move.dc = 4;
		assertEquals(true, q.isValidMove(move, board));
		
		// move white queen down 3 spaces
		move.dc = 7;
		move.dr = 4;
		assertEquals(false, q.isValidMove(move, board));
		
		// move white queen left 3 spaces
		move.dr = 4;
		move.dc = 0;
		assertEquals(true, q.isValidMove(move, board));
		
		// move white queen right 3 spaces
		move.dr = 4;
		move.dc = 7;
		assertEquals(false, q.isValidMove(move, board));
		
		// move white queen diagonal up left
		move.dr = 3;
		move.dc = 3;
		assertEquals(true, q.isValidMove(move, board));
		
		// move white queen diagonal up right
		move.dr = 3;
		move.dc = 5;
		assertEquals(true, q.isValidMove(move, board));
		
		// move white queen diagonal down left
		move.dr = 5;
		move.dc = 3;
		assertEquals(true, q.isValidMove(move, board));
		
		// move white queen diagonal down right
		move.dr = 5;
		move.dc = 5;
		assertEquals(true, q.isValidMove(move, board));
		
		// move white queen up 3 with piece in path
		board.board[3][4] = q;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move white queen left 3 with piece in path
		board.board[4][2] = q;
		move.dr = 1;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move white queen right 3 with piece in path
		board.board[4][6] = q;
		move.dr = 4;
		move.dc = 7;
		assertEquals(false, board.isPathClear(move, 0));

		// move white queen down 3 with piece in path
		board.board[1][4] = q;
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		/* BLACK QUEEN TESTS */
		
		// move black queen up 3 spaces
		board.board[4][4] = b;
		move.sr = 4;
		move.sc = 4;
		move.dr = 1;
		move.dc = 4;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black queen down 3 spaces
		move.dc = 7;
		move.dr = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black queen left 3 spaces
		move.dr = 4;
		move.dc = 0;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black queen right 3 spaces
		move.dr = 4;
		move.dc = 7;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black queen diagonal up left
		move.dr = 3;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black queen diagonal up right
		move.dr = 3;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black queen diagonal down left
		move.dr = 5;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black queen diagonal down right
		move.dr = 5;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black queen up 3 with piece in path
		board.board[3][4] = b;
		move.dr = 2;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move black queen left 3 with piece in path
		board.board[4][2] = b;
		move.dr = 1;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move black queen right 3 with piece in path
		board.board[4][6] = b;
		move.dr = 4;
		move.dc = 7;
		assertEquals(false, board.isPathClear(move, 0));

		// move black queen down 3 with piece in path
		board.board[1][4] = b;
		move.dr = 0;
		move.dc = 4;
		assertEquals(false, board.isPathClear(move, 0));
	}

	@Test
	void test_knight() {
		Piece n = new Knight(Piece.WHITE);
		Piece b = new Knight(Piece.BLACK);
		Move move = new Move();
		Board board = new Board();
		
		/* WHITE KNIGHT TESTS */
		
		// move white knight 1 space up
		board.board[4][4] = n;
		move.sr = 4;
		move.sc = 4;
		move.dr = 5;
		move.dc = 4;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 space right
		move.dr = 4;
		move.dc = 5;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 space left
		move.dr = 4;
		move.dc = 3;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 space down
		move.dr = 5;
		move.dc = 4;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 up and 1 right
		move.dr = 3;
		move.dc = 5;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 up and 1 left
		move.dr = 3;
		move.dc = 4;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 down and 1 right
		move.dr = 5;
		move.dc = 5;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 down and 1 left
		move.dr = 5;
		move.dc = 3;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 right and 1 up
		move.dr = 3;
		move.dc = 5;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 right and 1 down
		move.dr = 5;
		move.dc = 5;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 left and 1 up
		move.dr = 3;
		move.dc = 3;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 1 left and 1 down
		move.dr = 5;
		move.dc = 3;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 2 left 1 up
		move.dr = 5;
		move.dc = 2;
		assertEquals(true, n.isValidMove(move, board));
		
		// move white knight 2 left and 1 down
		move.dr = 3;
		move.dc = 2;
		assertEquals(false, n.isValidMove(move, board));
		
		// move white knight 2 right and 1 up
		move.dr = 5;
		move.dc = 6;
		assertEquals(true, n.isValidMove(move, board));
		
		// move white knight 2 right and 1 down
		move.dr = 3;
		move.dc = 6;
		assertEquals(true, n.isValidMove(move, board));
		
		// move white knight 2 up 1 left
		move.dr = 6;
		move.dc = 3;
		assertEquals(true, n.isValidMove(move, board));
		
		// move white knight 2 up and 1 right
		move.dr = 6;
		move.dc = 5;
		assertEquals(true, n.isValidMove(move, board));
		
		// move white knight 2 down and 1 left
		move.dr = 2;
		move.dc = 3;
		assertEquals(true, n.isValidMove(move, board));
		
		// move white knight 2 down and 1 right
		move.dr = 2;
		move.dc = 5;
		assertEquals(true, n.isValidMove(move, board));
		
		/* BLACK KNIGHT TESTS */
		
		// move black knight 1 space up
		board.board[4][4] = b;
		move.sr = 4;
		move.sc = 4;
		move.dr = 5;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 space right
		move.dr = 4;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 space left
		move.dr = 4;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 space down
		move.dr = 5;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 up and 1 right
		move.dr = 3;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 up and 1 left
		move.dr = 3;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 down and 1 right
		move.dr = 5;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 down and 1 left
		move.dr = 5;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 right and 1 up
		move.dr = 3;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 right and 1 down
		move.dr = 5;
		move.dc = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 left and 1 up
		move.dr = 3;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 1 left and 1 down
		move.dr = 5;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 2 left 1 up
		move.dr = 5;
		move.dc = 2;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black knight 2 left and 1 down
		move.dr = 3;
		move.dc = 2;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black knight 2 right and 1 up
		move.dr = 5;
		move.dc = 6;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black knight 2 right and 1 down
		move.dr = 3;
		move.dc = 6;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black knight 2 up 1 left
		move.dr = 6;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black knight 2 up and 1 right
		move.dr = 6;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black knight 2 down and 1 left
		move.dr = 2;
		move.dc = 3;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black knight 2 down and 1 right
		move.dr = 2;
		move.dc = 5;
		assertEquals(true, b.isValidMove(move, board));
	}

	@Test
	void test_bishop() {
		Piece bi = new Bishop(Piece.WHITE);
		Piece b = new Bishop(Piece.BLACK);
		Move move = new Move();
		Board board = new Board();
		
		/* WHITE BISHOP TESTS */
		
		// move white bishop 1 to the right
		board.board[4][4] = bi;
		move.sr = 4;
		move.sc = 4;
		move.dr = 4;
		move.dr = 5;
		assertEquals(false, bi.isValidMove(move, board));
		
		// move white bishop 1 to the left
		move.dr = 4;
		move.dc = 3;
		assertEquals(false, bi.isValidMove(move, board));
		
		// move white bishop 1 up
		move.dr = 3;
		move.dc = 4;
		assertEquals(false, bi.isValidMove(move, board));
		
		// move white bishop 1 down
		move.dr = 5;
		move.dc = 4;
		assertEquals(false, bi.isValidMove(move, board));
		
		// move white bishop up and to the right
		move.dr = 6;
		move.dc = 6;
		assertEquals(true, bi.isValidMove(move, board));
		
		// move white bishop up and to the left
		move.dr = 6;
		move.dc = 2;
		assertEquals(true, bi.isValidMove(move, board));
		
		// move white bishop down and to the right
		move.dr = 2;
		move.dc = 6;
		assertEquals(true, bi.isValidMove(move, board));
		
		// move white bishop down and to the left
		move.dr = 2;
		move.dc = 2;
		assertEquals(true, bi.isValidMove(move, board));
		
		// move white bishop up and to the right with piece in path
		board.board[5][5] = bi;
		move.dr = 6;
		move.dc = 6;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move white bishop up and to the left with piece in path
		board.board[3][3] = bi;
		move.dr = 2;
		move.dc = 2;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move white bishop down and to the left with piece in path
		board.board[5][3] = bi;
		move.dr = 2;
		move.dc = 6;
		assertEquals(true, board.isPathClear(move, 0));
		
		// move white bishop down and to the right with piece in path
		board.board[3][3] = bi;
		move.dr = 2;
		move.dc = 2;
		assertEquals(false, board.isPathClear(move, 0));
		
		/* BLACK BISHOP TESTS */
		
		board.board[4][4] = bi;
		move.sr = 4;
		move.sc = 4;
		move.dr = 4;
		move.dr = 5;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black bishop 1 to the left
		move.dr = 4;
		move.dc = 3;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black bishop 1 up
		move.dr = 3;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black bishop 1 down
		move.dr = 5;
		move.dc = 4;
		assertEquals(false, b.isValidMove(move, board));
		
		// move black bishop up and to the right
		move.dr = 6;
		move.dc = 6;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black bishop up and to the left
		move.dr = 6;
		move.dc = 2;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black bishop down and to the right
		move.dr = 2;
		move.dc = 6;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black bishop down and to the left
		move.dr = 2;
		move.dc = 2;
		assertEquals(true, b.isValidMove(move, board));
		
		// move black bishop up and to the right with piece in path
		board.board[5][5] = b;
		move.dr = 6;
		move.dc = 6;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move black bishop up and to the left with piece in path
		board.board[3][3] = b;
		move.dr = 2;
		move.dc = 2;
		assertEquals(false, board.isPathClear(move, 0));
		
		// move black bishop down and to the left with piece in path
		board.board[5][3] = b;
		move.dr = 2;
		move.dc = 6;
		assertEquals(true, board.isPathClear(move, 0));
		
		// move black bishop down and to the right with piece in path
		board.board[3][3] = b;
		move.dr = 2;
		move.dc = 2;
		assertEquals(false, board.isPathClear(move, 0));
		
	}
}