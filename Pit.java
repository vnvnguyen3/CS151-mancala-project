/**
 * Team Project Solution
 * Author: Vincent Nguyen, My Nguyen, Seng Cheok
 * Version: Coding in Java Language
 * Copyright
 */
package project.CS151;

/**
 * Pit class
 * @author Vincent Nguyen, My Nguyen, Seng Cheok
 * Postcondition: Hold the number of stones, the next pit, the opposite pit
 * 					for each pit ont he board
 */
public class Pit {
	
	private int stones;
	private Pit next;
	private Pit opposite;
	private CapturePit capture;
	private boolean end;

	//constructor
	public Pit(int s) {
		stones = s;
		end  = false;
	}
	/**
	 * getStones function
	 * @return the number of stones in the pit
	 * Postcondition: Get the number of stones in the pit
	 */
	public int getStones() {
		return stones;
	}
	/**
	 * add function
	 * Postcondition: Add one stone to the pit
	 */
	public void add() {
		stones++;
	}
	/**
	 * add function
	 * @param s the number of stones to add
	 * Postcondition: Add many stones to the pit
	 */
	public void add(int s) {
		stones+=s;
	}
	/**
	 * transferTo function
	 * @param p the capture pit to transfer to
	 * Postcondition: Transfers all of its stones to capture pit
	 */
	public void transferTo(CapturePit p) {
		p.gather(stones);
		remove();
	}
	/**
	 * remove function
	 * Postcondition: Removes all stones in the pit
	 */
	public void remove() {
		stones = 0;
	}
	/**
	 * click function
	 * Postcondition: When you click on this pit, it will remove its stones 
	 * 					and pass them to the next pit
	 */
	public void click() {
		if(stones>0) {
			int s = stones;
			remove();
			next.receive(s);
		}
	}
	/**
	 * receive function
	 * @param s the number of stones passed from the previous pit
	 * Postcondition: Receive stones from previous pit 
	 */
	public void receive(int s) {
		add();
		s--;
		if(s>0) {
			next.receive(s);
		}
		else {
			end = true;
		}
	}
	/**
	 * setOpposite function
	 * @param p the opposite pit
	 * Postcondition: Sets the opposite pit
	 */
	public void setOpposite(Pit p) {
		opposite = p;
	}
	/**
	 * getOpposite function
	 * @return the opposite pit
	 * Postcondition: Get the opposite pit
	 */
	public Pit getOpposite() {
		return opposite;
	}
	/**
	 * setNext function
	 * @param p the next pit
	 * Postcondition: Sets the next pit
	 */
	public void setNext(Pit p) {
		next = p;
	}
	/**
	 * setCapture function
	 * @param p the capture pit
	 * Postcondition: the capture pit is set
	 */
	public void setCapture(CapturePit p) {
		capture = p;
	}
	/**
	 * getCapture function
	 * @return the capture pit
	 * Postcondition: get the capture pit
	 */
	public CapturePit getCapture() {
		return capture;
	}
	/**
	 * isEnd function
	 * @return end
	 * Postcondition: Return true if the pit is the lost stone dropped in
	 */
	public boolean isEnd() {
		return end;
	}
	/**
	 * notEnd function
	 * Postcondition: Sets end to false
	 */
	public void notEnd() {
		end = false;
	}
	/**
	 * isCapture function
	 * @return false
	 * Postcondition: Return true if this is the capture pit
	 */
	public boolean isCapture() {
		return false;
	}
	
}//end Pit class
