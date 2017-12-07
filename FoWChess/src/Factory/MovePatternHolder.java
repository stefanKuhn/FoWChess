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
    static Tile tempTile;
    int width, height;

    public MovePattern getPawn() {
        return pawn;
    }

    public MovePattern getRook() {
        return rook;
    }

    public MovePattern getBishop() {
        return bishop;
    }

    public MovePattern getKnight() {
        return knight;
    }

    public MovePattern getQueen() {
        return queen;
    }

    public MovePattern getKing() {
        return king;
    }
    
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
            tempTile = FoWChess.getNorth(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightNorth(tempTile);
            }
        }
    }
    public static void highlightEast(Tile tile){
        if (FoWChess.getEast(tile) != null ){
            tempTile = FoWChess.getEast(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightEast(tempTile);
            }
        }
    }
    public static void highlightSouth(Tile tile){
        if (FoWChess.getSouth(tile) != null ){
            tempTile = FoWChess.getSouth(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightSouth(tempTile);
            }
        }
    }
    public static void highlightWest(Tile tile){
        if (FoWChess.getWest(tile) != null ){
            tempTile = FoWChess.getWest(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightWest(tempTile);
            }
        }
    }
    public static void highlightNorthEast(Tile tile){
        if (FoWChess.getNorthEast(tile) != null ){
            tempTile = FoWChess.getNorthEast(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightNorthEast(tempTile);
            }
        }
    }
    public static void highlightNorthWest(Tile tile){
        if (FoWChess.getNorthWest(tile) != null ){
            tempTile = FoWChess.getNorthWest(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightNorthWest(tempTile);
            }
        }
    }
    public static void highlightSouthEast(Tile tile){
        if (FoWChess.getSouthEast(tile) != null ){
            tempTile = FoWChess.getSouthEast(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightSouthEast(tempTile);
            }
        }
    }
    public static void highlightSouthWest(Tile tile){
        if (FoWChess.getSouthWest(tile) != null ){
            tempTile = FoWChess.getSouthWest(tile);
            tempTile.setIsHighlighted(true);
            FoWChess.getHighlightedTiles().push(tempTile);
            tempTile.highLight();
            if (tempTile.getMob() != null && tempTile.getLightlevel() > 0){
                highlightSouthWest(tempTile);
            }
        }
    }
}
