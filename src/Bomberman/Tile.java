package Bomberman;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Tile {
	
	private ImageIcon image;
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private boolean blocked;
	private boolean isBlock=false;
	private boolean exit;
	private boolean powerup;
	private boolean flower;
	
	
	Tile(char type){
		switch(type){
		// 'X' = block
		case 'X' :	setBlocked(true);
					isBlock=true;
					setImage(ImageLoader.getTileImage(type));
					break;

		// G = goal			
		case 'G' :	setBlocked(false);
					setExit(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		
		/*
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
					
		
		// S = lockerer Stein (später als Sprite)
		case 'Y' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;

					
		// S = stone
		case 'Y' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;			
		
		// H = versteckte Tuer hinter lockerem Stein
		case 'S' :	setBlocked(true);
					setImage(ImageLoader.getTileImage(type));
					break;
		*/
					
		// floor
		default:	setBlocked(false);
					setImage(ImageLoader.getTileImage(' '));
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
	
	
	public void addSprite(Sprite sprite){
		sprites.add(sprite);
	}
	
	public void removeSprite(Sprite sprite){
		sprites.remove(sprite);
	}

	public boolean isBlock(){
		return isBlock;
	}
	
	public void explode(){
		ArrayList<Sprite> spritescopy = new ArrayList<Sprite>(sprites);
		for(Sprite sprite : spritescopy){
			sprite.explode();
		}
	}
}
