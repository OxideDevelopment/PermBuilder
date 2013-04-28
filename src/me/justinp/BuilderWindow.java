package me.justinp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class BuilderWindow {

	protected Shell shlPermissionBuilder;

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
		
		shlPermissionBuilder.open();
		shlPermissionBuilder.layout();
		while (!shlPermissionBuilder.isDisposed()) {
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
		shlPermissionBuilder.setImage(SWTResourceManager.getImage(BuilderWindow.class, "/me/justinp/images/icon.ico"));
		shlPermissionBuilder.setSize(515, 363);
		shlPermissionBuilder.setText("Permission Builder");

	}

}
