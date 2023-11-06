package controll;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import model.Move;
import model.Piece;
import model.Player;
import model.Spot;
import view.Board;

public class ControllBoard implements MouseMotionListener, MouseListener {
	private Board board;
	private Spot spotSelected = null, spotPerve = null;
	private Player whiteTurn = new Player(true), blackTurn = new Player(false);
	boolean whiteTurnData = true;

	public Spot getSpotPerve() {
		return spotPerve;
	}

	public void setSpotPerve(Spot spotPerve) {
		this.spotPerve = spotPerve;
	}

	private Piece pieceSelected = null;
	private Point point = null;
	private Point pointDf = null;
	private Move move = null;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Spot getSpotSelected() {
		return spotSelected;
	}

	public void setSpotSelected(Spot spotSelected) {
		this.spotSelected = spotSelected;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPointDf() {
		return pointDf;
	}

	public void setPointDf(Point pointDf) {
		this.pointDf = pointDf;
	}

	public ControllBoard(Board board) {
		super();
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		// lay spot tren board
		this.spotSelected = this.board.getSpotByPoint(e.getPoint());

		// kiem tra spot moiw vau preass co null hay ko

		if (this.spotSelected != null) {
			this.pieceSelected = this.spotSelected.getPiece();

			if (this.spotSelected.getPiece().isWhite() == whiteTurnData) {
				this.move = new Move(spotSelected, pieceSelected);
				this.whiteTurnData = !this.whiteTurnData;
			}else {
				this.board.showWarmTurnMess(this.whiteTurnData);
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// buoc 1 lay df tai e
		this.point = this.getPointDf(e);
		// buuoc 2

		Point oldPoint = new Point(this.pieceSelected.getDx(), this.pieceSelected.getDy());
		this.board.update(this.pieceSelected, oldPoint, point);
		this.board.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		if (this.spotSelected != null) {
			this.point = e.getPoint();
			this.move.Move(this.point);
			this.board.repaint();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Point getPointDf(MouseEvent e) {
		int dx = e.getY() / (this.board.getSpotSize());
		int dy = e.getX() / (this.board.getSpotSize());

		return new Point(dx, dy);
	}

}
