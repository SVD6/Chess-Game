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
    
    @Override
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        int changeInColumn = src.getColumnNumber() - dest.getColumnNumber();
        int changeInRow = src.getRowNumber() - dest.getRowNumber();

        if ((changeInColumn == 0 && changeInRow!=0)){
            int srcY = src.getRowNumber();
            int destY = dest.getRowNumber();
            boolean check = true;
            if (srcY > destY) { // Moving from Black to White. Flip it for uniform iteration
               int temp = srcY;
                srcY = destY;
                destY = temp;   
            }
            srcY++; destY--;
            for (int i=srcY; i<=destY;i++) {
                if (board.getSquare(new Coordinate(src.getColumnNumber(),i)).isOccupied()) check= false;      
            }
            
            
            return super.isLegalMove(board, src, dest) && check;}
        else if (changeInRow == 0 && changeInColumn!=0){
            int srcX = src.getColumnNumber();
            int destX = dest.getColumnNumber();
            boolean check = true;
            if (srcX > destX) { // Moving from Black to White. Flip it for uniform iteration
               int temp = srcX;
                srcX = destX;
                destX = temp;   
            }
            srcX++; destX--;
            for (int i=srcX; i<=destX;i++) {
                if (board.getSquare(new Coordinate(i,src.getRowNumber())).isOccupied()) check= false;      
            }
            
            
            return super.isLegalMove(board, src, dest) && check;}  
        else 
            return false;
        
//        switch (check){
//            case 0: return super.isLegalMove(board, src, dest);
//                
//            case 1: return super.isLegalMove(board, src, dest);
//            
//            default : return false;
//                
//            
//        }
//        if (!super.isLegalMove(board, src, dest)) return false;
//        // TBD: Can also move along the X axis!!
//        // Only along the COLUMN(Y) axis
//        if (src.getColumn() != dest.getColumn() ) return false;
//        // AND only if intermediate squares are unoccupied
//        int x = src.getColumn();
//        int srcY = src.getRow();
//        int destY = dest.getRow();
//        if (srcY > destY) { // Moving from Black to White. Flip it for uniform iteration
//           int temp = srcY;
//            srcY = destY;
//            destY = temp;   
//        }
//        srcY++; destY--;
//        for (int i=srcY; i<=destY;i++) {
//            if (board.getSquare(new Coordinate(x,i)).isOccupied()) return false;      
//        }
//        return true;
    }
}
