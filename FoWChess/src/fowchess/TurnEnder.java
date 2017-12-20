/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowchess;

import Objects.Tile;

/**
 *
 * @author Sumpf
 */
public class TurnEnder {
    
    static TurnEnder instance;
    
    private TurnEnder(){
        
    }
    
    public static TurnEnder getInstance(){
        if (instance==null){
            instance = new TurnEnder();
        }
        return instance;
    }
    
    public void endTurn (FoWChess game){
         for (Tile[] row : game.getBoard()){
            for (Tile tile : row){
                tile.drawFigure();
            }
        }
    }
    
}
