package chess;

import chess.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ChessBoard {

    private Square board[][];
    private ChessColour activeColour;
    private int fullMove;
    private ArrayList<Piece> whiteTakenPieces;
    private ArrayList<Piece> blackTakenPieces;
    private ObservableList<Piece> whiteTakenPiece;
    private ObservableList<Piece> blackTakenPiece;

    public ChessBoard() {
        board = new Square[8][8];
        for (int c = 0; c < 8; c++) {
            for (int r = 0; r < 8; r++) {
                board[c][r] = new Square(new Coordinate(c, r));
            }
        }
        reset();
        activeColour = ChessColour.WHITE;
        fullMove = 1;
    }

    private void reset() {
        // White rows
        board[0][0].addPiece(new Rook(ChessColour.WHITE));
        board[7][0].addPiece(new Rook(ChessColour.WHITE));
        board[1][0].addPiece(new Knight(ChessColour.WHITE));
        board[6][0].addPiece(new Knight(ChessColour.WHITE));
        board[2][0].addPiece(new Bishop(ChessColour.WHITE));
        board[5][0].addPiece(new Bishop(ChessColour.WHITE));
        board[3][0].addPiece(new Queen(ChessColour.WHITE));
        board[4][0].addPiece(new King(ChessColour.WHITE));

        for (int c = 0; c < 8; c++) {
            board[c][1].addPiece(new Pawn(ChessColour.WHITE));
        }

        // Black rows
        board[0][7].addPiece(new Rook(ChessColour.BLACK));
        board[7][7].addPiece(new Rook(ChessColour.BLACK));
        board[1][7].addPiece(new Knight(ChessColour.BLACK));
        board[6][7].addPiece(new Knight(ChessColour.BLACK));
        board[2][7].addPiece(new Bishop(ChessColour.BLACK));
        board[5][7].addPiece(new Bishop(ChessColour.BLACK));
        board[3][7].addPiece(new Queen(ChessColour.BLACK));
        board[4][7].addPiece(new King(ChessColour.BLACK));

        for (int c = 0; c < 8; c++) {
            board[c][6].addPiece(new Pawn(ChessColour.BLACK));
        }

        // Middle rows : Make sure they are UNOCCUPIED by deleting
        Piece p;
        for (int c = 0; c < 8; c++) {
            for (int r = 2; r < 6; r++) {
                p = board[c][r].deletePiece();
            }
        }

        this.blackTakenPieces = new ArrayList<Piece>();
        this.whiteTakenPieces = new ArrayList<Piece>();
        blackTakenPiece = FXCollections.observableList(blackTakenPieces);
        whiteTakenPiece = FXCollections.observableList(whiteTakenPieces);
    }

    protected Square getSquare(Coordinate c) {
        return (board[c.getColumnNumber()][c.getRowNumber()]);
    }

    public boolean move(Coordinate src, Coordinate dest) {
        Square srcSquare = this.getSquare(src);
        if (!srcSquare.isOccupied()) {
            return false;
        }

        Piece p = srcSquare.getPiece();
        if (!p.getColour().equals(activeColour)) {
            return false;
        }

        if (p.isLegalMove(this, src, dest)) {
            Square destSquare = this.getSquare(dest);
            Piece takenPiece = destSquare.addPiece(p);
            if (takenPiece != null) {
                if (takenPiece.getColour() == ChessColour.BLACK) {
                    blackTakenPiece.add(takenPiece);
                } else {
                    whiteTakenPiece.add(takenPiece);
                }
            }
            srcSquare.deletePiece();
            activeColour = (activeColour == ChessColour.BLACK) ? ChessColour.WHITE : ChessColour.BLACK;
            if (activeColour == ChessColour.WHITE) {
                fullMove++;
            }
            return true;
        } else {
            return false;
        }
    }

    public void addTakenObserver(ListChangeListener listener) {
        this.blackTakenPiece.addListener(listener);
        this.whiteTakenPiece.addListener(listener);
    }

    @Override
    public String toString() {

        String s = "Board\n";
        for (int r = 7; r >= 0; r--) {
            for (int c = 0; c < 8; c++) {
                Piece p = board[c][r].getPiece();
                s += (p == null) ? " " : p.getShortName();
                s += "_";
            }
            s += "\n";
        }
        return s;
    }

    public String toFEN() {

        String s = "";
        for (int r = 7; r >= 0; r--) {
            for (int c = 0; c < 8; c++) {
                Piece p = board[c][r].getPiece();
                s += (p == null) ? " " : p.getShortName();
            }
            s += "/";
        }
        s += " " + ((activeColour == ChessColour.WHITE) ? "w" : "b");
        s += " " + fullMove;
        s += "\n";

        return s;
    }

    public String toTakenString() {
        String result = "";
        for (int i = 0; i < whiteTakenPieces.size() && whiteTakenPieces.get(i).getColour() == ChessColour.WHITE; i++) {
            result += whiteTakenPieces.get(i);
        }
        result += ",";
        for (int i = 0; i < blackTakenPieces.size() && blackTakenPieces.get(i).getColour() == ChessColour.BLACK; i++) {
            result += blackTakenPieces.get(i).getShortName();
        }
        return result;
    }
}
