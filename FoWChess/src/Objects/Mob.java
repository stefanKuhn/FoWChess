/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Sumpf
 */
public class Mob {
    int ownerId, vision;
    char identity;
    String name;
    boolean hasMoved;

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public Mob(int ownerId, int vision, char identity, String name) {
        this.ownerId = ownerId;
        this.vision = vision;
        this.identity = identity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public char getIdentity() {
        return identity;
    }

    public void setIdentity(char identity) {
        this.identity = identity;
    }
    
}
