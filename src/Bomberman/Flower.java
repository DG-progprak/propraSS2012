package Bomberman;

public class Flower extends Item{
	
	Flower(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("flower"));
		// TODO Auto-generated constructor stub
		
		
		
	}

	public void visit(Player player){
		map.main.restart("flowermap", map.players );
		destroy();
	}
}
