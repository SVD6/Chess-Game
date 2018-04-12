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
import java.util.List;
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

    private ChessBoard board = new ChessBoard();
    private Button[] whiteTakenSquare;
    private Button[] blackTakenSquare;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        whiteTakenSquare = new Button[16];
        blackTakenSquare = new Button[16];
        EventHandler<ActionEvent> sharedHandler = new SquareEventHandler(board);
        board.addTakenObserver(this);

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
            this.whiteTakenSquare[i] = new Button();
            whiteTakenSquare[i].setStyle("-fx-background-color: grey;");
            whiteTakenSquare[i].setMinSize(90, 45);
            whitetaken.getChildren().add(whiteTakenSquare[i]);
        }

        for (int i = 0; i < 16; i++) {
            blackTakenSquare[i] = new Button();
            blackTakenSquare[i].setStyle("-fx-background-color: grey;");
            blackTakenSquare[i].setMinSize(90, 45);
            blacktaken.getChildren().add(blackTakenSquare[i]);
        }

        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void onChanged(Change c) {
        while (c.next()) {
            if (c.wasAdded()) {
                int index = c.getFrom();
                List<Piece> pieces = c.getAddedSubList();
                for (Piece p : pieces) {
                    if (p.getColour() == ChessColour.BLACK) blackTakenSquare[index].setGraphic(new ImageView(new Image("chess/images/" + p.getImageName())));
                    else whiteTakenSquare[index].setGraphic(new ImageView(new Image("chess/images/" + p.getImageName())));
                }
            }
        }
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
        Square square = new Square(new Coordinate(button.getText()));

        if (firstClick == false) {
            secondSquare = square;
            secondButton = button;
            boolean move = board.move(firstSquare.getCoordinate(), secondSquare.getCoordinate());

            if (move == true) {
                secondButton.setGraphic(firstButton.getGraphic());
                firstButton.setGraphic(null);
            } else {
                System.out.println("False move, try again");
            }
            firstClick = true;
        } else if (firstClick == true) {
            firstSquare = square;
            firstButton = button;
            firstClick = false;
        }
    }
}
