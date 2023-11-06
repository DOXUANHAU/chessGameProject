package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controll.ControllBoard;
import model.Pawn;
import model.Piece;
import model.PieceList;
import model.Player;
import model.Spot;

public class Board extends JPanel {
	public static final int EDGE_SIZE = 560;
	private int spotSize;

	public int getSpotSize() {
		return spotSize;
	}

	private Spot[][] spots;
	private PieceList pieceList;
	private ArrayList<Piece> piecesListData;
	private ControllBoard controllBoard;

	public Board() {
		this.piecesListData = new ArrayList<>();
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(EDGE_SIZE, EDGE_SIZE));
		this.spots = new Spot[8][8];
		this.spotSize = EDGE_SIZE / 8;
		this.pieceList = new PieceList(piecesListData, this.spotSize);
		this.insetrIconIntoSpot();
		this.addController();
	}

	private void addController() {
		// TODO Auto-generated method stub
		this.controllBoard = new ControllBoard(this);
		this.addMouseMotionListener(controllBoard);
		this.addMouseListener(controllBoard);

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint((Graphics2D) g);
		this.drawBoard((Graphics2D) g);
		this.drawPiece((Graphics2D) g);
	}

	public void drawBoard(Graphics2D graphics2d) {
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				if ((i + j) % 2 == 0) {
					graphics2d.setColor(new Color(235, 235, 208));

				} else {
					graphics2d.setColor(new Color(119, 148, 85));
				}
				graphics2d.fillRect(i * this.spotSize, j * this.spotSize, this.spotSize, this.spotSize);

			}
		}

	}

	public void drawPiece(Graphics2D graphics2d) {
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots.length; j++) {
				if (this.spots[i][j] != null) {
					Piece piece = this.spots[i][j].getPiece();

					graphics2d.drawImage(piece.getImage(), piece.getLocationDx(), piece.getLocationDy(), this);

				}
			}
		}
	}

//ham gan icon vao spot
	public void insetrIconIntoSpot() {
		for (int i = 0; i < this.piecesListData.size(); i++) {
			Piece piece = this.piecesListData.get(i);

			this.spots[piece.getDx()][piece.getDy()] = new Spot(piece);
		}
	}

	public Spot getSpotByPoint(Point point) {

		int dx = point.y / (this.spotSize);
		int dy = point.x / (this.spotSize);

		return this.spots[dx][dy];

	}
// update piece thong qua point moi va cu
	public void update(Piece pieceSelected, Point oldPoint, Point newPoint) {
		// neu vi tri moi == null
		if (this.spots[newPoint.x][newPoint.y] == null) {
//update vao spot
			int index = this.getIndexPiece(pieceSelected);
			this.piecesListData.get(index).updatePiece(newPoint);
			this.spots[newPoint.x][newPoint.y] = new Spot(this.piecesListData.get(index));
			this.spots[oldPoint.x][oldPoint.y] = null;

		} else {
			//check la quan j de xu li
// check la quan gi white or black
			Spot spot = this.spots[newPoint.x][newPoint.y];

			if (pieceSelected.isWhite() != spot.getPiece().isWhite()) {
// hai qua co sau khi released la khac nhau
				int index = this.getIndexPiece(pieceSelected);
				this.piecesListData.get(index).updatePiece(newPoint);
				this.spots[newPoint.x][newPoint.y] = new Spot(this.piecesListData.get(index));
				this.spots[oldPoint.x][oldPoint.y] = null;

				this.pieceList.kill(spot.getPiece());
				
			} else {
				// tra ve vi tri cu
				int index = this.getIndexPiece(pieceSelected);
				this.piecesListData.get(index).updatePiece(oldPoint);
			}
		}
	}


	public int getIndexPiece(Piece piece) {
		return this.piecesListData.indexOf(piece);

	}

	public void showWarmTurnMess(boolean whiteTurnData) {
		// TODO Auto-generated method stubif(whiteTurnData) {
		if(whiteTurnData) {
		JOptionPane.showMessageDialog(this, "Not Black Turn");
		return;
	}else {
		JOptionPane.showMessageDialog(this, "Not White Turn");
		return;
		
	}
		
	}
}
