package Bomberman;

import javax.swing.ImageIcon;

public class Tile {
	
	private ImageIcon image;
	private boolean blocked;
	
	Tile(char type){
		switch(type){
		// X = unzerst�rbare Mauer
		case 'X' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		// G = sichtbare T�r			
		case 'G' :	setBlocked(false);
					setImage(ImageLoader.getTileImage(type));
					break;
					
		// Y = lockerer Stein		
		case 'Y' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		
		// S = versteckte T�r hinter lockerem Stein
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

}
