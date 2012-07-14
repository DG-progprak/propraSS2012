package Bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener{
	
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	boolean debug = false;
	boolean plant = false;

	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("key pressed: " + c);
		if(c == 'w') up = true;
		if(c == 's') down = true;
		if(c == 'a') left = true;
		if(c == 'd') right = true;
		if(c == 'e') plant = true;
		
		if(c == 'x') debug = true;	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("key released: " + c);
		if(c == 'w') up = false;
		if(c == 'a') down = false;
		if(c == 's') left = false;
		if(c == 'd') right = false;	
		if(c == 'e') plant = false;
		
		if(c == 'x') debug = false;	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
