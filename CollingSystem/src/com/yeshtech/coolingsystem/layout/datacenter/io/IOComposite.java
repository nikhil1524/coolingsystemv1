package com.yeshtech.coolingsystem.layout.datacenter.io;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class IOComposite extends Composite {
	private Text textIOPrintCriterionPrintEvery1;
	private Text textIOPrintCriterionPrintEvery2;
	private Text txtIOBaseName;
	private Text txtIONumberOfSteps;
	private Text textIONotifyEvery;
	private Combo cmbIOInformationLevel;
	private Button chkIOPrintResults;
	private Button rdBtnIOPrintCriterionPrintEvery1;
	private Button rdBtnIOPrintCriterionPrintEvery2;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public IOComposite(Composite parent, int style, PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {

		setLocation(-9, -114);
		Label lblIoNotifyEvery = new Label(this, SWT.NONE);
		lblIoNotifyEvery.setBounds(10, 15, 82, 15);
		lblIoNotifyEvery.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_NOTIFY_EVERY));

		Label lblIoStepse1 = new Label(this, SWT.NONE);
		lblIoStepse1.setBounds(315, 15, 55, 15);
		lblIoStepse1.setText(loader.getValue(LabelConstants.LAYOUT_IO_STEPS));

		textIONotifyEvery = new Text(this, SWT.BORDER);
		textIONotifyEvery.setBounds(101, 11, 211, 25);
		textIONotifyEvery.setText(Constants.INT_ONE);

		Group grpIOInformationLevel = new Group(this, SWT.NONE);
		grpIOInformationLevel.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_INFORMATION_LEVEL));
		grpIOInformationLevel.setBounds(10, 42, 323, 65);

		cmbIOInformationLevel = new Combo(grpIOInformationLevel, SWT.NONE);
		cmbIOInformationLevel.setItems(new String[] {"0: only critical errors printed to screen", "1: + flow network and steady-state framework conversion data", "2: + data center flow network optimization output", "3: + additional warning and information messages"});
		cmbIOInformationLevel.setBounds(10, 20, 291, 23);
		cmbIOInformationLevel.select(0);

		chkIOPrintResults = new Button(this, SWT.CHECK);
		chkIOPrintResults.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_PRINT_RESULTS));
		chkIOPrintResults.setBounds(339, 67, 192, 16);

		Group grpIOPrintCriterion = new Group(this, SWT.NONE);
		grpIOPrintCriterion.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_PRINT_CRITERION));
		grpIOPrintCriterion.setBounds(10, 114, 323, 82);

		rdBtnIOPrintCriterionPrintEvery1 = new Button(grpIOPrintCriterion,
				SWT.RADIO);
		rdBtnIOPrintCriterionPrintEvery1.setSelection(true);
		rdBtnIOPrintCriterionPrintEvery1.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_PRINT_EVERY));
		rdBtnIOPrintCriterionPrintEvery1.setBounds(10, 22, 90, 16);

		rdBtnIOPrintCriterionPrintEvery2 = new Button(grpIOPrintCriterion,
				SWT.RADIO);
		rdBtnIOPrintCriterionPrintEvery2.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_PRINT_EVERY));
		rdBtnIOPrintCriterionPrintEvery2.setBounds(10, 54, 90, 16);

		textIOPrintCriterionPrintEvery1 = new Text(grpIOPrintCriterion,
				SWT.BORDER);
		textIOPrintCriterionPrintEvery1.setBounds(106, 17, 150, 27);
		textIOPrintCriterionPrintEvery1.setText(Constants.INT_ZERO);

		textIOPrintCriterionPrintEvery2 = new Text(grpIOPrintCriterion,
				SWT.BORDER);
		textIOPrintCriterionPrintEvery2.setBounds(106, 48, 150, 27);
		textIOPrintCriterionPrintEvery2.setText(Constants.DBL_ZERO);

		Label lblIoStepse2 = new Label(grpIOPrintCriterion, SWT.NONE);
		lblIoStepse2.setText(loader.getValue(LabelConstants.LAYOUT_IO_STEPS));
		lblIoStepse2.setBounds(262, 23, 41, 15);

		Label lblIoS = new Label(grpIOPrintCriterion, SWT.NONE);
		lblIoS.setText(loader.getValue(LabelConstants.LAYOUT_IO_S));
		lblIoS.setBounds(262, 57, 17, 15);

		Label lblIoBaseName = new Label(this, SWT.NONE);
		lblIoBaseName.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_BASE_NAME));
		lblIoBaseName.setBounds(10, 213, 134, 15);

		txtIOBaseName = new Text(this, SWT.BORDER);
		txtIOBaseName.setBounds(150, 205, 183, 31);
		txtIOBaseName.setText("out");

		Label lblIoNumberOfSteps = new Label(this, SWT.WRAP);
		lblIoNumberOfSteps.setText(loader
				.getValue(LabelConstants.LAYOUT_IO_NUMBER_OF_STEPS));
		lblIoNumberOfSteps.setBounds(10, 245, 161, 31);

		txtIONumberOfSteps = new Text(this, SWT.BORDER);
		txtIONumberOfSteps.setBounds(170, 246, 163, 29);
		txtIONumberOfSteps.setText(Constants.INT_ZERO);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
