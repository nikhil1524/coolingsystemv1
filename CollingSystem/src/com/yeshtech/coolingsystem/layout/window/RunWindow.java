package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.DisplayMonitor;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RunWindow {

	protected Shell shell;
	private Text txtInputDeckFileName;
	private Text txtOutputResults;

	/**
	 * Launch the application.
	 * 
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
		// setting display to center of screen
		DisplayMonitor dm = new DisplayMonitor(shell,display);
		shell.setLocation(dm.getMonitorCenterXCoordinate(),dm.getMonitorCenterYCoordinate());

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
		PropertiesLoader loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");

		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(RunWindow.class,
				"/icon/App.ico"));
		shell.setSize(389, 261);
		shell.setText(loader.getValue(LabelConstants.LAYOUT_RUN_WINDOW));

		Button chkPreprocessOnly = new Button(shell, SWT.CHECK);
		chkPreprocessOnly.setBounds(20, 20, 129, 16);
		chkPreprocessOnly.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_WINDOW_PREPROCESS_ONLY));

		Label lblInputDeckFileName = new Label(shell, SWT.NONE);
		lblInputDeckFileName.setBounds(20, 56, 129, 15);
		lblInputDeckFileName
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RUN_WINDOW_INPUT_DECK_FILENAME));

		Label lblOutputResults = new Label(shell, SWT.NONE);
		lblOutputResults.setBounds(20, 90, 133, 15);
		lblOutputResults
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RUN_WINDOW_OUTPUT_RESULTS_FILENAME));

		Button btnGo = new Button(shell, SWT.NONE);
		btnGo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
			PostprocessingWindow window = new PostprocessingWindow();
			window.open();
				
			}
		});
		btnGo.setBounds(21, 123, 335, 46);
		btnGo.setText(loader.getValue(LabelConstants.LAYOUT_RUN_WINDOW_GO));

		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnClose.setBounds(20, 183, 93, 25);
		btnClose.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_WINDOW_CLOSE));

		txtInputDeckFileName = new Text(shell, SWT.BORDER);
		txtInputDeckFileName.setText(Constants.INPUT_TXT);
		txtInputDeckFileName.setBounds(159, 53, 197, 21);

		txtOutputResults = new Text(shell, SWT.BORDER);
		txtOutputResults.setText(Constants.OUTPUT_TXT);
		txtOutputResults.setBounds(159, 88, 197, 21);

	}
}
