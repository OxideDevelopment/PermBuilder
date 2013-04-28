package me.justinp.update;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Updater {

	public static final String VERSION_LINK = "https://raw.github.com/OxideDevelopment/PermBuilder/master/src/me/justinp/update/version.txt";
	
	
	public static void checkUpdates(final Display display) {
		//Check for updates asynchronously..
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					//Lets get our current version.
					File currentVersion = new File("version.txt");
					BufferedReader currentReader = new BufferedReader(new FileReader(currentVersion));
					String thisVersion = currentReader.readLine();
					currentReader.close();
					
					//Get the version from GitHub <3
					URL versionURL = new URL(VERSION_LINK);
					BufferedReader latestReader = new BufferedReader(new InputStreamReader(versionURL.openStream()));
					String latestVersion = latestReader.readLine();
					
					//Compare the two versions
					if(!thisVersion.equals(latestVersion)) {
						//Update available
						messageBox("Update",
								"A new update is available(" + latestVersion + "). Download it from the bukkit thread.",
								display.getActiveShell());
					}
					
					
				} catch (FileNotFoundException e) {
					messageBox("Error", "Version.txt file is missing. Update checking halted.", display.getActiveShell());
				} catch (IOException e) {
					messageBox("Error", "Error while reading Version.txt. Update checking halted.", display.getActiveShell());
				}
				
			}
			
		}).start();
	}
	
	private static void messageBox(String title, String msg, Shell shell) {
		MessageBox mb = new MessageBox(shell);
		mb.setText(title);
		mb.setMessage(msg);
		mb.open();
	}
}
