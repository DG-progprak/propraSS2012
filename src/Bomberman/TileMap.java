package Bomberman;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class TileMap {
	Main main;
	public int tileSize = 16;
	public int mapHeight = 13;
	public int mapWidth = 13;
	
	public Tile[][] tiles = new Tile[mapHeight][mapWidth];
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	

	public Bomb player1_bomb;
	
	/** read .txt file.
	 * char: tile type
	 * tile x position: charPosition in line
	 * tile y position: line number
	 * TODO error handling, check if txt file is valid map / char is valid tiletype
	 */ 
	TileMap(Main main, String mapname)
	{
		this.main = main;
		String currentLine;
		
		try{
			BufferedReader in = new BufferedReader (new FileReader("maps/" + mapname + ".txt"));
			
			for (int j = 0; j < mapHeight; j++){
				currentLine = in.readLine();
				for (int i = 0; i < mapWidth; i++){
					this.setTile(i, j, currentLine.charAt(i));
				}
			}
			
		} catch (IOException e){
			System.err.println(e);
		}
		
		spawnSprite(1, 1, 'P');
		spawnSprite(11, 11, 'P');
		
		//spawn_player1();
		//spawn_player2();
	}

	
	public void setTile(int x, int y, char tiletype){
		System.out.println("setting tile [" + x + "," + y + "] to type: " + tiletype);
		switch(tiletype){
		
			//floor
			case ' ' :	tiles[x][y] = new Tile(' ');
						break;
						
			//block
			case 'X' :	tiles[x][y] = new Tile('X');
						break;
								
			//stone
			case 'S' :  tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'S');
						break;			
		
			//goal
			case 'g' :	tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'g');
						break;
						
			//goal behind stone
			case 'G' :  tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'g');
						spawnSprite(x, y, 'S');
						break;
						
			//powerup
			case 'i' :  tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'i');
						break;	
						
			//powerup behind stone
			case 'I' :  tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'i');
						spawnSprite(x, y, 'S');
						break;
						
			//flower
			case 'f' : tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'f');
						break;
						
		   //flower behind stone
			case 'F' :  tiles[x][y] = new Tile(' ');
						spawnSprite(x, y, 'f');
						spawnSprite(x, y, 'S');
						break;
						
			//default : floor
			default  :  tiles[x][y] = new Tile(' ');
		
		}
				
	}
	
	public void spawnSprite(int x, int y, char type){
		Sprite sprite=null;
		
		switch(type){
		
		case 'E':	sprite = new Explosion (this, x, y);
					break;
					
		case 'P':	sprite = new Player (this, x, y);
					break;
					
		case 'S':	sprite = new Stone (this, x, y);
					break;
					
		case 'i':	sprite = new Powerup (this, x, y);
					break;
					
		case 'f':	sprite = new Flower (this, x, y);
					break;
					
		case 'g':	sprite = new Goal (this, x, y);
					break;

		}
	
		if(sprite != null){
			tiles[x][y].addSprite(sprite);
			sprites.add(sprite);
		}
	}
	
	
	public void spawnBomb(int x, int y, int bombradius){
		Sprite sprite = new Bomb (this, x, y, bombradius);
		tiles[x][y].addSprite(sprite);
		sprites.add(sprite);
	}
	
	//TODO ?create datatype position with toPixel and toTile functions?
	public int X_TileToPixel(int x){
		return (x*this.tileSize);
	}
	
	public int Y_TileToPixel(int y){
		return (y*this.tileSize);
	}
	
	public  int X_PixelToTile(int x){
		return (x/this.tileSize);
	}
	
	public  int Y_PixelToTile(int y){
		return (y/this.tileSize);
	}
	
	//debug
	public  static int X2Tile(int x){
		return (x/16);
	}
	
	public  static int Y2Tile(int y){
		return (y/16);
	}
		
	
	public void updateSprites(){
		ArrayList<Sprite> spritescopy = new ArrayList<Sprite>(sprites);
		for(Sprite sprite : spritescopy){
			sprite.update();
		}
	}
	

}
