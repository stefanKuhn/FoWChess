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
    
    Tile e, ne, n, nw, w, sw, s, se;
    boolean he, hne, hn, hnw, hw, hsw, hs, hse, mapped;

    public Tile(Background bg, int x, int y, int lightlevel) {
        this.isVisible = false;
        this.tileColor = bg;
        this.x = x;
        this.y = y;
        this.lightlevel = lightlevel;
        this.isHighlighted=false;
        mapped=false;
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
        isHighlighted=false;
    }
    
    public void adaptLight(){
        if (getMob()!=null){
            lightlevel=3;
        }
        propagateLight(lightlevel);
    }
    
    public void propagateLight(int lightLevel){
        //
        if (lightLevel<this.lightlevel){
            return;
        }
        
        this.lightlevel=lightLevel;
        if (lightLevel<=1){
            return;
        }
        lightLevel--;
        
        //performance imp: mapping once after board initialisation
        if (!mapped){
            map();
        }
        if (he){
            e.propagateLight(lightLevel);
        }
        if (hne){
            ne.propagateLight(lightLevel);
        }
        if (hn){
            n.propagateLight(lightLevel);
        }
        if (hnw){
            nw.propagateLight(lightLevel);
        }
        if (hw){
            w.propagateLight(lightLevel);
        }
        if (hsw){
            sw.propagateLight(lightLevel);
        }
        if (hs){
            s.propagateLight(lightLevel);
        }
        if (hse){
            se.propagateLight(lightLevel);
        }
    }
    
    public void map(){
    if (fowchess.FoWChess.getEast(this)!=null){
            he=true;
            e=fowchess.FoWChess.getEast(this);
        }
    if (fowchess.FoWChess.getNorthEast(this)!=null){
            hne=true;
            ne=fowchess.FoWChess.getNorthEast(this);
        }
    if (fowchess.FoWChess.getNorth(this)!=null){
            hn=true;
            n=fowchess.FoWChess.getNorth(this);
        }
    if (fowchess.FoWChess.getNorthWest(this)!=null){
            hnw=true;
            nw=fowchess.FoWChess.getNorthWest(this);
        }
    if (fowchess.FoWChess.getWest(this)!=null){
            hw=true;
            w=fowchess.FoWChess.getEast(this);
        }
    if (fowchess.FoWChess.getSouthWest(this)!=null){
            hsw=true;
            sw=fowchess.FoWChess.getSouthWest(this);
        }
    if (fowchess.FoWChess.getSouth(this)!=null){
            hs=true;
            s=fowchess.FoWChess.getSouth(this);
        }
    if (fowchess.FoWChess.getSouthEast(this)!=null){
            hse=true;
            se=fowchess.FoWChess.getSouthEast(this);
        }
    mapped=true;
    }
    
    
    public void highLight(){
        if (lightlevel>0){
        setBackground(PaintMakerAndHolder.getInstance().getHighlighted());
        fowchess.FoWChess.getHighlightedTiles().push(this);
        }
        else
        {
            setBackground(PaintMakerAndHolder.getInstance().getHighlightedFog());
        }
        this.isHighlighted = true;
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

    public Tile getE() {
        return e;
    }

    public Tile getNe() {
        return ne;
    }

    public Tile getN() {
        return n;
    }

    public Tile getNw() {
        return nw;
    }

    public Tile getW() {
        return w;
    }

    public Tile getSw() {
        return sw;
    }

    public Tile getS() {
        return s;
    }

    public Tile getSe() {
        return se;
    }

    public boolean isHe() {
        return he;
    }

    public boolean isHne() {
        return hne;
    }

    public boolean isHn() {
        return hn;
    }

    public boolean isHnw() {
        return hnw;
    }

    public boolean isHw() {
        return hw;
    }

    public boolean isHsw() {
        return hsw;
    }

    public boolean isHs() {
        return hs;
    }

    public boolean isHse() {
        return hse;
    }

    public boolean isMapped() {
        return mapped;
    }
    
    
    
    
    
}
