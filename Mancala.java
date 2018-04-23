package mancala;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * @author Vincent Nguyen
 */
public class Mancala {
	private Board x;
	private boolean aTurn, prevUndo;
	private int[] list;
	private int undos;
	private JFrame frame;
	private JTextArea area, counter;
	private JTextPane text;
	private JPanel topPanel, bottomPanel;
	private JButton a,b,three,four,first,second,undo,a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6;
	public Mancala() {
		undos = 0;
		prevUndo = false;
		list = new int[14];
		frame = new JFrame();
		frame.setLayout(new GridLayout(3,1));
		topPanel = new JPanel();
		text = new JTextPane();
		text.setText("Which player goes first? A or B?");
		text.setEditable(false);
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		frame.add(text);
		area = new JTextArea();
		area.setEditable(false);
		topPanel.add(area);
		counter = new JTextArea();
		counter.setEditable(false);
		bottomPanel = new JPanel();
		a = new JButton("A");	
		a.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				setTurn(true);
			}
		});
		b = new JButton("B");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				setTurn(false);
			}
		});
		three = new JButton("3");	
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStones(3);
			}
		});
		four = new JButton("4");
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStones(4);
			}
		});
		first = new JButton("Style 1");	
		first.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStyle();
			}
		});
		second = new JButton("Style 2");
		second.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				selectStyle();
			}
		});
		undo = new JButton("UNDO");
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
		area.setVisible(false);
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
		frame.add(topPanel);
		frame.add(bottomPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.pack();
		frame.setVisible(true);
	}
	public void setTurn(boolean aTurn) {
		this.aTurn = aTurn;
		a.setVisible(false);
		b.setVisible(false);
		text.setText("3 stones or 4 stones?");
		three.setVisible(true);
		four.setVisible(true);
	}
	public void selectStones(int i) {
		x = new Board(i,aTurn);
		list = x.list();
		three.setVisible(false);
		four.setVisible(false);
		text.setText("Choose a style");
		first.setVisible(true);
		second.setVisible(true);
	}
	public void selectStyle() {
		first.setVisible(false);
		second.setVisible(false);
		area.setVisible(true);
		undo.setVisible(true);
		counter.setVisible(true);
		paint();
	}
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
		area.setText("");
		for(String s: x.visual()) {
			area.append(s+"\n\r");
		}
	}
	public void select(int i) {
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
				area.setText("");
				for(String s: x.visual()) {
					area.append(s+"\n\r");
				}
			}
			else {
				paint();
			}
		}
	}
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