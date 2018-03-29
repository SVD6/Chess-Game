/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author vikra
 */
public class test {
    
    public static void main(String[] args) {
        ChessBoard newgame = new ChessBoard();
        System.out.println(newgame.toString());
        System.out.println(newgame.getSquare(new Coordinate(1, 1)).getPiece().getImageName());
        newgame.move(new Coordinate(1,1), new Coordinate(3,1));
        System.out.println(newgame.toString());
    }
    
}
