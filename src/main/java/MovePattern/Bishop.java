/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import Factory.MovePatternHolder;
import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author danie
 */
public class Bishop extends MovePattern {

    public Bishop(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        mph.highlightNorthEast(from);
        mph.highlightNorthWest(from);
        mph.highlightSouthEast(from);
        mph.highlightSouthWest(from);
    }

    @Override
    public void move(Tile from, Tile to) {
        if (mph.isNorthEast(from, to)) {
            mph.moveNorthEast(from, to);
        }
        if (mph.isSouthWest(from, to)) {
            mph.moveSouthWest(from, to);
        }
        if (mph.isNorthWest(from, to)) {
            mph.moveNorthWest(from, to);
        }
        if (mph.isSouthEast(from, to)) {
            mph.moveSouthEast(from, to);
        }
        if (FoWChess.getTurnsActive()) {
            FoWChess.endTurn();
        }

    }
}
