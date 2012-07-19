package Bomberman;

public class Player extends Creature {
	public static int players=0;
	
	private int z = 2;
	
	private int player;
    private int bombradius=1;
    	
	Player(TileMap map, int tile_posX, int tile_posY) {
		super(map, tile_posX, tile_posY);
		posX = map.X_TileToPixel(tile_posX);
		posY = map.Y_TileToPixel(tile_posY) - 10;
		this.player=players+1;
		players++;
		
		if (player==1) map.main.inputManager.setPlayer1(this);
		if (player==2) map.main.inputManager.setPlayer2(this);
		this.setImage(ImageLoader.getImage("player" + player + "_down_1"));
	}
	
	
	public void action(String action) {
	
		System.out.println("player: action " + action);//debug
		
		if (!isMoving) {
			
			if (action.equals("up") || action.equals("down") || action.equals("left") || action.equals("right")){
				currentDirection = action;
				
				//keep old position
				old_tposX=tposX();
				old_tposY=tposY();
				
				move(action);
			} else if (action.equals("plant")) map.spawnBomb( tposX(), tposY(), bombradius );
			
		}
	}
	
	private void move(String direction){
		int i = 0;
		int j = 0;
		
		if (direction.equals("up")) j = -1;
		if (direction.equals("down")) j = 1;
		if (direction.equals("left")) i = -1;
		if (direction.equals("right")) i = 1;
		
		anim_only = map.tiles[ tposX()+i ][ tposY()+j ].isBlocked();
		isMoving = true;
	}

	public void update() {
		int s = 2; // test,debug
		if (isMoving) {

			//sprite animation
			if (fc == 0 / s) setImage(ImageLoader.getImage("player" + player + "_" + currentDirection + "_1"));
			if (fc == 16 / s) setImage(ImageLoader.getImage("player" + player + "_" + currentDirection + "_2"));
			if (fc == 48 / s) setImage(ImageLoader.getImage("player" + player + "_" + currentDirection + "_1"));

			//actually move the sprites location
			if (!anim_only) {
				if (fc % (4 / s) == 0) {

					if (currentDirection.equals("up")) posY--;
					if (currentDirection.equals("down")) posY++;
					if (currentDirection.equals("left"))posX--;
					if (currentDirection.equals("right")) posX++;
				}
			}

			//increment framecount
			fc++;

			// update position on tilemap, +4 to guarantee moving into next pixel interval / next tile
			if (fc == ( (32 + 4) / s) ) {
				
				//remove sprite from old tile location
				map.tiles[old_tposX][old_tposY].removeSprite(this);
				
				//add sprite to new tile location
				map.tiles[tposX()][tposY()].addSprite(this);
				
				//tell tile player is there
				map.tiles[tposX()][tposY()].visit(this);

			}
			
			//movement completed
			if (fc == (63 / s)) {
				isMoving = false;
				fc = 0;
			}

		}

	}
	

	public int tposY(){
		return ( (posY + 10 + 8) / 16 );
	}
	
	public int getZ() {
		return z;
	}


	public void setBombradius(int bombradius) {
		this.bombradius = bombradius;
	}
	
	public void explode(){
		destroy();
	}
	
	public void monster(Monster monster){
		destroy();
	}
	

}
