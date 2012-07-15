package Bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener{
	
	boolean up1 = false;
	boolean down1 = false;
	boolean left1 = false;
	boolean right1 = false;
	boolean plant1 = false;
	
	boolean up2 = false;
	boolean down2 = false;
	boolean left2 = false;
	boolean right2 = false;
	boolean plant2 = false;
	
	boolean debug = false;

	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("key pressed: " + c);
		if(c == 'w') up1 = true;
		if(c == 's') down1 = true;
		if(c == 'a') left1 = true;
		if(c == 'd') right1 = true;
		if(c == 'e') plant1 = true;
		
		if(c == 'i') up2 = true;
		if(c == 'k') down2 = true;
		if(c == 'j') left2 = true;
		if(c == 'l') right2 = true;
		if(c == 'o') plant2 = true;
		
		if(c == 'x') debug = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("key released: " + c);
		if(c == 'w') up1 = false;
		if(c == 'a') down1 = false;
		if(c == 's') left1 = false;
		if(c == 'd') right1 = false;	
		if(c == 'e') plant1 = false;
		
		if(c == 'i') up2 = false;
		if(c == 'k') down2 = false;
		if(c == 'j') left2 = false;
		if(c == 'l') right2 = false;	
		if(c == 'o') plant2 = false;
		
		if(c == 'x') debug = false;	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
