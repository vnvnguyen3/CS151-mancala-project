package mancala;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class SquareStyle implements Style, Icon{
	@Override
	public Color getPitColor() {
		return Color.PINK;
	}

	@Override
	public Shape getPitShape() {
		return new Rectangle2D.Double(0, 0, 170, 170);
	}

	@Override
	public int getIconHeight() 
		return 0;
	}

	@Override
	public int getIconWidth() {
		return 0;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Shape s = new Rectangle2D.Double(0, 0, 170, 170);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.PINK);
		g2.fill(s);
		g2.draw(s);
	}

}
