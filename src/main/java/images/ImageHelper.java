package images;

import javafx.scene.image.Image;

public class ImageHelper {

    /*
	Image bKing 	= new Image(getClass().getClassLoader().getResourceAsStream("/images/blackking.bmp"));
	Image bKnight 	= new Image(getClass().getClassLoader().getResourceAsStream("/images/blackknight.bmp"));
	Image bPawn	= new Image(getClass().getClassLoader().getResourceAsStream("/images/blackpawn.bmp"));
	Image bQueen	= new Image(getClass().getClassLoader().getResourceAsStream("/images/blackqueen.bmp"));
	Image bRook 	= new Image(getClass().getClassLoader().getResourceAsStream("/images/blackrook.bmp"));
	Image bRunner	= new Image(getClass().getClassLoader().getResourceAsStream("/images/blackrunner.bmp"));
	Image wKing 	= new Image(getClass().getClassLoader().getResourceAsStream("/images/whiteking.bmp"));
	Image wKnight 	= new Image(getClass().getClassLoader().getResourceAsStream("/images/whiteknight.bmp"));
	Image wPawn	= new Image(getClass().getClassLoader().getResourceAsStream("/images/whitepawn.bmp"));
	Image wQueen	= new Image(getClass().getClassLoader().getResourceAsStream("/images/whitequeen.bmp"));
	Image wRook 	= new Image(getClass().getClassLoader().getResourceAsStream("/images/whiterook.bmp"));
	Image wRunner	= new Image(getClass().getClassLoader().getResourceAsStream("/images/whiterunner.bmp"));
        */
        Image bKing, bKnight, bPawn, bQueen,bRook,  bRunner, wKing, wKnight, wPawn, wQueen, wRook, wRunner;

        private static ImageHelper instance;

	private ImageHelper(){
		
                this.bKing 	= new Image(ImageHelper.class.getResourceAsStream("../images/blackking.bmp"));
		
                
                this.bKnight 	= new Image(ImageHelper.class.getResourceAsStream("../images/blackknight.bmp"));
		this.bPawn	= new Image(ImageHelper.class.getResourceAsStream("../images/blackpawn.bmp"));
		this.bQueen	= new Image(ImageHelper.class.getResourceAsStream("../images/blackqueen.bmp"));
		this.bRook 	= new Image(ImageHelper.class.getResourceAsStream("../images/blackrook.bmp"));
		this.bRunner	= new Image(ImageHelper.class.getResourceAsStream("../images/blackrunner.bmp"));
		this.wKing 	= new Image(ImageHelper.class.getResourceAsStream("../images/whiteking.bmp"));
		this.wKnight 	= new Image(ImageHelper.class.getResourceAsStream("../images/whiteknight.bmp"));
		this.wPawn	= new Image(ImageHelper.class.getResourceAsStream("../images/whitepawn.bmp"));
		this.wQueen	= new Image(ImageHelper.class.getResourceAsStream("../images/whitequeen.bmp"));
		this.wRook 	= new Image(ImageHelper.class.getResourceAsStream("../images/whiterook.bmp"));
		this.wRunner	= new Image(ImageHelper.class.getResourceAsStream("../images/whiterunner.bmp"));
	}

    public static ImageHelper getInstance() {

        if (instance == null) {
            instance = new ImageHelper();
        }
        return instance;
    }

    public Image getBKing() {
        return bKing;
    }

    public Image getBKnight() {
        return wKnight;
    }

    public Image getBPawn() {
        return bPawn;
    }

    public Image getBQueen() {
        return bQueen;
    }

    public Image getBRook() {
        return bRook;
    }

    public Image getBRunner() {
        return bRunner;
    }

    public Image getWKing() {
        return bKing;
    }

    public Image getWKnight() {
        return wKnight;
    }

    public Image getWQueen() {
        return bQueen;
    }

    public Image getWPawn() {
        return wPawn;
    }

    public Image getWRook() {
        return bRook;
    }

    public Image getWRunner() {
        return bRunner;
    }

}
