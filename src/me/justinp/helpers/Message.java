package me.justinp.helpers;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Message {

	public static void show(String title, String msg, Shell shell) {
		MessageBox mb = new MessageBox(shell);
		mb.setText(title);
		mb.setMessage(msg);
		mb.open();
	}
}
