package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;

public class ImageHelper {

    Image bKing, bKnight, bPawn, bQueen,bRook,  bRunner, wKing, wKnight, wPawn, wQueen, wRook, wRunner;


 private ImageHelper() throws FileNotFoundException{
  this.bKing  = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackking.bmp")));
  this.bKnight  = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackknight.bmp")));
  this.bPawn = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackpawn.bmp")));
  this.bQueen = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackqueen.bmp")));
  this.bRook  = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackrook.bmp")));
  this.bRunner = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackrunner.bmp")));
  this.wKing  = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiteking.bmp")));
  this.wKnight  = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiteknight.bmp")));
  this.wPawn = new Image(new FileInputStream(new File("src\\main\\java\\images\\whitepawn.bmp")));
  this.wQueen = new Image(new FileInputStream(new File("src\\main\\java\\images\\whitequeen.bmp")));
  this.wRook  = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiterook.bmp")));
  this.wRunner = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiterook.bmp")));
 }

    private static ImageHelper instance;

    public static ImageHelper getInstance() throws FileNotFoundException {

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