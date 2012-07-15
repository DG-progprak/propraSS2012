package Bomberman;

import javax.swing.ImageIcon;

public class Tile {
	
	private ImageIcon image;
	private boolean blocked;
	private boolean exit;
	private boolean powerup;
	private boolean flower;
	
	
	Tile(char type){
		switch(type){
		// X = unzerstoerbare Mauer
		case 'X' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		// G = sichtbare Tuer			
		case 'G' :	setBlocked(false);
					setExit(true);
					setImage(ImageLoader.getTileImage(type));
					break;
					
		// P = Powerup		
		case 'P' :	setBlocked(false);
					setPowerup(true);
					setImage(ImageLoader.getTileImage(type));
					break;
			
		// F = Flower		
		case 'F' :	setBlocked(false);
					setFlower(true);
					setImage(ImageLoader.getTileImage(type));
					break;
					
					
		// Y = lockerer Stein (später als Sprite)
		case 'Y' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		
		// S = versteckte Tuer hinter lockerem Stein
		case 'S' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		// Boden
		default:	setBlocked(false);
					setImage(ImageLoader.getTileImage(type));
					break;
	}
		
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	public void setImage(ImageIcon image){
		this.image = image;
	}
	
	public boolean isBlocked(){
		System.out.println("Tile says blocked set to: " + blocked);
		return blocked;
	}
	
	public void setBlocked(boolean blocked){
		this.blocked = blocked;
	}
	
	//Ausgang
	public boolean isExit(){
		return exit;
	}
	
	public void setExit(boolean exit){
		this.exit = exit;
	}

	//Powerup
	public boolean isPowerup(){
		return powerup;
	}
	
	public void setPowerup(boolean powerup){
		this.powerup = powerup;
	}
	
	//Flower
	public boolean isFlower(){
		return flower;
	}
	
	public void setFlower(boolean flower){
		this.flower = flower;
	}

}
