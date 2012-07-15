package Bomberman;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Enumeration;


public class Renderer {
	BufferedImage mapImage;
	BufferedImage frame;
	
	public BufferedImage renderTileMap(TileMap map){
		mapImage = new BufferedImage(map.mapWidth*map.tileSize, map.mapHeight*map.tileSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = mapImage.createGraphics();
		
		for (int i = 0; i < map.mapWidth; i++){
			for (int j = 0; j < map.mapHeight; j++){
				
				g2.drawImage(map.tiles[i][j].getImage().getImage(),map.X_TileToPixel(i), map.Y_TileToPixel(j),null);		
			}
		}
		g2.dispose(); //free resources
		return mapImage;	
	}
	
	//https://forums.oracle.com/forums/thread.jspa?threadID=1267489
	public BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
	
	
	public BufferedImage renderFrame(TileMap map){
		Sprite sprite;
		frame = deepCopy(mapImage);
		Graphics2D g2 = frame.createGraphics();
		//render bomb
		if (map.player1_bomb != null) {
			g2.drawImage(map.player1_bomb.getImage().getImage(), map.player1_bomb.get_posX(), map.player1_bomb.get_posY(), null);
		}
		//render sprites
		Enumeration<Sprite> sprites = map.sprites.elements();
		while( sprites.hasMoreElements() ){
			sprite = sprites.nextElement();
			g2.drawImage(sprite.getImage().getImage(), sprite.get_posX(), sprite.get_posY(), null);
		}
		
		g2.dispose(); //free resources
		return frame;
	}

}
