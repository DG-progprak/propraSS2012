package Bomberman;

public class Stone extends Sprite{
	
	private int z = 1;

	Stone(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("stone"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void explode(){
		//TODO
	}


	public int getZ() {
		return z;
	}

}
