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
public class Pawn extends MovePattern {

    public Pawn(int width, int height) {
        super(width, height);
    }

    @Override
    public void highlight(Tile from) {
        x = from.getX();
        y = from.getY();
        if (from.getMob().getOwnerId() == 0) {
            if (from.isHn() && from.getN().getMob() == null) {
                from.getN().highLight();
                if (!from.getMob().isHasMoved()) {
                    if (from.getN().isHn() && from.getN().getN().getMob() == null) {
                        from.getN().getN().highLight();
                    }
                }
            }
            if (from.isHne() && (from.getNe().getMob() != null && from.getNe().getMob().getOwnerId() != 0 || from.getE().getMob() != null && from.getE().getMob().getOwnerId() != 0 && FoWChess.getTargetsForEnPassant().contains(from.getE().getMob()))) {
                from.getNe().highLight();
            }
            if (from.isHnw() && (from.getNw().getMob() != null && from.getNw().getMob().getOwnerId() != 0 || from.getW().getMob() != null && from.getW().getMob().getOwnerId() != 0 && FoWChess.getTargetsForEnPassant().contains(from.getW().getMob()))) {
                from.getNw().highLight();
            }
        } else {
            if (from.isHs() && from.getS().getMob() == null) {
                from.getS().highLight();
                if (!from.getMob().isHasMoved()) {
                    if (from.getS().isHs() && from.getS().getS().getMob() == null) {
                        from.getS().getS().highLight();
                    }
                }
            }
            if (from.isHse() && (from.getSe().getMob() != null && from.getSe().getMob().getOwnerId() != 1 || from.getE().getMob() != null && from.getE().getMob().getOwnerId() != 0 && FoWChess.getTargetsForEnPassant().contains(from.getE().getMob()))) {
                from.getSe().highLight();
            }
            if (from.isHsw() && (from.getSw().getMob() != null && from.getSw().getMob().getOwnerId() != 1 || from.getW().getMob() != null && from.getW().getMob().getOwnerId() != 0 && FoWChess.getTargetsForEnPassant().contains(from.getW().getMob()))) {
                from.getSw().highLight();
            }
        }
    }

    @Override
    public void move(Tile from, Tile to) {
        tempMob = from.getMob();
        if (!tempMob.isHasMoved()) {
            tempMob.setHasMoved(true);
            if (Math.abs(to.getY() - from.getY()) == 2) {
                FoWChess.getTargetsForEnPassant().add(tempMob);
            }
        } else if (FoWChess.getTargetsForEnPassant().contains(tempMob)) {
            FoWChess.getTargetsForEnPassant().remove(tempMob);
        } else if (to.getX() - from.getX() == 1 && !(from.getE().getMob() == null) && FoWChess.getTargetsForEnPassant().contains(from.getE().getMob())) {
            log.setVictimOfEnPassant(from.getE().getMob());
            from.getE().setMob(null);
        } else if (to.getX() - from.getX() == -1 && !(from.getW().getMob() == null) && FoWChess.getTargetsForEnPassant().contains(from.getW().getMob())) {
            log.setVictimOfEnPassant(from.getW().getMob());
            from.getW().setMob(null);
        }
        if (log.getVictimOfEnPassant() == null){
            if (to.getMob() != null){
                log.newEntry(from.getMob(), to);
            }
        }
        else{
            log.anotherNewEntry(from.getMob(), to);
            log.setVictimOfEnPassant(null);
        }
        to.setMob(tempMob);
        from.setMob(null);
        if (FoWChess.getTurnsActive()){
            FoWChess.endTurn();
        }
    }
}
