package chess;

public class Bishop extends Piece {

    public Bishop(ChessColour colour) {
        super(colour, ChessPieces.BISHOP);
    }

    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        if (!(super.isLegalMove(board, src, dest))) {
            return false;
        }
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - src.getColumnNumber();

        if (Math.abs(deltaRow) == Math.abs(deltaCol)) {
            int srcY = src.getRowNumber();
            int destY = dest.getRowNumber();
            int srcX = src.getColumnNumber();
            int destX = dest.getRowNumber();
            int Yoffset = 0, Xoffset = 0;

            if (srcY < destY) {
                Yoffset = 1;
            } else {
                Xoffset = -1;
            }

            if (srcX < destX) {
                Xoffset = 1;
            } else {
                Xoffset = -1;
            }

            int j = srcY;

            for (int i = srcX + Xoffset; i != destX; i += Xoffset) {
                if (board.getSquare(new Coordinate(i, j)).isOccupied()) {
                    return false;
                }

                j += Yoffset;
            }

            return true;
        } else {
            return false;
        }
    }
}
