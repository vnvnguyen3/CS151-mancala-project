package projectExample;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Style1{
	
	static JFrame frame;
	static JLabel text = new JLabel();
	static Circle pit = new Circle(65, 65);
	static Circle capturePit = new Circle(65, 200);
	JPanel  panel = new JPanel();
	static JLabel pits[] = new JLabel[14];
	static JButton buttons[] = {
			new JButton("A1     "),
			new JButton("A2     "),
			new JButton("A3     "),
			new JButton("A4     "),
			new JButton("A5     "),
			new JButton("A6     "),
			new JButton("B6     "),
			new JButton("B5     "),
			new JButton("B4     "),
			new JButton("B3     "),
			new JButton("B2     "),
			new JButton("B1     ")};
	
	static JButton undo = new JButton("Undo");
	
	//public static void main(String[] args) {
	public Style1(Board1 b){
		
		frame = new JFrame();
		BorderLayout layout = new BorderLayout();
		frame.getContentPane().setLayout(layout);
		frame.setSize(700, 350);
		int []arr = b.list();
		for(int i = 0; i < 12; i++ ){
			pits[i] = new JLabel(Integer.toString(arr[i]));	
		}
		for(int i = 12; i < 14; i++ ){
			pits[i] = new JLabel("0");	
		}	
		
		Container rowA = new Container();
		// Layout from left to right
		rowA.setLayout( new FlowLayout() );
		for(int i = 0; i < 6; i++) 
			rowA.add(buttons[i]);
		
		Container A = new Container();
		// Layout from left to right
		A.setLayout( new FlowLayout() );
		for(int i = 0; i < 6; i++) {	
			A.add(pits[i]);
			pits[i].setIcon(pit);
			pits[i].setHorizontalTextPosition(JLabel.CENTER);
		}
		
		Container B = new Container();
		// Layout from left to right
		B.setLayout( new FlowLayout() );
		for(int i = 6; i < 12; i++){
			B.add(pits[i]);
			pits[i].setIcon(pit);
			pits[i].setHorizontalTextPosition(JLabel.CENTER);	
		}
		
		Container rowB = new Container(); // Create a container
		rowB.setLayout(new FlowLayout() ); // Layout from left to right
		for(int i = 6; i < 12; i++) 
			rowB.add(buttons[i]);
		
		Container undoButton = new Container();
		undoButton.setLayout(new FlowLayout() );
		undoButton.add(undo);
		
		Container captureA = new Container();
		captureA.setLayout(new FlowLayout() );
		captureA.add(pits[12]);
		pits[12].setIcon(capturePit);
		pits[12].setHorizontalTextPosition(JLabel.CENTER);
		Container captureB = new Container();
		captureB.setLayout(new FlowLayout() );
		captureB.add(pits[13]);
		pits[13].setIcon(capturePit);
		pits[13].setHorizontalTextPosition(JLabel.CENTER);
		
		Container rows = new Container();
		// layout from top to bottom
		rows.setLayout(new BoxLayout(rows, BoxLayout.Y_AXIS) );
		rows.add(rowB);
		rows.add(B);
		rows.add(A);
		rows.add(rowA);
		rows.add(undoButton);
		frame.add(rows, BorderLayout.CENTER);
		frame.add(pits[12], BorderLayout.EAST);
		frame.add(pits[13], BorderLayout.WEST);
		frame.add(undoButton, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);      
		
	}
	
	public JButton[] pitButton(){		
		return buttons;		
	}
	public JButton undoButton(){
		return undo;
	}

}
