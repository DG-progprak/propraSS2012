package Bomberman;


public class Main {
	
	public boolean isRunning;
	
	GUI gui;
	TileMap map;
	Renderer renderer;
	InputManager inputManager;
	
	boolean restart=false;
	String mapname;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().initialize();
		
	}
	
	private void initialize(){
		gui = new GUI();
		inputManager = new InputManager(this, gui.input);
		ImageLoader.loadImages();
		map = new TileMap(this,"testmapB");
		renderer = new Renderer();
		isRunning=true;
		gameLoop();
	}
	
	
	public void restart(String mapname){
		this.restart=true;
		this.mapname=mapname;
	}
	
	public void newGame(String mapname){
		//reset player count
		Player.players = 0;
		//create new map object
		this.map =  new TileMap(this,mapname);
		//render basic map
		renderer.renderTileMap(this.map);
	}
	
	
	
	private void gameLoop(){
		int goalFPS = 60;
		long maxsleep = 1000/goalFPS;
		long runTime;
		long startTime = System.currentTimeMillis();
		
		//test
		renderer.renderTileMap(map);
		
		while(isRunning){
			runTime = System.currentTimeMillis() - startTime;
			startTime = System.currentTimeMillis();
			
			//System.out.println(runTime);

			//send input commands
			inputManager.sendCommands();
			
			//restart
			if (restart){
				newGame(mapname);
				restart=false;
			}
			//update game
			map.updateSprites();
			
			//gui.showFrame(renderer.renderTileMap(map));
			//render frame
			gui.showFrame(renderer.renderFrame(map));
			
			if(runTime < maxsleep){
				try{
					Thread.sleep(maxsleep-runTime);
				} catch (InterruptedException e){
					System.err.println(e);
				}
			}
				

		}
	}

}