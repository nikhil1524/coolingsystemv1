package com.yeshtech.coolingsystem.layout.window;

import java.awt.FlowLayout;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
		//shell.setLayout(new GridLayout(1,true));
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
		
		
		//Time Curve table started 
		
		
		
		/*Group grpTimeCurveTable = new Group(composite, SWT.NONE);
		grpTimeCurveTable.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_TIMECURVE_TABLE));
		grpTimeCurveTable.setBounds(10, 0, 336, 253);*/
		
		Group grpTimeCurveTable = new Group(shell,  SWT.NONE);
		grpTimeCurveTable.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_TIMECURVE_TABLE));
		grpTimeCurveTable.setBounds(20, 84, 376, 261);
		grpTimeCurveTable.setLayout(new FillLayout(SWT.VERTICAL));
		//grpTimeCurveTable.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,true));
		
		Composite composite = new Composite(grpTimeCurveTable, SWT.NONE);
		composite.setBounds(35, 91, 336, 244);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		composite.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,true));
		
		ScrolledComposite srlComTable = new ScrolledComposite(composite,SWT.BORDER| SWT.V_SCROLL | SWT.H_SCROLL);
		srlComTable.setLayout(new GridLayout(2,true));
		srlComTable.setBounds(35,91,300,200);
		
//	    Composite innerFrontComp = new Composite(srlComTable, SWT.NONE);
//	    innerFrontComp.setBounds(0, 0, 365, 253);
//	    innerFrontComp.setLayout(new GridLayout(1,true));
//
//		
//	    srlComTable.setMinSize(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT));
//	    srlComTable.setContent(innerFrontComp);
//	    srlComTable.setExpandHorizontal(true);
//	    srlComTable.setExpandVertical(true);
//	    srlComTable.setAlwaysShowScrollBars(true);
    	
    	
//		Label lblTimecurveTableXValues = new Label(innerFrontComp, SWT.NONE);
//		lblTimecurveTableXValues.setBounds(67, 10, 55, 15);
//		lblTimecurveTableXValues.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_X_VALUES));
//		
//		Label lblTimecurveTableYValues = new Label(innerFrontComp, SWT.NONE);
//		lblTimecurveTableYValues.setBounds(212, 10, 55, 15);
//		lblTimecurveTableYValues.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_Y_VALUES));
//		
//
//    	for(int i = 0; i < 1000; i++){
//    		new Button(innerFrontComp, SWT.PUSH).setText("Text");
//    	}

		
		
		
//		text_2 = new Text(innerFrontComp, SWT.BORDER);
//		text_2.setBounds(32, 31, 125, 32);
//		
//		text_3 = new Text(innerFrontComp, SWT.BORDER);
//		text_3.setBounds(182, 31, 125, 32);
//		
//		text_4 = new Text(innerFrontComp, SWT.BORDER);
//		text_4.setBounds(32, 73, 125, 32);
//		
//		text_5 = new Text(innerFrontComp, SWT.BORDER);
//		text_5.setBounds(182, 73, 125, 32);
		
//		text_6 = new Text(innerFrontComp, SWT.BORDER);
//		text_6.setBounds(32, 118, 125, 32);
//		
//		text_7 = new Text(innerFrontComp, SWT.BORDER);
//		text_7.setBounds(182, 118, 125, 32);
//		
//		text_8 = new Text(innerFrontComp, SWT.BORDER);
//		text_8.setBounds(32, 166, 125, 32);
//		
//		text_9 = new Text(innerFrontComp, SWT.BORDER);
//		text_9.setBounds(182, 166, 125, 32);
//		
//		text_10 = new Text(innerFrontComp, SWT.BORDER);
//		text_10.setBounds(32, 208, 125, 32);
//		
//		text_11 = new Text(innerFrontComp, SWT.BORDER);
//		text_11.setBounds(182, 208, 125, 32);
		
		//srlComTable.setContent(innerFrontComp);
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(22, 354, 99, 34);
		btnCancel.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CANCEL));
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(297, 354, 99, 34);
		btnSave.setText(loader.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_SAVE));

		//frontComp.setMinHeight(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
	    //frontComp.setMinWidth(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
	  
	}

}
