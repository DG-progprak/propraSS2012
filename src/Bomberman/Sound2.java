import java.applet.*; 
import java.awt.*; 
import java.awt.event.*; 

public class Sound2 extends Applet implements ActionListener 
{ 
  AudioClip Space; 
  Button Play; 

  public void init() 
  { 
    Space = getAudioClip(getCodeBase(), "Shirobon - Golden Apples.mp3"); 
    Play = new Button("Sound abspielen"); 
    Play.addActionListener(this); 
    add(Play); 
  } 

  public void actionPerformed(ActionEvent ev) 
  { 
    Space.play(); //spielt eine Sound-Datei wiederholt ab, und zwar unendlich oft. 
  } 
} 