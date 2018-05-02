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
	private Board x;
	private boolean aTurn, prevUndo;
	private int[] list;
	private int undos;
	private JFrame frame;
	private JTextArea counter;
	private JTextPane text;
	private JPanel midPanel, bottomPanel,aRow,bRow,aMancala,bMancala,rowPanel,mainPanel;
	private JButton a,b,three,four,first,second,undo,a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6;
	private JLabel topLabel, bottomLabel;
	private JLabel c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
	private Style style;
	
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
		text.setFont(new Font("Arial", Font.PLAIN, 50));
		text.setText("Which player goes first? A or B?");
		text.setEditable(false);
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		frame.add(text, BorderLayout.NORTH);
		
		topLabel = new JLabel("B     B6           B5           B4           B3          B2           B1       A");
        bottomLabel = new JLabel("       A1           A2            A3           A4          A5          A6");
        topLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        bottomLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        aRow = new JPanel();
        aRow.setLayout(new GridLayout(1, 6));
        aMancala = new JPanel();
        bRow = new JPanel();
        bRow.setLayout(new GridLayout(1, 6));
        bMancala = new JPanel();
        rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(2, 1));
        rowPanel.add(bRow);
        rowPanel.add(aRow);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bMancala, BorderLayout.WEST);
        mainPanel.add(rowPanel, BorderLayout.CENTER);
        mainPanel.add(aMancala, BorderLayout.EAST);
        midPanel.setLayout(new BorderLayout());
        midPanel.add(topLabel, BorderLayout.NORTH);
        midPanel.add(mainPanel, BorderLayout.CENTER);
        midPanel.add(bottomLabel, BorderLayout.SOUTH);
        midPanel.setVisible(false);
        
        c0 = new JLabel("3",SwingConstants.CENTER);
        c1 = new JLabel("3",SwingConstants.CENTER);
        c2 = new JLabel("3",SwingConstants.CENTER);
        c3 = new JLabel("3",SwingConstants.CENTER);
        c4 = new JLabel("3",SwingConstants.CENTER);
        c5 = new JLabel("3",SwingConstants.CENTER);
        c6 = new JLabel("0",SwingConstants.CENTER);
        c7 = new JLabel("3",SwingConstants.CENTER);
        c8 = new JLabel("3",SwingConstants.CENTER);
        c9 = new JLabel("3",SwingConstants.CENTER);
        c10 = new JLabel("3",SwingConstants.CENTER);
        c11 = new JLabel("3",SwingConstants.CENTER);
        c12 = new JLabel("3",SwingConstants.CENTER);
        c13 = new JLabel("0",SwingConstants.CENTER);
        c0.setFont(new Font("Arial", Font.PLAIN, 50));
        c1.setFont(new Font("Arial", Font.PLAIN, 50));
        c2.setFont(new Font("Arial", Font.PLAIN, 50));
        c3.setFont(new Font("Arial", Font.PLAIN, 50));
        c4.setFont(new Font("Arial", Font.PLAIN, 50));
        c5.setFont(new Font("Arial", Font.PLAIN, 50));
        c6.setFont(new Font("Arial", Font.PLAIN, 50));
        c7.setFont(new Font("Arial", Font.PLAIN, 50));
        c8.setFont(new Font("Arial", Font.PLAIN, 50));
        c9.setFont(new Font("Arial", Font.PLAIN, 50));
        c10.setFont(new Font("Arial", Font.PLAIN, 50));
        c11.setFont(new Font("Arial", Font.PLAIN, 50));
        c12.setFont(new Font("Arial", Font.PLAIN, 50));
        c13.setFont(new Font("Arial", Font.PLAIN, 50));
        aRow.add(c0);
        aRow.add(c1);
        aRow.add(c2);
        aRow.add(c3);
        aRow.add(c4);
        aRow.add(c5);
        aMancala.add(c6);
        bRow.add(c12);
        bRow.add(c11);
        bRow.add(c10);
        bRow.add(c9);
        bRow.add(c8);
        bRow.add(c7);
        bMancala.add(c13);
        
		counter = new JTextArea();
		counter.setFont(new Font("Arial", Font.PLAIN, 35));
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
			public void actionPerformed(ActionEvent event) {
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
		
		Dimension d1 = new Dimension(150,150);
		undo = new JButton("UNDO");
		undo.setFont(new Font("Arial", Font.PLAIN, 35));
		undo.setPreferredSize(d1);
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				undo();
			}
		});
		a1 = new JButton("A1");
		a1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(1);
			}
		});
		a2 = new JButton("A2");
		a2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(2);
			}
		});
		a3 = new JButton("A3");
		a3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(3);
			}
		});
		a4 = new JButton("A4");
		a4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(4);
			}
		});
		a5 = new JButton("A5");
		a5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(5);
			}
		});
		a6 = new JButton("A6");
		a6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(6);
			}
		});
		b1 = new JButton("B1");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(1);
			}
		});
		b2 = new JButton("B2");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(2);
			}
		});
		b3 = new JButton("B3");
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(3);
			}
		});
		b4 = new JButton("B4");
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(4);
			}
		});
		b5 = new JButton("B5");
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(5);
			}
		});
		b6 = new JButton("B6");
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				select(6);
			}
		});
		a1.setFont(new Font("Arial", Font.PLAIN, 50));
		a2.setFont(new Font("Arial", Font.PLAIN, 50));
		a3.setFont(new Font("Arial", Font.PLAIN, 50));
		a4.setFont(new Font("Arial", Font.PLAIN, 50));
		a5.setFont(new Font("Arial", Font.PLAIN, 50));
		a6.setFont(new Font("Arial", Font.PLAIN, 50));
		b1.setFont(new Font("Arial", Font.PLAIN, 50));
		b2.setFont(new Font("Arial", Font.PLAIN, 50));
		b3.setFont(new Font("Arial", Font.PLAIN, 50));
		b4.setFont(new Font("Arial", Font.PLAIN, 50));
		b5.setFont(new Font("Arial", Font.PLAIN, 50));
		b6.setFont(new Font("Arial", Font.PLAIN, 50));
		a1.setPreferredSize(d1);
		a2.setPreferredSize(d1);
		a3.setPreferredSize(d1);
		a4.setPreferredSize(d1);
		a5.setPreferredSize(d1);
		a6.setPreferredSize(d1);
		b1.setPreferredSize(d1);
		b2.setPreferredSize(d1);
		b3.setPreferredSize(d1);
		b4.setPreferredSize(d1);
		b5.setPreferredSize(d1);
		b6.setPreferredSize(d1);
		three.setVisible(false);
		four.setVisible(false);
		first.setVisible(false);
		second.setVisible(false);
		undo.setVisible(false);
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		a4.setVisible(false);
		a5.setVisible(false);
		a6.setVisible(false);
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		counter.setVisible(false);
		bottomPanel.add(a);
		bottomPanel.add(b);
		bottomPanel.add(three);
		bottomPanel.add(four);
		bottomPanel.add(first);
		bottomPanel.add(second);
		bottomPanel.add(counter);
		bottomPanel.add(undo);
		bottomPanel.add(a1);
		bottomPanel.add(a2);
		bottomPanel.add(a3);
		bottomPanel.add(a4);
		bottomPanel.add(a5);
		bottomPanel.add(a6);
		bottomPanel.add(b6);
		bottomPanel.add(b5);
		bottomPanel.add(b4);
		bottomPanel.add(b3);
		bottomPanel.add(b2);
		bottomPanel.add(b1);
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
		c0.setIcon((Icon) style);
		c1.setIcon((Icon) style);
		c2.setIcon((Icon) style);
		c3.setIcon((Icon) style);
		c4.setIcon((Icon) style);
		c5.setIcon((Icon) style);
		c7.setIcon((Icon) style);
		c8.setIcon((Icon) style);
		c9.setIcon((Icon) style);
		c10.setIcon((Icon) style);
		c11.setIcon((Icon) style);
		c12.setIcon((Icon) style);
		
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
		c0.setText(""+current[0]);
		c1.setText(""+current[1]);
		c2.setText(""+current[2]);
		c3.setText(""+current[3]);
		c4.setText(""+current[4]);
		c5.setText(""+current[5]);
		c6.setText(""+current[6]);
		c7.setText(""+current[7]);
		c8.setText(""+current[8]);
		c9.setText(""+current[9]);
		c10.setText(""+current[10]);
		c11.setText(""+current[11]);
		c12.setText(""+current[12]);
		c13.setText(""+current[13]);
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
			a1.setVisible(true);
			a2.setVisible(true);
			a3.setVisible(true);
			a4.setVisible(true);
			a5.setVisible(true);
			a6.setVisible(true);
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(false);
			b4.setVisible(false);
			b5.setVisible(false);
			b6.setVisible(false);
		}
		else {
			text.setText("B's turn");
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(true);
			b4.setVisible(true);
			b5.setVisible(true);
			b6.setVisible(true);
			a1.setVisible(false);
			a2.setVisible(false);
			a3.setVisible(false);
			a4.setVisible(false);
			a5.setVisible(false);
			a6.setVisible(false);
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
		if(x.get(i).getStones()> 0) {
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
		if(undos <= 2) {
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