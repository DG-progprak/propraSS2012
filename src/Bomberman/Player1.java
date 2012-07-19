package Bomberman;

public class Player1 extends Menuitem{
	
	Player1(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("player1"));
		// TODO Auto-generated constructor stub
		
		
		
	}

	public void visit(Player player){
	
		map.main.restart("random", 1 );
	}
}
