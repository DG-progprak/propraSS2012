package Bomberman;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;


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
	
	// https://forums.oracle.com/forums/thread.jspa?threadID=1267489
	public BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
	
	
	public BufferedImage renderFrame(TileMap map){

		frame = deepCopy(mapImage);
		Graphics2D g2 = frame.createGraphics();
	
		HashMap<String, ArrayList<Sprite> > sprites = new HashMap<String, ArrayList<Sprite> >();
		// create i ArrayLists for i different z layers
		for (int i=0; i<4; i++){
			sprites.put("layer" + i, new ArrayList<Sprite>());
		}
		
		// distribute sprites to z layers
		for (Sprite sprite : map.sprites){
			sprites.get("layer" + sprite.getZ()).add(sprite);
		}
		
		// draw sprites in z order
		for (int i=0; i<4; i++){
			for (Sprite sprite : sprites.get("layer" + i)) g2.drawImage(sprite.getImage().getImage(), sprite.posX(), sprite.posY(), null);
		}
		
		g2.dispose(); //free resources
		return frame;
	}

}
