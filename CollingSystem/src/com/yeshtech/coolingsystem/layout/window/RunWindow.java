package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RunWindow {

	protected Shell shell;
	private Text txtInputDeckFileName;
	private Text txtOutputResults;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RunWindow window = new RunWindow();
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
		shell.setSize(389, 261);
		shell.setText("SWT Application");
		
		Button chkPreprocessOnly = new Button(shell, SWT.CHECK);
		chkPreprocessOnly.setBounds(20, 20, 129, 16);
		chkPreprocessOnly.setText("Preprocess Only");
		
		Label lblInputDeckFileName = new Label(shell, SWT.NONE);
		lblInputDeckFileName.setBounds(20, 56, 129, 15);
		lblInputDeckFileName.setText("Input deck filename :");
		
		Label lblOutputResults = new Label(shell, SWT.NONE);
		lblOutputResults.setBounds(20, 90, 133, 15);
		lblOutputResults.setText("Output results filename :");
		
		Button btnGo = new Button(shell, SWT.NONE);
		btnGo.setBounds(21, 123, 335, 46);
		btnGo.setText("Go !");
		
		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.setBounds(20, 183, 93, 25);
		btnClose.setText("Close");
		
		txtInputDeckFileName = new Text(shell, SWT.BORDER);
		txtInputDeckFileName.setBounds(159, 53, 197, 21);
		
		txtOutputResults = new Text(shell, SWT.BORDER);
		txtOutputResults.setBounds(159, 88, 197, 21);

	}
}
