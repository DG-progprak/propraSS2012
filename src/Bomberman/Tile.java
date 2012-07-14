package Bomberman;

import javax.swing.ImageIcon;

public class Tile {
	
	private ImageIcon image;
	private boolean blocked;
	
	Tile(char type){
		switch(type){
		// X = unzerstörbare Mauer
		case 'X' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		// G = sichtbare Tür			
		case 'G' :	setBlocked(false);
					setImage(ImageLoader.getTileImage(type));
					break;
					
		// Y = lockerer Stein		
		case 'Y' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		
		// S = versteckte Tür hinter lockerem Stein
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
