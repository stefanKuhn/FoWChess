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
public class Queen extends MovePattern {

    public Queen(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        mph.highlightNorthEast(from);
        mph.highlightNorthWest(from);
        mph.highlightSouthEast(from);
        mph.highlightSouthWest(from);
        mph.highlightNorth(from);
        mph.highlightWest(from);
        mph.highlightSouth(from);
        mph.highlightEast(from);
    }

    @Override
    public void move(Tile from, Tile to) {
        if (mph.isNorthEast(from, to)) {
            mph.moveNorthEast(from, to);
        } else if (mph.isSouthWest(from, to)) {
            mph.moveSouthWest(from, to);
        } else if (mph.isNorthWest(from, to)) {
            mph.moveNorthWest(from, to);
        } else if (mph.isSouthEast(from, to)) {
            mph.moveSouthEast(from, to);
        } else if (mph.isNorth(from, to)) {
            mph.moveNorth(from, to);
        } else if (mph.isSouth(from, to)) {
            mph.moveSouth(from, to);
        } else if (mph.isWest(from, to)) {
            mph.moveWest(from, to);
        } else if (mph.isEast(from, to)) {
            mph.moveEast(from, to);
        }
        if (FoWChess.getTurnsActive()) {
            FoWChess.endTurn();
        }
    }

}
