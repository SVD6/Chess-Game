package chess;

import javafx.scene.layout.GridPane;

public class NewChessBoard extends GridPane {

    private NewSquare board[][];
    private ChessColour activeColour;
    private int fullMove;

    public NewChessBoard() {
        board = new NewSquare[8][8];
        int color = 1;
        for (int c = 0; c < 8; c++) {
            for (int r = 0; r < 8; r++) {
                board[c][r] = new NewSquare(c, r, null);
                if (color == 1) {
                    board[c][r].setStyle("-fx-background-color: grey;");
                }
                color = color == 1 ? 0 : 1;
            }
            color = color == 1 ? 0 : 1;
        }
        activeColour = ChessColour.WHITE;
        fullMove = 1;
    }

    public void Reset() {
        //White Rows
//        board[0][0].setPiece(new Rook(ChessColour.WHITE));
//        board[7][0].setPiece(new Rook(ChessColour.WHITE));
//        board[1][0].setPiece(new Knight(ChessColour.WHITE));
//        board[6][0].setPiece(new Knight(ChessColour.WHITE));
//        board[2][0].setPiece(new Bishop(ChessColour.WHITE));
//        board[5][0].setPiece(new Bishop(ChessColour.WHITE));
//        board[3][0].setPiece(new Queen(ChessColour.WHITE));
//        board[4][0].setPiece(new King(ChessColour.WHITE));

        for (int c = 0; c < 8; c++) {
            board[c][1].setPiece(new Pawn(ChessColour.WHITE));
        }

        // Black rows
//        board[0][7].setPiece(new Rook(ChessColour.BLACK));
//        board[7][7].setPiece(new Rook(ChessColour.BLACK));
//        board[1][7].setPiece(new Knight(ChessColour.BLACK));
//        board[6][7].setPiece(new Knight(ChessColour.BLACK));
//        board[2][7].setPiece(new Bishop(ChessColour.BLACK));
//        board[5][7].setPiece(new Bishop(ChessColour.BLACK));
//        board[3][7].setPiece(new Queen(ChessColour.BLACK));
//        board[4][7].setPiece(new King(ChessColour.BLACK));
        for (int c = 0; c < 8; c++) {
            board[c][6].setPiece(new Pawn(ChessColour.BLACK));
        }

        for (int c = 0; c < 8; c++) {
            for (int r = 2; r < 6; r++) {
                board[c][r].removePiece();
            }
        }
    }
}
