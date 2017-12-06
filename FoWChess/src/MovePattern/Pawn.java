/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import MovePattern.MovePattern;
import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author danie
 */
public class Pawn extends MovePattern{
    

    public Pawn(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        x = from.getX();
        y = from.getY();
        if (from.getMob().getOwnerId() == 0){
            if (y + 1 < height){
                if(!(lastChosenTile = FoWChess.getBoard()[x][y + 1]).containsMob()){
                    lastChosenTile.setIsHighlighted(true);
                    FoWChess.getHighlightedTiles().push(lastChosenTile);
                }
                if (x + 1 < width && (lastChosenTile = FoWChess.getBoard()[x + 1][y + 1]).containsMob()){
                    lastChosenTile.setIsHighlighted(true);
                    FoWChess.getHighlightedTiles().push(lastChosenTile);
                }    
                if (x - 1 >= 0 && (lastChosenTile = FoWChess.getBoard()[x - 1][y + 1]).containsMob()){
                    lastChosenTile.setIsHighlighted(true);
                    FoWChess.getHighlightedTiles().push(lastChosenTile);
                }    
            }
        }
        else{
            if (y - 1 >= 0){
                if(!(lastChosenTile = FoWChess.getBoard()[x][y - 1]).containsMob()){
                    lastChosenTile.setIsHighlighted(true);
                    FoWChess.getHighlightedTiles().push(lastChosenTile);
                }
                if (x + 1 < width && (lastChosenTile = FoWChess.getBoard()[x + 1][y - 1]).containsMob()){
                    lastChosenTile.setIsHighlighted(true);
                    FoWChess.getHighlightedTiles().push(lastChosenTile);
                }    
                if (x - 1 >= 0 && (lastChosenTile = FoWChess.getBoard()[x - 1][y - 1]).containsMob()){
                    lastChosenTile.setIsHighlighted(true);
                    FoWChess.getHighlightedTiles().push(lastChosenTile);
                }    
            }
        }
    }  
}
