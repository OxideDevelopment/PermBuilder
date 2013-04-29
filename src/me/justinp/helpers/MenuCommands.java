package me.justinp.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class MenuCommands {

	/**
	 * Open the file, and dump its contents into editor.
	 * @param shell Current shell in use.
	 * @param editor The StyledText component on the screen.
	 */
	public void FileOpen(Shell shell, StyledText editor) {
		FileDialog dialog = new FileDialog(shell);
		String[] exentsions = {"*.yml"};
		dialog.setFileName("groups.yml");
		dialog.setFilterExtensions(exentsions);
		dialog.open();
		
		File selectedFile = new File(dialog.getFilterPath() 
				+ System.getProperty("file.separator") 
				+ dialog.getFileName());
		
		//Clear text
		editor.setText("");
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				if(editor.getText().equals(""))
					editor.append(currentLine);
				else
					editor.append("\n" + currentLine);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
