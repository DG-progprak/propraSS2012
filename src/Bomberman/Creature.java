package Bomberman;

public abstract class Creature extends Sprite {

	protected int old_tposX;
	protected int old_tposY;
	
	Creature(TileMap map, int tile_posX, int tile_posY) {
		super(map, tile_posX, tile_posY);
	}
	
	protected boolean isMoving = false;
	
	
	
	

}
