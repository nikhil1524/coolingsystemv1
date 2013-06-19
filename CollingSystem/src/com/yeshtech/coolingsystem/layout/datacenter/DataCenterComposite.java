package com.yeshtech.coolingsystem.layout.datacenter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class DataCenterComposite extends Composite {

	private Text txtDataCenterAPTotalHeatGain;
	private Text txtDataCenterDCDXDim;
	private Text txtDataCenterDCDYDim;
	private Text txtDataCenterDCDZDim;
	private Text txtDataCenterDCDSubPlenHeight;
	private Text txtDataCenterDCDRetPlenHeight;
	private Text txtDataCenterGPExtHeatGain;
	private Text txtDataCenterGPNoRacks;
	private Text txtDataCenterGPR;
	private Text txtDataCenterGPFloorLeak;
	private Text txtDataCenterGPCeilLeak;
	private Text txtDataCenterGPFloorOpen;
	private Text txtDataCenterGPCeilOpen;
	private Group grpGeneration1Parameters;
	private Group grpGenerationParameters;
	private Label lblTtotalHeatrGain;
	private Button btnNewButton;
	private Label lblW;
	private Label lblExternalHeatGain;
	private Label label_13;
	private Button button;
	private Label lblNumberOfRackes;
	private Button btnLayout;
	private Label lblR, lblKw;
	private Label lblFloorLeak;
	private Label lblCeilingLeak;
	private Label lblFloorOpen;
	private Label lblCeilingOpen;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public DataCenterComposite(Composite parent, int style,
			PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {
		Group grpDatacentermodel = new Group(this, SWT.NONE);
		grpDatacentermodel.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_DATA_CENTER_MODEL));
		grpDatacentermodel.setBounds(10, 10, 158, 71);

		Button btnDataCenterDCMGen1 = new Button(grpDatacentermodel, SWT.RADIO);
		btnDataCenterDCMGen1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				enabledisableGen1Para(true);
				enabledisableGen2Para(false);
			}
		});
		btnDataCenterDCMGen1.setSelection(true);
		btnDataCenterDCMGen1.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_GENERATION_1));
		btnDataCenterDCMGen1.setBounds(10, 22, 90, 16);

		Button btnDataCenterDCMGen2 = new Button(grpDatacentermodel, SWT.RADIO);
		btnDataCenterDCMGen2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				enabledisableGen2Para(true);
				enabledisableGen1Para(false);
			}
		});
		btnDataCenterDCMGen2.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_GENERATION_2));
		btnDataCenterDCMGen2.setBounds(10, 44, 90, 16);

		grpGeneration1Parameters = new Group(this, SWT.NONE);
		grpGeneration1Parameters
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_GENERATION_1_PARAMETER));
		grpGeneration1Parameters.setBounds(196, 10, 347, 71);

		lblTtotalHeatrGain = new Label(grpGeneration1Parameters, SWT.NONE);
		lblTtotalHeatrGain.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_TOTAL_HEAT_GAIN));
		lblTtotalHeatrGain.setBounds(10, 29, 93, 15);

		txtDataCenterAPTotalHeatGain = new Text(grpGeneration1Parameters,
				SWT.BORDER);
		txtDataCenterAPTotalHeatGain.setBounds(109, 26, 75, 20);
		txtDataCenterAPTotalHeatGain.setText(Constants.INT_ZERO);

		lblW = new Label(grpGeneration1Parameters, SWT.NONE);
		lblW.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_W));
		lblW.setBounds(203, 29, 11, 15);

		btnNewButton = new Button(grpGeneration1Parameters, SWT.NONE);
		btnNewButton.setBounds(240, 24, 75, 25);
		btnNewButton.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_TIME_CURVE));

		Group grpDataCenterDimentsion = new Group(this, SWT.NONE);
		grpDataCenterDimentsion
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_DATA_CENTER_DIMENSIONS));
		grpDataCenterDimentsion.setBounds(303, 87, 240, 199);

		Label lblXdimensions = new Label(grpDataCenterDimentsion, SWT.NONE);
		lblXdimensions.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_X_DIMENSION));
		lblXdimensions.setBounds(10, 19, 82, 15);

		txtDataCenterDCDXDim = new Text(grpDataCenterDimentsion, SWT.BORDER);
		txtDataCenterDCDXDim.setBounds(148, 14, 50, 20);
		txtDataCenterDCDXDim.setText(Constants.INT_TEN);

		Label lblM = new Label(grpDataCenterDimentsion, SWT.NONE);
		lblM.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_M));
		lblM.setBounds(204, 19, 23, 15);

		Label lblYdimensions = new Label(grpDataCenterDimentsion, SWT.NONE);
		lblYdimensions.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_Y_DIMENSION));
		lblYdimensions.setBounds(10, 53, 82, 15);

		txtDataCenterDCDYDim = new Text(grpDataCenterDimentsion, SWT.BORDER);
		txtDataCenterDCDYDim.setBounds(148, 48, 50, 20);
		txtDataCenterDCDYDim.setText(Constants.INT_TEN);

		Label label_9 = new Label(grpDataCenterDimentsion, SWT.NONE);
		label_9.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_M));
		label_9.setBounds(204, 53, 23, 15);

		Label lblZdimensions = new Label(grpDataCenterDimentsion, SWT.NONE);
		lblZdimensions.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_Z_DIMENSION));
		lblZdimensions.setBounds(10, 86, 82, 15);

		txtDataCenterDCDZDim = new Text(grpDataCenterDimentsion, SWT.BORDER);
		txtDataCenterDCDZDim.setBounds(148, 81, 50, 20);
		txtDataCenterDCDZDim.setText(Constants.INT_FIVE);

		Label label_11 = new Label(grpDataCenterDimentsion, SWT.NONE);
		label_11.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_M));
		label_11.setBounds(204, 86, 23, 15);

		Label lblS = new Label(grpDataCenterDimentsion, SWT.NONE);
		lblS.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_SUBFLOOR_PLENUM));
		lblS.setBounds(10, 122, 132, 15);

		txtDataCenterDCDSubPlenHeight = new Text(grpDataCenterDimentsion,
				SWT.BORDER);
		txtDataCenterDCDSubPlenHeight.setBounds(149, 122, 50, 20);
		txtDataCenterDCDSubPlenHeight.setText(Constants.DBL_ZEROPOINTONE);

		Label label_10 = new Label(grpDataCenterDimentsion, SWT.NONE);
		label_10.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_M));
		label_10.setBounds(204, 122, 23, 15);

		Label lblReturnPlenumHeight = new Label(grpDataCenterDimentsion,
				SWT.NONE);
		lblReturnPlenumHeight.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_RETURN_PLENUM));
		lblReturnPlenumHeight.setBounds(10, 157, 132, 15);

		txtDataCenterDCDRetPlenHeight = new Text(grpDataCenterDimentsion,
				SWT.BORDER);
		txtDataCenterDCDRetPlenHeight.setBounds(149, 157, 50, 20);
		txtDataCenterDCDRetPlenHeight.setText(Constants.DBL_ZEROPOINTONE);

		Label label_12 = new Label(grpDataCenterDimentsion, SWT.NONE);
		label_12.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_M));
		label_12.setBounds(204, 157, 23, 15);

		grpGenerationParameters = new Group(this, SWT.NONE);
		grpGenerationParameters
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_GENERATION_2_PARAMETER));
		grpGenerationParameters.setBounds(10, 87, 287, 199);

		lblExternalHeatGain = new Label(grpGenerationParameters, SWT.NONE);
		lblExternalHeatGain
				.setText(loader
						.getValue(LabelConstants.LAYOUT_DATA_CENTER_EXTERNAL_HEAT_GAIN));
		lblExternalHeatGain.setBounds(10, 24, 106, 15);

		txtDataCenterGPExtHeatGain = new Text(grpGenerationParameters,
				SWT.BORDER);
		txtDataCenterGPExtHeatGain.setBounds(122, 24, 42, 20);
		txtDataCenterGPExtHeatGain.setText(Constants.INT_ZERO);

		label_13 = new Label(grpGenerationParameters, SWT.NONE);
		label_13.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_W));
		label_13.setBounds(170, 24, 19, 15);

		button = new Button(grpGenerationParameters, SWT.NONE);
		button.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_TIME_CURVE));
		button.setBounds(195, 19, 75, 25);

		lblNumberOfRackes = new Label(grpGenerationParameters, SWT.NONE);
		lblNumberOfRackes.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_NO_OF_RACKS));
		lblNumberOfRackes.setBounds(10, 65, 146, 15);

		txtDataCenterGPNoRacks = new Text(grpGenerationParameters, SWT.BORDER);
		txtDataCenterGPNoRacks.setBounds(162, 62, 42, 20);
		txtDataCenterGPNoRacks.setText(Constants.INT_ONE);

		btnLayout = new Button(grpGenerationParameters, SWT.NONE);
		btnLayout.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_LAYOUT));
		btnLayout.setBounds(210, 60, 67, 25);

		lblR = new Label(grpGenerationParameters, SWT.NONE);
		lblR.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_R_EXTERNAL_EQUIP));
		lblR.setBounds(10, 96, 146, 15);

		txtDataCenterGPR = new Text(grpGenerationParameters, SWT.BORDER);
		txtDataCenterGPR.setBounds(162, 91, 44, 20);
		txtDataCenterGPR.setText(Constants.DBL_ZEROPOINTONE);
		lblKw = new Label(grpGenerationParameters, SWT.NONE);
		lblKw.setText(loader.getValue(LabelConstants.LAYOUT_DATA_CENTER_K_W));
		lblKw.setBounds(235, 96, 42, 15);

		txtDataCenterGPFloorLeak = new Text(grpGenerationParameters, SWT.BORDER);
		txtDataCenterGPFloorLeak.setBounds(80, 130, 58, 20);
		txtDataCenterGPFloorLeak.setText(Constants.DBL_ZEROPOINTTWO);

		lblFloorLeak = new Label(grpGenerationParameters, SWT.NONE);
		lblFloorLeak.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_FLOOR_LEAK));
		lblFloorLeak.setBounds(10, 133, 64, 15);

		lblCeilingLeak = new Label(grpGenerationParameters, SWT.NONE);
		lblCeilingLeak.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_CEILING_LEAK));
		lblCeilingLeak.setBounds(142, 133, 75, 15);

		txtDataCenterGPCeilLeak = new Text(grpGenerationParameters, SWT.BORDER);
		txtDataCenterGPCeilLeak.setBounds(223, 130, 58, 20);
		txtDataCenterGPCeilLeak.setText(Constants.DBL_ZEROPOINTTWO);

		lblFloorOpen = new Label(grpGenerationParameters, SWT.NONE);
		lblFloorOpen.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_FLOOR_OPEN));
		lblFloorOpen.setBounds(10, 172, 64, 15);

		txtDataCenterGPFloorOpen = new Text(grpGenerationParameters, SWT.BORDER);
		txtDataCenterGPFloorOpen.setBounds(80, 169, 58, 20);
		txtDataCenterGPFloorOpen.setText(Constants.DBL_ZEROPOINTTWO);

		lblCeilingOpen = new Label(grpGenerationParameters, SWT.NONE);
		lblCeilingOpen.setText(loader
				.getValue(LabelConstants.LAYOUT_DATA_CENTER_CEILING_OPEN));
		lblCeilingOpen.setBounds(142, 172, 78, 15);

		txtDataCenterGPCeilOpen = new Text(grpGenerationParameters, SWT.BORDER);
		txtDataCenterGPCeilOpen.setBounds(223, 169, 58, 20);
		txtDataCenterGPCeilOpen.setText(Constants.DBL_ZEROPOINTTWO);
		
		//default gen2Para Should be disabled
		enabledisableGen2Para(false);
	}

	public void enabledisableGen1Para(boolean bolEnableDisable) {
		grpGeneration1Parameters.setEnabled(bolEnableDisable);
		lblTtotalHeatrGain.setEnabled(bolEnableDisable);
		txtDataCenterAPTotalHeatGain.setEnabled(bolEnableDisable);
		btnNewButton.setEnabled(bolEnableDisable);
		lblW.setEnabled(bolEnableDisable);
	}

	public void enabledisableGen2Para(boolean bolEnableDisable) {
		{

			grpGenerationParameters.setEnabled(bolEnableDisable);
			lblExternalHeatGain.setEnabled(bolEnableDisable);
			txtDataCenterGPExtHeatGain.setEnabled(bolEnableDisable);
			label_13.setEnabled(bolEnableDisable);
			button.setEnabled(bolEnableDisable);
			lblNumberOfRackes.setEnabled(bolEnableDisable);
			txtDataCenterGPNoRacks.setEnabled(bolEnableDisable);
			btnLayout.setEnabled(bolEnableDisable);
			lblR.setEnabled(bolEnableDisable);
			txtDataCenterGPR.setEnabled(bolEnableDisable);
			lblKw.setEnabled(bolEnableDisable);
			lblFloorLeak.setEnabled(bolEnableDisable);
			txtDataCenterGPFloorLeak.setEnabled(bolEnableDisable);
			lblCeilingLeak.setEnabled(bolEnableDisable);
			txtDataCenterGPCeilLeak.setEnabled(bolEnableDisable);
			lblFloorOpen.setEnabled(bolEnableDisable);
			txtDataCenterGPFloorOpen.setEnabled(bolEnableDisable);
			lblCeilingOpen.setEnabled(bolEnableDisable);
			txtDataCenterGPCeilOpen.setEnabled(bolEnableDisable);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
