package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class DataCenterLayoutWindow {

	protected Shell shell;
	private Text txtSupplyHeatIndex;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DataCenterLayoutWindow window = new DataCenterLayoutWindow();
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
		shell.setSize(453, 281);
		shell.setText("Data Center Layout");
		
		Group grpRowNumber = new Group(shell, SWT.NONE);
		grpRowNumber.setText("Row Number");
		grpRowNumber.setBounds(10, 10, 414, 56);
		
		Combo cmbRowNumber = new Combo(grpRowNumber, SWT.NONE);
		cmbRowNumber.setBounds(10, 23, 394, 23);
		
		Group grpRackSpecification = new Group(shell, SWT.NONE);
		grpRackSpecification.setText("Rack Specification");
		grpRackSpecification.setBounds(10, 72, 414, 56);
		
		Combo cmbRackSpecification = new Combo(grpRackSpecification, SWT.NONE);
		cmbRackSpecification.setBounds(10, 23, 164, 23);
		
		Button btnEditRack = new Button(grpRackSpecification, SWT.NONE);
		btnEditRack.setBounds(180, 23, 75, 25);
		btnEditRack.setText("Edit Rack");
		
		Button btnDeleteRack = new Button(grpRackSpecification, SWT.NONE);
		btnDeleteRack.setBounds(259, 23, 66, 25);
		btnDeleteRack.setText("Delete");
		
		Button btnNewRack = new Button(grpRackSpecification, SWT.NONE);
		btnNewRack.setBounds(329, 23, 75, 25);
		btnNewRack.setText("New Rack");
		
		Label lblSupplyHeadIndex = new Label(shell, SWT.NONE);
		lblSupplyHeadIndex.setBounds(10, 147, 167, 15);
		lblSupplyHeadIndex.setText("Supply heat index value ( SHI ) : ");
		
		txtSupplyHeatIndex = new Text(shell, SWT.BORDER);
		txtSupplyHeatIndex.setBounds(183, 144, 76, 21);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(25, 188, 92, 37);
		btnCancel.setText("Cancel");
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(322, 191, 99, 32);
		btnSave.setText("Save");

	}
}
