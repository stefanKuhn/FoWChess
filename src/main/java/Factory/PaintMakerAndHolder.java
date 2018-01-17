/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Sumpf
 */
public class PaintMakerAndHolder {

    static PaintMakerAndHolder instance;

    Background black, white, selected, highlighted, fogBlack, fogWhite, highlightedFog;

    private PaintMakerAndHolder() {
    }

    public static PaintMakerAndHolder getInstance() {
        if (instance == null) {
            instance = new PaintMakerAndHolder();
            instance.init();

        }
        return instance;
    }

    //instantiates all BG's
    private void init() {
        black = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
        white = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        selected = new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY));
        highlighted = new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY));
        fogBlack = new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY));
        fogWhite = new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY));
        highlightedFog = new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY));
    }

    public Background getBlack() {
        return black;
    }

    public Background getWhite() {
        return white;
    }

    public Background getSelected() {
        return selected;
    }

    public Background getHighlighted() {
        return highlighted;
    }

    public Background getFogBlack() {
        return fogBlack;
    }

    public Background getFogWhite() {
        return fogWhite;
    }

    public void setFogWhite(Background fogWhite) {
        this.fogWhite = fogWhite;
    }

    public Background getHighlightedFog() {
        return highlightedFog;
    }

}
