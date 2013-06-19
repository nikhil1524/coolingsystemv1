package com.yeshtech.coolingsystem.layout.run;

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

public class RunComposite extends Composite {
	private Text txtRunTransientParamFinalStep;
	private Text txtRunTransientParamFinalTime;
	private Text txtRunTransientParamTimeStepValue;
	private Text txtRunTransientParamRestartFileName;
	private Button chkBoxRunOverriteComponent;
	private Button rdBtnRunTransientParamFinalTime;
	private Button rdBtnRuSimeulationTypeSteady;
	private Button rdBtnRuSimeulationTypeTransient;
	private Button rdBtnRunTransientParamFinalStep;
	private Label lblRunTransientParamFinalTime;
	private Label lblRunTransientParamTimeStepValueunits;
	private Label lblRunTransientParamTimeStepValue ;
	private Label lblRunTransientParamRestartFileName;
	private Group grpRunSimulationType;
	private Group grpRunTransientParameter;
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public RunComposite(Composite parent, int style, PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {
		this.setBounds(0, 0, 300, 400);
		grpRunSimulationType = new Group(this, SWT.NONE);
		grpRunSimulationType.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_SIMULATION_TYPE));
		grpRunSimulationType.setBounds(21, 20, 117, 98);

		rdBtnRuSimeulationTypeSteady = new Button(grpRunSimulationType,
				SWT.RADIO);
		rdBtnRuSimeulationTypeSteady.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				enableDisableGrpRunTransPara(false);
			}
		});
		rdBtnRuSimeulationTypeSteady.setSelection(true);
		rdBtnRuSimeulationTypeSteady.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_STEADY));
		rdBtnRuSimeulationTypeSteady.setBounds(10, 27, 90, 16);

		rdBtnRuSimeulationTypeTransient = new Button(grpRunSimulationType,
				SWT.RADIO);
		rdBtnRuSimeulationTypeTransient.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				enableDisableGrpRunTransPara(true);
			}
		});
		rdBtnRuSimeulationTypeTransient.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_TRANSIENT));
		rdBtnRuSimeulationTypeTransient.setBounds(10, 61, 90, 16);

		grpRunTransientParameter = new Group(this, SWT.NONE);
		grpRunTransientParameter.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_TRANSIENT_PARAMETER));
		grpRunTransientParameter.setBounds(172, 13, 345, 189);


		rdBtnRunTransientParamFinalStep = new Button(grpRunTransientParameter,
				SWT.RADIO);
		rdBtnRunTransientParamFinalStep.setSelection(true);
		rdBtnRunTransientParamFinalStep.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_FINAL_STEP));
		rdBtnRunTransientParamFinalStep.setBounds(10, 26, 90, 16);

		txtRunTransientParamFinalStep = new Text(grpRunTransientParameter,
				SWT.BORDER);
		txtRunTransientParamFinalStep.setBounds(127, 21, 181, 21);
		txtRunTransientParamFinalStep.setText(Constants.INT_ZERO);

		rdBtnRunTransientParamFinalTime = new Button(grpRunTransientParameter,
				SWT.RADIO);
		rdBtnRunTransientParamFinalTime.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_FINAL_TIME));
		rdBtnRunTransientParamFinalTime.setBounds(10, 55, 90, 16);

		txtRunTransientParamFinalTime = new Text(grpRunTransientParameter,
				SWT.BORDER);
		txtRunTransientParamFinalTime.setBounds(127, 48, 181, 21);
		txtRunTransientParamFinalTime.setText(Constants.DBL_ZERO);

		lblRunTransientParamTimeStepValue = new Label(
				grpRunTransientParameter, SWT.NONE);
		lblRunTransientParamTimeStepValue.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_TIME_STEP_VALUE));
		lblRunTransientParamTimeStepValue.setBounds(21, 106, 90, 15);

		lblRunTransientParamRestartFileName = new Label(
				grpRunTransientParameter, SWT.NONE);
		lblRunTransientParamRestartFileName.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_RESTART_FILE_NAME));
		lblRunTransientParamRestartFileName.setBounds(21, 139, 90, 15);

		txtRunTransientParamTimeStepValue = new Text(grpRunTransientParameter,
				SWT.BORDER);
		txtRunTransientParamTimeStepValue.setBounds(127, 103, 181, 21);
		txtRunTransientParamTimeStepValue.setText(Constants.DBL_ZERO);

		txtRunTransientParamRestartFileName = new Text(
				grpRunTransientParameter, SWT.BORDER);
		txtRunTransientParamRestartFileName.setBounds(127, 136, 181, 21);
		txtRunTransientParamRestartFileName.setText(Constants.OUT_S_TXT);
		
		lblRunTransientParamFinalTime = new Label(grpRunTransientParameter, SWT.NONE);
		lblRunTransientParamFinalTime.setText(Constants.UNIT_S);
		lblRunTransientParamFinalTime.setBounds(314, 51, 21, 15);
		
		lblRunTransientParamTimeStepValueunits = new Label(grpRunTransientParameter, SWT.NONE);
		lblRunTransientParamTimeStepValueunits.setText(Constants.UNIT_S);
		lblRunTransientParamTimeStepValueunits.setBounds(314, 106, 21, 15);

		chkBoxRunOverriteComponent = new Button(this, SWT.CHECK);
		chkBoxRunOverriteComponent.setText(loader
				.getValue(LabelConstants.LAYOUT_RUN_OVERRITE_COMPONENT));
		chkBoxRunOverriteComponent.setBounds(21, 235, 467, 16);
		
		//Disable grpRunTransientParameter
		enableDisableGrpRunTransPara(false);
	}

	
	private void enableDisableGrpRunTransPara(boolean bolEnableDisable){
		grpRunTransientParameter.setEnabled(bolEnableDisable);
		rdBtnRunTransientParamFinalStep.setEnabled(bolEnableDisable);
		rdBtnRunTransientParamFinalTime.setEnabled(bolEnableDisable);
		txtRunTransientParamFinalStep.setEnabled(bolEnableDisable);
		txtRunTransientParamFinalTime.setEnabled(bolEnableDisable);
		lblRunTransientParamFinalTime.setEnabled(bolEnableDisable);
		lblRunTransientParamTimeStepValue.setEnabled(bolEnableDisable);
		txtRunTransientParamTimeStepValue.setEnabled(bolEnableDisable);
		lblRunTransientParamTimeStepValueunits.setEnabled(bolEnableDisable);
		lblRunTransientParamRestartFileName.setEnabled(bolEnableDisable);
		txtRunTransientParamRestartFileName.setEnabled(bolEnableDisable);
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
