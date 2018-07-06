package edu.csuft.lqh.go;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 面板
 * @author lqh
 *
 */
public class GamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 游戏模型 
	 */
	GameModel model;
	
	MouseAdapter listener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			//每次鼠标点击创建一个棋子
			Piece piece = new Piece(e.getX(), e.getY());
			piece.isBlack = pieceList.size() % 2 == 0;
			pieceList.add(piece);
			
			// 更新模型
			model.update(piece);
			// 画布需要重新绘制
			repaint();
		}
	};
	
	//一个棋子
	Piece piece;
	
	ArrayList<Piece> pieceList = new ArrayList<>();
	/**
	 * 棋盘
	 */
	Image bg;
	
	/**
	 * 创建游戏面板
	 */
	public GamePanel(GameModel model) {
		try {
			// 加载工程目录中的图片
			bg = ImageIO.read(new File("res/go.jpg"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//Paint(graphics);
		piece = new Piece(300, 300);
		
		//注册一个点击事件
		addMouseListener(listener);
	}
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		Graphics2D g = (Graphics2D) graphics;
		//开启 2D 渲染的抗锯齿选项
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		//棋盘
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
		//棋子
//		g.fillOval(300, 300, 70, 70);
		for (Piece piece : pieceList) {
			piece.paint(g);
			
		}
	}
}
