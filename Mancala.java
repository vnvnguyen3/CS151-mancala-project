/**
 * Team Project Solution
 * Author: Vincent Nguyen, My Nguyen, Seng Cheok
 * Version: Coding in Java Language
 * Copyright
 */
package project.CS151;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Mancala class
 * @author Vincent Nguyen, My Nguyen, Seng Cheok
 * Postcondition: create graphic Mancala board and update the board after each player 
 * 					select a pit and undo button
 */
public class Mancala {
	
	public static final int FONT_SIZE = 40;
	private Board x;
	private boolean aTurn, prevUndo;
	private int[] list;
	private int undos;
	private JFrame frame;
	private JTextArea counter;
	private JTextPane text;
	private JPanel midPanel, bottomPanel,aRow,bRow,rowPanel,mainPanel;
	private JButton a,b,three,four,first,second,undo;
	private JLabel topLabel, bottomLabel;
	private Style style;
	
	static JButton buttonsA[] = {
			new JButton("A1"),
			new JButton("A2"),
			new JButton("A3"),
			new JButton("A4"),
			new JButton("A5"),
			new JButton("A6")};
	static JButton buttonsB[] = {
			new JButton("B1"),
			new JButton("B2"),
			new JButton("B3"),
			new JButton("B4"),
			new JButton("B5"),
			new JButton("B6")};
	static JLabel C[] = new JLabel[14];
	
	/**
	 * Mancala constructor
	 * Precondition: create a frame, ask the players to choose which players would go first,
	 * 					the number of stones they want to place in each pit, and board style
	 * Postcondition: The graphic Mancala board is created.
	 * 					After each player's turn, the board is updated according to Mancala rules
	 */
	public Mancala() {
		undos = 0;
		prevUndo = false;
		list = new int[14];
		frame = new JFrame();
		midPanel = new JPanel();
		text = new JTextPane();
		text.setFont(new Font("Arial", Font.PLAIN, 55));
		text.setText("Which player goes first? A or B?");
		text.setEditable(false);
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		frame.add(text, BorderLayout.NORTH);
		
		topLabel = new JLabel("            B6          B5         B4         B3         B2          B1");
        JLabel top[] = new JLabel[6];
        top[0] = new JLabel( "   B ");
        top[1] = new JLabel( "   A ");
		bottomLabel = new JLabel("           A1          A2         A3         A4           A5          A6");
        topLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        bottomLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        aRow = new JPanel();
        aRow.setLayout(new GridLayout(1, 6));
        bRow = new JPanel();
        bRow.setLayout(new GridLayout(1, 6));
        
        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(2, 1));
        rowPanel.add(aRow);
        rowPanel.add(bRow);
        
        for(int i=0; i< 14;i++)
        {
        		if(i ==6 || i == 13) {
        		C[i] = new JLabel("0",SwingConstants.CENTER);
        		C[i].setFont(new Font("Arial", Font.PLAIN, 55));
        		}
        		else {
        		C[i] = new JLabel("3",SwingConstants.CENTER);
        		C[i].setFont(new Font("Arial", Font.PLAIN, 45));}		
        }
        for(int i=0; i<6;i++)
        {
        	 aRow.add(C[i]);
        }       
        for(int i=12; i>6;i--)
        {
        	 bRow.add(C[i]);
        }
      
