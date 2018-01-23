package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;

public class ImageHelper {

    Image bKing, bKnight, bPawn, bQueen, bRook, bRunner, wKing, wKnight, wPawn, wQueen, wRook, wRunner;

 private ImageHelper() throws FileNotFoundException{
  this.bKing  = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackking.png")));
  this.bKnight  = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackknight.png")));
  this.bPawn = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackpawn.png")));
  this.bQueen = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackqueen.png")));
  this.bRook  = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackrook.png")));
  this.bRunner = new Image(new FileInputStream(new File("src\\main\\java\\images\\blackrunner.png")));
  this.wKing  = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiteking.png")));
  this.wKnight  = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiteknight.png")));
  this.wPawn = new Image(new FileInputStream(new File("src\\main\\java\\images\\whitepawn.png")));
  this.wQueen = new Image(new FileInputStream(new File("src\\main\\java\\images\\whitequeen.png")));
  this.wRook  = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiterook.png")));
  this.wRunner = new Image(new FileInputStream(new File("src\\main\\java\\images\\whiterunner.png")));
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
        return bKnight;
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
        return wKing;
    }

    public Image getWKnight() {
        return wKnight;
    }

    public Image getWQueen() {
        return wQueen;
    }

    public Image getWPawn() {
        return wPawn;
    }

    public Image getWRook() {
        return wRook;
    }

    public Image getWRunner() {
        return wRunner;
    }

}
