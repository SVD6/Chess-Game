/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Sai Vikranth Desu
 */
public class Pawn extends Piece{
    
    public Pawn (ChessColour colour) {
        super (colour, ChessPieces.PAWN);
    }
    
    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        boolean result = super.isLegalMove(board, src, dest);
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - dest.getColumnNumber();
        boolean Result = false;
    
        if (board.getSquare(src).getPiece().getColour() == ChessColour.WHITE) {
            if (deltaRow == 1 && deltaCol == 0) {
                Result = true;
            }
            if (deltaRow == 2 && deltaCol == 0 && (board.getSquare(src).getRowNumber() == 1)) {
                Result = true;
            }
        }

        if (board.getSquare(src).getPiece().getColour() == ChessColour.BLACK) {
            if (deltaRow == -1 && deltaCol == 0) {
                Result = true;
            }
            if (deltaRow == -2 && deltaCol == 0 && (board.getSquare(src).getRowNumber() == 6)) {
                Result = true;
            }
        }
        return (Result && result);
    }
}
