package com.paint.gjt;

import java.awt.Font;
import java.awt.Graphics;

public class PaintRect {
	
	private String chString;
	private int x,y;
	public PaintRect(char textChar, int x, int y) {
		this.x = x;
		this.y = y;
		this.chString = String.valueOf(textChar);
	}
	
	public void drawRwct(Graphics g){
		g.drawRect(x+5, y+5, 30, 30);
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.drawString(chString, x+10, y+30);
	}
}
