package mancala;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class CircleStyle implements Style, Icon{

	@Override
	public Color getPitColor() {
		return Color.YELLOW;
	}

	@Override
	public Shape getPitShape() {
		return new Ellipse2D.Double(0, 0, 50, 50);
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Shape s = new Ellipse2D.Double(0, 0, 250, 250);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fill(s);
		g2.draw(s);
	}
	
}
