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
 * ���
 * @author lqh
 *
 */
public class GamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��Ϸģ�� 
	 */
	GameModel model;
	
	MouseAdapter listener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			//ÿ�����������һ������
			Piece piece = new Piece(e.getX(), e.getY());
			piece.isBlack = pieceList.size() % 2 == 0;
			pieceList.add(piece);
			
			// ����ģ��
			model.update(piece);
			// ������Ҫ���»���
			repaint();
		}
	};
	
	//һ������
	Piece piece;
	
	ArrayList<Piece> pieceList = new ArrayList<>();
	/**
	 * ����
	 */
	Image bg;
	
	/**
	 * ������Ϸ���
	 */
	public GamePanel(GameModel model) {
		try {
			// ���ع���Ŀ¼�е�ͼƬ
			bg = ImageIO.read(new File("res/go.jpg"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//Paint(graphics);
		piece = new Piece(300, 300);
		
		//ע��һ������¼�
		addMouseListener(listener);
	}
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		Graphics2D g = (Graphics2D) graphics;
		//���� 2D ��Ⱦ�Ŀ����ѡ��
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		//����
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
		//����
//		g.fillOval(300, 300, 70, 70);
		for (Piece piece : pieceList) {
			piece.paint(g);
			
		}
	}
}
