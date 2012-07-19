import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Button2 extends JFrame{
	private JButton neustart;
	private JButton einspieler;
	private JButton zweispieler;
	private JButton highscore;
	
	private JButton bild;
	public gui(){
		super("Titel");
		setLayout (new FlowLayout());
		
		neustart = new JButton ("Neustart Knopf");
		add(neustart);
		
		einspieler = new JButton ("Ein Spieler Knopf");
		add(einspieler);
		
		zweispieler = new JButton ("Zwei Spieler Knopf");
		add(zweispieler);
		
		highscore = new JButton ("Highscoret Knopf");
		add(highscore);
		
		
		ausfuehrenKlasse ausfuehren = new ausfuehrenKlasse();
		neustart.addAncestorListener(ausfuehren);
		einspieler.addAncestorListener(ausfuehren);
		zweispieler.addAncestorListener(ausfuehren);
		highscore.addAncestorListener(ausfuehren);
	}
	private class ausfuhrenKlasse implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
			
		}
	}
}