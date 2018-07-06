package edu.csuft.lqh.go;

/**
 * 游戏的模型(逻辑)
 * @author asus
 *
 */
public class GameModel {
	
	/**
	 * 棋盘的数据
	 */
	int [][] data = new int [9][9];
	
	/**
	 * 显示
	 */
	public void show() {
		for (int[] row : data) {
			for (int e : row) {
				System.out.print(e + "\t");
			}
			System.out.println();
		}
	}

	public void update(Piece piece) {
		int x = (piece.y - 50) /100;
		int y = (piece.x - 50) /100;
		data[x][y] = piece.isBlack ? 1 : 2;
		show();
		System.out.println();
	}
}
