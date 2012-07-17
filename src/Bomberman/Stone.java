package Bomberman;

public class Stone extends Sprite{
	
	private int z = 1;

	Stone(TileMap map, int tposX, int tposY) {
		super(map, tposX, tposY);
		this.setImage(ImageLoader.getImage("stone"));
		map.tiles[tposX][tposY].setBlocked(true);
		// TODO Auto-generated constructor stub
	}

	
	public void explode(){
		destroy();
	}
	
	protected void destroy(){
		map.tiles[ tposX() ][ tposY() ].setBlocked(false);
		map.tiles[ tposX() ][ tposY() ].removeSprite(this);
		map.sprites.remove(this);
	}

}
