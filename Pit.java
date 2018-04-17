package mancala;
/*
 * @author Vincent Nguyen
 */
public class Pit {
	private int stones;
	private Pit next;
	private Pit opposite;
	private CapturePit capture;
	private boolean end;
	/*
	 * Pit class
	 */
	public Pit(int s) {
		stones = s;
		end  = false;
	}
	/*
	 * Returns the number of stones in the pit
	 * @return the number of stones in the pit
	 */
	public int getStones() {
		return stones;
	}
	/*
	 * Adds one stone to the pit
	 */
	public void add() {
		stones++;
	}
	/*
	 * Adds many stones to the pit
	 * @param s the number of stones to add
	 */
	public void add(int s) {
		stones+=s;
	}
	/*
	 * Transfers all of its stones to capture pit
	 * @param p the capture pit to transfer to
	 */
	public void transferTo(CapturePit p) {
		p.gather(stones);
		remove();
	}
	/*
	 * Removes all stones in the pit
	 */
	public void remove() {
		stones = 0;
	}
	/*
	 * When you click on this pit, it will remove its stones and pass them to the next pit
	 */
	public void click() {
		if(stones>0) {
			int s = stones;
			remove();
			next.receive(s);
		}
	}
	/*
	 * Receive stones from previous pit 
	 * @param s the number of stones passed from the previous pit
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
		/*
		else if(stones==1&&opposite.getStones()>0){	
			transferTo(capture);
			opposite.transferTo(capture);
		}
		*/
	}
	/*
	 * Sets the opposite pit
	 * @param p the opposite pit
	 */
	public void setOpposite(Pit p) {
		opposite = p;
	}
	/*
	 * Returns the opposite pit
	 * @return the opposite pit
	 */
	public Pit getOpposite() {
		return opposite;
	}
	/*
	 * Sets the next pit
	 * @param p the next pit
	 */
	public void setNext(Pit p) {
		next = p;
	}
	/*
	 * Sets the capture pit
	 * @param p the capture pit
	 */
	public void setCapture(CapturePit p) {
		capture = p;
	}
	/*
	 * Returns the capture pit
	 * @return the capture pit
	 */
	public CapturePit getCapture() {
		return capture;
	}
	/*
	 * Return true if the pit is the lost stone dropped in
	 * @return end
	 */
	public boolean isEnd() {
		return end;
	}
	/*
	 * Sets end to false
	 */
	public void notEnd() {
		end = false;
	}
	/*
	 * Return true if this is the capture pit
	 * @return false
	 */
	public boolean isCapture() {
		return false;
	}
}
