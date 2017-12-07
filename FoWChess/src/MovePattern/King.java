/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author danie
 */
public class King extends MovePattern{

    public King(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        if (FoWChess.getNorth(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getNorthEast(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getNorthWest(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getSouth(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getSouthEast(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getSouthWest(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getWest(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
        if (FoWChess.getEast(from) != null){
            (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            lastChosenTile.highLight();
        }
    }
    
}
