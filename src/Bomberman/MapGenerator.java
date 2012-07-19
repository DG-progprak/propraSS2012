package Bomberman;

import java.util.Random;

public class MapGenerator {
	//is startlocation used?
	private boolean startlocation0 = false;
	private boolean startlocation1 = false;
	private boolean startlocation2 = false;
	private boolean startlocation3 = false;
	//when to spawn goal
	private int goal;
	//how many sprites already spawned
	private int count=0;
	
	private int players = 2;
	
	Random rand = new Random();
	
	TileMap map;
	
	MapGenerator(TileMap map){
		this.map = map;
		
		test();
		setBlocks();
		StartLocation();
		fillMap();
		
	}
	
	private int random(int min, int max){
		return ( rand.nextInt(max - min + 1) + min );
	}
	
	private void test(){
		int i;
		int j;
		
		for (i=0; i<= 12; i++){
			for (j=0; j<=12; j++){
				map.setTile(i, j, ' ');
			}
		}
	}
	
	private void setBlocks(){
		
		int i;
		int j;
		
		//set outer blocks
		for (i = 0; i <= 12; i++){
			//top
			map.setTile(0, i, 'X');
			//bottom
			map.setTile(12, i, 'X');
		}
		for (i=1; i<= 11; i++){
			//left
			map.setTile(i, 0, 'X');
			//bottom
			map.setTile(i, 12, 'X');
		}
		
		//set inner blocks
		for (i = 2; i <= 10; i+=2){
			for (j = 2; j <= 10; j+=2){
				map.setTile(i, j, 'X');
			}
		}	
	}
	
	private void StartLocation(){
		int i;
		
		if (players == 1){
			//when to spawn goal?
			goal = random(1, 93);
			//where to start
			i = random(0,3);
			setStartLocation(i);
		}
		
		if (players == 2){
			i = random (0,3);
			setStartLocation(i);
			//get opposite starting location
			i = (i + 2) % 4;
			setStartLocation(i);
		}
		
	}
	
	private void setStartLocation(int location){
		int x;
		int y;
		
		
		switch(location){
		//top left
		case 0 :  x=1; y=1; startlocation0 = true; break;
		//top right
		case 1 :  x=11; y=1; startlocation1 = true; break;
		//bottom right
		case 2 :  x=11; y=11; startlocation2 = true; break;
		//bottom left
		case 3 :  x=1; y=11; startlocation3 = true; break;
		//default top left
		default: x=1; y=1; startlocation0 = true; break;
		}
		//starting corner should consist of floor tiles
		map.setTile(x, y, ' ');
		if (x==1) map.setTile(2, y, ' '); else map.setTile(10, y, ' ');
		if (y==1) map.setTile(x, 2, ' '); else map.setTile(x, 10, ' ');
		//spawn player sprite
		map.spawnSprite(x, y, 'P');
	}
	
	private void fillMap(){
		int i;
		int j;
		
		//inner tiles top to bottom
		for (i=3; i<=9; i+=2){
			for (j=2; j<=10; j++){
				map.setTile(i, j, randomSprite() );
			}
		}
		
		//inner tiles left to right
		for (i=2; i<=10; i+=2){
			for (j=3; j<=9; j+=2){
				map.setTile( i, j, randomSprite() );
			}
		}
		
		//top and bottom side without starting corners
		for (i=3; i<=9; i++){
			map.setTile( i, 1, randomSprite() );
			map.setTile( i, 11, randomSprite() );
		}
		
		//left and right side without starting corners
		for (i=3; i<=9; i++){
			map.setTile( 1, i, randomSprite() );
			map.setTile( 11, i, randomSprite() );
		}
		
		//start location0 used
		if( !startlocation0 ){
			map.setTile( 1, 1, randomSprite() );
			map.setTile( 1, 2, randomSprite() );
			map.setTile( 2, 1, randomSprite() );
		}
		//start location1 used
		if( !startlocation1 ){
			map.setTile( 11, 1, randomSprite() );
			map.setTile( 11, 2, randomSprite() );
			map.setTile( 10, 1, randomSprite() );
		}
		//start location2 used
		if( !startlocation2 ){
			map.setTile( 11, 11, randomSprite() );
			map.setTile( 11, 10, randomSprite() );
			map.setTile( 10, 11, randomSprite() );
		}
		//start location3 used
		if( !startlocation3 ){
			map.setTile( 1, 11, randomSprite() );
			map.setTile( 1, 10, randomSprite() );
			map.setTile( 2, 11, randomSprite() );
		}
		
	}
	
	private char randomSprite(){
		//default floor
		char c = ' ';
		double r = rand.nextDouble();
		
		//
		count++;
		//spawn item?
		if (r < 0.02) {
			c = randomItem();
			//yes. item behind stone?
			r = rand.nextDouble();
			if (r < 0.75) c = Character.toUpperCase(c);
		//no. spawn stone?
		} else if (r < 0.25){
			c = 'S';
		}	
		
		//spawn goal
		if ( (players == 1) && (count == goal) ) c = 'g';
		return (c);
	}
	
	private char randomItem(){
		int r = random(1,2);
		System.out.println(r);
		char c;
		
		switch(r){
		case 1 : c = 'i'; break;
		case 2 : c = 'f'; break;
		default : c = 'i'; System.out.println("randomItem error, use default item 'i' "); break;
		}
		
		return (c);
	}

}
