package model;

import java.awt.Point;

public class Spot {
	 private Piece piece;

	public Spot(Piece piece) {
		super();
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void kill() {
		// TODO Auto-generated method stub
		this.piece.kill();
	}

	
}
