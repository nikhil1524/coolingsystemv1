package com.yeshtech.coolingsystem.layout.constants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class ConstantsComposite extends Composite {

	private Text txtConstWPSpecHeat;
	private Text txtConstWPDensity;
	private Text txtConstWPEnthWatVap;
	private Text txtConstAPSpecHeat;
	private Text txtConstAPDensity;
	private Text txtConstAPEnthWatVap;
	private Text txtConstGraviAcce;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ConstantsComposite(Composite parent, int style,
			PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {
		Group grpConstWaterProperties = new Group(this, SWT.NONE);
		grpConstWaterProperties.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_WATER_PROPERTIES));
		grpConstWaterProperties.setBounds(10, 10, 267, 149);

		Label lblSpecific = new Label(grpConstWaterProperties, SWT.NONE);
		lblSpecific.setBounds(10, 24, 93, 15);
		lblSpecific.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_SPECIFIC_HEAT));

		Label lblDensity = new Label(grpConstWaterProperties, SWT.NONE);
		lblDensity.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_DENSITY));
		lblDensity.setBounds(10, 56, 93, 15);

		Label lblEnthal = new Label(grpConstWaterProperties, SWT.NONE);
		lblEnthal.setAlignment(SWT.CENTER);
		lblEnthal.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_FORMATION_OF_WATER));
		lblEnthal.setBounds(10, 87, 107, 52);

		txtConstWPSpecHeat = new Text(grpConstWaterProperties, SWT.BORDER);
		txtConstWPSpecHeat.setBounds(123, 24, 75, 20);
		txtConstWPSpecHeat.setText(Constants.CONSTANTS_WATER_PROP_SPEC_HEAT);
		
		txtConstWPDensity = new Text(grpConstWaterProperties, SWT.BORDER);
		txtConstWPDensity.setBounds(123, 53, 75, 20);
		txtConstWPDensity.setText(Constants.CONSTANTS_WATER_PROP_DENSITY);
		
		txtConstWPEnthWatVap = new Text(grpConstWaterProperties, SWT.BORDER);
		txtConstWPEnthWatVap.setBounds(123, 87, 75, 20);
		txtConstWPEnthWatVap.setText(Constants.CONSTANTS_WATER_PROP_ENTHALPY);
		
		Label lblJ = new Label(grpConstWaterProperties, SWT.NONE);
		lblJ.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_J_KG_K));
		lblJ.setBounds(205, 24, 52, 15);

		Label lblKg = new Label(grpConstWaterProperties, SWT.NONE);
		lblKg.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_KG_M_3));
		lblKg.setBounds(204, 56, 52, 15);

		Label lblKgm = new Label(grpConstWaterProperties, SWT.NONE);
		lblKgm.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_J_KG));
		lblKgm.setBounds(204, 87, 52, 15);

		Group grpConstAirProperties = new Group(this, SWT.NONE);
		grpConstAirProperties.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_AIR_PROPERTIES));
		grpConstAirProperties.setBounds(283, 10, 267, 149);

		Label label_2 = new Label(grpConstAirProperties, SWT.NONE);
		label_2.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_SPECIFIC_HEAT));
		label_2.setBounds(10, 24, 93, 15);

		Label label_3 = new Label(grpConstAirProperties, SWT.NONE);
		label_3.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_DENSITY));
		label_3.setBounds(10, 55, 93, 15);

		txtConstAPSpecHeat = new Text(grpConstAirProperties, SWT.BORDER);
		txtConstAPSpecHeat.setBounds(122, 24, 75, 20);
		txtConstAPSpecHeat.setText(Constants.CONSTANTS_AIR_PROP_SPEC_HEAT);
		
		txtConstAPDensity = new Text(grpConstAirProperties, SWT.BORDER);
		txtConstAPDensity.setBounds(122, 53, 75, 20);
		txtConstAPDensity.setText(Constants.CONSTANTS_AIR_PROP_DENSITY);
		
		txtConstAPEnthWatVap = new Text(grpConstAirProperties, SWT.BORDER);
		txtConstAPEnthWatVap.setBounds(122, 87, 75, 20);
		txtConstAPEnthWatVap.setText(Constants.CONSTANTS_AIR_PROP_ENTHALPY);
		
		Label lblIdealGas = new Label(grpConstAirProperties, SWT.NONE);
		lblIdealGas.setText(loader
				.getValue(LabelConstants.LAYOUT_CONSTANTS_IDEAL_GAS_CONSTANT));
		lblIdealGas.setAlignment(SWT.CENTER);
		lblIdealGas.setBounds(10, 84, 83, 62);

		Label label_5 = new Label(grpConstAirProperties, SWT.NONE);
		label_5.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_J_KG_K));
		label_5.setBounds(205, 24, 52, 15);

		Label label_6 = new Label(grpConstAirProperties, SWT.NONE);
		label_6.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_J_KG_K));
		label_6.setBounds(204, 87, 52, 15);

		Label label_7 = new Label(grpConstAirProperties, SWT.NONE);
		label_7.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_KG_M_3));
		label_7.setBounds(204, 56, 52, 15);

		Label lblGraviatationalAcceleration = new Label(this, SWT.NONE);
		lblGraviatationalAcceleration
				.setText(loader
						.getValue(LabelConstants.LAYOUT_CONSTANTS_GRAVITATIONAL_ACCELERATION)
						+ "\r\n");
		lblGraviatationalAcceleration.setAlignment(SWT.CENTER);
		lblGraviatationalAcceleration.setBounds(10, 173, 171, 26);

		txtConstGraviAcce = new Text(this, SWT.BORDER);
		txtConstGraviAcce.setBounds(187, 170, 75, 20);
		txtConstGraviAcce.setText(Constants.CONSTANTS_GRAVITATIONAL_ACC);
		

		Label lblKgm_1 = new Label(this, SWT.NONE);
		lblKgm_1.setText(loader.getValue(LabelConstants.LAYOUT_CONSTANTS_M_S_2));
		lblKgm_1.setBounds(283, 173, 52, 15);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
