package model;

public class Player {
boolean turn  ;

public Player() {
	
}

public Player(boolean b) {
	// TODO Auto-generated constructor stub
	this.turn =b;
}

public boolean isTurn() {
	return turn;
}

public void setTurn(boolean turn) {
	this.turn = turn;
}



}
