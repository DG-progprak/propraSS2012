package Bomberman;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class TileMap {
	Main main;
	public int tileSize = 16;
	public int mapHeight = 13;
	public int mapWidth = 13;
	
	public Tile[][] tiles = new Tile[mapHeight][mapWidth];
	Vector<Sprite> sprites = new Vector<Sprite>();
	

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
		
		spawn_player1();

	}

	
	public void setTile(int x, int y, char tiletype){
		tiles[x][y] = new Tile(tiletype);
	}
	
	public void spawn_player1(){
		sprites.add(new Player(this, 1, 1) );
	}
	
	public void spawnBomb(int posX, int posY){
		player1_bomb = new Bomb(this, posX, posY);
		
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
		Sprite sprite;
		Enumeration<Sprite> sprites = this.sprites.elements();
		while( sprites.hasMoreElements() ){
			sprite = sprites.nextElement();
			sprite.update();
		}
		//update bomb
		if (player1_bomb != null) {
			System.out.println("bomb is set: update()"); //debug
			player1_bomb.update();
		}
	}
	
	//debug
	public void printSpritePositions(){
		Sprite sprite;
		Enumeration<Sprite> sprites = this.sprites.elements();
		while( sprites.hasMoreElements() ){
			sprite = sprites.nextElement();
			System.out.println(sprite.toString() + " " + sprite.posX + " " + sprite.posY);
		}
	}
	
	public void printTileStatus(){
		for (int i = 0; i < mapHeight; i++){
			System.out.println(tiles[0][i].isBlocked());	
		}
	}


}
