package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
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
import org.eclipse.swt.events.SelectionAdapter;

public class NewFanWindow implements SelectionListener {

	protected Shell shell;
	private Text txtFanName;
	private Text txtFixedFlowFlowRate;
	private Text txtFixedFlowEfficiency;
	private Text txtFixedPressureRisePressureRate;
	private Text txtFixedPressureEfficiency;
	private Text txtFanCurveName;
	private Text txtRefFlowHead;
	private Text txtRefFlowrate;
	private Text txtStagFlowHead;
	private Text txtRefFanspeed;
	private Text txtMaxFanspeed;
	private Text txtMaxEfficiency;
	private Text txtFanCurveQuatc;
	private Text txtFanCurveHhatc;
	private Text txtFanCurveA;
	private Text txtFanCurveB;
	private Text txtFanCurveAlpha;
	private FansServerInterface fansServerInterface;
	private Button btnSave;
	private Group grpFixedFlowPan;
	private Label lblFlowRate;
	private Label lblM3S;
	private Label lblEfficiency;
	private Label lblPressureRise;
	private Label lblPa;
	private Label lblFixedPressEfficiency;
	private Group grpFanCurveData;
	private Label lblFanCurveName;
	private Label lblRefFlowHead;
	private Label lblM1;
	private Label lblRefFlowrate;
	private Label lblM3S2;
	private Label lblStagFlowHead;
	private Label lblM2;
	private Label lblRefFanspeed;
	private Label lblRpm1;
	private Label lblMaxFanspeed;
	private Label lblB;
	private Label lblRpm2;
	private Label lblMaxEfficiency;
	private Label lblFanCurveEfficiencyParam;
	private Label lblAlpha;
	private Label lblDeg;
	private Label lblQuatc;
	private Label lblHhatc;
	private Label lblA;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NewFanWindow window = new NewFanWindow();
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
		DisplayMonitor dm = new DisplayMonitor(shell, display);
		shell.setLocation(dm.getMonitorCenterXCoordinate(),
				dm.getMonitorCenterYCoordinate());

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
		shell.setImage(SWTResourceManager.getImage(NewFanWindow.class,
				"/icon/App.ico"));
		shell.setSize(529, 525);
		shell.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW));

		Group grpFanType = new Group(shell, SWT.NONE);
		grpFanType.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE));
		grpFanType.setBounds(10, 57, 212, 115);

		Button rdBtnFixedFlow = new Button(grpFanType, SWT.RADIO);
		rdBtnFixedFlow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				fixedFlowPlanActiveInactive(true);
				fixedPressureRiseFan(false);
				fanCurveData(false);
			}
		});
		rdBtnFixedFlow.setBounds(20, 29, 90, 16);
		rdBtnFixedFlow
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE_FIXED_FLOW));

		Button rdBtnFixedPressureRise = new Button(grpFanType, SWT.RADIO);
		rdBtnFixedPressureRise.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				fixedFlowPlanActiveInactive(false);
				fixedPressureRiseFan(true);
				fanCurveData(false);
			}
		});
		rdBtnFixedPressureRise.setBounds(20, 58, 122, 16);
		rdBtnFixedPressureRise
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE_FIXED_PRESSURE_RISE));

		Button rdBtnSpecifiedFanCurve = new Button(grpFanType, SWT.RADIO);
		rdBtnSpecifiedFanCurve.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				fixedFlowPlanActiveInactive(false);
				fixedPressureRiseFan(false);
				fanCurveData(true);
			}
		});
		rdBtnSpecifiedFanCurve.setBounds(20, 89, 141, 16);
		rdBtnSpecifiedFanCurve
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE_SPECIFIED_FAN_CURVE));

		grpFixedFlowPan = new Group(shell, SWT.NONE);
		grpFixedFlowPan.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_FLOW_FAN));
		grpFixedFlowPan.setBounds(10, 187, 212, 100);

		lblFlowRate = new Label(grpFixedFlowPan, SWT.NONE);
		lblFlowRate.setBounds(12, 22, 55, 15);
		lblFlowRate
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_FLOW_FAN_FLOW_RATE));

		lblEfficiency = new Label(grpFixedFlowPan, SWT.NONE);
		lblEfficiency.setBounds(13, 60, 55, 15);
		lblEfficiency
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_FLOW_FAN_EFFICIENCY));

		txtFixedFlowFlowRate = new Text(grpFixedFlowPan, SWT.BORDER);
		txtFixedFlowFlowRate.setText(Constants.DBL_ONE_POINT_ZER0);
		txtFixedFlowFlowRate.setBounds(93, 21, 63, 21);

		txtFixedFlowEfficiency = new Text(grpFixedFlowPan, SWT.BORDER);
		txtFixedFlowEfficiency.setText(Constants.DBL_ZERO_POINT_EIGHT);
		txtFixedFlowEfficiency.setBounds(93, 60, 109, 21);

		lblM3S = new Label(grpFixedFlowPan, SWT.NONE);
		lblM3S.setBounds(162, 22, 40, 15);
		lblM3S.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M_3_S));

		Group grpFixedPressureRise = new Group(shell, SWT.NONE);
		grpFixedPressureRise
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_PRESSURE_RISE_FAN));
		grpFixedPressureRise.setBounds(10, 301, 209, 115);

		lblPressureRise = new Label(grpFixedPressureRise, SWT.NONE);
		lblPressureRise.setBounds(10, 34, 76, 15);
		lblPressureRise
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_PRESSURE_RISE_FAN_PRESSURE_RISE));

		lblFixedPressEfficiency = new Label(grpFixedPressureRise, SWT.NONE);
		lblFixedPressEfficiency.setBounds(10, 72, 76, 15);
		lblFixedPressEfficiency
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_PRESSURE_RISE_FAN_EFFICIENCY));

		txtFixedPressureRisePressureRate = new Text(grpFixedPressureRise,
				SWT.BORDER);
		txtFixedPressureRisePressureRate.setText(Constants.DBL_ONE_POINT_ZER0);
		txtFixedPressureRisePressureRate.setBounds(92, 32, 63, 21);

		txtFixedPressureEfficiency = new Text(grpFixedPressureRise, SWT.BORDER);
		txtFixedPressureEfficiency.setText(Constants.DBL_ZERO_POINT_EIGHT);
		txtFixedPressureEfficiency.setBounds(92, 70, 107, 21);

		lblPa = new Label(grpFixedPressureRise, SWT.NONE);
		lblPa.setBounds(161, 34, 38, 15);
		lblPa.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_PA));

		grpFanCurveData = new Group(shell, SWT.NONE);
		grpFanCurveData.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA));
		grpFanCurveData.setBounds(241, 10, 262, 406);

		lblFanCurveName = new Label(grpFanCurveData, SWT.NONE);
		lblFanCurveName.setBounds(21, 27, 96, 15);
		lblFanCurveName
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_FAN_CURVE_NAME));

		lblRefFlowHead = new Label(grpFanCurveData, SWT.NONE);
		lblRefFlowHead.setBounds(21, 55, 84, 15);
		lblRefFlowHead
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_REF_FLOW_HEAD));

		lblRefFlowrate = new Label(grpFanCurveData, SWT.NONE);
		lblRefFlowrate.setBounds(21, 82, 84, 15);
		lblRefFlowrate
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_REF_FLOWRATE));

		lblStagFlowHead = new Label(grpFanCurveData, SWT.NONE);
		lblStagFlowHead.setBounds(21, 110, 96, 15);
		lblStagFlowHead
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_STAG_FLOW_HEAD));

		lblRefFanspeed = new Label(grpFanCurveData, SWT.NONE);
		lblRefFanspeed.setBounds(21, 136, 96, 15);
		lblRefFanspeed
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_REF_FANSPEED));

		lblMaxFanspeed = new Label(grpFanCurveData, SWT.NONE);
		lblMaxFanspeed.setBounds(21, 163, 96, 15);
		lblMaxFanspeed
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_MAX_FANSPEED));

		lblMaxEfficiency = new Label(grpFanCurveData, SWT.NONE);
		lblMaxEfficiency.setBounds(21, 192, 96, 15);
		lblMaxEfficiency.setText("Max. efficiency:");

		txtFanCurveName = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveName.setBounds(139, 25, 113, 21);

		txtRefFlowHead = new Text(grpFanCurveData, SWT.BORDER);
		txtRefFlowHead.setText(Constants.INT_TEN);
		txtRefFlowHead.setBounds(139, 54, 68, 21);

		txtRefFlowrate = new Text(grpFanCurveData, SWT.BORDER);
		txtRefFlowrate.setText(Constants.DBL_ZERO_POINT_ZERO_FIVE);
		txtRefFlowrate.setBounds(139, 80, 68, 21);

		txtStagFlowHead = new Text(grpFanCurveData, SWT.BORDER);
		txtStagFlowHead.setText(Constants.INT_FIFTEEN);
		txtStagFlowHead.setBounds(139, 107, 68, 21);

		txtRefFanspeed = new Text(grpFanCurveData, SWT.BORDER);
		txtRefFanspeed.setText(Constants.INT_THOUSAND);
		txtRefFanspeed.setBounds(139, 134, 68, 21);

		txtMaxFanspeed = new Text(grpFanCurveData, SWT.BORDER);
		txtMaxFanspeed.setText(Constants.INT_THOUSAND);
		txtMaxFanspeed.setBounds(139, 161, 68, 21);

		txtMaxEfficiency = new Text(grpFanCurveData, SWT.BORDER);
		txtMaxEfficiency.setText(Constants.DBL_ZERO_POINT_NINE);
		txtMaxEfficiency.setBounds(139, 189, 68, 21);

		lblFanCurveEfficiencyParam = new Label(grpFanCurveData, SWT.NONE);
		lblFanCurveEfficiencyParam.setBounds(41, 226, 177, 15);
		lblFanCurveEfficiencyParam
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_FAN_CURVE_EFFICIENCY));

		lblAlpha = new Label(grpFanCurveData, SWT.NONE);
		lblAlpha.setBounds(21, 259, 55, 15);
		lblAlpha.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_ALPHA));

		lblQuatc = new Label(grpFanCurveData, SWT.NONE);
		lblQuatc.setBounds(21, 287, 55, 15);
		lblQuatc.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_QHATC));

		lblHhatc = new Label(grpFanCurveData, SWT.NONE);
		lblHhatc.setBounds(21, 316, 55, 15);
		lblHhatc.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_HHATC));

		lblA = new Label(grpFanCurveData, SWT.NONE);
		lblA.setBounds(21, 345, 55, 15);
		lblA.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_A));

		lblB = new Label(grpFanCurveData, SWT.NONE);
		lblB.setBounds(21, 372, 55, 15);
		lblB.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_B));

		txtFanCurveQuatc = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveQuatc.setText(Constants.DBL_ZERO_POINT_FIVE);
		txtFanCurveQuatc.setBounds(89, 285, 104, 21);

		txtFanCurveHhatc = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveHhatc.setText(Constants.DBL_ZERO_POINT_SEVENTY_FIVE);
		txtFanCurveHhatc.setBounds(89, 314, 104, 21);

		txtFanCurveA = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveA.setText(Constants.DBL_ONE_POINT_ZER0);
		txtFanCurveA.setBounds(89, 342, 104, 21);

		txtFanCurveB = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveB.setText(Constants.DBL_ONE_POINT_ZER0);
		txtFanCurveB.setBounds(89, 370, 104, 21);

		txtFanCurveAlpha = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveAlpha.setText(Constants.DBL_FIFTY_SIX_POINT_THREE);
		txtFanCurveAlpha.setBounds(89, 256, 104, 21);

		lblM1 = new Label(grpFanCurveData, SWT.NONE);
		lblM1.setBounds(213, 55, 39, 15);
		lblM1.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M));

		lblM3S2 = new Label(grpFanCurveData, SWT.NONE);
		lblM3S2.setBounds(213, 82, 39, 15);
		lblM3S2.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M_3_S));

		lblRpm1 = new Label(grpFanCurveData, SWT.NONE);
		lblRpm1.setBounds(213, 136, 39, 15);
		lblRpm1.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_RPM));

		lblM2 = new Label(grpFanCurveData, SWT.NONE);
		lblM2.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M));
		lblM2.setBounds(213, 110, 39, 15);

		lblRpm2 = new Label(grpFanCurveData, SWT.NONE);
		lblRpm2.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_RPM));
		lblRpm2.setBounds(213, 163, 39, 15);

		lblDeg = new Label(grpFanCurveData, SWT.NONE);
		lblDeg.setBounds(199, 259, 55, 15);
		lblDeg.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_DEG));

		Label lblFanName = new Label(shell, SWT.NONE);
		lblFanName.setBounds(21, 18, 74, 15);
		lblFanName.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_NAME));

		txtFanName = new Text(shell, SWT.BORDER);
		txtFanName.setBounds(101, 15, 106, 21);

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(this);
		btnCancel.setBounds(21, 434, 94, 31);
		btnCancel
				.setText(loader
						.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_CANCEL));

		btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(this);
		btnSave.setBounds(376, 434, 94, 31);
		btnSave.setText(loader
				.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_SAVE));

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnSave)) {
			this.fansServerInterface.addFan(txtFanName.getText());
			this.shell.dispose();
		} else {
			this.shell.dispose();
		}
	}

	public void fixedFlowPlanActiveInactive(boolean bolActiveInactive) {
		grpFixedFlowPan.setEnabled(bolActiveInactive);
		lblFlowRate.setEnabled(bolActiveInactive);
		txtFixedFlowFlowRate.setEnabled(bolActiveInactive);
		lblM3S.setEnabled(bolActiveInactive);
		lblEfficiency.setEnabled(bolActiveInactive);
		txtFixedFlowEfficiency.setEnabled(bolActiveInactive);
	}

	public void fixedPressureRiseFan(boolean bolActiveInactive) {
		lblPressureRise.setEnabled(bolActiveInactive);
		txtFixedPressureRisePressureRate.setEnabled(bolActiveInactive);
		lblPa.setEnabled(bolActiveInactive);
		lblFixedPressEfficiency.setEnabled(bolActiveInactive);
		txtFixedPressureEfficiency.setEnabled(bolActiveInactive);
	}

	public void fanCurveData(boolean bolActiveInactive) {

		grpFanCurveData.setEnabled(bolActiveInactive);
		lblFanCurveName.setEnabled(bolActiveInactive);
		txtFanCurveName.setEnabled(bolActiveInactive);
		lblRefFlowHead.setEnabled(bolActiveInactive);
		txtRefFlowHead.setEnabled(bolActiveInactive);
		lblM1.setEnabled(bolActiveInactive);
		lblRefFlowrate.setEnabled(bolActiveInactive);
		txtRefFlowrate.setEnabled(bolActiveInactive);
		lblM3S2.setEnabled(bolActiveInactive);
		lblStagFlowHead.setEnabled(bolActiveInactive);
		txtStagFlowHead.setEnabled(bolActiveInactive);
		lblM2.setEnabled(bolActiveInactive);
		lblRefFanspeed.setEnabled(bolActiveInactive);
		txtRefFanspeed.setEnabled(bolActiveInactive);
		lblRpm1.setEnabled(bolActiveInactive);
		lblMaxFanspeed.setEnabled(bolActiveInactive);
		txtMaxFanspeed.setEnabled(bolActiveInactive);
		lblRpm2.setEnabled(bolActiveInactive);
		lblMaxEfficiency.setEnabled(bolActiveInactive);
		txtMaxEfficiency.setEnabled(bolActiveInactive);
		lblFanCurveEfficiencyParam.setEnabled(bolActiveInactive);
		lblAlpha.setEnabled(bolActiveInactive);
		txtFanCurveAlpha.setEnabled(bolActiveInactive);
		lblDeg.setEnabled(bolActiveInactive);
		lblQuatc.setEnabled(bolActiveInactive);
		txtFanCurveQuatc.setEnabled(bolActiveInactive);
		lblHhatc.setEnabled(bolActiveInactive);
		txtFanCurveHhatc.setEnabled(bolActiveInactive);
		lblA.setEnabled(bolActiveInactive);
		txtFanCurveA.setEnabled(bolActiveInactive);
		lblB.setEnabled(bolActiveInactive);
		txtFanCurveB.setEnabled(bolActiveInactive);

	}

}
