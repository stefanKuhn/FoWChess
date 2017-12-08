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
        if (FoWChess.getNorth(from) != null && (FoWChess.getNorth(from).getMob() == null || FoWChess.getNorth(from).getMob() != null && FoWChess.getNorth(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getNorth(from).highLight();
        }
        if (FoWChess.getNorthEast(from) != null && (FoWChess.getNorthEast(from).getMob() == null || FoWChess.getNorthEast(from).getMob() != null && FoWChess.getNorthEast(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getNorthEast(from).highLight();
        }
        if (FoWChess.getNorthWest(from) != null && (FoWChess.getNorthWest(from).getMob() == null || FoWChess.getNorthWest(from).getMob() != null && FoWChess.getNorthWest(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getNorthWest(from).highLight();
        }
        if (FoWChess.getSouth(from) != null && (FoWChess.getSouth(from).getMob() == null || FoWChess.getSouth(from).getMob() != null && FoWChess.getSouth(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getSouth(from).highLight();
        }
        if (FoWChess.getSouthEast(from) != null && (FoWChess.getSouthEast(from).getMob() == null || FoWChess.getSouthEast(from).getMob() != null && FoWChess.getSouthEast(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getSouthEast(from).highLight();
        }
        if (FoWChess.getSouthWest(from) != null && (FoWChess.getSouthWest(from).getMob() == null || FoWChess.getSouthWest(from).getMob() != null && FoWChess.getSouthWest(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getSouthWest(from).highLight();
        }
        if (FoWChess.getWest(from) != null && (FoWChess.getWest(from).getMob() == null || FoWChess.getWest(from).getMob() != null && FoWChess.getWest(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getWest(from).highLight();
        }
        if (FoWChess.getEast(from) != null && (FoWChess.getEast(from).getMob() == null || FoWChess.getEast(from).getMob() != null && FoWChess.getEast(from).getMob().getOwnerId() != FoWChess.getWhoseTurn())){
            FoWChess.getEast(from).highLight();
        }
    }
    
}
