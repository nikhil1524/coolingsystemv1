package com.yeshtech.coolingsystem.layout.datacenter.printedwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.layout.datacenter.lumps.LumpsInterface;
import com.yeshtech.coolingsystem.util.DisplayMonitor;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.wb.swt.SWTResourceManager;

public class PrintedLumpWindow {

	protected Shell shell;
	private Text txtNameOfTheLump;
	private Button btnPrintedLumpSave;
	private PropertiesLoader loader;
	private LumpsInterface lumpsInterface;
	public PrintedLumpWindow(PropertiesLoader loader) {
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
		DisplayMonitor dm = new DisplayMonitor(shell,display);
		shell.setLocation(dm.getMonitorCenterXCoordinate(),dm.getMonitorCenterYCoordinate());

		
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
				lumpsInterface.addPrintedLump(txtNameOfTheLump.getText());
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
