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
		//System.out.println(this.toString() + " " + this.posX + " " + this.posY);
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
		//detonate
			if (tick == maxticks) {
				detonate();
			}
					
	}

	private void detonate(){
		//remove bomb
		destroy();
		//on spot
		blast(0, 0, 1);
		//up
		blast(0, -1, bombradius);
		//down
		blast(0, 1, bombradius);
		//left
		blast(-1, 0, bombradius);
		//right
		blast(1, 0, bombradius);	
	}
	
	private void blast(int x, int y, int bombradius){
		int i=1;
		while(i <= bombradius && !map.tiles[ tposX()+(x*i) ][ tposY()+(y*i) ].isBlock() ){
			map.tiles[ tposX()+(x*i) ][ tposY()+(y*i) ].explode();
			map.spawnSprite(tposX()+(x*i), tposY()+(y*i), 'E');
			i++;
		}
	}
	
	
	public void explode(){
		detonate();
	}
	
}

