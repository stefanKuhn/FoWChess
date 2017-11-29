/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Objects.Tile;
import javafx.scene.layout.Background;
/**
 *
 * @author Sumpf
 */
public class TileFactory {
    static TileFactory instance;
    private TileFactory(){};
    Tile lastCreated;
    Background lastGivenBG;
    
    public static TileFactory getInstance(){
        if (instance==null){
            instance=new TileFactory();
        }
        return instance;
    }
    
    public Tile makeTile(int x, int y){
        
        //on even rows
        if (x<<31>>31==0){
            //even tiles are black
            if (y<<31>>31==0){
                lastGivenBG=PaintMakerAndHolder.getInstance().getBlack();
            } else {
                lastGivenBG=PaintMakerAndHolder.getInstance().getWhite();
            }
        }//on uneven rows
        else {
            //uneven tiles are black
             if (y<<31>>31==0){
                lastGivenBG=PaintMakerAndHolder.getInstance().getWhite();
            } else {
                lastGivenBG=PaintMakerAndHolder.getInstance().getBlack();
            }
        }
       
        
        lastCreated = new Tile(lastGivenBG, x, y, 0);
        
        return lastCreated;
    }
}
