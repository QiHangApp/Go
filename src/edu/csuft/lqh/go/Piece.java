package edu.csuft.lqh.go;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * ����
 * @author lqh
 *
 */
public class Piece {
	
	/**
	 * x ����
	 */
	int x;
	
	/**
	 * y ����
	 */
	int y;
	
	
	/**
	 * ������ɫ
	 */
	boolean isBlack = true;
	
	/**
	 * ���Ӵ�С
	 */
	int size = 40;
	
	/**
	 * ����
	 * @param x
	 * @param y
	 */
	public Piece(int x, int y) {
		super();
		this.x = x - size/2;
		this.y = y - size/2;
	}
	
	/**
	 * ����(��ʾ�ڻ�����)
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(isBlack ? Color.BLACK : Color.WHITE);
		g.fillOval(x, y, size, size);
	}
}
