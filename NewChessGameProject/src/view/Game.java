package view;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	public Game() {
		// TODO Auto-generated constructor stub
		this.setSize(650, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.init();
		this.setVisible(true);
	}
	public void init() {
		Board board = new Board();
		board.setBounds(0, 0, Board.EDGE_SIZE, Board.EDGE_SIZE);
		this.add(board);
	}

}
