package Bomberman;

public class Bomb extends Sprite {
	
	private int z = 1;
	
	private int fc=0;
	private int maxticks=3;
	private int tick=0;
	private int bombradius;

	Bomb(TileMap map, int tile_posX, int tile_posY, int bombradius) {
		super(map, tile_posX, tile_posY);
		this.bombradius = bombradius;
		System.out.println(this.toString() + " " + this.posX + " " + this.posY);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		//System.out.println(posX); //debug
		int s = 1; //test,debug
			
			if (fc == 0/s) setImage(ImageLoader.getImage("bomb_1"));
			if (fc == 32/s) setImage(ImageLoader.getImage("bomb_2"));		
			
			fc++;
			if (fc == (63/s)){
				tick++;
				fc=0;
			}
		//destroy
			if (tick == maxticks) {
				detonate();
				destroy();
			}
					
	}

	private void detonate(){
		map.spawnSprite(tposX(), tposY(), 'E');
		for (int i=1; i<=bombradius; i++){
			map.spawnSprite(tposX()-i, tposY(), 'E');
			map.spawnSprite(tposX(), tposY()-i, 'E');
			map.spawnSprite(tposX()+i, tposY(), 'E');
			map.spawnSprite(tposX(), tposY()+i, 'E');
		}
	}
	
	public int getZ() {
		return z;
	}
	
}

