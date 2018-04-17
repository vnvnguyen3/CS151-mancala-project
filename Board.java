package mancala;

import java.util.ArrayList;
/*
 * @author Vincent Nguyen
 */
public class Board {
	private Pit a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6;
	private CapturePit a7,b7;
	private ArrayList<Pit> aPits,bPits;
	private boolean aTurn,capture;
	/*
	 * Board class
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
	/*
	 * Alternative board class
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
	 * Prints visual of the board
	 * will not be used in the final product
	 */
	public ArrayList<String> visual(){
		ArrayList<String> visual = new ArrayList<String>();
		visual.add("     B6 B5 B4 B3 B2 B1");
		visual.add("     "+b6.getStones()+"    "+b5.getStones()+"    "+b4.getStones()+"    "+b3.getStones()+"    "+b2.getStones()+"    "+b1.getStones());
		visual.add("B                                        A");
		visual.add(b7.getStones()+"                                        "+a7.getStones());
		visual.add("     "+a1.getStones()+"    "+a2.getStones()+"    "+a3.getStones()+"    "+a4.getStones()+"    "+a5.getStones()+"    "+a6.getStones());
		visual.add("     A1 A2  A3  A4  A5  A6");
		return visual;
	}
	/*
	 * Returns true if all of the pits on a's side is empty
	 */
	public boolean aDone() {
		for(Pit p: aPits) {
			if(p.getStones()>0) {
				return false;
			}
		}
		for(Pit p: bPits) {
			p.transferTo(b7);
		}
		return true;
	}
	/*
	 * Returns true if all of the pits on b's side is empty
	 */
	public boolean bDone() {
		for(Pit p: bPits) {
			if(p.getStones()>0) {
				return false;
			}
		}
		for(Pit p: aPits) {
			p.transferTo(a7);
		}
		return true;
	}
	/*
	 * Returns one of the pits on the board
	 * @return the pit
	 */
	public Pit get(int i) {
		if(i>=0||i<=5) {
			return aPits.get(i);
		}
		else if(i == 6) {
			return a7;
		}
		else if(i>=7||i<=12) {
			int j = i-7;
			return bPits.get(j);
		}
		else {
			return b7;
		}
	}
	/*
	 * Selects pit that will be clicked on
	 */
	public void select(int i) {
		int j = i - 1;
		if(aTurn) {
			aPits.get(j).click();
		}
		else{
			bPits.get(j).click();
		}
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
	/*
	 * Returns true if the last move ended on the capture pit
	 * @return capture
	 */
	public boolean wasCapture() {
		return capture;
	}
	/*
	 * Returns an array of integers based on how many stones each pit has
	 * @return an int array
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
	/*
	 * Returns true if it is a's turn
	 * @return aTurn
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
	/*
	 * Return true if a is winning
	 * @return status of game
	 */
	public boolean aWins() {
		return a7.getStones()>b7.getStones();
	}
	/*
	 * Return true if b is winning
	 * @return status of game
	 */
	public boolean bWins() {
		return a7.getStones()<b7.getStones();
	}
}
