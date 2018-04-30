package mancala;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class SquareStyle implements Style{
	@Override
	public Color getPitColor() {
		return Color.PINK;
	}

	@Override
	public Shape getPitShape() {
		return new Rectangle2D.Double(0, 0, 65, 65);
	}

	@Override
	public void customDraw(Graphics g, int width, int height) {
		g.drawRect(0, 0, width, height);
	}

	@Override
	public void customFill(Graphics g, int width, int height) {
		g.fillRect(0, 0, width, height);
	}
}
