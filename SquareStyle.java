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
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

/**
 * SquareStyle class
 * @author Vincent Nguyen, My Nguyen, Seng Cheok
 * Postcondition: being used for drawing the squares which represents the pits of the board
 */
public class SquareStyle implements Style, Icon
{
	/**
	 * Get each pit's color which is pink in this case
	 */
	@Override
	public Color getPitColor() {
		return Color.PINK;
	}
	/**
	 * Get the shape of each pit which is an square in this case
	 */
	@Override
	public Shape getPitShape() {
		return new Rectangle2D.Double(0, 0, 175, 175);
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
	 * Draw the square and fill its color with pink
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Shape s = new Rectangle2D.Double(0, 0, 170, 170);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.PINK);
		g2.fill(s);
		g2.draw(s);
	}

}
