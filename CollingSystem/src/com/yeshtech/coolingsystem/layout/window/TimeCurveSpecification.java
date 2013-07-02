package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.yeshtech.coolingsystem.util.DisplayMonitor;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class TimeCurveSpecification {

	protected Shell shell;
	private Text txtCurveName;
	private Text txtNumberOfRows;
	private ScrolledComposite frontComp;
	private Composite innerFrontComp;
	private Group grpTimeCurveTable;

	/**
	 * Launch the application.
	 * 
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
		// setting display to center of screen
		DisplayMonitor.getInstance(shell, display);
		shell.setLocation(DisplayMonitor.getMonitorCenterXCoordinate(),
				DisplayMonitor.getMonitorCenterYCoordinate());
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
		final PropertiesLoader loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");

		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(
				TimeCurveSpecification.class, "/icon/App.ico"));
		shell.setSize(422, 436);
		shell.setText(loader
				.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW));

		Label lblCurveName = new Label(shell, SWT.NONE);
		lblCurveName.setBounds(22, 18, 83, 15);
		lblCurveName
				.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CURVE_NAME));

		Label lblNumberOfRows = new Label(shell, SWT.NONE);
		lblNumberOfRows.setBounds(22, 43, 97, 15);
		lblNumberOfRows
				.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_NUMBER_OF_ROWS));

		txtCurveName = new Text(shell, SWT.BORDER);
		txtCurveName.setBounds(125, 14, 146, 21);

		txtNumberOfRows = new Text(shell, SWT.BORDER);
		txtNumberOfRows.setText("4");
		txtNumberOfRows.setBounds(125, 41, 146, 21);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(22, 82, 374, 266);

		grpTimeCurveTable = new Group(composite, SWT.NONE);
		grpTimeCurveTable
				.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_TIMECURVE_TABLE));
		grpTimeCurveTable.setBounds(0, 0, 374, 266);
		grpTimeCurveTable.setVisible(false);

		/*
		 * grpTimeCurveTable = new Group(shell, SWT.NONE);
		 * grpTimeCurveTable.setText(loader.getValue(LabelConstants.
		 * LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_TIMECURVE_TABLE));
		 * grpTimeCurveTable.setBounds(20, 75, 365, 253);
		 * grpTimeCurveTable.setLayout(new FillLayout(SWT.HORIZONTAL));
		 */

		frontComp = new ScrolledComposite(grpTimeCurveTable, SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		frontComp.setBounds(10, 22, 354, 238);
		frontComp.setExpandHorizontal(true);
		frontComp.setExpandVertical(true);

		// frontComp.setAlwaysShowScrollBars(true);

		Button btnCreateTable = new Button(shell, SWT.NONE);
		btnCreateTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				innerFrontComp = new Composite(frontComp, SWT.NONE);
				innerFrontComp.setBounds(0, 0, 366, 260);

				Label lblTimecurveTableXValues = new Label(innerFrontComp,
						SWT.NONE);
				lblTimecurveTableXValues.setBounds(67, 10, 55, 15);
				lblTimecurveTableXValues.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_X_VALUES));

				Label lblTimecurveTableYValues = new Label(innerFrontComp,
						SWT.NONE);
				lblTimecurveTableYValues.setBounds(212, 10, 55, 15);
				lblTimecurveTableYValues.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_Y_VALUES));

				int noOfServer = Integer.parseInt(txtNumberOfRows.getText());
				int x = 0;
				for (int i = 0; i < noOfServer; i++) {
					Text text_2 = new Text(innerFrontComp, SWT.BORDER);
					text_2.setBounds(32, 31 + x, 125, 32);

					Text text_3 = new Text(innerFrontComp, SWT.BORDER);
					text_3.setBounds(182, 31 + x, 125, 32);
					x = x + 42;
				}

				frontComp.setContent(innerFrontComp);
				frontComp.setMinSize(innerFrontComp.computeSize(SWT.DEFAULT,
						SWT.DEFAULT));
				grpTimeCurveTable.setVisible(true);
			}
		});
		btnCreateTable.setBounds(297, 13, 99, 45);
		btnCreateTable
				.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CREATE_TABLE));

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnCancel.setBounds(22, 354, 99, 34);
		btnCancel
				.setText(loader
						.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_CANCEL));

		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(297, 354, 99, 34);
		btnSave.setText(loader
				.getValue(LabelConstants.LAYOUT_TIME_CURVE_SPECIFICATION_WINDOW_SAVE));
		/*
		 * frontComp.setMinHeight(innerFrontComp.computeSize(SWT.DEFAULT,
		 * SWT.DEFAULT).y);
		 * frontComp.setMinWidth(innerFrontComp.computeSize(SWT.DEFAULT,
		 * SWT.DEFAULT).x); frontComp.setContent(innerFrontComp);
		 * frontComp.setExpandHorizontal(true);
		 * frontComp.setExpandVertical(true);
		 */
	}

}
