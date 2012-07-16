package Bomberman;

import javax.swing.ImageIcon;

public abstract class Sprite {
	
	protected ImageIcon image;
	protected int tile_posX;
	protected int tile_posY;
	
	protected int posX;
	protected int posY;
	
	private int z = 0;
	
	TileMap map;
	
	Sprite(TileMap map, int tile_posX, int tile_posY){
		this.map = map;
		this.tile_posX = tile_posX;
		this.tile_posY = tile_posY;
		posX = map.X_TileToPixel(tile_posX);
		posY = map.Y_TileToPixel(tile_posY);
	}
	
	
	public void setImage(ImageIcon image){
		this.image = image;
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	public int posX(){
		return posX;
	}
	
	public int posY(){
		return posY;
	}
	
	public int tposX(){
		return (posX/16);
	}
	
	public int tposY(){
		return (posY/16);
	}
	
	protected void destroy(){
		map.tiles[ tposX() ][ tposY() ].removeSprite(this);
		map.sprites.remove(this);
	}
	
	abstract public void update();

	
	public int getZ() {
		return z;
	}

}
