/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import MovePattern.MovePattern;
import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author danie
 */
public class Bishop extends MovePattern{

    public Bishop(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        x = from.getX();
        y = from.getY();
        for (int i = 0; i < width; i++){
            
        }
    }
}
