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
public class Knight extends MovePattern {

    public Knight(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        x = from.getX();
        y = from.getY();
        if (y + 2 < height) {
            if (x + 1 < width) {
                FoWChess.getBoard()[x + 1][y + 2].highLight();
            }
            if (x - 1 >= 0) {
                FoWChess.getBoard()[x - 1][y + 2].highLight();
            }
        }
        if (y - 2 >= 0) {
            if (x + 1 < width) {
                FoWChess.getBoard()[x + 1][y - 2].highLight();
            }
            if (x - 1 >= 0) {
                FoWChess.getBoard()[x - 1][y - 2].highLight();
            }
        }
        if (y + 1 < height) {
            if (x + 2 < width) {
                FoWChess.getBoard()[x + 2][y + 1].highLight();
            }
            if (x - 2 >= 0) {
                FoWChess.getBoard()[x - 2][y + 1].highLight();
            }
        }
        if (y - 1 >= 0) {
            if (x + 2 < width) {
                FoWChess.getBoard()[x + 2][y - 1].highLight();
            }
            if (x - 2 >= 0) {
                FoWChess.getBoard()[x - 2][y - 1].highLight();
            }
        }
    }

    @Override
    public void move(Tile from, Tile to) {
        if (to.getMob() != null){
            log.newEntry(from.getMob(), to);
        }
        to.setMob(from.getMob());
        from.setMob(null);
        if (FoWChess.getTurnsActive()){
            FoWChess.endTurn();
        }
    }
}
