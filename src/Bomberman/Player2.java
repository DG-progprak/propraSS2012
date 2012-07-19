package Bomberman;

public class Player2 extends Menuitem{
	
	Player2(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		this.setImage(ImageLoader.getImage("player2"));
		// TODO Auto-generated constructor stub
		
		
		
	}

	public void visit(Player player){
		map.main.players=2;
		map.main.restart("random", map.players );
	}
}
