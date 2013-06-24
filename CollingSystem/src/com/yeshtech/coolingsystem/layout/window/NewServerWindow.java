package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class NewServerWindow {

	protected Shell shell;
	private Text txtServerName;
	private Text txtHeatOutput;
	private Text txtThermalResistance;

	/**
	 * Launch the application.
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
		shell.setSize(421, 243);
		shell.setText("New Server");
		
		Label lblServerName = new Label(shell, SWT.NONE);
		lblServerName.setBounds(28, 18, 86, 15);
		lblServerName.setText("Server Name : ");
		
		Label lblHeatOutput = new Label(shell, SWT.NONE);
		lblHeatOutput.setBounds(28, 54, 86, 15);
		lblHeatOutput.setText("Heat Output : ");
		
		Label lblThermalResistance = new Label(shell, SWT.NONE);
		lblThermalResistance.setBounds(28, 93, 121, 15);
		lblThermalResistance.setText("Thermal Resistance : ");
		
		txtServerName = new Text(shell, SWT.BORDER);
		txtServerName.setBounds(167, 16, 181, 21);
		
		txtHeatOutput = new Text(shell, SWT.BORDER);
		txtHeatOutput.setBounds(167, 52, 181, 21);
		
		txtThermalResistance = new Text(shell, SWT.BORDER);
		txtThermalResistance.setBounds(167, 90, 181, 21);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(28, 140, 121, 43);
		btnCancel.setText("Cancel");
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(247, 142, 121, 40);
		btnSave.setText("Save");
		
		Label lblW = new Label(shell, SWT.NONE);
		lblW.setBounds(354, 57, 27, 15);
		lblW.setText("W");
		
		Label lblKw = new Label(shell, SWT.NONE);
		lblKw.setBounds(355, 93, 33, 15);
		lblKw.setText("K/W");

	}

}