/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;

/**
 *
 * @author Sumpf
 */
public class Tile extends Button{
    boolean isVisible, containsMob;
    Background tileColor;
    Mob mob;
    int x,y,lightlevel;

    public Tile(Background bg, int x, int y, int lightlevel) {
        this.isVisible = false;
        this.tileColor = bg;
        this.x = x;
        this.y = y;
        this.lightlevel = lightlevel;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean isContainsMob() {
        return containsMob;
    }

    public void setContainsMob(boolean containsMob) {
        this.containsMob = containsMob;
    }

    public Background getTileColor() {
        return tileColor;
    }

    public void setTileColor(Background tileColor) {
        this.tileColor = tileColor;
    }



    public Mob getMob() {
        return mob;
    }

    public void setMob(Mob mob) {
        this.mob = mob;
    }

    public int getLightlevel() {
        return lightlevel;
    }

    public void setLightlevel(int lightlevel) {
        this.lightlevel = lightlevel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    
    
}
