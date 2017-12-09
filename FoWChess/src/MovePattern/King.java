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
public class King extends MovePattern{

    public King(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        if (from.isHn() && (from.getN().getMob() == null || from.getN().getMob() != null && from.getN().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getNorth(from).highLight();
        }
        if (from.isHne() && (from.getNe().getMob() == null || from.getNe().getMob() != null && from.getNe().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getNe().highLight();
        }
        if (from.isHnw() && (from.getNw().getMob() == null || from.getNw().getMob() != null && from.getNw().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getNw().highLight();
        }
        if (from.isHs() && (from.getS().getMob() == null || from.getS().getMob() != null && from.getS().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getS().highLight();
        }
        if (from.isHse() && (from.getSe().getMob() == null || from.getSe().getMob() != null && from.getSe().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getSe().highLight();
        }
        if (from.isHsw() && (from.getSw().getMob() == null || from.getSw().getMob() != null && from.getSw().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getSw().highLight();
        }
        if (from.isHw() && (from.getW().getMob() == null || from.getW().getMob() != null && from.getW().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getW().highLight();
        }
        if (from.isHe() && (from.getE().getMob() == null || from.getE().getMob() != null && from.getE().getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            from.getE().highLight();
        }
    }
    
}
