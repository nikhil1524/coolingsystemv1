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
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class NewFanWindow implements SelectionListener{

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
	/**
	 * Launch the application.
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
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void setFansServerInterface(FansServerInterface serverInterface)
	{
		this.fansServerInterface = serverInterface;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		PropertiesLoader loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");
		shell = new Shell();
		shell.setSize(529, 525);
		shell.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW));
		
		Group grpFanType = new Group(shell, SWT.NONE);
		grpFanType.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE));
		grpFanType.setBounds(10, 57, 212, 115);
		
		Button rdBtnFixedFlow = new Button(grpFanType, SWT.RADIO);
		rdBtnFixedFlow.setBounds(20, 29, 90, 16);
		rdBtnFixedFlow.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE_FIXED_FLOW));
		
		Button rdBtnFixedPressureRise = new Button(grpFanType, SWT.RADIO);
		rdBtnFixedPressureRise.setBounds(20, 58, 122, 16);
		rdBtnFixedPressureRise.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE_FIXED_PRESSURE_RISE));
		
		Button rdBtnSpecifiedFanCurve = new Button(grpFanType, SWT.RADIO);
		rdBtnSpecifiedFanCurve.setBounds(20, 89, 141, 16);
		rdBtnSpecifiedFanCurve.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_TYPE_SPECIFIED_FAN_CURVE));
		
		Group grpFixedFlowPan = new Group(shell, SWT.NONE);
		grpFixedFlowPan.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_FLOW_FAN));
		grpFixedFlowPan.setBounds(10, 187, 212, 100);
		
		Label lblFlowRate = new Label(grpFixedFlowPan, SWT.NONE);
		lblFlowRate.setBounds(12, 22, 55, 15);
		lblFlowRate.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_FLOW_FAN_FLOW_RATE));
		
		Label lblEfficiency = new Label(grpFixedFlowPan, SWT.NONE);
		lblEfficiency.setBounds(13, 60, 55, 15);
		lblEfficiency.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_FLOW_FAN_EFFICIENCY));
		
		txtFixedFlowFlowRate = new Text(grpFixedFlowPan, SWT.BORDER);
		txtFixedFlowFlowRate.setText(Constants.DBL_ONE_POINT_ZER0);
		txtFixedFlowFlowRate.setBounds(93, 21, 63, 21);
		
		txtFixedFlowEfficiency = new Text(grpFixedFlowPan, SWT.BORDER);
		txtFixedFlowEfficiency.setText(Constants.DBL_ZERO_POINT_EIGHT);
		txtFixedFlowEfficiency.setBounds(93, 60, 109, 21);
		
		Label lblM3S = new Label(grpFixedFlowPan, SWT.NONE);
		lblM3S.setBounds(162, 22, 40, 15);
		lblM3S.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M_3_S));
		
		Group grpFixedPressureRise = new Group(shell, SWT.NONE);
		grpFixedPressureRise.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_PRESSURE_RISE_FAN));
		grpFixedPressureRise.setBounds(10, 301, 209, 115);
		
		Label lblNewLabel_3 = new Label(grpFixedPressureRise, SWT.NONE);
		lblNewLabel_3.setBounds(10, 34, 76, 15);
		lblNewLabel_3.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_PRESSURE_RISE_FAN_PRESSURE_RISE));
		
		Label lblNewLabel_4 = new Label(grpFixedPressureRise, SWT.NONE);
		lblNewLabel_4.setBounds(10, 72, 76, 15);
		lblNewLabel_4.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FIXED_PRESSURE_RISE_FAN_EFFICIENCY));
		
		txtFixedPressureRisePressureRate = new Text(grpFixedPressureRise, SWT.BORDER);
		txtFixedPressureRisePressureRate.setText(Constants.DBL_ONE_POINT_ZER0);
		txtFixedPressureRisePressureRate.setBounds(92, 32, 63, 21);
		
		txtFixedPressureEfficiency = new Text(grpFixedPressureRise, SWT.BORDER);
		txtFixedPressureEfficiency.setText(Constants.DBL_ZERO_POINT_EIGHT);
		txtFixedPressureEfficiency.setBounds(92, 70, 107, 21);
		
		Label lblPa = new Label(grpFixedPressureRise, SWT.NONE);
		lblPa.setBounds(161, 34, 38, 15);
		lblPa.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_PA));
		
		Group grpFanCurveData = new Group(shell, SWT.NONE);
		grpFanCurveData.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA));
		grpFanCurveData.setBounds(241, 10, 262, 406);
		
		Label lblFanCurveName = new Label(grpFanCurveData, SWT.NONE);
		lblFanCurveName.setBounds(21, 27, 96, 15);
		lblFanCurveName.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_FAN_CURVE_NAME));
		
		Label lblRefFlowHead = new Label(grpFanCurveData, SWT.NONE);
		lblRefFlowHead.setBounds(21, 55, 84, 15);
		lblRefFlowHead.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_REF_FLOW_HEAD));
		
		Label lblRefFlowrate = new Label(grpFanCurveData, SWT.NONE);
		lblRefFlowrate.setBounds(21, 82, 84, 15);
		lblRefFlowrate.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_REF_FLOWRATE));
		
		Label lblStagFlowHead = new Label(grpFanCurveData, SWT.NONE);
		lblStagFlowHead.setBounds(21, 110, 96, 15);
		lblStagFlowHead.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_STAG_FLOW_HEAD));
		
		Label lblRefFanspeed = new Label(grpFanCurveData, SWT.NONE);
		lblRefFanspeed.setBounds(21, 136, 96, 15);
		lblRefFanspeed.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_REF_FANSPEED));
		
		Label lblMaxFanspeed = new Label(grpFanCurveData, SWT.NONE);
		lblMaxFanspeed.setBounds(21, 163, 96, 15);
		lblMaxFanspeed.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_MAX_FANSPEED));
		
		Label lblMaxEfficiency = new Label(grpFanCurveData, SWT.NONE);
		lblMaxEfficiency.setBounds(21, 192, 96, 15);
		lblMaxEfficiency.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_MAX_EFFICIENCY));
		
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
		
		Label lblFanCurveEfficiencyParam = new Label(grpFanCurveData, SWT.NONE);
		lblFanCurveEfficiencyParam.setBounds(41, 226, 177, 15);
		lblFanCurveEfficiencyParam.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_FAN_CURVE_EFFICIENCY));
		
		Label lblAlpha = new Label(grpFanCurveData, SWT.NONE);
		lblAlpha.setBounds(21, 259, 55, 15);
		lblAlpha.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_ALPHA));
		
		Label lblQuatc = new Label(grpFanCurveData, SWT.NONE);
		lblQuatc.setBounds(21, 287, 55, 15);
		lblQuatc.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_QHATC));
		
		Label lblHhatc = new Label(grpFanCurveData, SWT.NONE);
		lblHhatc.setBounds(21, 316, 55, 15);
		lblHhatc.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_HHATC));
		
		Label lblA = new Label(grpFanCurveData, SWT.NONE);
		lblA.setBounds(21, 345, 55, 15);
		lblA.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_A));
		
		Label lblB = new Label(grpFanCurveData, SWT.NONE);
		lblB.setBounds(21, 372, 55, 15);
		lblB.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_B));
		
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
		
		Label lblM1 = new Label(grpFanCurveData, SWT.NONE);
		lblM1.setBounds(213, 55, 39, 15);
		lblM1.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M));
		
		Label lblM3S2 = new Label(grpFanCurveData, SWT.NONE);
		lblM3S2.setBounds(213, 82, 39, 15);
		lblM3S2.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M_3_S));
		
		Label lblRpm1 = new Label(grpFanCurveData, SWT.NONE);
		lblRpm1.setBounds(213, 136, 39, 15);
		lblRpm1.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_RPM));
		
		Label lblM2 = new Label(grpFanCurveData, SWT.NONE);
		lblM2.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_M));
		lblM2.setBounds(213, 110, 39, 15);
		
		Label lblRpm2 = new Label(grpFanCurveData, SWT.NONE);
		lblRpm2.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_RPM));
		lblRpm2.setBounds(213, 163, 39, 15);
		
		Label lblDeg = new Label(grpFanCurveData, SWT.NONE);
		lblDeg.setBounds(199, 259, 55, 15);
		lblDeg.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_DEG));
		
		Label lblFanName = new Label(shell, SWT.NONE);
		lblFanName.setBounds(21, 18, 74, 15);
		lblFanName.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_NAME));
		
		txtFanName = new Text(shell, SWT.BORDER);
		txtFanName.setBounds(101, 15, 106, 21);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(this);
		btnCancel.setBounds(21, 434, 94, 31);
		btnCancel.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_CANCEL));
		
		btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(this);
		btnSave.setBounds(376, 434, 94, 31);
		btnSave.setText(loader.getValue(LabelConstants.LAYOUT_NEW_FAN_WINDOW_FAN_CURVE_DATA_SAVE));

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(btnSave))
		{
			this.fansServerInterface.addFan(txtFanName.getText());
			this.shell.dispose();
		}
		else
		{
			this.shell.dispose();
		}
	}
}
