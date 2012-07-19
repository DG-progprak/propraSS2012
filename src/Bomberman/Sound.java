import java.net.URL;
import java.applet.*;


public class Sound
{
	private AudioClip[] sounds; // Hintergrundmusik
	public Sound()
	{
		initSounds();
		}
		private void initSounds()
		{
			try{
				
			ClassLoader loader = Sound.class.getClassLoader();

			sounds = new AudioClip[1];
			sounds[0] = Applet.newAudioClip(loader.getResource("Shirobon - Golden Apples.mp3"));
			
			}
			catch (Exception ex)
			
			{
			ex.printStackTrace();
			}

		}
		public void playSound(int index)
		{
			
		if (index>0 && index<sounds.length) sounds[index].play();
		}
		
		public static void main(String[] args)
		{
			Sound Sound = new Sound(); 
			Sound.playSound(0);  
			try
			{
				Thread.sleep(100); 
			}
			catch (InterruptedException ex) {}
			Sound.playSound(1); 
		}
}