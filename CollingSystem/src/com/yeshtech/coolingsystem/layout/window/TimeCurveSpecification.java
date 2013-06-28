package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

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
	private Text text_10;
	private Text text_11;

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
		PropertiesLoader loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");
		
		shell = new Shell();
		shell.setSize(422, 436);
		shell.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW));
		
		Label lblCurveName = new Label(shell, SWT.NONE);
		lblCurveName.setBounds(22, 18, 83, 15);
		lblCurveName.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CURVE_NAME));
		
		Label lblNumberOfRows = new Label(shell, SWT.NONE);
		lblNumberOfRows.setBounds(22, 43, 97, 15);
		lblNumberOfRows.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_NUMBER_OF_ROWS));
		
		txtCurveName = new Text(shell, SWT.BORDER);
		txtCurveName.setBounds(125, 14, 146, 21);
		
		txtNumberOfRows = new Text(shell, SWT.BORDER);
		txtNumberOfRows.setBounds(125, 41, 146, 21);
		
		Button btnCreateTable = new Button(shell, SWT.NONE);
		btnCreateTable.setBounds(297, 13, 99, 45);
		btnCreateTable.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CREATE_TABLE));
		
		/*Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(35, 82, 336, 253);*/
		
		/*Group grpTimeCurveTable = new Group(composite, SWT.NONE);
		grpTimeCurveTable.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_TIMECURVE_TABLE));
		grpTimeCurveTable.setBounds(10, 0, 336, 253);*/
		
		Group grpTimeCurveTable = new Group(shell,  SWT.NONE);
		grpTimeCurveTable.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_TIMECURVE_TABLE));
		grpTimeCurveTable.setBounds(20, 75, 365, 253);
		grpTimeCurveTable.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite frontComp = new ScrolledComposite(grpTimeCurveTable, SWT.H_SCROLL
		        | SWT.V_SCROLL);
		
	    Composite innerFrontComp = new Composite(frontComp, SWT.NONE);
	    innerFrontComp.setBounds(0, 0, 365, 253);
		//frontComp.setAlwaysShowScrollBars(true);
		
		
		
		Label lblTimecurveTableXValues = new Label(innerFrontComp, SWT.NONE);
		lblTimecurveTableXValues.setBounds(67, 10, 55, 15);
		lblTimecurveTableXValues.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_X_VALUES));
		
		Label lblTimecurveTableYValues = new Label(innerFrontComp, SWT.NONE);
		lblTimecurveTableYValues.setBounds(212, 10, 55, 15);
		lblTimecurveTableYValues.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_Y_VALUES));
		
		text_2 = new Text(innerFrontComp, SWT.BORDER);
		text_2.setBounds(32, 31, 125, 32);
		
		text_3 = new Text(innerFrontComp, SWT.BORDER);
		text_3.setBounds(182, 31, 125, 32);
		
		text_4 = new Text(innerFrontComp, SWT.BORDER);
		text_4.setBounds(32, 73, 125, 32);
		
		text_5 = new Text(innerFrontComp, SWT.BORDER);
		text_5.setBounds(182, 73, 125, 32);
		
		text_6 = new Text(innerFrontComp, SWT.BORDER);
		text_6.setBounds(32, 118, 125, 32);
		
		text_7 = new Text(innerFrontComp, SWT.BORDER);
		text_7.setBounds(182, 118, 125, 32);
		
		text_8 = new Text(innerFrontComp, SWT.BORDER);
		text_8.setBounds(32, 166, 125, 32);
		
		text_9 = new Text(innerFrontComp, SWT.BORDER);
		text_9.setBounds(182, 166, 125, 32);
		
		text_10 = new Text(innerFrontComp, SWT.BORDER);
		text_10.setBounds(32, 208, 125, 32);
		
		text_11 = new Text(innerFrontComp, SWT.BORDER);
		text_11.setBounds(182, 208, 125, 32);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(22, 354, 99, 34);
		btnCancel.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CANCEL));
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(274, 354, 99, 34);
		btnSave.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_SAVE));

		frontComp.setMinHeight(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
	    frontComp.setMinWidth(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
	    frontComp.setContent(innerFrontComp);
	    frontComp.setExpandHorizontal(true);
	    frontComp.setExpandVertical(true);
	}

}
