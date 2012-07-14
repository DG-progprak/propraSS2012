package Bomberman;

public class Player extends Creature {
	public static int players=0;
	
	private int player;
	private int fc=0;
	private boolean anim_only=false;
	private String currentDirection;
	
	Player(TileMap map, int tile_posX, int tile_posY) {
		super(map, tile_posX, tile_posY);
		posX = map.X_TileToPixel(tile_posX);
		posY = map.Y_TileToPixel(tile_posY) - 10;
		this.player=players+1;
		players++;
		map.main.inputManager.setPlayer(this);
		this.setImage(ImageLoader.getImage("player" + player + "_down_1"));
		
		// TODO Auto-generated constructor stub
	}
	
	
	public void move(String direction){
		System.out.println("player: move " + direction);//debug
		if (!isMoving){
			
			if(direction.equals("up")) {
				//anim_only = map.tiles[tile_posX][tile_posY - 1].isBlocked();
				anim_only = map.tiles[posX/16][(posY + 10)/16 - 1].isBlocked();
				System.out.println(anim_only); //debug
				currentDirection = direction;
				isMoving = true;
				
			} else if (direction.equals("down")) {
				//anim_only = map.tiles[tile_posX][tile_posY + 1].isBlocked();
				anim_only = map.tiles[posX/16][(posY + 10)/16 + 1].isBlocked();
				System.out.println(anim_only); //debug
				currentDirection = direction;
				isMoving = true;
				
			} else if (direction.equals("left")) {
				//anim_only = map.tiles[tile_posX - 1][tile_posY].isBlocked();
				anim_only = map.tiles[posX/16 - 1][(posY + 10)/16].isBlocked();
				System.out.println(anim_only); //debug
				currentDirection = direction;
				isMoving = true;
				
			} else if (direction.equals("right")) {
				//anim_only = map.tiles[tile_posX + 1][tile_posY].isBlocked();
				anim_only = map.tiles[posX/16 + 1][(posY + 10)/16].isBlocked();
				System.out.println(anim_only); //debug
				currentDirection = direction;	
				isMoving = true;
				
			} else if (direction.equals("plant")) {
				map.spawnBomb(posX/16,(posY + 10)/16);
			}
			
		}	
	}

	public void update(){
		int s = 2; //test,debug
		if (isMoving){
			
			if (fc == 0/s) setImage(ImageLoader.getImage("player" + player + "_" + currentDirection + "_1"));
			if (fc == 16/s) setImage(ImageLoader.getImage("player" + player + "_" + currentDirection + "_2"));
			if (fc == 48/s) setImage(ImageLoader.getImage("player" + player + "_" + currentDirection + "_1"));
			
			if (!anim_only){
				if (fc%(4/s) == 0){
					if 		(currentDirection == "up") posY--; 
					else if (currentDirection == "down") posY++;
					else if (currentDirection == "left") posX--;
					else if (currentDirection == "right") posX++;
				}
			}
			
			fc++;
			if (fc == (63/s)){
				isMoving = false;
				fc=0;
			}
		}
	}
	
	

}
