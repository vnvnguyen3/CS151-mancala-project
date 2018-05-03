/**
 * Team Project Solution
 * Author: Vincent Nguyen, My Nguyen, Seng Cheok
 * Version: Coding in Java Language
 * Copyright
 */
package project.CS151;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

/**
 * CircleStyle class
 * @author Vincent Nguyen, My Nguyen, Seng Cheok
 * Postcondition: being used for drawing the circles which represents the pits of the board
 */
public class CircleStyle implements Style, Icon{

	/**
	 * Get each pit's color which is yellow in this case
	 */
	@Override
	public Color getPitColor() {
		return Color.YELLOW;
	}
	/**
	 * Get the shape of each pit which is an circle in this case
	 */
	@Override
	public Shape getPitShape() {
		return new Ellipse2D.Double(0, 0, 175, 175);
	}

	@Override
	public int getIconHeight() {
		return 0;
	}

	@Override
	public int getIconWidth() {
		return 0;
	}

	/**
	 * paintIcon function
	 * Draw the circle and fill its color with yellow
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Shape s = new Ellipse2D.Double(0, 0, 175, 175);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fill(s);
		g2.draw(s);
	}
}
