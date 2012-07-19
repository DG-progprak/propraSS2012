package Bomberman;

import java.util.Random;

public class Monster extends Creature {
	
	private int z = 2;
	private Random rand = new Random();
	
	Monster(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		posX = map.X_TileToPixel(tile_posX);
		posY = map.Y_TileToPixel(tile_posY);
		//this.setImage(ImageLoader.getImage("bomb_1"));
		this.setImage(ImageLoader.getImage("monster" + "_down_1"));
		randomDirection();
	}
	
	
	public void action(String action) {

		if (!isMoving) {

			if (action.equals("up") || action.equals("down") || action.equals("left") || action.equals("right")) {
				currentDirection = action;

				// keep old position
				old_tposX = tposX();
				old_tposY = tposY();

				move(action);
			}
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
			if (fc == 0 / s) setImage(ImageLoader.getImage("monster" + "_" + currentDirection + "_1"));
			if (fc == 16 / s) setImage(ImageLoader.getImage("monster" + "_" + currentDirection + "_2"));
			if (fc == 48 / s) setImage(ImageLoader.getImage("monster" + "_" + currentDirection + "_1"));

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
				map.tiles[tposX()][tposY()].monster(this);

			}
			
			//movement completed
			if (fc == (63 / s)) {
				isMoving = false;
				fc = 0;
				//where to move next
				randomDirection();
			}

		}

	}
	
	public void visit(Player player){
		player.destroy();
	}
	
	private int random(int min, int max){
		return ( rand.nextInt(max - min + 1) + min );
	}
	
	private void randomDirection(){
		int r = random(0, 3);
		
		switch(r){
		case 0 :  action("up"); break;
		case 1 :  action("down"); break;
		case 2 :  action("left"); break;
		case 3 :  action("right"); break;
		default: System.out.println("randomDirection error"); break;
		}
	}
	
	public void explode(){
		destroy();
	}
	
	public int getZ() {
		return z;
	}

}
