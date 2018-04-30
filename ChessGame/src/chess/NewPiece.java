package chess;

import java.util.ArrayList;

public abstract class NewPiece {

    private ChessColour colour;
    private ChessPieces name;
    private ArrayList<MoveList> moves;

    public NewPiece(ChessColour colour, ChessPieces name) {
        this.colour = colour;
        this.name = name;
    }

    public ChessColour getColour() {
        return this.colour;
    }

    public ChessPieces getName() {
        return this.name;
    }

    public String getImageName() {
        return "chess/images/" + this.getColour().toString().toLowerCase() + "_" + this.getName().toString().toLowerCase() + ".png";
    }
    
    public ArrayList getMoves() {
        return this.moves;
    }

    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {

        if (board.getSquare(dest).isOccupied()) {
            if (!(board.getSquare(dest).getPiece().getColour() == board.getSquare(src).getPiece().getColour())) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public String toString() {
        return (getColour() + " " + getName());
    }
}
