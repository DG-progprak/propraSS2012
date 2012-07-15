package Bomberman;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ImageLoader {
	static private Map<String, ImageIcon> images = new HashMap<String, ImageIcon>();
	//HashMap images = new HashMap();

	static private ImageIcon floorTile = new ImageIcon ("images/tiles/floor.png");
	static private ImageIcon blockTile = new ImageIcon ("images/tiles/block.png");
	static private ImageIcon goalTile = new ImageIcon ("images/tiles/goal.png");
	static private ImageIcon stoneTile = new ImageIcon ("images/tiles/stone.png");
	static private ImageIcon flowerTile = new ImageIcon ("images/items/flower.png");
	static private ImageIcon powerupTile = new ImageIcon ("images/items/powerup.png");
	

	
	public static ImageIcon getTileImage(char type){
		switch(type){
			case 'X' : return blockTile;
			case 'G' : return goalTile;
			//neue cases
			case 'Y' : return stoneTile;
			case 'S' : return stoneTile;
			case 'F' : return flowerTile;
			case 'P' : return powerupTile;
			default: return floorTile;
		}
	}
	
	public static void loadImages(){
		images.put( "player1_up_1" , new ImageIcon ("images/player/player1/back-0.png") );
		images.put( "player1_up_2" , new ImageIcon ("images/player/player1/back-1.png") );
		images.put( "player1_down_1" , new ImageIcon ("images/player/player1/front-0.png") );
		images.put( "player1_down_2" , new ImageIcon ("images/player/player1/front-1.png") );
		images.put( "player1_left_1" , new ImageIcon ("images/player/player1/left-0.png") );
		images.put( "player1_left_2" , new ImageIcon ("images/player/player1/left-1.png") );
		images.put( "player1_right_1" , new ImageIcon ("images/player/player1/right-0.png") );
		images.put( "player1_right_2" , new ImageIcon ("images/player/player1/right-1.png") );
		
		images.put( "player2_up_1" , new ImageIcon ("images/player/player2/back-0.png") );
		images.put( "player2_up_2" , new ImageIcon ("images/player/player2/back-1.png") );
		images.put( "player2_down_1" , new ImageIcon ("images/player/player2/front-0.png") );
		images.put( "player2_down_2" , new ImageIcon ("images/player/player2/front-1.png") );
		images.put( "player2_left_1" , new ImageIcon ("images/player/player2/left-0.png") );
		images.put( "player2_left_2" , new ImageIcon ("images/player/player2/left-1.png") );
		images.put( "player2_right_1" , new ImageIcon ("images/player/player2/right-0.png") );
		images.put( "player2_right_2" , new ImageIcon ("images/player/player2/right-1.png") );
		
		//PowerUp 
		images.put( "powerup" , new ImageIcon ("images/items/powerup.png") );
		
		//Bonuslevel
		images.put( "flower" , new ImageIcon ("images/items/flower.png") );
		
		images.put( "bomb_1" , new ImageIcon ("images/bomb/bomb1.png") );
		images.put( "bomb_2" , new ImageIcon ("images/bomb/bomb2.png") );
		
		System.out.println(images.get("player1_down_1").toString());
	}
	
	public static ImageIcon getImage(String key){
		return images.get(key);
	}
	

	

}
