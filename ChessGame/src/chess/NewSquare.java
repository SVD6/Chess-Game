package chess;

import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class NewSquare extends Button {

    private int x;
    private int y;
    private NewPiece piece;

    public NewSquare (int x, int y, NewPiece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
    
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public NewPiece getPiece() { return this.piece; }
    
    public void setPiece(NewPiece piece) {
        this.piece = piece;
        this.setGraphic(new ImageView(new Image(piece.getImageName())));
    }
    
    public NewPiece removePiece() {
        NewPiece temp = this.piece;
        piece = null;
        return temp;
    }
    
    public String getCoordinate() {
        return "" + this.x + "," + this.y;
    }
    
    public boolean isOccupied() {
        return (this.piece != null);
    }

}
