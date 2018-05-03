/**
 * Team Project Solution
 * Author: Vincent Nguyen, My Nguyen, Seng Cheok
 * Version: Coding in Java Language
 * Copyright
 */
package project.CS151;

/**
 * CapturePit class
 * @author Vincent Nguyen, My Nguyen, Seng Cheok
 * Postcondition: Store all the stones that each player wins in their own Mancala
 */
public class CapturePit extends Pit{
	
	//constructor
	public CapturePit(int s) {
		super(s);
	}
	/**
	 * gather function
	 * @param s the number of stones from the pits
	 * Postcondition: Gathers all of the stones from pits
	 */
	public void gather(int s) {
		super.add(s);
	}
	/**
	 * isCapture function
	 * @return true
	 * Postcondition: Return true if this is the capture pit
	 */
	public boolean isCapture() {
		return true;
	}

}//end CapturePit class
