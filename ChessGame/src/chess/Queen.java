package chess;

public class Queen extends Piece {

    public Queen(ChessColour colour) {
        super(colour, ChessPieces.QUEEN);
    }
    
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - src.getColumnNumber();
        boolean Result = false;

        if (Math.abs(deltaRow) <= 1 && Math.abs(deltaRow) <= 1) {
            Result = true;
        }
        return Result;
    }
}
