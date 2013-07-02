package com.yeshtech.coolingsystem.layout.datacenter.printedwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.layout.datacenter.lumps.LumpsInterface;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.wb.swt.SWTResourceManager;

public class PrintedPathWindow {

	protected Shell shell;
	private Text txtNameOfThePath;
	public PropertiesLoader loader;
	private LumpsInterface lumpsInterface;

	public PrintedPathWindow(PropertiesLoader loader) {
		this.loader = loader;
	}

	public void setLumpsInterface(LumpsInterface lumpsInterface)
	{
		this.lumpsInterface = lumpsInterface;
	}
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		// setting the screen in center

		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();

		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;

		shell.setLocation(x, y);
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
		shell.setImage(SWTResourceManager.getImage(PrintedPathWindow.class, "/icon/App.ico"));
		shell.setSize(457, 244);
		shell.setText(loader
				.getValue(LabelConstants.LAYOUT_PRINTED_PATHS_NEW_PRINTED_PATHS));
		Label lblNameOfThePath = new Label(shell, SWT.NONE);
		lblNameOfThePath.setBounds(24, 39, 249, 15);
		lblNameOfThePath
				.setText(loader
						.getValue(LabelConstants.LAYOUT_PRINTED_PATHS_NAME_OF_THE_PATH));

		txtNameOfThePath = new Text(shell, SWT.BORDER);
		txtNameOfThePath.setBounds(24, 86, 407, 25);

		Button btnPrintedPathCancel = new Button(shell, SWT.NONE);
		btnPrintedPathCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnPrintedPathCancel.setBounds(20, 143, 105, 32);
		btnPrintedPathCancel.setText(loader
				.getValue(LabelConstants.LAYOUT_CANCEL));

		Button btnPrintedPathSave = new Button(shell, SWT.NONE);
		btnPrintedPathSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				lumpsInterface.addPrintedPath(txtNameOfThePath.getText());
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnPrintedPathSave.setBounds(326, 143, 105, 32);
		btnPrintedPathSave.setText(loader.getValue(LabelConstants.LAYOUT_SAVE));
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PropertiesLoader loader = PropertiesLoader
					.getPropertiesLoader("com.deam.util.layout-label");

			PrintedPathWindow window = new PrintedPathWindow(loader);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
