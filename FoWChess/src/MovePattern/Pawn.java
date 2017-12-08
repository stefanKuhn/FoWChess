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
            if (from.isHn() && from.getN().getMob() == null){
                from.getN().highLight();
            }
            if (from.isHne() && from.getNe().getMob() != null && from.getNe().getMob().getOwnerId() != 0){
                from.getNe().highLight();
            }
            if (from.isHnw() && from.getNw().getMob() != null && from.getNw().getMob().getOwnerId() != 0){
                from.getNw().highLight();
            }
        }
        else{
            if (from.isHs() && from.getS().getMob() == null){
                from.getS().highLight();
            }
            if (from.isHse() && from.getSe().getMob() != null && from.getSe().getMob().getOwnerId() != 1){
                from.getSe().highLight();
            }
            if (from.isHsw() && from.getSw().getMob() != null && from.getSw().getMob().getOwnerId() != 1){
                from.getSw().highLight();
            }
        }
    }  
}
