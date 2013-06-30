package com.yeshtech.coolingsystem.layout.datacenter.solution;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class SolutionComposite extends Composite {

	private Text txtSolnGSGlobalRelPara;
	private Text txtSolnGSGlobalSolnTol;
	private Text txtSolnGSMaxGlobIter;
	private Text txtSolnFSFlowRelPara;
	private Text txtSolnFSFlowSolnTol;
	private Text txtSolnFSMaxNumFlowIter;
	private Text txtSolnFSInitFlowRate;
	private Text txtSolnFSZeroFloorFlowVal;
	private Text txtSolnFSMinFlowRate;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public SolutionComposite(Composite parent, int style,
			PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {

		Group grpSolnSolnMethod = new Group(this, SWT.NONE);
		grpSolnSolnMethod.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_SOLUTION_METHOD));
		grpSolnSolnMethod.setBounds(10, 10, 158, 111);

		Button rdoSolnSMImp = new Button(grpSolnSolnMethod, SWT.RADIO);
		rdoSolnSMImp.setSelection(true);
		rdoSolnSMImp.setBounds(10, 29, 90, 16);
		rdoSolnSMImp.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_IMPLISIT));

		Button rdoSolnSMExp = new Button(grpSolnSolnMethod, SWT.RADIO);
		rdoSolnSMExp.setBounds(10, 64, 90, 16);
		rdoSolnSMExp.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_EXPLISIT));

		Group grpSolnGlobalSoln = new Group(this, SWT.NONE);
		grpSolnGlobalSoln.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_GLOBAL_SOLUTION));
		grpSolnGlobalSoln.setBounds(188, 10, 355, 111);

		Label lblGlobalRelacsation = new Label(grpSolnGlobalSoln, SWT.NONE);
		lblGlobalRelacsation.setBounds(10, 19, 154, 15);
		lblGlobalRelacsation
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_GLOBAL_RELAXATION_PARAMETER));

		Label lblGlobalResolution = new Label(grpSolnGlobalSoln, SWT.NONE);
		lblGlobalResolution
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_GLOBAL_SOLUTION_TOLERANCE));
		lblGlobalResolution.setBounds(10, 52, 154, 15);

		Label lblMaximumNumberOf = new Label(grpSolnGlobalSoln, SWT.NONE);
		lblMaximumNumberOf
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_MAX_NO_OF_GLOBAL_ITERATION));
		lblMaximumNumberOf.setBounds(10, 81, 205, 15);

		txtSolnGSGlobalRelPara = new Text(grpSolnGlobalSoln, SWT.BORDER);
		txtSolnGSGlobalRelPara.setBounds(221, 16, 75, 20);
		txtSolnGSGlobalRelPara.setText(Constants.SOLUTION_GLOBAL_RELAXATION_PARAMETER);

		txtSolnGSGlobalSolnTol = new Text(grpSolnGlobalSoln, SWT.BORDER);
		txtSolnGSGlobalSolnTol.setBounds(221, 49, 75, 20);
		txtSolnGSGlobalSolnTol.setText(Constants.SOLUTION_GLOBAL_SOLUTION_TOLERANCE);

		txtSolnGSMaxGlobIter = new Text(grpSolnGlobalSoln, SWT.BORDER);
		txtSolnGSMaxGlobIter.setBounds(221, 78, 75, 20);
		txtSolnGSMaxGlobIter.setText(Constants.SOLUTION_MAX_NO_GLOBAL_ITERATIONS);

		Group grpSolnFlowSoln = new Group(this, SWT.NONE);
		grpSolnFlowSoln.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_FLOW_SOLUTION));
		grpSolnFlowSoln.setBounds(10, 126, 533, 162);

		txtSolnFSFlowRelPara = new Text(grpSolnFlowSoln, SWT.BORDER);
		txtSolnFSFlowRelPara.setBounds(164, 17, 76, 21);
		txtSolnFSFlowRelPara.setText(Constants.SOLUTION_FLOW_RELAXATION_PARAMETER);
		
		
		Label lblFlowRelaxationParameter = new Label(grpSolnFlowSoln, SWT.NONE);
		lblFlowRelaxationParameter
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_FLOW_RELAXATION_PARAMETER));
		lblFlowRelaxationParameter.setBounds(10, 20, 154, 15);

		txtSolnFSFlowSolnTol = new Text(grpSolnFlowSoln, SWT.BORDER);
		txtSolnFSFlowSolnTol.setBounds(164, 56, 75, 20);
		txtSolnFSFlowSolnTol.setText(Constants.SOLUTION_FLOW_SOLUTION_TOLERANCE);
		
		Label lblFlowSolutionTolerance = new Label(grpSolnFlowSoln, SWT.NONE);
		lblFlowSolutionTolerance
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_FLOW_SOLUTION_TOLERANCE));
		lblFlowSolutionTolerance.setBounds(10, 59, 154, 15);

		txtSolnFSMaxNumFlowIter = new Text(grpSolnFlowSoln, SWT.BORDER);
		txtSolnFSMaxNumFlowIter.setBounds(164, 102, 75, 20);
		txtSolnFSMaxNumFlowIter.setText(Constants.SOLUTION_MAX_NO_FLOW_ITERATIONS);
		
		Label lblMaximumNumberOf_1 = new Label(grpSolnFlowSoln, SWT.NONE);
		lblMaximumNumberOf_1.setAlignment(SWT.CENTER);
		lblMaximumNumberOf_1
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_MAX_NO_OF_FLOW_ITERATION));
		lblMaximumNumberOf_1.setBounds(10, 105, 145, 40);

		Label lblInitialFlowRate = new Label(grpSolnFlowSoln, SWT.NONE);
		lblInitialFlowRate.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_INITIAL_FLOW_RATE));
		lblInitialFlowRate.setBounds(257, 20, 137, 15);

		txtSolnFSInitFlowRate = new Text(grpSolnFlowSoln, SWT.BORDER);
		txtSolnFSInitFlowRate.setBounds(400, 17, 75, 20);
		txtSolnFSInitFlowRate.setText(Constants.SOLUTION_INITIAL_FLOW_RATE);
		
		Label lblZeroFloorFlow = new Label(grpSolnFlowSoln, SWT.NONE);
		lblZeroFloorFlow
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_ZERO_FLOOR_FLOW_VALUE));
		lblZeroFloorFlow.setBounds(257, 59, 137, 15);

		txtSolnFSZeroFloorFlowVal = new Text(grpSolnFlowSoln, SWT.BORDER);
		txtSolnFSZeroFloorFlowVal.setBounds(400, 56, 75, 20);
		txtSolnFSZeroFloorFlowVal.setText(Constants.SOLUTION_ZERO_FLOOR_FLOW_VALUE);
		
		
		Label lblMinimumAllowableFlow = new Label(grpSolnFlowSoln, SWT.NONE);
		lblMinimumAllowableFlow.setAlignment(SWT.CENTER);
		lblMinimumAllowableFlow
				.setText(loader
						.getValue(LabelConstants.LAYOUT_SOLUTION_MIN_ALLOWABLE_FLOW_RATE));
		lblMinimumAllowableFlow.setBounds(257, 102, 142, 40);

		txtSolnFSMinFlowRate = new Text(grpSolnFlowSoln, SWT.BORDER);
		txtSolnFSMinFlowRate.setBounds(400, 102, 75, 20);
		txtSolnFSMinFlowRate.setText(Constants.SOLUTION_MIN_ALLOWABLE_FLOW_RATE);
		
		Label lblNewLabel = new Label(grpSolnFlowSoln, SWT.NONE);
		lblNewLabel.setBounds(482, 17, 41, 21);
		lblNewLabel.setText(loader
				.getValue(LabelConstants.LAYOUT_SOLUTION_M_3_S));

		Label label = new Label(grpSolnFlowSoln, SWT.NONE);
		label.setText(loader.getValue(LabelConstants.LAYOUT_SOLUTION_M_3_S));
		label.setBounds(482, 56, 41, 21);

		Label label_1 = new Label(grpSolnFlowSoln, SWT.NONE);
		label_1.setText(loader.getValue(LabelConstants.LAYOUT_SOLUTION_M_3_S));
		label_1.setBounds(482, 102, 41, 21);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
