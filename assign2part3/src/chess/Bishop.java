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
public class Bishop extends Piece{
    
    public Bishop (ChessColour colour) {
        super (colour, ChessPieces.BISHOP);
    }
    
    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - src.getColumnNumber();
        boolean Result = false;
        
        if (Math.abs(deltaRow) == Math.abs(deltaCol)) {
            if (!(board.getSquare(dest).isOccupied() && (board.getSquare(dest).getPiece().getColour() == board.getSquare(src).getPiece().getColour())) || (!board.getSquare(dest).isOccupied())) {
                Result = true;
            }
        }
        return Result;
    }
}
