/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovePattern;

import Factory.MovePatternHolder;
import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author danie
 */
public class King extends MovePattern {

    public King(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        if (from.isHn() && (from.getN().getMob() == null || from.getN().getMob() != null && from.getN().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getN().highLight();
        }
        if (from.isHne() && (from.getNe().getMob() == null || from.getNe().getMob() != null && from.getNe().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getNe().highLight();
        }
        if (from.isHnw() && (from.getNw().getMob() == null || from.getNw().getMob() != null && from.getNw().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getNw().highLight();
        }
        if (from.isHs() && (from.getS().getMob() == null || from.getS().getMob() != null && from.getS().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getS().highLight();
        }
        if (from.isHse() && (from.getSe().getMob() == null || from.getSe().getMob() != null && from.getSe().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getSe().highLight();
        }
        if (from.isHsw() && (from.getSw().getMob() == null || from.getSw().getMob() != null && from.getSw().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getSw().highLight();
        }
        if (from.isHw() && (from.getW().getMob() == null || from.getW().getMob() != null && from.getW().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getW().highLight();
        }
        if (from.isHe() && (from.getE().getMob() == null || from.getE().getMob() != null && from.getE().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            from.getE().highLight();
        }
        if (!from.getMob().isHasMoved()) {
            if (from.getX() <= 4 && MovePatternHolder.tryWest(from.getMob().getOwnerId(), from, FoWChess.getBoard()[0][from.getY()])) {
                FoWChess.getBoard()[from.getX() - 2][from.getY()].highLight();
            } else if (width - from.getX() <= 5 && MovePatternHolder.tryEast(from.getMob().getOwnerId(), from, FoWChess.getBoard()[width - 1][from.getY()])) {
                FoWChess.getBoard()[from.getX() + 2][from.getY()].highLight();
            }
        }
    }

    @Override
    public void move(Tile from, Tile to) {
        x = from.getX();
        y = from.getY();
        from.getMob().setHasMoved(true);
        if (to.getMob() != null) {
            log.newEntry(from.getMob(), to);
        } else if (to.getX() == x - 2){
            from.getW().setMob((tempTile = FoWChess.getBoard()[0][y]).getMob());
            tempTile.setMob(null);
        } else if (to.getX() == x + 2){
            from.getE().setMob((tempTile = FoWChess.getBoard()[width - 1][y]).getMob());
            tempTile.setMob(null);            
        }
        to.setMob(from.getMob());
        from.setMob(null);
        if (FoWChess.getTurnsActive()) {
            FoWChess.endTurn();
        }
    }

    @Override
    public void threaten(Tile from) {
        MovePatternHolder.clearThreatenedTiles();
        if (from.isHn() && (from.getN().getMob() == null || from.getN().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getN());
        }
        if (from.isHne() && (from.getNe().getMob() == null || from.getNe().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getNe());
        }
        if (from.isHnw() && (from.getNw().getMob() == null ||  from.getNw().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getNw());
        }
        if (from.isHs() && (from.getS().getMob() == null ||  from.getS().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getS());
        }
        if (from.isHse() && (from.getSe().getMob() == null || from.getSe().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getSe());
        }
        if (from.isHsw() && (from.getSw().getMob() == null || from.getSw().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getSw());
        }
        if (from.isHw() && (from.getW().getMob() == null || from.getW().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getW());
        }
        if (from.isHe() && (from.getE().getMob() == null || from.getE().getMob().getOwnerId() == FoWChess.getWhoseTurn())) {
            MovePatternHolder.addThreatenedTile(from.getE());
        }
    }

}
