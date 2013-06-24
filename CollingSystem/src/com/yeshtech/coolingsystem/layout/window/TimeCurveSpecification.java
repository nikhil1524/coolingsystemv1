package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TimeCurveSpecification {

	protected Shell shell;
	private Text txtCurveName;
	private Text txtNumberOfRows;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TimeCurveSpecification window = new TimeCurveSpecification();
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
		shell.setSize(422, 436);
		shell.setText("Timecurve Specification");
		
		Label lblCurveName = new Label(shell, SWT.NONE);
		lblCurveName.setBounds(22, 18, 83, 15);
		lblCurveName.setText("Curve Name :");
		
		Label lblNumberOfRows = new Label(shell, SWT.NONE);
		lblNumberOfRows.setBounds(22, 43, 97, 15);
		lblNumberOfRows.setText("Number Of rows :");
		
		txtCurveName = new Text(shell, SWT.BORDER);
		txtCurveName.setBounds(125, 14, 146, 21);
		
		txtNumberOfRows = new Text(shell, SWT.BORDER);
		txtNumberOfRows.setBounds(125, 41, 146, 21);
		
		Button btnCreateTable = new Button(shell, SWT.NONE);
		btnCreateTable.setBounds(297, 13, 99, 45);
		btnCreateTable.setText("Create Table");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(35, 82, 346, 253);
		
		Group grpTimeCurveTable = new Group(composite, SWT.NONE);
		grpTimeCurveTable.setText("Timecurve Table");
		grpTimeCurveTable.setBounds(10, 0, 336, 253);
		
		Label lblTimecurveTableXValues = new Label(grpTimeCurveTable, SWT.NONE);
		lblTimecurveTableXValues.setBounds(67, 34, 55, 15);
		lblTimecurveTableXValues.setText("X-Values");
		
		Label lblTimecurveTableYValues = new Label(grpTimeCurveTable, SWT.NONE);
		lblTimecurveTableYValues.setBounds(212, 34, 55, 15);
		lblTimecurveTableYValues.setText("Y - Values");
		
		text_2 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_2.setBounds(32, 55, 125, 32);
		
		text_3 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_3.setBounds(182, 55, 125, 32);
		
		text_4 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_4.setBounds(32, 97, 125, 32);
		
		text_5 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_5.setBounds(182, 97, 125, 32);
		
		text_6 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_6.setBounds(32, 142, 125, 32);
		
		text_7 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_7.setBounds(182, 142, 125, 32);
		
		text_8 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_8.setBounds(32, 190, 125, 32);
		
		text_9 = new Text(grpTimeCurveTable, SWT.BORDER);
		text_9.setBounds(182, 190, 125, 32);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(22, 354, 99, 34);
		btnCancel.setText("Cancel");
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(274, 354, 99, 34);
		btnSave.setText("Save");

	}

}
