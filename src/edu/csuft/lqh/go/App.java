package edu.csuft.lqh.go;

public class App {
	public static void main(String[] args) {
		// 逻辑（模型）
		GameModel gameModel = new GameModel();
		// 界面（视图）
		GameFrame frame = new GameFrame(gameModel);
	}
}
