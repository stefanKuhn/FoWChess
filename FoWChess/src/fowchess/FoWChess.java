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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Sumpf
 */
public class FoWChess extends Application {
    
    private Tile[][] board;//two dimensional array for the tiles
    private Label[] widthLabel;//labels for x axis
    private Label[] heightLabel;//labels for y axis
    private Tile lastCreatedTile;
    private Label lastCreatedLabel;

    public void makeLabel(String text,int size){
        lastCreatedLabel = new Label(text);
        lastCreatedLabel.setMinSize(size, size);
        lastCreatedLabel.setAlignment(Pos.CENTER);
    }
    
    public GridPane generateBoard(int width, int height, int size){
        GridPane root = new GridPane();
        board = new Tile[width][height];
        widthLabel = new Label[width];
        heightLabel = new Label[height];
        //Place tiles and give them color
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                lastCreatedTile = TileFactory.getInstance().makeTile(i,height - j - 1);
                board[i][height - j - 1] = lastCreatedTile;
                lastCreatedTile.setMinSize(size,size);
                root.add(lastCreatedTile, i + 2, j + 2);
                lastCreatedTile.setBackground(lastCreatedTile.getTileColor());
            }
        }
        //Place x axis labels
        for(int i = 1; i <= width; i++){
            makeLabel(Integer.toString(i),size);
            root.add(lastCreatedLabel,i + 1,1);
            makeLabel(Integer.toString(i),size);
            root.add(lastCreatedLabel,i + 1,height + 2);
        }
        //Place y axis labels
        for(int j = 1; j <= height; j++){
            makeLabel(Integer.toString(j),size);
            root.add(lastCreatedLabel,1,height - j + 2);
            makeLabel(Integer.toString(j),size);
            root.add(lastCreatedLabel,width + 2,height - j + 2);
        }
        return root;
    }
    
    public Scene makeScene(int width, int height, int size){
        GridPane root = generateBoard(width,height,size);
        Scene scene = new Scene(root, (width + 2) * size, (height + 2) * size);
        return scene;
    }
        
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = makeScene(8,8,50);
                
        primaryStage.setTitle("FoWChess");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
