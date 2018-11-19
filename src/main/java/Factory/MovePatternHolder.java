/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Logger.Logger;
import MovePattern.Bishop;
import MovePattern.King;
import MovePattern.Rook;
import MovePattern.MovePattern;
import MovePattern.Pawn;
import MovePattern.Queen;
import MovePattern.Knight;
import Objects.Mob;
import Objects.Tile;
import fowchess.FoWChess;
import java.util.ArrayList;

/**
 *
 * @author Sumpf
 */
public class MovePatternHolder {

    MovePattern pawn, rook, bishop, knight, queen, king;
    static MovePatternHolder instance;
    static Tile tempTile;
    static Mob tempMob;
    int width, height;
    static Logger log;
    static ArrayList<Tile> threatenedTiles;

    public static ArrayList<Tile> getThreatenedTiles() {
        return threatenedTiles;
    }

    public static void setThreatenedTiles(ArrayList<Tile> threatenedTiles) {
        MovePatternHolder.threatenedTiles = threatenedTiles;
    }
    
    public static void clearThreatenedTiles(){
        threatenedTiles = new ArrayList();
    }
    
    public static void addThreatenedTile(Tile tile){
        threatenedTiles.add(tile);
    }

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
        this.log = Logger.getInstance();
    }

    public static MovePatternHolder getInstance() {
        if (instance == null) {
            instance = new MovePatternHolder();
            instance.init();
        }
        return instance;
    }

    public static void addNorth(Tile tile) {
        if (tile.isHn() && (tile.getN().getMob() == null || tile.getN().getMob() != null && tile.getN().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getN();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addNorth(tempTile);
            }
        }
    }

    public static void addEast(Tile tile) {
        if (tile.isHe() && (tile.getE().getMob() == null || tile.getE().getMob() != null && tile.getE().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getE();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addEast(tempTile);
            }
        }
    }

    public static void addSouth(Tile tile) {
        if (tile.isHs() && (tile.getS().getMob() == null || tile.getS().getMob() != null && tile.getS().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getS();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addSouth(tempTile);
            }
        }
    }

    public static void addWest(Tile tile) {
        if (tile.isHw() && (tile.getW().getMob() == null || tile.getW().getMob() != null && tile.getW().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getW();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addWest(tempTile);
            }
        }
    }

    public static void addNorthEast(Tile tile) {
        if (tile.isHne() && (tile.getNe().getMob() == null || tile.getNe().getMob() != null && tile.getNe().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getNe();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addNorthEast(tempTile);
            }
        }
    }

    public static void addNorthWest(Tile tile) {
        if (tile.isHnw() && (tile.getNw().getMob() == null || tile.getNw().getMob() != null && tile.getNw().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getNw();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addNorthWest(tempTile);
            }
        }
    }

    public static void addSouthEast(Tile tile) {
        if (tile.isHse() && (tile.getSe().getMob() == null || tile.getSe().getMob() != null && tile.getSe().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getSe();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addSouthEast(tempTile);
            }
        }
    }

    public static void addSouthWest(Tile tile) {
        if (tile.isHsw() && (tile.getSw().getMob() == null || tile.getSw().getMob() != null && tile.getSw().getMob().getOwnerId() != FoWChess.getWhoseTurn())) {
            tempTile = tile.getSw();
            threatenedTiles.add(tempTile);
            if (tempTile.getMob() == null || tempTile.getLightlevel() == 0) {
                addSouthWest(tempTile);
            }
        }
    }
    
    public static void highlightNorth(Tile tile) {
        threatenedTiles = new ArrayList();
        addNorth(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightEast(Tile tile) {
        threatenedTiles = new ArrayList();
        addEast(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightSouth(Tile tile) {
        threatenedTiles = new ArrayList();
        addSouth(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightWest(Tile tile) {
        threatenedTiles = new ArrayList();
        addWest(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightNorthEast(Tile tile) {
        threatenedTiles = new ArrayList();
        addNorthEast(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightNorthWest(Tile tile) {
        threatenedTiles = new ArrayList();
        addNorthWest(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightSouthEast(Tile tile) {
        threatenedTiles = new ArrayList();
        addSouthEast(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
        }
    }

    public static void highlightSouthWest(Tile tile) {
        threatenedTiles = new ArrayList();
        addSouthWest(tile);
        for (Tile tileToHighlight : threatenedTiles){
            tileToHighlight.highLight();
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

    public static boolean tryEast(int ownerId, Tile from, Tile to) {
        boolean returnValue = false;
        boolean returnState = false;
        if (FoWChess.getTilesUnderAttack().contains(from)){
            return false;
        }
        else if (from.equals(to)) {
            return true;
        }
        else if (!(from.getE().getMob() == null || (tempMob = from.getE().getMob()).getOwnerId() == ownerId && !tempMob.isHasMoved() && tempMob.getName().equals("rook"))) {
            returnState = true;
        }
        if (!returnState) {
            returnValue = tryEast(ownerId, from.getE(), to);
        }
        return returnValue;
    }

    public static boolean tryWest(int ownerId, Tile from, Tile to) {
        boolean returnValue = false;
        boolean returnState = false;
        if (FoWChess.getTilesUnderAttack().contains(from)){
            return false;
        }
        else if (from.equals(to)) {
            return true;
        }
        else if (!(from.getW().getMob() == null || (tempMob = from.getW().getMob()).getOwnerId() == ownerId && !tempMob.isHasMoved() && tempMob.getName().equals("rook"))) {
            returnState = true;
        }
        if (!returnState) {
            returnValue = tryWest(ownerId, from.getW(), to);
        }
        return returnValue;
    }

    public static void moveNorth(Tile from, Tile to) {
        if (from == to) {
            return;
        }
        boolean returnState = false;
        if (from.getN().getMob() != null) {
            returnState = true;
            log.newEntry(from.getMob(), from.getN());
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
            log.newEntry(from.getMob(), from.getS());
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
            log.newEntry(from.getMob(), from.getE());
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
            log.newEntry(from.getMob(), from.getW());
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
            log.newEntry(from.getMob(), from.getNe());
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
            log.newEntry(from.getMob(), from.getNw());
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
            log.newEntry(from.getMob(), from.getSe());
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
            log.newEntry(from.getMob(), from.getSw());
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
