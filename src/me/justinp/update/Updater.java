package me.justinp.update;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import me.justinp.helpers.Message;

import org.eclipse.swt.widgets.Shell;

public class Updater {

	public static final String VERSION_LINK = "https://raw.github.com/OxideDevelopment/PermBuilder/master/src/me/justinp/update/version.txt";
	public static final String VERSION = "0.1-ALPHA";
	
	public static void checkUpdates(Shell shell) {
		//Check for updates
		try {

			//Get the version from GitHub <3
			URL versionURL = new URL(VERSION_LINK);
			BufferedReader latestReader = new BufferedReader(new InputStreamReader(versionURL.openStream()));
			String latestVersion = latestReader.readLine();

			//Compare the two versions
			if(!VERSION.equals(latestVersion)) {
				//Update available
				Message.show("Update",
						"A new update is available(" + latestVersion + "). Download it from the bukkit thread.",
						shell);
			}else {
				//No new updates
				Message.show("Pat yourself on your back!", "PermBuilder is up to date.", shell);
			}


		} catch (FileNotFoundException exx) {
			Message.show("Error", "Version.txt file is missing. Update checking halted.", shell);
		} catch (IOException ex2) {
			Message.show("Error", "Error while reading Version.txt. Update checking halted.", shell);
		}
	}
	

}
