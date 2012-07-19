package Bomberman;

public class Goal extends Item{
	
	Goal(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("goal"));		
	}

	public void visit(Player player){
		map.main.restart("random", map.players);
		
	}
}
