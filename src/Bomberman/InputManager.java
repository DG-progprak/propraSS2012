package Bomberman;


public class InputManager {
	Main main;
	keyListener GUIInput;
	Player player1;
	
	InputManager(Main main, keyListener GUIInput){
		this.main = main;
		this.GUIInput = GUIInput;
	}
	
	public void setPlayer(Player player){
		player1 = player;
	}
	public void sendCommands(){
		if (GUIInput.up){
			System.out.println("InputManager: move up");
			player1.move("up");
		}
		else if(GUIInput.down){
			System.out.println("InputManager: move down");
			player1.move("down");
		}
		else if(GUIInput.left){
			System.out.println("InputManager: move left");
			player1.move("left");
		}
		else if(GUIInput.right){
			System.out.println("InputManager: move right");
			player1.move("right");
		}
		else if(GUIInput.plant){
			System.out.println("InputManager: plant bomb");
			player1.move("plant");
		}
		
		else if(GUIInput.debug){
			main.restart("testmapA");
			//restart game
			//reset player count
			//Player.players = 0;
			//create new TileMap
			//main.map =  new TileMap(main,"testmapA");
			//main.renderer.renderTileMap(main.map);
			
			//System.out.println(player1.toString() + " " + player1.posX + " " + player1.posY);
			//System.out.println(player1.toString() + " " + player1.tile_posX + " " + player1.tile_posY);
	
		}
		
		//try to workaround linux keyrelease bug
		GUIInput.up=false;
		GUIInput.down=false;
		GUIInput.left=false;
		GUIInput.right=false;
		GUIInput.plant=false;
		
		
	}
	

}