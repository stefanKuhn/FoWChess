package Objects;

import javafx.scene.image.Image;

public class ImageHelper {
	Image bKing 	= new Image(getClass().getResourceAsStream("blackking.bmp"));
	Image bKnight 	= new Image(getClass().getResourceAsStream("blackknight.bmp"));
	Image bPawn		= new Image(getClass().getResourceAsStream("blackpawn.bmp"));
	Image bQueen	= new Image(getClass().getResourceAsStream("blackqueen.bmp"));
	Image bRook 	= new Image(getClass().getResourceAsStream("blackrook.bmp"));
	Image bRunner	= new Image(getClass().getResourceAsStream("blackrunner.bmp"));
	Image wKing 	= new Image(getClass().getResourceAsStream("whiteking.bmp"));
	Image wKnight 	= new Image(getClass().getResourceAsStream("whiteknight.bmp"));
	Image wPawn		= new Image(getClass().getResourceAsStream("whitepawn.bmp"));
	Image wQueen	= new Image(getClass().getResourceAsStream("whitequeen.bmp"));
	Image wRook 	= new Image(getClass().getResourceAsStream("whiterook.bmp"));
	Image wRunner	= new Image(getClass().getResourceAsStream("whiterunner.bmp"));
	
	private ImageHelper(){
		this.bKing 		= new Image(getClass().getResourceAsStream("blackking.bmp"));
		this.bKnight 	= new Image(getClass().getResourceAsStream("blackknight.bmp"));
		this.bPawn		= new Image(getClass().getResourceAsStream("blackpawn.bmp"));
		this.bQueen		= new Image(getClass().getResourceAsStream("blackqueen.bmp"));
		this.bRook 		= new Image(getClass().getResourceAsStream("blackrook.bmp"));
		this.bRunner	= new Image(getClass().getResourceAsStream("blackrunner.bmp"));
		this.wKing 		= new Image(getClass().getResourceAsStream("whiteking.bmp"));
		this.wKnight 	= new Image(getClass().getResourceAsStream("whiteknight.bmp"));
		this.wPawn		= new Image(getClass().getResourceAsStream("whitepawn.bmp"));
		this.wQueen		= new Image(getClass().getResourceAsStream("whitequeen.bmp"));
		this.wRook 		= new Image(getClass().getResourceAsStream("whiterook.bmp"));
		this.wRunner	= new Image(getClass().getResourceAsStream("whiterunner.bmp"));
	}
	
	private static ImageHelper instance;
	public static ImageHelper getInstance(){
	
	if (instance==null){
		instance=new ImageHelper();
	}
	return instance;
}

public Image getBKing(){
	return bKing;
}

public Image getBKnight(){
	return wKnight;
}

public Image getBPawn(){
	return bPawn;
}

public Image getBQueen(){
	return bQueen;
}

public Image getBRook(){
	return bRook;
}

public Image getBRunner(){
	return bRunner;
}


public Image getWKing(){
	return bKing;
}

public Image getWKnight(){
	return wKnight;
}

public Image getWQueen(){
	return bQueen;
}

public Image getWPawn(){
	return wPawn;
}

public Image getWRook(){
	return bRook;
}

public Image getWRunner(){
	return bRunner;
}


}
