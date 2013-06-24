package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

public class PostprocessingWindow {

	protected Shell shell;
	private Text txtResultFileName;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PostprocessingWindow window = new PostprocessingWindow();
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
		shell.setSize(474, 438);
		shell.setText("Postprocessing");
		
		Label lblResultFileName = new Label(shell, SWT.NONE);
		lblResultFileName.setBounds(10, 12, 94, 15);
		lblResultFileName.setText("Result Filename :");
		
		txtResultFileName = new Text(shell, SWT.BORDER);
		txtResultFileName.setBounds(120, 10, 76, 21);
		
		Button btnLoadResults = new Button(shell, SWT.NONE);
		btnLoadResults.setBounds(209, 6, 101, 25);
		btnLoadResults.setText("Load Results");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 60, 437, 275);
		
		CTabFolder tabFolder = new CTabFolder(composite, SWT.BORDER);
		tabFolder.setBounds(0, 0, 437, 275);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmDdd = new CTabItem(tabFolder, SWT.NONE);
		tbtmDdd.setText("Input Parameters");
		
		CTabItem tbtmExergyDestruction = new CTabItem(tabFolder, SWT.NONE);
		tbtmExergyDestruction.setText("Exergy Destruction");
		
		CTabItem tbtmDesignParameter = new CTabItem(tabFolder, SWT.NONE);
		tbtmDesignParameter.setText("Design Parameters");
		
		CTabItem tbtmGraphics = new CTabItem(tabFolder, SWT.NONE);
		tbtmGraphics.setText("Graphics");
		
		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.setBounds(353, 348, 94, 37);
		btnClose.setText("Close");

	}
}
