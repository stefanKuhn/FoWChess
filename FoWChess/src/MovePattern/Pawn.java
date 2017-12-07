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
public class Pawn extends MovePattern{
    

    public Pawn(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        x = from.getX();
        y = from.getY();
        if (from.getMob().getOwnerId() == 0){
            if (FoWChess.getNorth(from) != null && FoWChess.getNorth(from).getMob() == null){
                (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
                FoWChess.getHighlightedTiles().push(lastChosenTile);
            }
            if (FoWChess.getNorthEast(from) != null && FoWChess.getNorth(from).getMob() != null){
                (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
                FoWChess.getHighlightedTiles().push(lastChosenTile);
            }
            if (FoWChess.getNorthWest(from) != null && FoWChess.getNorth(from).getMob() != null){
                (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
                FoWChess.getHighlightedTiles().push(lastChosenTile);
            }
        }
        else{
            if (FoWChess.getSouth(from) != null && FoWChess.getNorth(from).getMob() == null){
                (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
                FoWChess.getHighlightedTiles().push(lastChosenTile);
            }
            if (FoWChess.getSouthEast(from) != null && FoWChess.getNorth(from).getMob() != null){
                (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
                FoWChess.getHighlightedTiles().push(lastChosenTile);
            }
            if (FoWChess.getSouthWest(from) != null && FoWChess.getNorth(from).getMob() != null){
                (lastChosenTile = FoWChess.getNorth(from)).setIsHighlighted(true);
                FoWChess.getHighlightedTiles().push(lastChosenTile);
            }
        }
    }  
}
