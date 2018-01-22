/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import Factory.MovePatternHolder;
import Logger.Logger;
import Objects.Mob;
import Objects.Tile;

/**
 *
 * @author Sumpf
 */
public abstract class MovePattern {

    int width, height, x, y;
    Tile tempTile;
    MovePatternHolder mph;
    Mob tempMob;
    Logger log;

    public MovePattern(int width, int height) {
        this.width = width;
        this.height = height;
        this.mph = MovePatternHolder.getInstance();
        this.log = Logger.getInstance();
    }

    public abstract void highlight(Tile from);

    public abstract void move(Tile from, Tile to);
}
