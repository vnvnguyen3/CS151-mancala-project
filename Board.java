/**
 * Team Project Solution
 * Author: Vincent Nguyen, My Nguyen, Seng Cheok
 * Version: Coding in Java Language
 * Copyright
 */
package project.CS151;

import java.util.ArrayList;

/**
 * Board class ((this is the Model which holds the datas)
 * @author Vincent Nguyen, My Nguyen, Seng Cheok
 * Postcondition: Maintain the rules of Mancala games
 * 					Display the winner
 */

public class Board 
{

	private Pit a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6;
	private CapturePit a7,b7;
	private ArrayList<Pit> aPits,bPits;
	private boolean aTurn,capture;
	/**
	 * Board constructor
	 * @param s the initial number of stones being placed in each pit
	 * @param aTurn
	 * Postcondition: Make a connection between all the pits of the board
	 * 					to ensure the rules are correctly followed
	 */
	public Board(int s, boolean aTurn) {
		capture = true;
		this.aTurn = aTurn;
		a1 = new Pit(s);
		a2 = new Pit(s);
		a3 = new Pit(s);
		a4 = new Pit(s);
		a5 = new Pit(s);
		a6 = new Pit(s);
		b1 = new Pit(s);
		b2 = new Pit(s);
		b3 = new Pit(s);
		b4 = new Pit(s);
		b5 = new Pit(s);
		b6 = new Pit(s);
		a7 = new CapturePit(0);
		b7 = new CapturePit(0);
		a1.setNext(a2);
		a2.setNext(a3);
		a3.setNext(a4);
		a4.setNext(a5);
		a5.setNext(a6);
		a6.setNext(a7);
		a7.setNext(b1);
		b1.setNext(b2);
		b2.setNext(b3);
		b3.setNext(b4);
		b4.setNext(b5);
		b5.setNext(b6);
		b6.setNext(b7);
		b7.setNext(a1);
		a1.setOpposite(b6);
		a2.setOpposite(b5);
		a3.setOpposite(b4);
		a4.setOpposite(b3);
		a5.setOpposite(b2);
		a6.setOpposite(b1);
		b1.setOpposite(a6);
		b2.setOpposite(a5);
		b3.setOpposite(a4);
		b4.setOpposite(a3);
		b5.setOpposite(a2);
		b6.setOpposite(a1);
		a1.setCapture(a7);
		a2.setCapture(a7);
		a3.setCapture(a7);
		a4.setCapture(a7);
		a5.setCapture(a7);
		a6.setCapture(a7);
		b1.setCapture(b7);
		b2.setCapture(b7);
		b3.setCapture(b7);
		b4.setCapture(b7);
		b5.setCapture(b7);
		b6.setCapture(b7);
		aPits = new ArrayList<Pit>();
		bPits = new ArrayList<Pit>();
		aPits.add(a1);
		aPits.add(a2);
		aPits.add(a3);
		aPits.add(a4);
		aPits.add(a5);
		aPits.add(a6);
		bPits.add(b1);
		bPits.add(b2);
		bPits.add(b3);
		bPits.add(b4);
		bPits.add(b5);
		bPits.add(b6);
	}
	/**
	 * Board constructor
	 * @param l 
	 * @param aTurn
	 * Postcondition: Make a connection between all the pits of the board
	 * 					to ensure the rules are correctly followed
	 */
	public Board(int[] l, boolean aTurn) {
		capture = true;
		this.aTurn = aTurn;
		a1 = new Pit(l[0]);
		a2 = new Pit(l[1]);
		a3 = new Pit(l[2]);
		a4 = new Pit(l[3]);
		a5 = new Pit(l[4]);
		a6 = new Pit(l[5]);
		b1 = new Pit(l[7]);
		b2 = new Pit(l[8]);
		b3 = new Pit(l[9]);
		b4 = new Pit(l[10]);
		b5 = new Pit(l[11]);
		b6 = new Pit(l[12]);
		a7 = new CapturePit(l[6]);
		b7 = new CapturePit(l[13]);
		a1.setNext(a2);
		a2.setNext(a3);
		a3.setNext(a4);
		a4.setNext(a5);
		a5.setNext(a6);
		a6.setNext(a7);
		a7.setNext(b1);
		b1.setNext(b2);
		b2.setNext(b3);
		b3.setNext(b4);
		b4.setNext(b5);
		b5.setNext(b6);
		b6.setNext(b7);
		b7.setNext(a1);
		a1.setOpposite(b6);
		a2.setOpposite(b5);
		a3.setOpposite(b4);
		a4.setOpposite(b3);
		a5.setOpposite(b2);
		a6.setOpposite(b1);
		b1.setOpposite(a6);
		b2.setOpposite(a5);
		b3.setOpposite(a4);
		b4.setOpposite(a3);
		b5.setOpposite(a2);
		b6.setOpposite(a1);
		a1.setCapture(a7);
		a2.setCapture(a7);
		a3.setCapture(a7);
		a4.setCapture(a7);
		a5.setCapture(a7);
		a6.setCapture(a7);
		b1.setCapture(b7);
		b2.setCapture(b7);
		b3.setCapture(b7);
		b4.setCapture(b7);
		b5.setCapture(b7);
		b6.setCapture(b7);
		aPits = new ArrayList<Pit>();
		bPits = new ArrayList<Pit>();
		aPits.add(a1);
		aPits.add(a2);
		aPits.add(a3);
		aPits.add(a4);
		aPits.add(a5);
		aPits.add(a6);
		bPits.add(b1);
		bPits.add(b2);
		bPits.add(b3);
		bPits.add(b4);
		bPits.add(b5);
		bPits.add(b6);
	}
	
