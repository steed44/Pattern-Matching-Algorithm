package com.paint.ght;

import java.awt.Font;
import java.awt.Graphics;

public class PaintIndicator {
	// private char[] Index = {30,31};//new byte[2];
	private int textX, textY;
	private int patternX, patternY;
	String string = "▲";

	public PaintIndicator(int textX, int textY, int patternX, int patternY) {

		// this.textIndex = 30;
		// this.patternIndex = 31;
		// this.Index[0] = 30;
		// this.Index[1] = 31;
		this.patternX = patternX;
		this.patternY = patternY;
		this.textX = textX;
		this.textY = textY;

	}

	public void drawTextIndicator(Graphics g) {
		g.setFont(new Font("Courier", Font.BOLD, 20));
		// g.drawString(string, patternX+35, patternY+55);
		g.drawString("i" + string, textX + 10, textY + 55);

	}

	public void drawPatternIndicator(Graphics g) {
		g.setFont(new Font("Courier", Font.BOLD, 20));
		g.drawString("j" + string, patternX + 10, patternY + 55);
		// g.drawString(string, textX+35, textY+55);

	}

	/**
	 * 
	 * @param g
	 *            画笔
	 * @param c
	 *            要绘制的变量
	 */
	public void drawIndicatorX(Graphics g, String c) {
		if ("i".equals(c)) {
			g.setFont(new Font("Courier", Font.BOLD, 20));
			// g.drawString(string, patternX+35, patternY+55);
			g.drawString(c + string, patternX + 10, patternY + 55);

		} else if ("j".equals(c)) {
			g.setFont(new Font("Courier", Font.BOLD, 20));
			// g.drawString(string, patternX+35, patternY+55);
			g.drawString(c + string, textX + 10, textY + 55);
		}

	}
}
