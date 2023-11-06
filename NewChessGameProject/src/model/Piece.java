package model;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import view.Board;

public abstract class Piece {
		private Image image;
		private int dx,dy;
		private int locationDx,locationDy;
		private String name;
		private boolean isWhite;
		private ArrayList<Piece> arrayList;
		public ArrayList<Piece> getArrayList() {
			return arrayList;
		}
		public void setArrayList(ArrayList<Piece> arrayList) {
			this.arrayList = arrayList;
		}
		public Piece(Image image, int dx, int dy, String name, boolean isWhite,ArrayList<Piece> pieces) {
			super();
			this.image = image;
			this.dx = dx;
			this.dy = dy;
			this.locationDx = dy*Board.EDGE_SIZE/8;
			this.locationDy = dx*Board.EDGE_SIZE/8;
			this.name = name;
			this.isWhite = isWhite;
			this.arrayList =pieces;
			this.arrayList.add(this);
		}
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}
		public int getDx() {
			return dx;
		}
		public void setDx(int dx) {
			this.dx = dx;
		}
		public int getDy() {
			return dy;
		}
		public void setDy(int dy) {
			this.dy = dy;
		}
		public int getLocationDx() {
			return locationDx;
		}
		public void setLocationDx(int locationDx) {
			this.locationDx = locationDx;
		}
		public int getLocationDy() {
			return locationDy;
		}
		public void setLocationDy(int locationDy) {
			this.locationDy = locationDy;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isWhite() {
			return isWhite;
		}
		public void setWhite(boolean isWhite) {
			this.isWhite = isWhite;
		}
		public String toString() {
			return this.getName()+" ,i :"+this.getDx()+",: j "+this.getDy()+",: dx"+this.getLocationDx()+" ,dy :"+this.getLocationDy()+" :isWhite "+this.isWhite()+".";
		}
		public void setLocation(Point point) {
			this.locationDx = point.x-40;
			this.locationDy = point.y-40;
		}
		public void updatePiece(Point pointDf) {
			// TODO Auto-generated method stub
			this.dx = pointDf.x;
			this.dy = pointDf.y;
			this.locationDx = dy*Board.EDGE_SIZE/8;
			this.locationDy = dx*Board.EDGE_SIZE/8;
			
		}
		public void kill() {
			// TODO Auto-generated method stub
			this.arrayList.remove(this);
			
		}
}
