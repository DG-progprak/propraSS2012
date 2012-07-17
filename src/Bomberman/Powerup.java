package Bomberman;

public class Powerup extends Item{

	
	Powerup(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("powerup"));
		// TODO Auto-generated constructor stub
	}

	public void visit(Player player){
		player.setBombradius(2);
		destroy();
	}
}
