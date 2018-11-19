/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowchess;

import Factory.MobFactory;
import Factory.MovePatternHolder;
import Factory.TileFactory;
import Logger.Logger;
import Objects.Mob;
import Objects.Tile;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
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
    private Tile tempTile;//a temporary tile
    private Label tempLabel;//a temporary label
    private static int whoseTurn, width, height;//integers for storing whose turn it is, the numbers of rows and the numbers of columns of the chessboard generated
    private static Stack<Tile> highlightedTiles;//stack for the tiles which are highlighted
    private static Tile selected;//tile that is currently selected;
    private static MovePatternHolder mph;//reference to a singleton
    private Mob tempMob;//a temporary mob
    private static Mob targetForEnPassant;//single target for en passant
    private static ArrayList<Tile> tilesUnderAttack;//ArrayList to store tiles which are under attack for rochade
    private static Logger logger;//reference to a singleton
    private static Label[] logLabel;//labels for the log
    private static VBox log;//VBox containing the log
    private static boolean isTurn;//flag for if there is currently a turn active
    private static ArrayList<Tile> tilesContainingVisibleEnemies;//arraylist to store tiles containing visible enemies

    Button changebtn;
    private static boolean turnsActive;

    public void makeLabel(String text, int size) {//makes a label to be used for the axes
        tempLabel = new Label(text);
        tempLabel.setMinSize(size, size);
        tempLabel.setAlignment(Pos.CENTER);
    }

    public void makeLabel(int widthSize, int heightSize) {//makes a label to be used for the log
        tempLabel = new Label();
        tempLabel.setMinSize(widthSize, heightSize);
        tempLabel.setAlignment(Pos.CENTER_LEFT);
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
                tempTile.setMaxSize(size, size);
                root.add(tempTile, i + 2, j + 2);
                tempTile.setBackground(tempTile.getTileColor());
                tempTile.adaptBG();
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
        generalLineUp();
        return root;
    }

    public void generalLineUp() {//lines up the figurines
        for (int i = 0; i < width; i++) {//lines up the pawns in the second and second last row 
            getBoard()[i][1].setMob(MobFactory.getInstance().pawn(0));
            getBoard()[i][height - 2].setMob(MobFactory.getInstance().pawn(1));
        }
        //lines up rooks and knights
        getBoard()[0][0].setMob(MobFactory.getInstance().rook(0));
        getBoard()[1][0].setMob(MobFactory.getInstance().knight(0));
        getBoard()[width - 1][0].setMob(MobFactory.getInstance().rook(0));
        getBoard()[width - 2][0].setMob(MobFactory.getInstance().knight(0));
        getBoard()[0][height - 1].setMob(MobFactory.getInstance().rook(1));
        getBoard()[1][height - 1].setMob(MobFactory.getInstance().knight(1));
        getBoard()[width - 1][height - 1].setMob(MobFactory.getInstance().rook(1));
        getBoard()[width - 2][height - 1].setMob(MobFactory.getInstance().knight(1));
        //lines up the kings, queens and bishops and fills optional space with pawns
        if (width << 31 == 0) {//the number of rows is even
            getBoard()[width / 2 - 1][height - 1].setMob(MobFactory.getInstance().king(1));
            getBoard()[width / 2 - 2][height - 1].setMob(MobFactory.getInstance().bishop(1));
            getBoard()[width / 2][height - 1].setMob(MobFactory.getInstance().queen(1));
            getBoard()[width / 2 + 1][height - 1].setMob(MobFactory.getInstance().bishop(1));
            if (width > 8) {
                for (int i = 2; i < (int) Math.floor(width / 2) - 2; i++) {
                    getBoard()[i][height - 1].setMob(MobFactory.getInstance().pawn(0));
                }
                for (int i = (int) Math.floor(width / 2) + 2; i < width - 2; i++) {
                    getBoard()[i][height - 1].setMob(MobFactory.getInstance().pawn(0));
                }
            }
        } else {//the number of rows is uneven
            getBoard()[(int) Math.floor(width / 2)][height - 1].setMob(MobFactory.getInstance().king(1));
            getBoard()[(int) Math.floor(width / 2) + 1][height - 1].setMob(MobFactory.getInstance().queen(1));
            getBoard()[(int) Math.floor(width / 2) - 1][height - 1].setMob(MobFactory.getInstance().bishop(1));
            getBoard()[(int) Math.floor(width / 2) + 2][height - 1].setMob(MobFactory.getInstance().bishop(1));
            if (width > 8) {
                for (int i = 2; i < (int) Math.floor(width / 2) - 1; i++) {
                    getBoard()[i][height - 1].setMob(MobFactory.getInstance().pawn(0));
                }
                for (int i = (int) Math.floor(width / 2) + 3; i < width - 2; i++) {
                    getBoard()[i][height - 1].setMob(MobFactory.getInstance().pawn(0));
                }
            }
        }
        getBoard()[(int) Math.floor(width / 2)][0].setMob(MobFactory.getInstance().king(0));
        getBoard()[(int) Math.floor(width / 2) - 2][0].setMob(MobFactory.getInstance().bishop(0));
        getBoard()[(int) Math.floor(width / 2) - 1][0].setMob(MobFactory.getInstance().queen(0));
        getBoard()[(int) Math.floor(width / 2) + 1][0].setMob(MobFactory.getInstance().bishop(0));
        if (width > 8) {
            for (int i = 2; i < (int) Math.floor(width / 2) - 2; i++) {
                getBoard()[i][0].setMob(MobFactory.getInstance().pawn(0));
            }
            for (int i = (int) Math.floor(width / 2) + 2; i < width - 2; i++) {
                getBoard()[i][0].setMob(MobFactory.getInstance().pawn(0));
            }
        }
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

    public Scene makeScene(int width, int height, int size) {//initialises the scene
        setIsTurn(false);
        GridPane root = generateBoard(width, height, size);
        FlowPane flo = new FlowPane();
        changebtn = new Button("Start Turn");
        makeLog(5 * size, size, height);
        flo.getChildren().addAll(root, log, setChangeButton(changebtn, size));
        Scene scene = new Scene(flo, (width + 7) * size, (height + 3) * size);
        return scene;
    }

    //stefan.kuhn@hotmail.com
    //s.kuhn@rafisa.ch
    //daniel.baur@outlook.de
    public Button setChangeButton(Button changebtn, int size) {//sets action for klicking on start turn button

        changebtn.setMinSize(2 * size, size);
        changebtn.setAlignment(Pos.CENTER);
        changebtn.setOnAction((ActionEvent event) -> {
            try {
                if (!FoWChess.isIsTurn()) {
                    startTurn(size);
                }
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(FoWChess.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return changebtn;
    }

    public void eventHandler(Tile[][] board) {//sets action for klicking on board tiles
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.setOnAction((ActionEvent event) -> {
                    if (FoWChess.isIsTurn()) {//turn is active
                        //System.out.println(highlightedTiles.size());
                        if (tile.isIsHighlighted()) {//tile is highlighted
                            switch (tempMob.getName()) {//moves dependend on mob name
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
                        } else if (highlightedTiles.isEmpty()) {//there is no tile highlighted
                            if (tile.getMob() != null) {//there is a mob on the tile
                                if ((tempMob = tile.getMob()).getOwnerId() == whoseTurn) {//mob is owned by the player whose turn it is
                                    setSelected(tile);
                                    switch (tempMob.getName()) {//highlightes dependend on mob name
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
                        } else if (tile == selected) {//the tile is currently selected
                            setSelected(null);
                            dehighlight();
                        }
                    }
                });
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        //set globals
        turnsActive = true;
        highlightedTiles = new Stack();
        whoseTurn = 1;

        //JavaFX
        Scene scene = init(8, 8, 50, 2);
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
    public void dehighlight() {//removes all the highlights
        while (!highlightedTiles.empty()) {
            tempTile = highlightedTiles.pop();
            tempTile.adaptBG();
        }
    }

    /**
     * ends the turn by fogging the entire board
     */
    public static void endTurn() {
        isTurn = false;
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
    public static void startTurn(int size) throws FileNotFoundException {
        //setIsTurn is nonStatic, thus
        isTurn = true;
        switchActivePlayer();
        tilesContainingVisibleEnemies = new ArrayList();
        tilesUnderAttack = new ArrayList();
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.adaptLight();
            }
        }
        for (Tile[] row : board) {
            for (Tile tile : row) {
                if ((tile.getMob() != null) && (tile.getLightlevel() > 0)) {
                    tile.adaptFigurine(size);
                    if (tile.getMob().getOwnerId() != whoseTurn) {
                        tilesContainingVisibleEnemies.add(tile);
                    }
                }
            }
        }
        if (targetForEnPassant != null && targetForEnPassant.getOwnerId() == whoseTurn) {
            targetForEnPassant = null;
        }
        for (Tile tile : tilesContainingVisibleEnemies) {
            switch (tile.getMob().getName()) {//threatened tiles dependend on mob name
                case "pawn":
                    mph.getPawn().threaten(tile);
                    break;
                case "rook":
                    mph.getRook().threaten(tile);
                    break;
                case "bishop":
                    mph.getBishop().threaten(tile);
                    break;
                case "knight":
                    mph.getKnight().threaten(tile);
                    break;
                case "queen":
                    mph.getQueen().threaten(tile);
                    break;
                case "king":
                    mph.getKing().threaten(tile);
                    break;
                default:
                    break;
            }
            for (Tile threatenedTile : MovePatternHolder.getThreatenedTiles()){
                if (!tilesUnderAttack.contains(threatenedTile)){
                    tilesUnderAttack.add(threatenedTile);
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
     * @param numberOfPlayers
     * @return
     */
    public Scene init(int width, int height, int size, int numberOfPlayers) {
        if (width < 8) {//this is the minimal number of columns
            this.width = 8;
        } else {
            this.width = width;
        }
        if (height < 4) {//this is the minimal number of rows
            this.height = 4;
        } else {
            this.height = height;
        }

        //get instances of Singletons to be used
        this.mph = MovePatternHolder.getInstance();
        this.logger = Logger.getInstance();

        Scene returnThis = makeScene(this.width, this.height, size);
        eventHandler(board);
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

    public static boolean isIsTurn() {
        return isTurn;
    }

    public void setIsTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public void mapButtons() {//maps the buttons
        for (Tile[] row : board) {
            for (Tile tile : row) {
                tile.map();
            }
        }
    }

    public static Tile getNorth(Tile tile) {//gets northern tile
        if (tile.getY() + 1 < height) {
            return board[tile.getX()][tile.getY() + 1];
        }
        return null;
    }

    public static Tile getEast(Tile tile) {//gets eastern tile
        if (tile.getX() + 1 < width) {
            return board[tile.getX() + 1][tile.getY()];
        }
        return null;
    }

    public static Tile getSouth(Tile tile) {//gets southern tile
        if (tile.getY() - 1 >= 0) {
            return board[tile.getX()][tile.getY() - 1];
        }
        return null;
    }

    public static Tile getWest(Tile tile) {//gets western tile
        if (tile.getX() - 1 >= 0) {
            return board[tile.getX() - 1][tile.getY()];
        }
        return null;
    }

    public static Tile getNorthEast(Tile tile) {//gets north eastern tile
        if (tile.getX() + 1 < width && tile.getY() + 1 < height) {
            return board[tile.getX() + 1][tile.getY() + 1];
        }
        return null;
    }

    public static Tile getNorthWest(Tile tile) {//gets north western tile
        if (tile.getX() - 1 >= 0 && tile.getY() + 1 < height) {
            return board[tile.getX() - 1][tile.getY() + 1];
        }
        return null;
    }

    public static Tile getSouthEast(Tile tile) {//gets south eastern tile
        if (tile.getX() + 1 < width && tile.getY() - 1 >= 0) {
            return board[tile.getX() + 1][tile.getY() - 1];
        }
        return null;
    }

    public static Tile getSouthWest(Tile tile) {//gets south western tile
        if (tile.getX() - 1 >= 0 && tile.getY() - 1 >= 0) {
            return board[tile.getX() - 1][tile.getY() - 1];
        }
        return null;
    }

    public static int getWhoseTurn() {
        return whoseTurn;
    }

    public void makeLog(int widthSize, int heightSize, int height) {//initialises the log
        log = new VBox();
        log.setMinSize(widthSize, (height + 2) * heightSize);
        logLabel = new Label[height + 2];
        for (int i = 0; i < height + 2; i++) {//initialises log entries
            makeLabel(widthSize, heightSize);
            logLabel[i] = tempLabel;
        }
    }

    public static void updateLog() {//updates the log
        for (int i = 0; i < logger.getLog().size(); i++) {//sets the text for the entries
            logLabel[i].setText(logger.getLog().get(i));
        }
        for (int i = 0; i < height + 2; i++) {//adds labels to the log currently not contained by it and themselves containing any text
            if (!log.getChildren().contains(logLabel[i]) && logLabel[i].getText() != null) {
                log.getChildren().add(logLabel[i]);
            }
        }
    }

    public static Mob getTargetForEnPassant() {
        return targetForEnPassant;
    }

    public static void setTargetForEnPassant(Mob targetForEnPassant) {
        FoWChess.targetForEnPassant = targetForEnPassant;
    }

    public static ArrayList<Tile> getTilesUnderAttack() {
        return tilesUnderAttack;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
