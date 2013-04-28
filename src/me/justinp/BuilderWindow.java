package me.justinp;

import me.justinp.helpers.MenuCommands;
import me.justinp.update.Updater;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class BuilderWindow {

	protected Shell shlPermissionBuilder;
	protected MenuCommands cmd;
	
	//This is so we can access it in the events without making it final.
	private StyledText styledText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BuilderWindow window = new BuilderWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		//Loading image manually, since window builder doesn't want to do it..
		shlPermissionBuilder.setImage(SWTResourceManager.getImage(BuilderWindow.class,"images/icon.png"));
		
		//Check for updates.
		Updater.checkUpdates(shlPermissionBuilder);
		
		styledText = new StyledText(shlPermissionBuilder, SWT.BORDER);
		styledText.setEditable(false);
		styledText.setText("No file open.\r\nTo open one on your computer, goto File > Open\r\nTo open one on a FTP server, goto File > Open from FTP");
		styledText.setBounds(0, 0, 319, 481);
		
		//Menu bar
		Menu menu = new Menu(shlPermissionBuilder, SWT.BAR);
		shlPermissionBuilder.setMenuBar(menu);
		
		//The "file" itme in the menu bar
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		//Menu that holds the items(Such as Open, Save, etc)
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		//Create open item and register selected(Clicked) event.
		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cmd.FileOpen(shlPermissionBuilder, styledText);
			}
		});
		mntmOpen.setText("Open");
		
		//Menu item for open from FTP
		MenuItem mntmOpenFromFtp = new MenuItem(menu_1, SWT.NONE);
		mntmOpenFromFtp.setText("Open from FTP");
		
		//Menu item for save
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText("Save");
		
		//Menu item for save to ftp
		MenuItem mntmSaveToFtp = new MenuItem(menu_1, SWT.NONE);
		mntmSaveToFtp.setText("Save to FTP");
		
		
		shlPermissionBuilder.open();
		shlPermissionBuilder.layout();
		
		while (!shlPermissionBuilder.isDisposed()) {
			//Check for events and dispatch them to the proper listeners
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPermissionBuilder = new Shell();
		shlPermissionBuilder.setSize(750, 549);
		shlPermissionBuilder.setText("Permission Builder");
		
		cmd = new MenuCommands();
	}
}
