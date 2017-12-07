 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Factory.PaintMakerAndHolder;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;

/**
 *
 * @author Sumpf
 */
public class Tile extends Button{
    boolean isVisible, containsMob, isHighlighted;
    public Background tileColor;
    Mob mob;
    int x,y,lightlevel;

    public Tile(Background bg, int x, int y, int lightlevel) {
        this.isVisible = false;
        this.tileColor = bg;
        this.x = x;
        this.y = y;
        this.lightlevel = lightlevel;
    }
    
    
    public void adaptBG(){
        //if tile is not visible we use the corresponding fog color, otherwise tilecolor.
        if (lightlevel==0){
            if (getTileColor()==PaintMakerAndHolder.getInstance().getBlack()){                    
                    setBackground(PaintMakerAndHolder.getInstance().getFogBlack());
                    System.out.println("black fog");
            } else {
                setBackground(PaintMakerAndHolder.getInstance().getFogWhite());
                System.out.println("white fog");
            }
        }
        else {
            setBackground(tileColor);
        }
    }
    
    
    public void highLight(){
        if (lightlevel>0){
        setBackground(PaintMakerAndHolder.getInstance().getHighlighted());
        }
        else
        {
            setBackground(PaintMakerAndHolder.getInstance().getHighlightedFog());
        }
    }

    public boolean isIsHighlighted() {
        return isHighlighted;
    }

    public void setIsHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean containsMob() {
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

    public boolean hasLeft(){
        if (x==0){
            return false;
        }
        return true;
    }
    public Tile getLeft(){
        return fowchess.FoWChess.getBoard()[x-1][y];
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
