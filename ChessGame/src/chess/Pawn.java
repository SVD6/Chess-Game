package chess;

public class Pawn extends Piece {

    private boolean firstMove;

    public Pawn(ChessColour colour) {
        super(colour, ChessPieces.PAWN);
        this.firstMove = true;
    }

    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        if (!super.isLegalMove(board, src, dest)) {
            return false;
        }

        int deltaX = src.getColumn() - dest.getColumn();
        int deltaY = src.getRow() - dest.getRow();

        if (this.getColour() == ChessColour.BLACK && deltaY <= 0) {
            return false;
        }
        if (super.getColour() == ChessColour.WHITE && deltaY >= 0) {
            return false;
        }
        int add = 0;
        if(src.getRow() - dest.getRow() < 0 ){
            add = 1;
        }else{
            add = -1;
        }

        int deltaXabs = Math.abs(deltaX);
        int deltaYabs = Math.abs(deltaY);

        if (deltaXabs == 0 && deltaYabs == 1 & !board.getSquare(dest).isOccupied()) {
            firstMove = false;
            return true;
        }
        if (firstMove && deltaXabs == 0 && deltaYabs == 2 & !board.getSquare(dest).isOccupied()) {
            if(!board.getSquare(new Coordinate(0,src.getRowNumber()+add) ).isOccupied()){
                    
            firstMove = false;
            return true;}
        }
        if (deltaXabs == 1 && deltaYabs == 1 && board.getSquare(dest).isOccupied()) {
            firstMove = false;
            return true;
        }
        return false;
    }
}
