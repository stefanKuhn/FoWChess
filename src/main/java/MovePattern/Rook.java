/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import Factory.MovePatternHolder;
import Objects.Tile;
import fowchess.FoWChess;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Rook extends MovePattern {

    public Rook(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        mph.highlightNorth(from);
        mph.highlightWest(from);
        mph.highlightEast(from);
        mph.highlightSouth(from);
    }

    @Override
    public void move(Tile from, Tile to) {
        if (mph.isNorth(from, to)) {
            mph.moveNorth(from, to);
        }
        if (mph.isSouth(from, to)) {
            mph.moveSouth(from, to);
        }
        if (mph.isWest(from, to)) {
            mph.moveWest(from, to);
        }
        if (mph.isEast(from, to)) {
            mph.moveEast(from, to);
        }
        if (FoWChess.getTurnsActive()) {
            FoWChess.endTurn();
        }
        
    }

    @Override
    public void threaten(Tile from) {
        MovePatternHolder.clearThreatenedTiles();
        mph.addNorth(from);
        mph.addWest(from);
        mph.addEast(from);
        mph.addSouth(from);
    }

}
