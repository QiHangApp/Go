package edu.csuft.lqh.go;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 棋子
 * @author lqh
 *
 */
public class Piece {
	
	/**
	 * x 坐标
	 */
	int x;
	
	/**
	 * y 坐标
	 */
	int y;
	
	
	/**
	 * 棋子颜色
	 */
	boolean isBlack = true;
	
	/**
	 * 棋子大小
	 */
	int size = 40;
	
	/**
	 * 落子
	 * @param x
	 * @param y
	 */
	public Piece(int x, int y) {
		super();
		this.x = x - size/2;
		this.y = y - size/2;
	}
	
	/**
	 * 绘制(显示在画布中)
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(isBlack ? Color.BLACK : Color.WHITE);
		g.fillOval(x, y, size, size);
	}
}
