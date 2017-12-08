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
public class Pawn extends MovePattern{
    

    public Pawn(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        x = from.getX();
        y = from.getY();
        if (from.getMob().getOwnerId() == 0){
            if (FoWChess.getNorth(from) != null && FoWChess.getNorth(from).getMob() == null){
                FoWChess.getNorth(from).highLight();
            }
            if (FoWChess.getNorthEast(from) != null && FoWChess.getNorthEast(from).getMob() != null && FoWChess.getNorthEast(from).getMob().getOwnerId() != 0){
                FoWChess.getNorthEast(from).highLight();
            }
            if (FoWChess.getNorthWest(from) != null && FoWChess.getNorthWest(from).getMob() != null && FoWChess.getNorthWest(from).getMob().getOwnerId() != 0){
                FoWChess.getNorthWest(from).highLight();
            }
        }
        else{
            if (FoWChess.getSouth(from) != null && FoWChess.getSouth(from).getMob() == null){
                FoWChess.getSouth(from).highLight();
            }
            if (FoWChess.getSouthEast(from) != null && FoWChess.getSouthEast(from).getMob() != null && FoWChess.getSouthEast(from).getMob().getOwnerId() != 1){
                FoWChess.getSouthEast(from).highLight();
            }
            if (FoWChess.getSouthWest(from) != null && FoWChess.getSouthWest(from).getMob() != null && FoWChess.getSouthWest(from).getMob().getOwnerId() != 1){
                FoWChess.getSouthWest(from).highLight();
            }
        }
    }  
}
