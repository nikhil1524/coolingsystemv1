package com.yeshtech.coolingsystem.layout.printedwindow;

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

import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.wb.swt.SWTResourceManager;

public class PrintedLumpWindow {

	protected Shell shell;
	private Text txtNameOfTheLump;
	private Button btnPrintedLumpSave;
	private PropertiesLoader loader;

	public PrintedLumpWindow(PropertiesLoader loader) {
		this.loader = loader;
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
		shell.setImage(SWTResourceManager.getImage(PrintedLumpWindow.class,
				"/icon/App.ico"));
		shell.setSize(457, 244);
		shell.setText(loader
				.getValue(LabelConstants.LAYOUT_PRINTED_LUMPS_NEW_PRINTED_LUMPS));
		Label lblNameOfTheLump = new Label(shell, SWT.NONE);
		lblNameOfTheLump.setBounds(24, 38, 249, 15);
		lblNameOfTheLump
				.setText(loader
						.getValue(LabelConstants.LAYOUT_PRINTED_LUMPS_NAME_OF_THE_LUMP));

		txtNameOfTheLump = new Text(shell, SWT.BORDER);
		txtNameOfTheLump.setBounds(20, 77, 397, 25);

		Button btnPrintedLumpCancel = new Button(shell, SWT.NONE);
		btnPrintedLumpCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnPrintedLumpCancel.setBounds(20, 149, 105, 32);
		btnPrintedLumpCancel.setText(loader
				.getValue(LabelConstants.LAYOUT_CANCEL));

		btnPrintedLumpSave = new Button(shell, SWT.NONE);
		btnPrintedLumpSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnPrintedLumpSave.setBounds(312, 149, 105, 32);
		btnPrintedLumpSave.setText(loader.getValue(LabelConstants.LAYOUT_SAVE));
	}

	public Text getTxtNameOfTheLump() {
		return txtNameOfTheLump;
	}

	public static void main(String[] args) {
		try {
			PropertiesLoader loader = PropertiesLoader
					.getPropertiesLoader("com.deam.util.layout-label");

			PrintedLumpWindow window = new PrintedLumpWindow(loader);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
