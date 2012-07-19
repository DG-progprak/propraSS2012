import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button
extends JFrame
implements ActionListener
{
	public Button()
	{
		super("JButton");
		addWindowListener(new WindowClosingAdapter());
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		
		//Neustart-Button
		JButton neustartButton = new Neustart("Neustart");
		neustartButton.addActionListener(this);
		panel.add(neustartButton);

		//Ein Spieler-Button
		JButton einspielerButton = new EinSpielerButton("Ein Spieler");
		einspielerButton.addActionListener(this);
		panel.add(einspielerButton);
		
		//Zwei Spieler-Button
		JButton zweispielerButton = new ZweiSpielerButton("Zwei Spieler");
		zweispielerButton.addActionListener(this);
		panel.add(zweispielerButton);

		//Highscore-Button
		JButton highscoreButton = new HighscoreButton("Highscore");
		highscorerButton.addActionListener(this);
		panel.add(highscoreButton);
		
		//Hilfe-Button
		JButton helpButton = new JButton("Hilfe");
		helpButton.setMnemonic('H');
		helpButton.addActionListener(this);
		panel.add(helpButton);

		//Panel hinzufügen
		cp.add(panel);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		System.out.println(event.getActionCommand());
	}
	
	public static void main(String[] args)
	{
	Buttons frame = new Buttons();
	frame.setLocation(100, 100);
	frame.setSize(300, 100);
	frame.setVisible(true);
	}
}
