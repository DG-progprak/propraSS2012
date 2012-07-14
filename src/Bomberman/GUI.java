package Bomberman;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GUI{
	JFrame app;
	Canvas canvas;
	BufferStrategy buffer;
	Graphics graphics;
	keyListener input = new keyListener();
	
    GUI(){
    	// Create game window...
        app = new JFrame("Bomberman_test");
        app.setIgnoreRepaint( true );
        app.setResizable(false);
        app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //app.setMinimumSize(new Dimension(208,208));
        //app.setMinimumSize(new Dimension(416,416));
                    
        // Create canvas for painting...
        canvas = new Canvas();
        canvas.setIgnoreRepaint( true );
        //canvas.setSize( 208, 208 );
        canvas.setSize( 416, 416 );
                    
        // Add canvas to game window...
        app.add( canvas );
        app.pack();
        app.setVisible( true );
        
        // Create BackBuffer...
        canvas.createBufferStrategy( 2 );
        buffer = canvas.getBufferStrategy();
        
        // Add KeyListener
        canvas.addKeyListener(input);
        
        //make focusable
        canvas.setFocusable(true);

    }
    
    public void showFrame(BufferedImage frame){
    	graphics = buffer.getDrawGraphics();
    	//graphics.drawImage(frame,0,0,null);
    	graphics.drawImage(	frame,
    						0, 0, canvas.getWidth(), canvas.getHeight(),
    						0, 0, frame.getWidth(), frame.getHeight(),
    						null);
    	buffer.show();
    }
    

}
