/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author vikra
 */
public class ChessGame extends Application implements ListChangeListener {

    private ChessBoard board;
    private Button[] whiteTakenSquare;
    private Button[] blackTakenSquare;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        board = new ChessBoard();
        whiteTakenSquare = new Button[16];
        blackTakenSquare = new Button[16];
        EventHandler<ActionEvent> sharedHandler = new SquareEventHandler(board);
//        board.addTakenObserver(new ListChangeListener<Piece>());

        BorderPane root = new BorderPane();
        VBox whitetaken = new VBox();
        VBox blacktaken = new VBox();
        GridPane mainboard = new GridPane();

        Scene scene = new Scene(root, 900, 720);
        Button pieces[][] = new Button[8][8];

        mainboard.setMaxSize(720, 720);
        whitetaken.setMaxSize(90, 720);
        blacktaken.setMaxSize(90, 720);

        root.setCenter(mainboard);
        root.setLeft(whitetaken);
        root.setRight(blacktaken);

        int color = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getSquare(new Coordinate(i, j)).getPiece();
                pieces[i][j] = new Button("" + (new Coordinate(i, j)).getColumn() + (new Coordinate(i, j)).getRow());
                pieces[i][j].setMinSize(90, 90);
                if (piece != null) {
                    pieces[i][j].setGraphic(new ImageView(new Image("chess/images/" + piece.getImageName())));
                }
                pieces[i][j].setOnAction(sharedHandler);
                mainboard.add(pieces[i][j], i, 8 - j);
                if (color == 1) {
                    pieces[i][j].setStyle("-fx-background-color: grey;");
                }
                color = color == 1 ? 0 : 1;
            }
            color = color == 1 ? 0 : 1;
        }

        for (int i = 0; i < 16; i++) {
            Button temp = new Button();
            temp.setStyle("-fx-background-color: grey;");
            temp.setMinSize(90, 45);
            whitetaken.getChildren().add(temp);
        }

        for (int i = 0; i < 16; i++) {
            Button temp = new Button();
            temp.setStyle("-fx-background-color: grey;");
            temp.setMinSize(90, 45);
            blacktaken.getChildren().add(temp);
        }

        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void onChanged(Change c) {
        System.out.println("A piece was taken nigga");
    }

}

class SquareEventHandler implements EventHandler {

    private ChessBoard board;
    private boolean firstClick;
    private Square firstSquare;
    private Square secondSquare;
    private Button firstButton;
    private Button secondButton;

    public SquareEventHandler(ChessBoard board) {
        this.board = board;
        firstClick = true;
    }

    @Override
    public void handle(Event event) {
        Object source = event.getSource();
        Button button = (Button) source;
        Coordinate coordinate = new Coordinate(button.getText());
        Square square = new Square(coordinate);
        
        if (firstClick == false) {
            secondSquare = square;
            secondButton = button;
            boolean ismove = board.move(firstSquare.getCoordinate(), secondSquare.getCoordinate());
            System.out.println(ismove);
            if (ismove == true) {
                secondButton.setGraphic(firstButton.getGraphic());
                firstButton.setGraphic(null);
                firstClick = true;
                this.firstButton = null;
                this.firstSquare = null;
                this.secondButton = null;
                this.secondSquare = null;
            }
            
            else {
                System.out.println("False move, try again");
                this.firstButton = null;
                this.firstSquare = null;
                this.secondButton = null;
                this.secondSquare = null;
                firstClick = true;
            }
        }
        
        else if (firstClick == true) {
            firstSquare = square;
            firstButton = button;
            firstClick = false;
        }
        
        
        System.out.println(coordinate.toString());
    }
}
