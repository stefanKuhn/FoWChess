/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowchess;

import Factory.TileFactory;
import Objects.Tile;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sumpf
 */
public class FoWChess extends Application {
    
    private Tile[][] board;
    private Label[] widthLabel;
    private Label[] heightLabel;
    private Tile lastCreatedTile;
    private Label lastCreatedLabel;

    
    public GridPane generateBoard(int width, int height, int size){
        GridPane root = new GridPane();
        board = new Tile[width][height];
        widthLabel = new Label[width];
        heightLabel = new Label[height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                lastCreatedTile = TileFactory.getInstance().makeTile(i, j);
                board[i][j] = lastCreatedTile;
                lastCreatedTile.setMinSize(size,size);
                root.add(lastCreatedTile, i + 2, j + 2);
            }
        }
        for(int i = 1; i <= width; i++){
            lastCreatedLabel = new Label(Integer.toString(i));
            root.add(lastCreatedLabel,i + 1,1);
            lastCreatedLabel = new Label(Integer.toString(i));
            root.add(lastCreatedLabel,i + 1,height + 2);
        }
        for(int j = 1; j <= height; j++){
            lastCreatedLabel = new Label(Integer.toString(j));
            root.add(lastCreatedLabel,1,j + 1);
            lastCreatedLabel = new Label(Integer.toString(j));
            root.add(lastCreatedLabel,width + 2,j + 1);
        }
        return root;
    }
        
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = generateBoard(8,8,50);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
