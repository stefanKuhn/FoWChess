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
    
    private Tile[][] board;
    private Label[] widthLabel;
    private Label[] heightLabel;
    private Tile lastCreatedTile;
    private Label lastCreatedLabel;

    
    public GridPane generateBoard(int width, int height, int size){
        int fuckthis=1;
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
                lastCreatedTile.setBackground(lastCreatedTile.getTileColor());
            }
        }
        for(int i = 1; i <= width; i++){
            lastCreatedLabel = new Label(Integer.toString(i));
            lastCreatedLabel.setMinSize(size, size);
            lastCreatedLabel.setAlignment(Pos.CENTER);
            root.add(lastCreatedLabel,i + 1,1);
            lastCreatedLabel = new Label(Integer.toString(i));
            lastCreatedLabel.setMinSize(size, size);
            lastCreatedLabel.setAlignment(Pos.CENTER);
            root.add(lastCreatedLabel,i + 1,height + 2);
        }
        for(int j = 1; j <= height; j++){
            lastCreatedLabel = new Label(Integer.toString(j));
            lastCreatedLabel.setMinSize(size, size);
            lastCreatedLabel.setAlignment(Pos.CENTER);
            root.add(lastCreatedLabel,1,height - j + 2);
            lastCreatedLabel = new Label(Integer.toString(j));
            lastCreatedLabel.setMinSize(size, size);
            lastCreatedLabel.setAlignment(Pos.CENTER);
            root.add(lastCreatedLabel,width + 2,height - j + 2);
        }
        return root;
    }
        
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = generateBoard(8,8,50);
        root.setPadding(new Insets(15,15,15,15));        
        Scene scene = new Scene(root, 530, 530);
                
        primaryStage.setTitle("Hello World!");
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
