package mancala;
/*
 * @author Vincent Nguyen
 */
public class CapturePit extends Pit{
	/*
	 * CapturePit class
	 */
	public CapturePit(int s) {
		super(s);
	}
	/*
	 * Gathers all of the stones from pits
	 * @param s the number of stones from the pits
	 */
	public void gather(int s) {
		super.add(s);
	}
	/*
	 * Return true if this is the capture pit
	 * @return true
	 */
	public boolean isCapture() {
		return true;
	}
}