	/*
	 * Returns true if all of the pits on a's side is empty
	 */
	public boolean aDone() {
		for(Pit p: aPits) {
			if(p.getStones() > 0) {
				return false;
			}
		}
		for(Pit p: bPits) {
			p.transferTo(b7);
		}
		return true;
	}
	/**
	 * bDone function
	 * @return if b's side is empty
	 * Postcondition: Returns true if all of the pits on b's side is empty
	 * 					return false otherwise
	 */
	public boolean bDone() {
		for(Pit p: bPits) {
			if(p.getStones() > 0) {
				return false;
			}
		}
		for(Pit p: aPits) {
			p.transferTo(a7);
		}
		return true;
	}
	/**
	 * get function
	 * @param i index of a's pits or b's pits
	 * @return the pit
	 * Postcondition: Returns the selected pit on the board
	 */
	public Pit get(int i) {
		int j = i - 1;
		if(aTurn) {
			return aPits.get(j);
		}
		else {
			return bPits.get(j);
		}
	}
	/**
	 * select function
	 * @param i index of a's pits or b's pits
	 * Postcondition: Selects pit that will be clicked on
	 */
	public void select(int i) {
		int j = i - 1;
		Pit select = new Pit(0);
		if(aTurn) {
			select = aPits.get(j);
		}
		else{
			select = bPits.get(j);
		}
		if(select.getStones()>0) {
			select.click();
			Pit last = new Pit(0);
			for(Pit p: aPits) {
				if(p.isEnd()) {
					last = p;
				}
			}
			for(Pit p: bPits) {
				if(p.isEnd()) {
					last = p;
				}
			}
			if(a7.isEnd()) {
				last = a7;
			}
			else if(b7.isEnd()){
				last = b7;
			}
			if(!last.isCapture()&&last.getStones()==1&&last.getOpposite().getStones()>0) {
				boolean aPit = true;
				for(Pit p: bPits) {
					if(p==last) {
						aPit = false; 
					}
				}
				if(aPit&&aTurn||!aPit&&!aTurn) {
					last.transferTo(last.getCapture());
					last.getOpposite().transferTo(last.getCapture());
				}
			}
			aTurn = !aTurn;
			capture = false;
			if(last.isCapture()) {
				aTurn = !aTurn;
				capture = true;
			}
			last.notEnd();
		}
	}
	/**
	 * wasCapture function
	 * @return capture
	 * Postcondition: Returns true if the last move ended on the Mancala (capture pit)
	 */
	public boolean wasCapture() {
		return capture;
	}
	/**
	 * list function
	 * @return an array of stones in each pit
	 * Postcondition: Returns an array of integers based on how many stones each pit has
	 */
	public int[] list(){
		int[] list = new int[14];
		for(int i = 0;i<6;i++) {
			list[i]=aPits.get(i).getStones();
		}
		list[6]=a7.getStones();
		for(int i = 0;i<6;i++) {
			int j = i + 7;
			list[j]=bPits.get(i).getStones();
		}
		list[13]=b7.getStones();
		return list;
	}
	/**
	 * whoseTurn function
	 * @return aTurn
	 * Postcondition: Returns true if it is a's turn
	 * 					return false otherwise
	 */
	public boolean whoseTurn() {
		if(aTurn) {
			b6.setNext(a1);
			a6.setNext(a7);
		}
		else {
			b6.setNext(b7);
			a6.setNext(b1);
		}
		return aTurn;
	}
	/**
	 * aWins function
	 * @return if a is the winner
	 * Postcondition: Return true if a is winning
	 */
	public boolean aWins() {
		return a7.getStones() > b7.getStones();
	}
	/**
	 * bWins function
	 * @return if b is the winner
	 * Postcondition: Return true if b is winning
	 */
	public boolean bWins() {
		return a7.getStones()<b7.getStones();
	}
}
