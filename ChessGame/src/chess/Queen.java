/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import chess.Bishop;

/**
 *
 * @author Sai Vikranth Desu
 */
public class Queen extends Piece{
    
    public Queen (ChessColour colour) {
        super (colour, ChessPieces.QUEEN);
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
