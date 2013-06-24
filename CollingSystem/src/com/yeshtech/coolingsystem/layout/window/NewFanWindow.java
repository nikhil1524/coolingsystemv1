package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class NewFanWindow {

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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(529, 525);
		shell.setText("New Fan");
		
		Group grpFanType = new Group(shell, SWT.NONE);
		grpFanType.setText("Fan Type");
		grpFanType.setBounds(10, 57, 212, 115);
		
		Button rdBtnFixedFlow = new Button(grpFanType, SWT.RADIO);
		rdBtnFixedFlow.setBounds(20, 29, 90, 16);
		rdBtnFixedFlow.setText("Fixed Flow");
		
		Button rdBtnFixedPressureRise = new Button(grpFanType, SWT.RADIO);
		rdBtnFixedPressureRise.setBounds(20, 58, 122, 16);
		rdBtnFixedPressureRise.setText("Fixed Pressure Rise ");
		
		Button rdBtnSpecifiedFanCurve = new Button(grpFanType, SWT.RADIO);
		rdBtnSpecifiedFanCurve.setBounds(20, 89, 141, 16);
		rdBtnSpecifiedFanCurve.setText("Specified Fan Curve");
		
		Group grpFixedFlowPan = new Group(shell, SWT.NONE);
		grpFixedFlowPan.setText("Fixed Flow Fan");
		grpFixedFlowPan.setBounds(10, 187, 212, 100);
		
		Label lblFlowRate = new Label(grpFixedFlowPan, SWT.NONE);
		lblFlowRate.setBounds(12, 22, 55, 15);
		lblFlowRate.setText("Flow Rate :");
		
		Label lblEfficiency = new Label(grpFixedFlowPan, SWT.NONE);
		lblEfficiency.setBounds(13, 60, 55, 15);
		lblEfficiency.setText("Efficiency :");
		
		txtFixedFlowFlowRate = new Text(grpFixedFlowPan, SWT.BORDER);
		txtFixedFlowFlowRate.setBounds(93, 21, 63, 21);
		
		txtFixedFlowEfficiency = new Text(grpFixedFlowPan, SWT.BORDER);
		txtFixedFlowEfficiency.setBounds(93, 60, 109, 21);
		
		Label lblM3S = new Label(grpFixedFlowPan, SWT.NONE);
		lblM3S.setBounds(162, 22, 40, 15);
		lblM3S.setText("m^3/s");
		
		Group grpFixedPressureRise = new Group(shell, SWT.NONE);
		grpFixedPressureRise.setText("Fixed Pressure Rise Fan");
		grpFixedPressureRise.setBounds(10, 301, 209, 115);
		
		Label lblNewLabel_3 = new Label(grpFixedPressureRise, SWT.NONE);
		lblNewLabel_3.setBounds(10, 34, 90, 15);
		lblNewLabel_3.setText("Pressure Rate :");
		
		Label lblNewLabel_4 = new Label(grpFixedPressureRise, SWT.NONE);
		lblNewLabel_4.setBounds(10, 72, 76, 15);
		lblNewLabel_4.setText("Effciency :");
		
		txtFixedPressureRisePressureRate = new Text(grpFixedPressureRise, SWT.BORDER);
		txtFixedPressureRisePressureRate.setBounds(92, 32, 63, 21);
		
		txtFixedPressureEfficiency = new Text(grpFixedPressureRise, SWT.BORDER);
		txtFixedPressureEfficiency.setBounds(92, 70, 107, 21);
		
		Label lblPa = new Label(grpFixedPressureRise, SWT.NONE);
		lblPa.setBounds(161, 34, 38, 15);
		lblPa.setText("Pa");
		
		Group grpFanCurveData = new Group(shell, SWT.NONE);
		grpFanCurveData.setText("Fan Curve Data");
		grpFanCurveData.setBounds(241, 10, 262, 406);
		
		Label lblFanCurveName = new Label(grpFanCurveData, SWT.NONE);
		lblFanCurveName.setBounds(21, 27, 96, 15);
		lblFanCurveName.setText("Fan Curve Name : ");
		
		Label lblRefFlowHead = new Label(grpFanCurveData, SWT.NONE);
		lblRefFlowHead.setBounds(21, 55, 84, 15);
		lblRefFlowHead.setText("Ref. flow head :");
		
		Label lblRefFlowrate = new Label(grpFanCurveData, SWT.NONE);
		lblRefFlowrate.setBounds(21, 82, 84, 15);
		lblRefFlowrate.setText("Ref. flowrate :");
		
		Label lblStagFlowHead = new Label(grpFanCurveData, SWT.NONE);
		lblStagFlowHead.setBounds(21, 110, 96, 15);
		lblStagFlowHead.setText("Stag flow head :");
		
		Label lblRefFanspeed = new Label(grpFanCurveData, SWT.NONE);
		lblRefFanspeed.setBounds(21, 136, 96, 15);
		lblRefFanspeed.setText("Ref. Fanspeed :");
		
		Label lblMaxFanspeed = new Label(grpFanCurveData, SWT.NONE);
		lblMaxFanspeed.setBounds(21, 163, 96, 15);
		lblMaxFanspeed.setText("Max Fanspeed :");
		
		Label lblMaxEfficiency = new Label(grpFanCurveData, SWT.NONE);
		lblMaxEfficiency.setBounds(21, 192, 96, 15);
		lblMaxEfficiency.setText("Max efficiency :");
		
		txtFanCurveName = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveName.setBounds(139, 25, 113, 21);
		
		txtRefFlowHead = new Text(grpFanCurveData, SWT.BORDER);
		txtRefFlowHead.setBounds(139, 54, 68, 21);
		
		txtRefFlowrate = new Text(grpFanCurveData, SWT.BORDER);
		txtRefFlowrate.setBounds(139, 80, 68, 21);
		
		txtStagFlowHead = new Text(grpFanCurveData, SWT.BORDER);
		txtStagFlowHead.setBounds(139, 107, 68, 21);
		
		txtRefFanspeed = new Text(grpFanCurveData, SWT.BORDER);
		txtRefFanspeed.setBounds(139, 134, 68, 21);
		
		txtMaxFanspeed = new Text(grpFanCurveData, SWT.BORDER);
		txtMaxFanspeed.setBounds(139, 161, 68, 21);
		
		txtMaxEfficiency = new Text(grpFanCurveData, SWT.BORDER);
		txtMaxEfficiency.setBounds(139, 189, 68, 21);
		
		Label lblFanCurveEfficiencyParam = new Label(grpFanCurveData, SWT.NONE);
		lblFanCurveEfficiencyParam.setBounds(41, 226, 177, 15);
		lblFanCurveEfficiencyParam.setText("Fan Curve Effeciency Parameter");
		
		Label lblAlpha = new Label(grpFanCurveData, SWT.NONE);
		lblAlpha.setBounds(21, 259, 55, 15);
		lblAlpha.setText("alpha :");
		
		Label lblQuatc = new Label(grpFanCurveData, SWT.NONE);
		lblQuatc.setBounds(21, 287, 55, 15);
		lblQuatc.setText("Quatc :");
		
		Label lblHhatc = new Label(grpFanCurveData, SWT.NONE);
		lblHhatc.setBounds(21, 316, 55, 15);
		lblHhatc.setText("Hhatc :");
		
		Label lblA = new Label(grpFanCurveData, SWT.NONE);
		lblA.setBounds(21, 345, 55, 15);
		lblA.setText("a :");
		
		Label lblB = new Label(grpFanCurveData, SWT.NONE);
		lblB.setBounds(21, 372, 55, 15);
		lblB.setText("b :");
		
		txtFanCurveQuatc = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveQuatc.setBounds(89, 285, 104, 21);
		
		txtFanCurveHhatc = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveHhatc.setBounds(89, 314, 104, 21);
		
		txtFanCurveA = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveA.setBounds(89, 342, 104, 21);
		
		txtFanCurveB = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveB.setBounds(89, 370, 104, 21);
		
		txtFanCurveAlpha = new Text(grpFanCurveData, SWT.BORDER);
		txtFanCurveAlpha.setBounds(89, 256, 104, 21);
		
		Label lblM1 = new Label(grpFanCurveData, SWT.NONE);
		lblM1.setBounds(213, 55, 39, 15);
		lblM1.setText("m");
		
		Label lblM3S2 = new Label(grpFanCurveData, SWT.NONE);
		lblM3S2.setBounds(213, 82, 39, 15);
		lblM3S2.setText("m^3/s");
		
		Label lblRpm1 = new Label(grpFanCurveData, SWT.NONE);
		lblRpm1.setBounds(213, 136, 39, 15);
		lblRpm1.setText("rpm");
		
		Label lblM2 = new Label(grpFanCurveData, SWT.NONE);
		lblM2.setText("m");
		lblM2.setBounds(213, 110, 39, 15);
		
		Label lblRpm2 = new Label(grpFanCurveData, SWT.NONE);
		lblRpm2.setText("rpm");
		lblRpm2.setBounds(213, 163, 39, 15);
		
		Label lblDeg = new Label(grpFanCurveData, SWT.NONE);
		lblDeg.setBounds(199, 259, 55, 15);
		lblDeg.setText("deg");
		
		Label lblFanName = new Label(shell, SWT.NONE);
		lblFanName.setBounds(21, 18, 74, 15);
		lblFanName.setText("Fan Name :");
		
		txtFanName = new Text(shell, SWT.BORDER);
		txtFanName.setBounds(101, 15, 106, 21);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(21, 434, 94, 31);
		btnCancel.setText("Cancel");
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(376, 434, 94, 31);
		btnSave.setText("Save");

	}
}
