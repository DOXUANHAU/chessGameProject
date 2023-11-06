package model;

import java.awt.Point;

public class Move {
 private Spot spot;
 private Piece piece;
 private Point point;
 private int newDx,newDy;
public Move(Spot spot, Piece piece) {
	super();
	this.spot = spot;
	this.piece = piece;
	this.point = null;
	this.newDx = 0;
	this.newDy = 0;
}
public Spot getSpot() {
	return spot;
}
public void setSpot(Spot spot) {
	this.spot = spot;
}
public Piece getPiece() {
	return piece;
}
public void setPiece(Piece piece) {
	this.piece = piece;
}
public Point getPoint() {
	return point;
}
public void setPoint(Point point) {
	this.point = point;
}
public int getNewDx() {
	return newDx;
}
public void setNewDx(int newDx) {
	this.newDx = newDx;
}
public int getNewDy() {
	return newDy;
}
public void setNewDy(int newDy) {
	this.newDy = newDy;
}
public void Move(Point p) {
	// TODO Auto-generated method stub
	
	this.piece.setLocation(p);
}

 
}
