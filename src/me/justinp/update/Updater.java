package me.justinp.update;

import org.eclipse.swt.widgets.Display;

public class Updater {

	public static final String VERSION = "0.1-ALPHA";
	
	public static void checkUpdates(Display display) {
		//Check for updates asynchronously..
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
			
		}).start();
	}
}
