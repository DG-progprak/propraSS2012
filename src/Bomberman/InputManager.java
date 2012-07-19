package Bomberman;


public class InputManager {
	
	keyListener GUIInput;
	Player player1;
	Player player2;
	Main main;
	
	InputManager(Main main, keyListener GUIInput){
		this.main = main;
		this.GUIInput = GUIInput;
		
	}
	
	public void setPlayer1(Player player){
		player1 = player;
	}
	
	public void setPlayer2(Player player){
		player2 = player;
	}
	
	
	public void sendCommands(){
		if (GUIInput.up1){
			//System.out.println("InputManager: move up");
			player1.action("up");
		}
		else if(GUIInput.down1){
			//System.out.println("InputManager: move down");
			player1.action("down");
		}
		else if(GUIInput.left1){
			//System.out.println("InputManager: move left");
			player1.action("left");
		}
		else if(GUIInput.right1){
			//System.out.println("InputManager: move right");
			player1.action("right");
		}
		else if(GUIInput.plant1){
			//System.out.println("InputManager: Player 1 plants bomb!");
			player1.action("plant");
		}
		
		if (GUIInput.up2){
			//System.out.println("InputManager: move up");
			player2.action("up");
		}
		else if(GUIInput.down2){
			//System.out.println("InputManager: move down");
			player2.action("down");
		}
		else if(GUIInput.left2){
			//System.out.println("InputManager: move left");
			player2.action("left");
		}
		else if(GUIInput.right2){
			//System.out.println("InputManager: move right");
			player2.action("right");
		}
		else if(GUIInput.plant2){
			//System.out.println("InputManager: Player 2 plants bomb!");
			player2.action("plant");
		}
		
		else if(GUIInput.debug){
			GUIInput.debug = false;
			main.restart("startmap", main.players);
			//player1.setBombradius(3);
			//main.restart("testmapA");
			//Zuruecksetzen, wenn x gedrueckt wird, lade map a
			//Player.players = 0;
			//main.map=new TileMap(main, "testmapA");
			//main.renderer.renderTileMap(main.map);
			
			//System.out.println(player1.toString() + " " + player1.posX + " " + player1.posY);
			//System.out.println(player1.toString() + " " + player1.tile_posX + " " + player1.tile_posY);
		}
		

		
		//try to workaround linux keyrelease bug
		GUIInput.up1=false;
		GUIInput.down1=false;
		GUIInput.left1=false;
		GUIInput.right1=false;
		GUIInput.plant1=false;
		
		GUIInput.up2=false;
		GUIInput.down2=false;
		GUIInput.left2=false;
		GUIInput.right2=false;
		GUIInput.plant2=false;
		
		
	}
	

}
