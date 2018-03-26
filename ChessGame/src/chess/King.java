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
public class King extends Piece{
    
    public King (ChessColour colour) {
        super (colour, ChessPieces.KING);
    }
    
    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        boolean result = super.isLegalMove(board, src, dest);
                
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - src.getColumnNumber();
        boolean Result = false;
        
        if (Math.abs(deltaRow) <= 1 && Math.abs(deltaRow) <= 1) {
            Result = true;
        }
        return (Result && result);
    }
}
