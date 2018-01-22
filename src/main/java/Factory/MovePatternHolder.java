/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import MovePattern.Bishop;
import MovePattern.King;
import MovePattern.Rook;
import MovePattern.MovePattern;
import MovePattern.Pawn;
import MovePattern.Queen;
import MovePattern.Knight;
import Objects.Tile;
import fowchess.FoWChess;

/**
 *
 * @author Sumpf
 */
public class MovePatternHolder {

    MovePattern pawn, rook, bishop, knight, queen, king;
    static MovePatternHolder instance;
    static Tile tempTile;
    int width, height;

    public MovePattern getPawn() {
        return pawn;
    }

    public MovePattern getRook() {
        return rook;
    }

    public MovePattern getBishop() {
        return bishop;
    }

    public MovePattern getKnight() {
        return knight;
    }

    public MovePattern getQueen() {
        return queen;
    }

    public MovePattern getKing() {
        return king;
    }

    private MovePatternHolder() {
        this.width = FoWChess.getWidth();
        this.height = FoWChess.getHeight();

    }

    public static MovePatternHolder getInstance() {
        if (instance == null) {
            instance = new MovePatternHolder();
            instance.init();
        }
        return instance;
    }

    public static void highlightNorth(Tile tile) {
        if (tile.isHn() && (tile.getN().getMob() == null || tile.getN().getMob() != null && tile.getN().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getN();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightNorth(tempTile);
            }
        }
    }

    public static void highlightEast(Tile tile) {
        if (tile.isHe() && (tile.getE().getMob() == null || tile.getE().getMob() != null && tile.getE().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getE();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightEast(tempTile);
            }
        }
    }

    public static void highlightSouth(Tile tile) {
        if (tile.isHs() && (tile.getS().getMob() == null || tile.getS().getMob() != null && tile.getS().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getS();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightSouth(tempTile);
            }
        }
    }

    public static void highlightWest(Tile tile) {
        if (tile.isHw() && (tile.getW().getMob() == null || tile.getW().getMob() != null && tile.getW().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getW();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightWest(tempTile);
            }
        }
    }

    public static void highlightNorthEast(Tile tile) {
        if (tile.isHne() && (tile.getNe().getMob() == null || tile.getNe().getMob() != null && tile.getNe().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getNe();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightNorthEast(tempTile);
            }
        }
    }

    public static void highlightNorthWest(Tile tile) {
        if (tile.isHnw() && (tile.getNw().getMob() == null || tile.getNw().getMob() != null && tile.getNw().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getNw();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightNorthWest(tempTile);
            }
        }
    }

    public static void highlightSouthEast(Tile tile) {
        if (tile.isHse() && (tile.getSe().getMob() == null || tile.getSe().getMob() != null && tile.getSe().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getSe();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightSouthEast(tempTile);
            }
        }
    }

    public static void highlightSouthWest(Tile tile) {
        if (tile.isHsw() && (tile.getSw().getMob() == null || tile.getSw().getMob() != null && tile.getSw().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getSw();
            tempTile.highLight();
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                highlightSouthWest(tempTile);
            }
        }
    }

    public static boolean isNorth(Tile from, Tile to) {
        if (to.getY() - from.getY() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isSouth(Tile from, Tile to) {
        if (to.getY() - from.getY() < 0) {
            return true;
        }
        return false;
    }

    public static boolean isEast(Tile from, Tile to) {
        if (to.getX() - from.getX() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isWest(Tile from, Tile to) {
        if (to.getX() - from.getX() < 0) {
            return true;
        }
        return false;
    }

    public static boolean isNorthEast(Tile from, Tile to) {
        if (to.getY() - from.getY() == to.getX() - from.getX() && isNorth(from, to)) {
            return true;
        }
        return false;
    }

    public static boolean isSouthWest(Tile from, Tile to) {
        if (to.getY() - from.getY() == to.getX() - from.getX() && isSouth(from, to)) {
            return true;
        }
        return false;
    }

    public static boolean isSouthEast(Tile from, Tile to) {
        if (to.getY() - from.getY() == -(to.getX() - from.getX()) && isSouth(from, to)) {
            return true;
        }
        return false;
    }

    public static boolean isNorthWest(Tile from, Tile to) {
        if (to.getY() - from.getY() == -(to.getX() - from.getX()) && isNorth(from, to)) {
            return true;
        }
        return false;
    }

    public static void moveNorth(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getN().getMob() != null) {
            returnState = true;
        }
        from.getN().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveNorth(from.getN(), to);
        }
    }

    public static void moveSouth(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getS().getMob() != null) {
            returnState = true;
        }
        from.getS().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveSouth(from.getS(), to);
        }
    }

    public static void moveEast(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getE().getMob() != null) {
            returnState = true;
        }
        from.getE().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveEast(from.getE(), to);
        }
    }

    public static void moveWest(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getW().getMob() != null) {
            returnState = true;
        }
        from.getW().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveWest(from.getW(), to);
        }
    }

    public static void moveNorthEast(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getNe().getMob() != null) {
            returnState = true;
        }
        from.getNe().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveNorthEast(from.getNe(), to);
        }
    }

    public static void moveNorthWest(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getNw().getMob() != null) {
            returnState = true;
        }
        from.getNw().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveNorthWest(from.getNw(), to);
        }
    }

    public static void moveSouthEast(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getSe().getMob() != null) {
            returnState = true;
        }
        from.getSe().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveSouthEast(from.getSe(), to);
        }
    }

    public static void moveSouthWest(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getSw().getMob() != null) {
            returnState = true;
        }
        from.getSw().setMob(from.getMob());
        from.setMob(null);
        if (!returnState) {
            moveSouthWest(from.getSw(), to);
        }
    }

    public void init() {
        pawn = new Pawn(width, height);
        rook = new Rook(width, height);
        bishop = new Bishop(width, height);
        knight = new Knight(width, height);
        queen = new Queen(width, height);
        king = new King(width, height);
    }
}