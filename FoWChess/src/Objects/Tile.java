 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Factory.PaintMakerAndHolder;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    Image image;
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
    
    //here come the light related functions
    
    public void goDark(){
        this.lightlevel = 0;
    }
    
    public void adaptLight(){
        if (getMob()!=null){
            if (getMob().ownerId==fowchess.FoWChess.getWhoseTurn())
            lightlevel=getMob().getVision();
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
            w=fowchess.FoWChess.getWest(this);
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
        fowchess.FoWChess.getHighlightedTiles().push(this);
        if (lightlevel>0){
        setBackground(PaintMakerAndHolder.getInstance().getHighlighted());
        
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
    
    public void drawFigure()
    { 
    	int tileWidth = 50;
    	int tileHeight = 50;
    	if(this.mob == null)
    	{
    		
    	}
    	else
    	{
	    	switch(this.mob.getName()) 
		    {
		    	case "Bishop" :
		    		if(this.mob.getOwnerId() == 0)
		    		{
		    			image = new Image("/images/whitebishop.bmp", tileWidth, tileHeight, false, false);
		    		}
		    		else
		    		{
		    	    	image = new Image("/images/blackbishop.bmp", tileWidth, tileHeight, false, false);
		    		}
		    		break;
		    	case "King" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		image = new Image("/images/whiteking.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						image = new Image("/images/blackking.bmp", tileWidth, tileHeight, false, false);
					}
		    		break;
		    	case "Knight" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		image = new Image("/images/whiteknight.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						image = new Image("/images/blackknight.bmp", tileWidth, tileHeight, false, false);
					}
					break;
		    	case "Queen" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		image = new Image("/images/whitequeen.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						image = new Image("/images/blackqueen.bmp", tileWidth, tileHeight, false, false);
					}
					break;
		    	case "Rook" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		image = new Image("/images/whiterook.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						image = new Image("/images/blackrook.bmp", tileWidth, tileHeight, false, false);
					}
					break;
		    	default :             // Pawn = default
		    		if(this.mob.getOwnerId() == 0)
					{
		    			image = new Image("/images/whitepawn.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						image = new Image("/images/blackpawn.bmp", tileWidth, tileHeight, false, false);
					}
		    		break;
		    }
	    	ImageView imv = new ImageView();
	    	imv.setImage(image);
    	}
    }
    
    
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Factory.PaintMakerAndHolder;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    
    //here come the light related functions
    
    public void goDark(){
        this.lightlevel = 0;
    }
    
    public void adaptLight(){
        if (getMob()!=null){
            if (getMob().ownerId==fowchess.FoWChess.getWhoseTurn())
            lightlevel=getMob().getVision();
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
            w=fowchess.FoWChess.getWest(this);
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
        fowchess.FoWChess.getHighlightedTiles().push(this);
        if (lightlevel>0){
        setBackground(PaintMakerAndHolder.getInstance().getHighlighted());
        
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
    
    public void drawFigure()
    { 
    	int tileWidth = 50;
    	int tileHeight = 50;
    	if(this.mob == null)
    	{
    		
    	}
    	else
    	{
	    	switch(this.mob.getName()) 
		    {
		    	case "Bishop" :
		    		if(this.mob.getOwnerId() == 0)
		    		{
		    			Image image = new Image("/images/whitebishop.bmp", tileWidth, tileHeight, false, false);
		    		}
		    		else
		    		{
		    	    	Image image = new Image("/images/blackbishop.bmp", tileWidth, tileHeight, false, false);
		    		}
		    		break;
		    	case "King" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		Image image = new Image("/images/whiteking.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						Image image = new Image("/images/blackking.bmp", tileWidth, tileHeight, false, false);
					}
		    		break;
		    	case "Knight" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		Image image = new Image("/images/whiteknight.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						Image image = new Image("/images/blackknight.bmp", tileWidth, tileHeight, false, false);
					}
					break;
		    	case "Queen" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		Image image = new Image("/images/whitequeen.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						Image image = new Image("/images/blackqueen.bmp", tileWidth, tileHeight, false, false);
					}
					break;
		    	case "Rook" :
			    	if(this.mob.getOwnerId() == 0)
					{
			    		Image image = new Image("/images/whiterook.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						Image image = new Image("/images/blackrook.bmp", tileWidth, tileHeight, false, false);
					}
					break;
		    	default :             // Pawn = default
		    		if(this.mob.getOwnerId() == 0)
					{
		    			Image image = new Image("/images/whitepawn.bmp", tileWidth, tileHeight, false, false);
					}
					else
					{
						Image image = new Image("/images/blackpawn.bmp", tileWidth, tileHeight, false, false);
					}
		    		break;
		    }
    	}
    }
    
    
}
>>>>>>> b959c81a43ea2e74266828ea65cc1bb6ba89e973
