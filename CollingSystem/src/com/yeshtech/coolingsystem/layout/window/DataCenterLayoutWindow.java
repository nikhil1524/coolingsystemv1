package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.DisplayMonitor;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DataCenterLayoutWindow {

	protected Shell shell;
	private Text txtSupplyHeatIndex;
	public int intRowNum;

	public DataCenterLayoutWindow(int RowNum) {
		this.intRowNum = RowNum;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DataCenterLayoutWindow window = new DataCenterLayoutWindow(2);
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

		DisplayMonitor dm = new DisplayMonitor(shell, display);
		shell.setLocation(dm.getMonitorCenterXCoordinate(),
				dm.getMonitorCenterYCoordinate());

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
		shell.setImage(SWTResourceManager.getImage(
				DataCenterLayoutWindow.class, "/icon/App.ico"));
		shell.setSize(453, 281);
		shell.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_WINDOW));

		Group grpRowNumber = new Group(shell, SWT.NONE);
		grpRowNumber.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_ROW_NUMBER));
		grpRowNumber.setBounds(10, 10, 414, 56);

		Combo cmbRowNumber = new Combo(grpRowNumber, SWT.NONE);
		cmbRowNumber.setBounds(10, 23, 394, 23);

		System.out.println(intRowNum);
		for (int i = 1; i <= intRowNum; i++) {
			cmbRowNumber.add(new Integer(i).toString());
		}

		Group grpRackSpecification = new Group(shell, SWT.NONE);
		grpRackSpecification
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_RACK_SPECIFICATION));
		grpRackSpecification.setBounds(10, 72, 414, 56);

		Combo cmbRackSpecification = new Combo(grpRackSpecification, SWT.NONE);
		cmbRackSpecification.setBounds(10, 23, 164, 23);

		Button btnEditRack = new Button(grpRackSpecification, SWT.NONE);

		btnEditRack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
			}
		});
		btnEditRack.setBounds(180, 23, 75, 25);
		btnEditRack.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_EDIT_RACK));

		Button btnDeleteRack = new Button(grpRackSpecification, SWT.NONE);
		btnDeleteRack.setBounds(259, 23, 66, 25);
		btnDeleteRack
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_DELETE_RACK));

		Button btnNewRack = new Button(grpRackSpecification, SWT.NONE);
		btnNewRack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				RackPropertiesWindow window = new RackPropertiesWindow();
				window.open();
			}
		});
		btnNewRack.setBounds(329, 23, 75, 25);
		btnNewRack.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_NEW_RACK));

		Label lblSupplyHeadIndex = new Label(shell, SWT.NONE);
		lblSupplyHeadIndex.setBounds(10, 147, 167, 15);
		lblSupplyHeadIndex
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_SUPPLY_HEAT_INDEX));

		txtSupplyHeatIndex = new Text(shell, SWT.BORDER);
		txtSupplyHeatIndex.setBounds(183, 144, 76, 21);

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
				
			}
		});
		btnCancel.setBounds(25, 188, 92, 37);
		btnCancel.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_CANCEL));

		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(322, 191, 99, 32);
		btnSave.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT_SAVE));

	}
}
