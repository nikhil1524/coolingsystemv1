package com.yeshtech.coolingsystem.layout.external;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class ExternalComposite extends Composite {

	private Text txtExtExtAirBulbTemp;
	private Text txtExtEAHRelHum;
	private Text txtExtEAHDuePoint;
	private Text txtExtEAHWetBulb;
	private Text txtExtEAHExtWatTemp;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ExternalComposite(Composite parent, int style,
			PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {

		Label lblExternal = new Label(this, SWT.NONE);
		lblExternal.setText(loader
				.getValue(LabelConstants.LAYOUT_EXTERNAL_TEMPERATURE));
		lblExternal.setBounds(53, 32, 203, 15);

		txtExtExtAirBulbTemp = new Text(this, SWT.BORDER);
		txtExtExtAirBulbTemp.setBounds(281, 29, 75, 20);
		txtExtExtAirBulbTemp.setText(Constants.INT_TWENTYFIVE);

		Label lblC = new Label(this, SWT.NONE);
		lblC.setText(loader.getValue(LabelConstants.LAYOUT_EXTERNAL_C));
		lblC.setBounds(362, 27, 11, 15);

		Button btnExtTimeCurve = new Button(this, SWT.NONE);
		btnExtTimeCurve.setText(loader
				.getValue(LabelConstants.LAYOUT_EXTERNAL_TIMECURVE));
		btnExtTimeCurve.setBounds(396, 27, 75, 25);

		Group grpExternalAir = new Group(this, SWT.NONE);
		grpExternalAir.setText(loader
				.getValue(LabelConstants.LAYOUT_EXTERNAL_AIR_HUMIDITY));
		grpExternalAir.setBounds(41, 91, 363, 140);

		Button btnRelativeHumidity = new Button(grpExternalAir, SWT.RADIO);
		btnRelativeHumidity.setSelection(true);
		btnRelativeHumidity.setText(loader
				.getValue(LabelConstants.LAYOUT_EXTERNAL_RELATIVE_HUMIDITY));
		btnRelativeHumidity.setBounds(10, 30, 136, 16);

		Button btnDuePoint = new Button(grpExternalAir, SWT.RADIO);
		btnDuePoint.setText(loader
				.getValue(LabelConstants.LAYOUT_EXTERNAL_DUE_POINT));
		btnDuePoint.setBounds(10, 64, 90, 16);

		Button btnWetBulb = new Button(grpExternalAir, SWT.RADIO);
		btnWetBulb.setText(loader
				.getValue(LabelConstants.LAYOUT_EXTERNAL_WET_BULB));
		btnWetBulb.setBounds(10, 98, 90, 16);

		txtExtEAHRelHum = new Text(grpExternalAir, SWT.BORDER);
		txtExtEAHRelHum.setBounds(152, 28, 75, 20);
		txtExtEAHRelHum.setText(Constants.INT_FIFTY);

		Label label_8 = new Label(grpExternalAir, SWT.NONE);
		label_8.setText("%");
		label_8.setBounds(251, 31, 17, 20);

		txtExtEAHDuePoint = new Text(grpExternalAir, SWT.BORDER);
		txtExtEAHDuePoint.setBounds(152, 62, 75, 20);
		txtExtEAHDuePoint.setText(Constants.INT_FIFTEEN);

		Label label_15 = new Label(grpExternalAir, SWT.NONE);
		label_15.setText(loader.getValue(LabelConstants.LAYOUT_EXTERNAL_C));
		label_15.setBounds(251, 65, 17, 20);

		txtExtEAHWetBulb = new Text(grpExternalAir, SWT.BORDER);
		txtExtEAHWetBulb.setBounds(152, 96, 75, 20);
		txtExtEAHWetBulb.setText(Constants.INT_TWENTY);

		Label label_16 = new Label(grpExternalAir, SWT.NONE);
		label_16.setText(loader.getValue(LabelConstants.LAYOUT_EXTERNAL_C));
		label_16.setBounds(251, 99, 17, 20);

		Label lblExternalWaterTemperature = new Label(this, SWT.NONE);
		lblExternalWaterTemperature.setText("External water temperature :");
		lblExternalWaterTemperature.setBounds(53, 251, 203, 15);

		txtExtEAHExtWatTemp = new Text(this, SWT.BORDER);
		txtExtEAHExtWatTemp.setBounds(281, 248, 75, 20);
		txtExtEAHExtWatTemp.setText(Constants.INT_TWENTYFIVE);
		Label label_18 = new Label(this, SWT.NONE);
		label_18.setText(loader.getValue(LabelConstants.LAYOUT_EXTERNAL_C));
		label_18.setBounds(373, 251, 11, 15);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
