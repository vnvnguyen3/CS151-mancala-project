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
	private boolean aTurn;
	private int[] list;
	private JFrame frame;
	private JTextArea area;
	private JTextPane text;
	private JPanel topPanel, bottomPanel;
	private JButton a,b,three,four,first,second;
	public Mancala() {
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
		area.setVisible(false);
		three.setVisible(false);
		four.setVisible(false);
		first.setVisible(false);
		second.setVisible(false);
		bottomPanel.add(a);
		bottomPanel.add(b);
		bottomPanel.add(three);
		bottomPanel.add(four);
		bottomPanel.add(first);
		bottomPanel.add(second);
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
		paint();
	}
	public void paint() {
		aTurn = x.whoseTurn();
		if(aTurn) {
			text.setText("A's turn");
		}
		else {
			text.setText("B's turn");
		}
		for(String s: x.visual()) {
			area.append(s+"\n\r");
		}
	}
}
