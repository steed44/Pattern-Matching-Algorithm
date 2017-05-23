package com.paint.ght;

import java.awt.Font;
import java.awt.Graphics;

public class PaintRect {

	private String chString;
	private int x, y;

	public PaintRect(String textChar, int x, int y) {
		this.x = x;
		this.y = y;
		this.chString = textChar;
	}

	public void drawRwct(Graphics g, int i) {
		g.drawRect(x + 5, y + 5, 30, 30);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString(String.valueOf(i), x+8, y+2);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString(chString, x + 5, y + 30);
	}
	public void drawRwctBc(Graphics g) {
		g.drawRect(x + 5, y + 5, 30, 30);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString(chString, x + 5, y + 30);
	}
}
