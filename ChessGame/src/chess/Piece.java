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

public class Piece {
    private char shortName;
    private ChessColour colour;
    private ChessPieces name;
    private String imageName;
    
    public Piece(ChessColour colour, ChessPieces name)
    {
        this.colour = colour;
        this.name = name;
        this.shortName = name.getShortName();
        if (colour == ChessColour.BLACK) this.shortName = Character.toLowerCase(this.shortName);      
    }
        
    public ChessColour getColour() { return this.colour; }
    public ChessPieces getName() { return this.name; }
    public char getShortName ()  { return this.shortName; }
    
    public String getImageName() { return this.getColour().toString().toLowerCase() + "_" + this.getName().toString().toLowerCase() + ".png"; }
    
    public String toString() {       
        return (getColour() + " " + getName());
    }
    
    public boolean isLegalMove(ChessBoard board, Coordinate src, Coordinate dest) {
        
        if (board.getSquare(dest).isOccupied()) {
            if (!(board.getSquare(dest).getPiece().getColour() == board.getSquare(src).getPiece().getColour())) {
                return true;
            } 
            else {
                return false;
            }
        }
        else {
            return true;
        } 
    }
}

