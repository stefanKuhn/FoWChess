/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.MovePattern;

import Objects.Tile;

/**
 *
 * @author Sumpf
 */
public abstract class MovePattern {
    int width, height, x, y;
    Tile lastChosenTile;

    public MovePattern(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public abstract void highlight(Tile from);
}
