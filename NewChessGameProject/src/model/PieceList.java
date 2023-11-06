package model;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import view.ChessImage;

public class PieceList {
	private ArrayList<Piece> pieces = new ArrayList<>();
	private Image[] images;
	private ChessImage chessImage = new ChessImage();
	public PieceList(ArrayList<Piece> arrayList,int iconSize) {
		super();
		this.pieces = arrayList;
		try {
			this.images = this.chessImage.getImage(12, iconSize);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.createIconChess();
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	public Image[] getImages() {
		return images;
	}
	public void setImages(Image[] images) {
		this.images = images;
	}
	public ChessImage getChessImage() {
		return chessImage;
	}
	public void setChessImage(ChessImage chessImage) {
		this.chessImage = chessImage;
	}
	
	public void createIconChess() {
		// White Piece
				Rook rookWL = new Rook(this.images[4], 0, 0, "rookWL", true, pieces);
				Knight knightWL = new Knight(this.images[3], 0, 1, "kinghtWL", true, pieces);
				Bishop bishopWL = new Bishop(this.images[2], 0, 2, "bishopWL", true, pieces);
				King kingW = new King(this.images[0], 0, 3, "kingW", true, pieces);
				Queen queenW = new Queen(this.images[1], 0, 4, "queenW", true, pieces);
				Bishop bishopWR = new Bishop(this.images[2], 0, 5, "bishopWR", true, pieces);
				Knight knightWR = new Knight(this.images[3], 0, 6, "kinghtWR", true, pieces);
				Rook rookWR = new Rook(this.images[4], 0, 7, "rookWR", true, pieces);
				// craete Pawn
				for (int i = 0; i < 8; i++) {
					Pawn pawnW = new Pawn(this.images[5], 1, i, "pawnW", true, pieces);
				}

				// Black Piece

				Rook rookBL = new Rook(this.images[10], 7, 0, "rookBL", false, pieces);
				Knight knightL = new Knight(this.images[9], 7, 1, "kinghtBL", false, pieces);
				Bishop bishopBL = new Bishop(this.images[8], 7, 2, "bishopBL", false, pieces);
				King kingB = new King(this.images[6], 7, 3, "kingB", false, pieces);
				Queen queenB = new Queen(this.images[7], 7, 4, "queenB", false, pieces);
				Bishop bishopBR = new Bishop(this.images[8], 7, 5, "bishopBR", false, pieces);
				Knight knightBR = new Knight(this.images[9], 7, 6, "kinghtBR", false, pieces);
				Rook rookBR = new Rook(this.images[10], 7, 7, "rookBR", false, pieces);
				// craete Pawn
				for (int i = 0; i < 8; i++) {
					Pawn pawnB = new Pawn(this.images[11], 6, i, "pawnB", false, pieces);
				}

	}

	public void kill(Piece piece) {
		// TODO Auto-generated method stub
		this.getPieces().remove(piece);
	}
}
