/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import MovePattern.Bishop;
import MovePattern.King;
import MovePattern.Knight;
import MovePattern.MovePattern;
import MovePattern.Pawn;
import MovePattern.Queen;
import MovePattern.Rook;
import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author Sumpf
 */
public class MovePatternHolder {
    MovePattern pawn, rook, bishop, knight, queen, king;
    static MovePatternHolder instance;
    static Tile lastChosenTile;
    int width, height;
    
    private MovePatternHolder(){
        this.width = FoWChess.getWidth();
        this.height = FoWChess.getHeight();
        pawn = new Pawn(width,height);
        rook = new Rook(width,height);
        bishop = new Bishop(width,height);
        knight = new Knight(width,height);
        queen = new Queen(width,height);
        king = new King(width,height);
    }
    
    public static MovePatternHolder getInstance(){
        if (instance == null){
            instance = new MovePatternHolder();
        }
        return instance;
    }
    
    public static void highlightNorth(Tile tile){
        if (FoWChess.getNorth(tile) != null ){
            lastChosenTile = FoWChess.getNorth(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightNorth(lastChosenTile);
            }
        }
    }
    public static void highlightEast(Tile tile){
        if (FoWChess.getEast(tile) != null ){
            lastChosenTile = FoWChess.getEast(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightEast(lastChosenTile);
            }
        }
    }
    public static void highlightSouth(Tile tile){
        if (FoWChess.getSouth(tile) != null ){
            lastChosenTile = FoWChess.getSouth(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightSouth(lastChosenTile);
            }
        }
    }
    public static void highlightWest(Tile tile){
        if (FoWChess.getWest(tile) != null ){
            lastChosenTile = FoWChess.getWest(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightWest(lastChosenTile);
            }
        }
    }
    public static void highlightNorthEast(Tile tile){
        if (FoWChess.getNorthEast(tile) != null ){
            lastChosenTile = FoWChess.getNorthEast(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightNorthEast(lastChosenTile);
            }
        }
    }
    public static void highlightNorthWest(Tile tile){
        if (FoWChess.getNorthWest(tile) != null ){
            lastChosenTile = FoWChess.getNorthWest(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightNorthWest(lastChosenTile);
            }
        }
    }
    public static void highlightSouthEast(Tile tile){
        if (FoWChess.getSouthEast(tile) != null ){
            lastChosenTile = FoWChess.getSouthEast(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightSouthEast(lastChosenTile);
            }
        }
    }
    public static void highlightSouthWest(Tile tile){
        if (FoWChess.getSouthWest(tile) != null ){
            lastChosenTile = FoWChess.getSouthWest(tile);
            lastChosenTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(lastChosenTile);
            if (lastChosenTile.getMob() != null && lastChosenTile.getLightlevel() > 0){
                highlightSouthWest(lastChosenTile);
            }
        }
    }
}
