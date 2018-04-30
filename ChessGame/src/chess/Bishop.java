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
<<<<<<< HEAD
        boolean Result; 
        
=======
        boolean Result;

>>>>>>> b363033d95afa70b77311ca37530562200f17145
        if (Math.abs(deltaRow) == Math.abs(deltaCol)) {
            Result = true;
            int srcY = src.getRowNumber();
            int destY = dest.getRowNumber();
            int srcX = src.getColumnNumber();
            int destX = dest.getColumnNumber();
            int ypath = 1;
            int xpath = 1;
            if (destY < srcY) {
                ypath = -1;
            }
            if (destX < srcX) {
                xpath = -1;
            }
            srcX += xpath;

            if (srcY < destY) {
                for (int i = srcY + ypath; i < destY; i += ypath) {
                    if (board.getSquare(new Coordinate(srcX, i)).isOccupied()) {
                        Result = false;
                    }
                    srcX += xpath;
                }
            } else {
                for (int i = srcY + ypath; i > destY; i += ypath) {
                    if (board.getSquare(new Coordinate(srcX, i)).isOccupied()) {
                        Result = false;
                    }
                    srcX += xpath;
                }
            }

            return result && Result;
        } else {
            return false;
        }
    }
}
