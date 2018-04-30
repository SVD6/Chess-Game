package chess;

public class Bishop extends Piece {

    public Bishop(ChessColour colour) {
        super(colour, ChessPieces.BISHOP);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        boolean result = super.isLegalMove(board, src, dest);
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - src.getColumnNumber();
        boolean Result; 
        
        if (Math.abs(deltaRow) == Math.abs(deltaCol)) {
            Result = true;
            int srcY = src.getRowNumber();
            int destY = dest.getRowNumber();
            int srcX = src.getColumnNumber();
            int destX = dest.getRowNumber();
            
            for (int i = srcY; i <= destY; i++) {
                if (board.getSquare(new Coordinate(src.getColumnNumber(), i)).isOccupied()) {
                    Result = false;
                }
            }
            
            return result && Result;
        } else {
            return false;
        }
    }
}
