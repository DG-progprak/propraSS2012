package Bomberman;

public class Item extends Sprite {

	private int z = 0;
	
	Item(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		// TODO Auto-generated constructor stub
	}
	
	public int getZ() {
		return z;
	}

}
