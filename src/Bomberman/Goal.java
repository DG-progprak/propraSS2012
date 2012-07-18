package Bomberman;

public class Goal extends Item{
	
	Main main;

	
	Goal(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("goal"));
		// TODO Auto-generated constructor stub
		
		
		
	}

	public void visit(Player player){
		map.main.restart("testmapC");
		
	}
}
