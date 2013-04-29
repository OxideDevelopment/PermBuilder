package me.justinp.dialogs;

import me.justinp.helpers.Message;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class FtpSelection {

	protected Shell shell;
	private Text serverText;
	private Table table;
	private Text text;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		Group grpFtpServerInfo = new Group(shell, SWT.NONE);
		grpFtpServerInfo.setText("FTP Server Info");
		grpFtpServerInfo.setBounds(10, 10, 568, 62);
		
		Label lblServer = new Label(grpFtpServerInfo, SWT.NONE);
		lblServer.setBounds(10, 22, 40, 15);
		lblServer.setText("Server:");
		
		serverText = new Text(grpFtpServerInfo, SWT.BORDER);
		serverText.setBounds(56, 19, 169, 21);
		
		Label lblPort = new Label(grpFtpServerInfo, SWT.NONE);
		lblPort.setBounds(237, 22, 28, 15);
		lblPort.setText("Port:");
		
		Spinner spinner = new Spinner(grpFtpServerInfo, SWT.BORDER);
		spinner.setMaximum(9999999);
		spinner.setMinimum(1);
		spinner.setSelection(21);
		spinner.setBounds(271, 18, 54, 22);
		
		Label lblUser = new Label(grpFtpServerInfo, SWT.NONE);
		lblUser.setBounds(335, 22, 33, 15);
		lblUser.setText("User:");
		
		text = new Text(grpFtpServerInfo, SWT.BORDER);
		text.setBounds(374, 19, 159, 21);
		
		Button btnConnect = new Button(shell, SWT.NONE);
		btnConnect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Get password.
				InputDialog pwDialog = new InputDialog(shell, "Enter password", "Please enter your FTP password.", "", null);
				pwDialog.open();
				char[] pw = pwDialog.getValue().toCharArray();
				Message.show("", String.copyValueOf(pw), shell);
			}
		});
		btnConnect.setBounds(584, 28, 75, 25);
		btnConnect.setText("Connect");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 78, 649, 348);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnFileName = new TableColumn(table, SWT.NONE);
		tblclmnFileName.setWidth(295);
		tblclmnFileName.setText("File name");
		
		TableColumn tblclmnUsable = new TableColumn(table, SWT.NONE);
		tblclmnUsable.setWidth(349);
		tblclmnUsable.setText("Usable");
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(FtpSelection.class, "/me/justinp/images/ftp.png"));
		shell.setSize(685, 474);
		shell.setText("FTP");

	}
}
