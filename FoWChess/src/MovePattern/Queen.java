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
public class Queen extends MovePattern{

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
        mph.highlightEast(from);
        mph.highlightWest(from);
    }
    
}
