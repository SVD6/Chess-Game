/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sai Vikranth Desu
 */
package chess;

public class Assign1 {
    public static void main(String[] args) {
        
        ChessBoard newgame = new ChessBoard();
        System.out.println(newgame.toString());
        newgame.move(new Coordinate(1,1), new Coordinate(1,2));
        System.out.println(newgame.toString());
        newgame.move(new Coordinate(1,7), new Coordinate(0,5));

//        System.out.println(newgame.toString());
//        System.out.println(newgame.toFEN());
//        System.out.println(anotha);
//        boolean idk = newgame.move(new Coordinate(6,7), new Coordinate (6,5));
//        System.out.println(newgame.toString());
//        System.out.println(newgame.toFEN());
//        System.out.println(idk);
//        
//        Coordinate coordinates[] = new Coordinate[18];
//        Piece pieces[] = new Piece[18];
        
//        coordinates[0] = new Coordinate("a1"); 
//        pieces[0] = new Piece('R'); // White
//        coordinates[1] = new Coordinate("b1"); 
//        pieces[1] = new Piece('N');
//        coordinates[2] = new Coordinate("e1"); 
//        pieces[2] = new Piece('K');
//        coordinates[3] = new Coordinate("h1"); 
//        pieces[3] = new Piece('R');
//        coordinates[4] = new Coordinate("b2"); 
//        pieces[4] = new Piece('P');
//        coordinates[5] = new Coordinate("b5"); 
//        pieces[5] = new Piece('Q');
//        coordinates[6] = new Coordinate("a7"); 
//        pieces[6] = new Piece('p');
//        coordinates[7] = new Coordinate("b7"); 
//        pieces[7] = new Piece('p');
//        coordinates[8] = new Coordinate("c7"); 
//        pieces[8] = new Piece('p');
//        coordinates[9] = new Coordinate("d7"); 
//        pieces[9] = new Piece('p');
//        coordinates[10] = new Coordinate("e7"); 
//        pieces[10] = new Piece('p');
//        coordinates[11] = new Coordinate("f7"); 
//        pieces[11] = new Piece('p');    
//        coordinates[12] = new Coordinate("g7"); 
//        pieces[12] = new Piece('p');
//        coordinates[13] = new Coordinate("h7"); 
//        pieces[13] = new Piece('p');
//        coordinates[14] = new Coordinate("a8"); 
//        pieces[14] = new Piece('r');
//        coordinates[15] = new Coordinate("b8");
//        pieces[15] = new Piece('n');
//        coordinates[16] = new Coordinate("e8"); 
//        pieces[16] = new Piece('k');
//        coordinates[17] = new Coordinate("h8"); 
//        pieces[17] = new Piece('r'); // Black
//              
//        ChessBoard testBoard = new ChessBoard(coordinates, pieces);
//        System.out.println(testBoard.toString());
//        System.out.println(testBoard.toFEN());
    }
}
