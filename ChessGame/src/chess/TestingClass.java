package chess;

public class TestingClass {

    public static void main(String[] args) {
        ChessBoard newgame = new ChessBoard();
        System.out.println(newgame.toString());
        System.out.println(newgame.getSquare(new Coordinate(1, 1)).getPiece().getImageName());
    }
}
