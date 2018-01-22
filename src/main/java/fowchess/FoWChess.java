/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowchess;

import Factory.MovePatternHolder;
import Factory.TileFactory;
import Logger.Logger;
import Objects.Mob;
import Objects.Tile;
import java.util.ArrayList;
import java.util.Stack;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Sumpf
 */
public class FoWChess extends Application {

    private static Tile[][] board;//two dimensional array for the tiles
    private Label[] widthLabel;//labels for x axis
    private Label[] heightLabel;//labels for y axis
    private Tile tempTile;
    private Label tempLabel;
    private static int whoseTurn, width, height;
    private static Stack<Tile> highlightedTiles;
    private static Tile selected;//tile that is currently selected;
    private MovePatternHolder mph;
    private Mob tempMob;
    private static ArrayList<Mob> targetsForEnPassant;
    private static Logger logger;
    private static Label[] logLabel;
    private static VBox log;

    Button changebtn;
    private static boolean turnsActive;

    public void makeLabel(String text, int size) {
        tempLabel = new Label(text);
        tempLabel.setMinSize(size, size);
        tempLabel.setAlignment(Pos.CENTER);
    }

    public void makeLabel(int widthSize, int heightSize) {
        tempLabel = new Label();
        tempLabel.setMinSize(widthSize, heightSize);
        tempLabel.setAlignment(Pos.CENTER);
    }

