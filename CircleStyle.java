package mancala;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class CircleStyle implements Style{

	@Override
	public Color getPitColor() {
		return Color.YELLOW;
	}

	@Override
	public Shape getPitShape() {
		return new Ellipse2D.Double(0, 0, 65, 65);
	}

	@Override
	public void customDraw(Graphics g, int width, int height) {
		g.drawOval(0, 0, width, height);
	}

	@Override
	public void customFill(Graphics g, int width, int height) {
		g.fillOval(0, 0, width, height);
	}
	
}
