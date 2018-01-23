/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Objects.Mob;
import Objects.Tile;
import javafx.scene.layout.Background;

/**
 *
 * @author Sumpf
 */
public class MobFactory {

    static MobFactory instance;

    private MobFactory() {
    }
    ;
    Mob lastCreated;
    Background lastGivenBG;

    private int visionRange = 3;

    public static MobFactory getInstance() {
        if (instance == null) {
            instance = new MobFactory();
        }
        return instance;
    }

    public Mob bishop(int ownerId) {
        lastCreated = new Mob(ownerId, visionRange, "bishop");
        return lastCreated;
    }

    public Mob king(int ownerId) {
        lastCreated = new Mob(ownerId, visionRange, "king");
        return lastCreated;
    }

    public Mob knight(int ownerId) {
        lastCreated = new Mob(ownerId, visionRange, "knight");
        return lastCreated;
    }

    public Mob pawn(int ownerId) {
        lastCreated = new Mob(ownerId, visionRange, "pawn");
        return lastCreated;
    }

    public Mob queen(int ownerId) {
        lastCreated = new Mob(ownerId, visionRange, "queen");
        return lastCreated;
    }

    public Mob rook(int ownerId) {
        lastCreated = new Mob(ownerId, visionRange, "rook");
        return lastCreated;
    }
}