    /**
     * generates a board
     *
     * @param width
     * @param height
     * @param size
     * @return a Gridpane that represents the board
     */
    public GridPane generateBoard(int width, int height, int size) {
        GridPane root = new GridPane();
        board = new Tile[width][height];
        widthLabel = new Label[width];
        heightLabel = new Label[height];
        //Place tiles and give them color
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tempTile = TileFactory.getInstance().makeTile(i, height - j - 1);
                board[i][height - j - 1] = tempTile;
                tempTile.setMinSize(size, size);
                root.add(tempTile, i + 2, j + 2);
                tempTile.setBackground(tempTile.getTileColor());
                tempTile.adaptBG();//this line is only here to test against nullpointers.
            }
        }
        //Place x axis labels
        for (int i = 1; i <= width; i++) {
            makeLabel(Integer.toString(i), size);
            root.add(tempLabel, i + 1, 1);
            makeLabel(Integer.toString(i), size);
            root.add(tempLabel, i + 1, height + 2);
        }
        //Place y axis labels
        for (int j = 1; j <= height; j++) {
            makeLabel(Integer.toString(j), size);
            root.add(tempLabel, 1, height - j + 2);
            makeLabel(Integer.toString(j), size);
            root.add(tempLabel, width + 2, height - j + 2);
        }

        getBoard()[3][3].setMob(new Mob(0, 3, "pawn"));
        getBoard()[2][5].setMob(new Mob(1, 3, "pawn"));
        getBoard()[4][4].setMob(new Mob(0, 3, "rook"));
        return root;
    }

    public static Tile[][] getBoard() {
        return board;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static Stack<Tile> getHighlightedTiles() {
        return highlightedTiles;
    }

    public static boolean getTurnsActive() {
        return turnsActive;
    }

    public Scene makeScene(int width, int height, int size) {
        GridPane root = generateBoard(width, height, size);
        FlowPane flo = new FlowPane();
        changebtn = new Button("Start Turn");
        makeLog(4 * size, size);
        flo.getChildren().addAll(root, log, setChangeButton(changebtn));
        Scene scene = new Scene(flo, (width + 2) * size + 200, (height + 2) * size + 50);
        return scene;
    }

    //stefan.kuhn@hotmail.com
    //s.kuhn@rafisa.ch
    //daniel.baur@outlook.de
    public Button setChangeButton(Button changebtn) {

        changebtn.setMinSize(100, 50);
        changebtn.setAlignment(Pos.CENTER);
        changebtn.setOnAction((ActionEvent event) -> {
            startTurn();
        });
        return changebtn;
    }

    public void eventHandler(Tile[][] board) {
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.setOnAction((ActionEvent event) -> {
                    System.out.println(highlightedTiles.size());
                    if (tile.isIsHighlighted()) {
                        switch (tempMob.getName()) {
                            case "pawn":
                                mph.getPawn().move(selected, tile);
                                break;
                            case "rook":
                                mph.getRook().move(selected, tile);
                                break;
                            case "bishop":
                                mph.getBishop().move(selected, tile);
                                break;
                            case "knight":
                                mph.getKnight().move(selected, tile);
                                break;
                            case "queen":
                                mph.getQueen().move(selected, tile);
                                break;
                            case "king":
                                mph.getKing().move(selected, tile);
                                break;
                            default:
                                break;
                        }
                        dehighlight();
                    } else if (highlightedTiles.isEmpty()) {
                        if (tile.getMob() != null) {
                            if ((tempMob = tile.getMob()).getOwnerId() == whoseTurn) {
                                setSelected(tile);
                                switch (tempMob.getName()) {
                                    case "pawn":
                                        mph.getPawn().highlight(tile);
                                        break;
                                    case "rook":
                                        mph.getRook().highlight(tile);
                                        break;
                                    case "bishop":
                                        mph.getBishop().highlight(tile);
                                        break;
                                    case "knight":
                                        mph.getKnight().highlight(tile);
                                        break;
                                    case "queen":
                                        mph.getQueen().highlight(tile);
                                        break;
                                    case "king":
                                        mph.getKing().highlight(tile);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    } else if (tile == selected) {
                        System.out.println("should deselect");
                        setSelected(null);
                        dehighlight();
                    }
                });
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        //set globals
        turnsActive = true;

        //JavaFX
        Scene scene = init(8, 8, 50);
        primaryStage.setTitle("FoWChess");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    public static Tile getSelected() {
        return selected;
    }

    public static void setSelected(Tile selected) {
        FoWChess.selected = selected;
    }

    /**
     * dehighlights all highlighted (blue) tiles;
     */
    public void dehighlight() {
        while (!highlightedTiles.empty()) {
            tempTile = highlightedTiles.pop();
            tempTile.adaptBG();
        }
    }

    /**
     * ends the turn by fogging the entire board
     */
    public static void endTurn() {
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.goDark();
            }
        }
    }

    /**
     * starts the turn by handing over vision to the other player and
     * propagating light;
     */
    public static void startTurn() {
        switchActivePlayer();
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.adaptLight();
                if (tile.getMob() != null){
                    tile.adaptFigurine();
                }
            }
        }
    }

    /**
     * initializes scene
     *
     * @param width: board with
     * @param height: board height
     * @param size
     * @return
     */
    public Scene init(int width, int height, int size) {
        highlightedTiles = new Stack();
        targetsForEnPassant = new ArrayList();
        this.width = width;
        this.height = height;
        this.mph = MovePatternHolder.getInstance();
        this.logger = Logger.getInstance();
        Scene returnThis = makeScene(width, height, size);
        eventHandler(board);
        whoseTurn = 0;
        mapButtons();
        return returnThis;
    }

    /**
     * Switches the active Player to the next
     */
    public static void switchActivePlayer() {
        if (whoseTurn == 0) {
            whoseTurn = 1;
        } else {
            whoseTurn = 0;
        }
    }

    public static ArrayList<Mob> getTargetsForEnPassant() {
        return targetsForEnPassant;
    }

    public void mapButtons() {
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.map();
            }
        }
    }

    public static Tile getNorth(Tile tile) {
        if (tile.getY() + 1 < height) {
            return board[tile.getX()][tile.getY() + 1];
        }
        return null;
    }

    public static Tile getEast(Tile tile) {
        if (tile.getX() + 1 < width) {
            return board[tile.getX() + 1][tile.getY()];
        }
        return null;
    }

    public static Tile getSouth(Tile tile) {
        if (tile.getY() - 1 >= 0) {
            return board[tile.getX()][tile.getY() - 1];
        }
        return null;
    }

    public static Tile getWest(Tile tile) {
        if (tile.getX() - 1 >= 0) {
            return board[tile.getX() - 1][tile.getY()];
        }
        return null;
    }

    public static Tile getNorthEast(Tile tile) {
        if (tile.getX() + 1 < width && tile.getY() + 1 < height) {
            return board[tile.getX() + 1][tile.getY() + 1];
        }
        return null;
    }

    public static Tile getNorthWest(Tile tile) {
        if (tile.getX() - 1 >= 0 && tile.getY() + 1 < height) {
            return board[tile.getX() - 1][tile.getY() + 1];
        }
        return null;
    }

    public static Tile getSouthEast(Tile tile) {
        if (tile.getX() + 1 < width && tile.getY() - 1 >= 0) {
            return board[tile.getX() + 1][tile.getY() - 1];
        }
        return null;
    }

    public static Tile getSouthWest(Tile tile) {
        if (tile.getX() - 1 >= 0 && tile.getY() - 1 >= 0) {
            return board[tile.getX() - 1][tile.getY() - 1];
        }
        return null;
    }

    public static int getWhoseTurn() {
        return whoseTurn;
    }

    public void makeLog(int widthSize, int heightSize) {
        log = new VBox();
        log.setMinSize(widthSize, 10 * heightSize);
        logLabel = new Label[10];
        for (int i = 0; i < 10; i++) {
            makeLabel(widthSize, heightSize);
            logLabel[i] = tempLabel;
        }
    }

    public static void updateLog() {
        for (int i = 0; i < logger.getLog().size(); i++) {
            logLabel[i].setText(logger.getLog().get(i));
        }
        for (int i = 0; i < 10; i++) {
            if (!log.getChildren().contains(logLabel[i]) && logLabel[i].getText() != null) {
                log.getChildren().add(logLabel[i]);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
