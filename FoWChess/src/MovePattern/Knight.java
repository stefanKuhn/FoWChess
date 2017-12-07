/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import Objects.Tile;

/**
 *
 * @author danie
 */
public class Knight extends MovePattern{

    public Knight(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        mph.highlightNorth(from);
        mph.highlightWest(from);
        mph.highlightEast(from);
        mph.highlightWest(from);
    }
    
}
