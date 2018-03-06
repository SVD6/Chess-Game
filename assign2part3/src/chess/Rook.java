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
public class Rook extends Piece{
    
    public Rook (ChessColour colour) {
        super (colour, ChessPieces.ROOK);
    }
    
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        int deltaRow = dest.getRowNumber() - src.getRowNumber();
        int deltaCol = dest.getColumnNumber() - src.getColumnNumber();
        boolean Result = false;
        return Result;
    }
}
