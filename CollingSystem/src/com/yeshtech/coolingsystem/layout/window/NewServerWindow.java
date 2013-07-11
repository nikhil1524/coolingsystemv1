package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import com.yeshtech.coolingsystem.layout.datacenter.fans.FansServerInterface;
import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.DisplayMonitor;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.wb.swt.SWTResourceManager;

public class NewServerWindow implements SelectionListener {

	protected Shell shell;
	private Text txtServerName;
	private Text txtHeatOutput;
	private Text txtThermalResistance;
	private FansServerInterface fansServerInterface;
	private Button btnCancel;
	private Button btnSave;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NewServerWindow window = new NewServerWindow();
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

	public void setFansServerInterface(FansServerInterface serverInterface) {
		this.fansServerInterface = serverInterface;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		PropertiesLoader loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(NewServerWindow.class,
				"/icon/App.ico"));
		shell.setSize(421, 243);
		shell.setText(loader.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW));

		Label lblServerName = new Label(shell, SWT.NONE);
		lblServerName.setBounds(28, 18, 86, 15);
		lblServerName.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_SERVER_NAME));

		Label lblHeatOutput = new Label(shell, SWT.NONE);
		lblHeatOutput.setBounds(28, 54, 86, 15);
		lblHeatOutput.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_HEAT_OUTPUT));

		Label lblThermalResistance = new Label(shell, SWT.NONE);
		lblThermalResistance.setBounds(28, 93, 121, 15);
		lblThermalResistance
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_THERMAL_RESISTANCE));

		txtServerName = new Text(shell, SWT.BORDER);
		txtServerName.setBounds(167, 16, 181, 21);

		txtHeatOutput = new Text(shell, SWT.BORDER);
		txtHeatOutput.setText(Constants.INT_HUNDRED);
		txtHeatOutput.setBounds(167, 52, 181, 21);

		txtThermalResistance = new Text(shell, SWT.BORDER);
		txtThermalResistance.setText(Constants.DBL_ZEROPOINTONE);
		txtThermalResistance.setBounds(167, 90, 181, 21);

		btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(this);
		btnCancel.setBounds(28, 140, 121, 43);
		btnCancel.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_CANCEL));

		btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(this);
		btnSave.setBounds(247, 142, 121, 40);
		btnSave.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_SAVE));

		Label lblW = new Label(shell, SWT.NONE);
		lblW.setBounds(354, 57, 27, 15);
		lblW.setText(loader.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_W));

		Label lblKw = new Label(shell, SWT.NONE);
		lblKw.setBounds(355, 93, 33, 15);
		lblKw.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_SERVER_WINDOW_K_W));

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnSave)) {
			this.fansServerInterface.addServer(txtServerName.getText());
			this.shell.dispose();
		} else {
			this.shell.dispose();
		}
	}

}
