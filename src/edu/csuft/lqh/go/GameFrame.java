package edu.csuft.lqh.go;

import javax.swing.JFrame;

/**
 * ��Ϸ����
 * @author lqh
 *
 */
public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 */
	GamePanel gamePanel;
	
	/**
	 * ��Ϸģ��
	 */
	GameModel model;
	
	/**
	 * ������Ϸ����
	 */
	public GameFrame(GameModel model) {
		this.model = model;
		setTitle("������");
		setSize(800, 800);
		//��С���ɱ�
		setResizable(false);
		//�������λ����Ļ�м�
		setLocationRelativeTo(null);
		//���ڹر����˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel = new GamePanel(model);
		//this.add(gamePanel);
		setContentPane(gamePanel);
		//����
		setVisible(true);
	}
}