        JPanel LeftPanel = new JPanel();
        LeftPanel.setPreferredSize(new Dimension(100,650));
        LeftPanel.setLayout(new BorderLayout());
        top[0].setFont(new Font("Arial", Font.PLAIN, 50));
        LeftPanel.add(top[0], BorderLayout.NORTH);
        LeftPanel.add(C[13], BorderLayout.CENTER);
     
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(100,650));
        rightPanel.setLayout(new BorderLayout());
        top[1].setFont(new Font("Arial", Font.PLAIN, 50));
        rightPanel.add(top[1], BorderLayout.SOUTH);
        rightPanel.add(C[6], BorderLayout.CENTER);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(LeftPanel, BorderLayout.WEST);
        mainPanel.add(rowPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        
        midPanel.setLayout(new BorderLayout());
        midPanel.add(topLabel, BorderLayout.NORTH);
        midPanel.add(mainPanel, BorderLayout.CENTER);
        midPanel.add(bottomLabel, BorderLayout.SOUTH);
        midPanel.setVisible(false);
              
		counter = new JTextArea();
		counter.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
		counter.setEditable(false);
		bottomPanel = new JPanel();
		
		Dimension d = new Dimension(200,200);
		a = new JButton("A");	
		a.setFont(new Font("Arial", Font.PLAIN, 50));
		a.setPreferredSize(d);
		a.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				setTurn(true);
			}
		});
		b = new JButton("B");
		b.setFont(new Font("Arial", Font.PLAIN, 50));
		b.setPreferredSize(d);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				setTurn(false);
			}
		});
		three = new JButton("3");
		three.setFont(new Font("Arial", Font.PLAIN, 50));
		three.setPreferredSize(d);
		three.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectStones(3);
			}
		});
		four = new JButton("4");
		four.setFont(new Font("Arial", Font.PLAIN, 50));
		four.setPreferredSize(d);
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStones(4);
			}
		});
		first = new JButton("Circle");	
		first.setFont(new Font("Arial", Font.PLAIN, 50));
		first.setPreferredSize(d);
		first.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStyle(true);
			}
		});
		second = new JButton("Square");
		second.setFont(new Font("Arial", Font.PLAIN, 50));
		second.setPreferredSize(d);
		second.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStyle(false);
			}
		});
		
		Dimension d1 = new Dimension(155,155);
		for( int i=0; i <6 ;i++) {
			final Integer innerloop =  (int) (i);
			buttonsA[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) 
				{
					select(innerloop);
				}	
			});
			
			buttonsA[i].setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
			buttonsA[i].setPreferredSize(d1);
			buttonsA[i].setVisible(false);
			buttonsB[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) 
				{
					select(innerloop);
				}
			});
			buttonsB[i].setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
			buttonsB[i].setPreferredSize(d1);
			buttonsB[i].setVisible(false);
		}
		
		undo = new JButton("UNDO");
		undo.setFont(new Font("Arial", Font.PLAIN, 35));
		undo.setPreferredSize(d1);
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				undo();
			}
		});
		
		three.setVisible(false);
		four.setVisible(false);
		first.setVisible(false);
		second.setVisible(false);
		undo.setVisible(false);
		counter.setVisible(false);
		
		bottomPanel.add(a);
		bottomPanel.add(b);
		bottomPanel.add(three);
		bottomPanel.add(four);
		bottomPanel.add(first);
		bottomPanel.add(second);
		bottomPanel.add(counter);
		bottomPanel.add(undo);
		
		for( int i=0; i <6 ;i++) {
			int a = 5 - i;
			bottomPanel.add(buttonsA[i]);
			bottomPanel.add(buttonsB[a]);	
		}
	
		frame.add(midPanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * setTurn function
	 * @param aTurn: boolean, true means a's turn, false means b's turn
	 * Postcondition: Sets which player goes first in the game
	 */
	public void setTurn(boolean aTurn) {
		this.aTurn = aTurn;
		a.setVisible(false);
		b.setVisible(false);
		text.setText("3 stones or 4 stones?");
		three.setVisible(true);
		four.setVisible(true);
	}
	/**
	 * selectStones function
	 * @param i: desired number of stones being placed in each pit
	 * Postcondition: Fill each pit of the board with wither 3 or 4 stones
	 */
	public void selectStones(int i) {
		x = new Board(i,aTurn);
		list = x.list();
		three.setVisible(false);
		four.setVisible(false);
		text.setText("Choose a style");
		first.setVisible(true);
		second.setVisible(true);
	}
	/**
	 * selectStlye function
	 * @param circle: boolean, true means circle style, false means square style
	 * Postcondition: Draw appropriate board style according to the choice of board style
	 */
	public void selectStyle(boolean circle) {
		
		if(circle) {
			style = new CircleStyle();
		}
		else {
			style = new SquareStyle();
		}
		
		midPanel.setVisible(true);
		
		for(int i=0; i<14; i++)
		{
			if(i != 6 && i != 13){
				C[i].setIcon((Icon) style);
			}
		}
		
		first.setVisible(false);
		second.setVisible(false);
		undo.setVisible(true);
		counter.setVisible(true);
		
		paint();
	}
	/**
	 * print function
	 * Postcondition: Update the number of stones in each pit of the board
	 */
	public void print() {
		int[] current = x.list();
		
		for(int i = 0; i < 14; i++)
			C[i].setText("" + current[i]);		
	}
	/**
	 * paint function
	 * Postcondition: Shows an updated visual of the board 
	 * 					after the player selects a pit
	 */
	public void paint() {
		aTurn = x.whoseTurn();
		counter.setText("Undos: "+undos);
		if(aTurn) {
			text.setText("A's turn");
			for(int i=0; i < 6; i++)
			{
				buttonsA[i].setVisible(true);
				buttonsB[i].setVisible(false);
			}
			
		}
		else {
			text.setText("B's turn");
			for(int i=0; i < 6; i++)
			{
				buttonsA[i].setVisible(false);
				buttonsB[i].setVisible(true);
			}
		}
		print();
	}
	/**
	 * select function
	 * @param i indicates which pit
	 * Precondition: Select a pit
	 * Postcondition: update the board
	 */
	public void select(int i) {
		i=i+1;
		if(x.get(i).getStones()>0) {
			list = x.list();
			x.select(i);
			if(!prevUndo) {
				undos = 0;
			}
			prevUndo = false;
			if(x.aDone()||x.bDone()) {
				if(x.aWins()) {
					text.setText("A is the winner!");
				}
				else if(x.bWins()) {
					text.setText("B is the winner!");
				}
				else {
					text.setText("Tie game!");
				}
				print();
			}
			else {
				paint();
			}
		}
	}
	/**
	 * undo function
	 * Precondition: select a pit
	 * Postcondition: the state of the board go back to the state 
	 * 					before the player makes a selection of a pit
	 */
	public void undo() {
		if(undos<=2) {
			aTurn = !aTurn;
			if(x.wasCapture()) {
				aTurn = !aTurn;
			}
			x = new Board(list,aTurn);
			if(!prevUndo) {
				undos++;
			}
			prevUndo = true;
		}
		paint();
	}

}
