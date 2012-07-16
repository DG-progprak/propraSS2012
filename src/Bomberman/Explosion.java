package Bomberman;

public class Explosion extends Sprite {
	
	private int z = 3;

	private int fc=0;
	
	Explosion(TileMap map, int tilePosX, int tilePosY) {
		super(map, tilePosX, tilePosY);
		setImage(ImageLoader.getImage("explosion1"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {

		//System.out.println(posX); //debug
		int s = 1; //test,debug
			
			if (fc == 0/s) setImage(ImageLoader.getImage("explosion1"));
			if (fc == 12/s) setImage(ImageLoader.getImage("explosion2"));
			if (fc == 24/s) setImage(ImageLoader.getImage("explosion3"));
			if (fc == 36/s) setImage(ImageLoader.getImage("explosion2"));
			if (fc == 48/s) setImage(ImageLoader.getImage("explosion1"));
			fc++;
			if (fc == (59/s)) destroy();		
	}


	public int getZ() {
		return z;
	}


}
