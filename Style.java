package mancala;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

/*
 * Style interface
 * @author Vincent Nguyen
 */
public interface Style {
    Color getPitColor();
    Shape getPitShape();
    //Dimension getDimension();
    void customDraw(Graphics g, int width, int height);
    void customFill(Graphics g, int width, int height);
}
