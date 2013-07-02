package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.yeshtech.coolingsystem.util.Constants;
import com.yeshtech.coolingsystem.util.DisplayMonitor;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.wb.swt.SWTResourceManager;

public class RackPropertiesWindow implements SelectionListener {

	protected Shell shell;
	private Text txtRackName;
	private Text txtHeatOutput;
	private Text txtThermalResistance;
	private Text txtXDimension;
	private Text txtYDimension;
	private Text txtZDimension;
	private Text txtNumberOfServer;
	private Composite innerFrontComp;
	private Combo combo;
	private Button btnNewButton_1;
	private Button btnNewButton_2;
	private Button btnNewButton_3;
	private Group grpServersInRack;
	private ScrolledComposite frontComp;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RackPropertiesWindow window = new RackPropertiesWindow();
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
		shell.setImage(SWTResourceManager.getImage(RackPropertiesWindow.class,
				"/icon/App.ico"));
		shell.setSize(570, 475);
		shell.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW));

		Label lblRackName = new Label(shell, SWT.NONE);
		lblRackName.setBounds(10, 13, 74, 15);
		lblRackName
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_NAME));

		txtRackName = new Text(shell, SWT.BORDER);
		txtRackName.setBounds(103, 10, 135, 21);

		Group grpNonServerEquipment = new Group(shell, SWT.NONE);
		grpNonServerEquipment
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NON_SERVER_EQUIPMENT));
		grpNonServerEquipment.setBounds(10, 35, 296, 95);

		Label lblNewLabel_1 = new Label(grpNonServerEquipment, SWT.NONE);
		lblNewLabel_1.setBounds(10, 27, 75, 15);
		lblNewLabel_1
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NON_SERVER_EQUIPMENT_HEAT_OUTPUT));

		Label lblNewLabel_2 = new Label(grpNonServerEquipment, SWT.NONE);
		lblNewLabel_2.setBounds(10, 62, 117, 15);
		lblNewLabel_2
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NON_SERVER_EQUIPMENT_THERMAL_RESISTANCE));

		txtHeatOutput = new Text(grpNonServerEquipment, SWT.BORDER);
		txtHeatOutput.setText(Constants.INT_ZERO);
		txtHeatOutput.setBounds(92, 23, 91, 21);

		txtThermalResistance = new Text(grpNonServerEquipment, SWT.BORDER);
		txtThermalResistance.setText(Constants.DBL_ZEROPOINTONE);
		txtThermalResistance.setBounds(133, 58, 118, 21);

		Button btnNewButton = new Button(grpNonServerEquipment, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		btnNewButton.setBounds(213, 19, 75, 25);
		btnNewButton
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NON_SERVER_EQUIPMENT_TIMECURVE));

		Label lblW = new Label(grpNonServerEquipment, SWT.NONE);
		lblW.setBounds(189, 25, 18, 15);
		lblW.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NON_SERVER_EQUIPMENT_W));

		Label lblKW = new Label(grpNonServerEquipment, SWT.NONE);
		lblKW.setBounds(257, 60, 31, 15);
		lblKW.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NON_SERVER_EQUIPMENT_K_W));

		Group grpRackDimension = new Group(shell, SWT.NONE);
		grpRackDimension
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION));
		grpRackDimension.setBounds(313, 28, 230, 103);

		Label lblXdimension = new Label(grpRackDimension, SWT.NONE);
		lblXdimension.setBounds(10, 22, 72, 15);
		lblXdimension
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION_X_DIMENSION));

		Label lblYdimension = new Label(grpRackDimension, SWT.NONE);
		lblYdimension.setBounds(10, 46, 72, 15);
		lblYdimension
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION_Y_DIMENSION));

		Label lblZdimension = new Label(grpRackDimension, SWT.NONE);
		lblZdimension.setBounds(10, 70, 72, 15);
		lblZdimension
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION_Z_DIMENSION));

		txtXDimension = new Text(grpRackDimension, SWT.BORDER);
		txtXDimension.setText(Constants.DBL_ZERO_POINT_SIX_ZERO_NINE_SIX);
		txtXDimension.setBounds(101, 18, 97, 21);

		txtYDimension = new Text(grpRackDimension, SWT.BORDER);
		txtYDimension.setText(Constants.DBL_ONE_POINT_TWO_ONE_NINE);
		txtYDimension.setBounds(101, 43, 97, 21);

		txtZDimension = new Text(grpRackDimension, SWT.BORDER);
		txtZDimension.setText(Constants.DBL_ONE_POINT_NINE_FIVE_SIX);
		txtZDimension.setBounds(101, 69, 97, 21);

		Label lblM1 = new Label(grpRackDimension, SWT.NONE);
		lblM1.setBounds(204, 21, 19, 15);
		lblM1.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION_M));

		Label lblM2 = new Label(grpRackDimension, SWT.NONE);
		lblM2.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION_M));
		lblM2.setBounds(204, 44, 19, 15);

		Label lblM3 = new Label(grpRackDimension, SWT.NONE);
		lblM3.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_RACK_DIMENSION_M));
		lblM3.setBounds(204, 70, 19, 15);

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(10, 142, 108, 15);
		lblNewLabel_3
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_NUMBER_OF_SERVER));

		txtNumberOfServer = new Text(shell, SWT.BORDER);
		txtNumberOfServer.setText(Constants.INT_SIX);
		txtNumberOfServer.setBounds(121, 140, 51, 21);

		Composite comp_grpSerinRack = new Composite(shell, SWT.NONE);
		comp_grpSerinRack.setBounds(10, 180, 533, 213);

		grpServersInRack = new Group(comp_grpSerinRack, SWT.NONE);
		grpServersInRack
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_SERVERS_IN_RACK));
		grpServersInRack.setBounds(0, -14, 533, 227);
		grpServersInRack.setVisible(false);
		frontComp = new ScrolledComposite(grpServersInRack, SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		frontComp.setBounds(0, 25, 533, 192);
		frontComp.setExpandHorizontal(true);
		frontComp.setExpandVertical(true);

		Button btnCreateTable = new Button(shell, SWT.NONE);
		btnCreateTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				innerFrontComp = new Composite(frontComp, SWT.NONE);
				innerFrontComp.setBounds(0, 0, 529, 159);

				if (txtNumberOfServer.getText() != null
						&& !"".equals(txtNumberOfServer.getText())) {
					int numberOfServer = Integer.parseInt(txtNumberOfServer
							.getText());
					int cordinates = 0;
					for (int i = 1; i <= numberOfServer; i++) {
						Combo combo_1 = new Combo(innerFrontComp, SWT.NONE);
						combo_1.setBounds(10, 21 + cordinates, 142, 23);
						Button button = new Button(innerFrontComp, SWT.NONE);
						button.setText(loader
								.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE));
						button.setBounds(164, 21 + cordinates, 100, 25);

						Button button_1 = new Button(innerFrontComp, SWT.NONE);
						button_1.setText(loader
								.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE));
						button_1.setBounds(271, 21 + cordinates, 125, 25);

						Button button_2 = new Button(innerFrontComp, SWT.NONE);
						button_2.setText(loader
								.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE));
						button_2.setBounds(402, 21 + cordinates, 91, 25);
						cordinates = cordinates + 32;
					}

					frontComp.setContent(innerFrontComp);
					frontComp.setMinSize(innerFrontComp.computeSize(
							SWT.DEFAULT, SWT.DEFAULT));
					grpServersInRack.setVisible(true);

				}
			}
		});

		btnCreateTable.setBounds(182, 136, 75, 25);
		btnCreateTable
				.setText(loader
						.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_CREATE_TABLE));

		/*
		 * Combo combo_1 = new Combo(frontComp, SWT.NONE); combo_1.setBounds(10,
		 * 21 , 142, 23); Button button = new Button(frontComp, SWT.NONE);
		 * button.setText(loader.getValue(LabelConstants.
		 * LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE)); button.setBounds(164,
		 * 21, 100, 25);
		 * 
		 * Button button_1 = new Button(frontComp, SWT.NONE);
		 * button_1.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE
		 * )); button_1.setBounds(271, 21, 125, 25);
		 * 
		 * Button button_2 = new Button(frontComp, SWT.NONE);
		 * button_2.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE));
		 * button_2.setBounds(402, 21, 91, 25);
		 * 
		 * Combo combo_2 = new Combo(frontComp, SWT.NONE); combo_2.setBounds(10,
		 * 56, 142, 23);
		 * 
		 * Button button_3 = new Button(frontComp, SWT.NONE);
		 * button_3.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE
		 * )); button_3.setBounds(164, 53, 100, 25);
		 * 
		 * Button button_4 = new Button(frontComp, SWT.NONE);
		 * button_4.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE
		 * )); button_4.setBounds(271, 53, 125, 25);
		 * 
		 * Button button_5 = new Button(frontComp, SWT.NONE);
		 * button_5.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE));
		 * button_5.setBounds(402, 53, 91, 25);
		 * 
		 * Combo combo_3 = new Combo(frontComp, SWT.NONE); combo_3.setBounds(10,
		 * 89, 142, 23);
		 * 
		 * Button button_6 = new Button(frontComp, SWT.NONE);
		 * button_6.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE
		 * )); button_6.setBounds(164, 86, 100, 25);
		 * 
		 * Button button_7 = new Button(frontComp, SWT.NONE);
		 * button_7.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE
		 * )); button_7.setBounds(271, 86, 125, 25);
		 * 
		 * Button button_8 = new Button(frontComp, SWT.NONE);
		 * button_8.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE));
		 * button_8.setBounds(402, 86, 91, 25);
		 * 
		 * Combo combo_4 = new Combo(frontComp, SWT.NONE); combo_4.setBounds(10,
		 * 121, 142, 23);
		 * 
		 * Button button_9 = new Button(frontComp, SWT.NONE);
		 * button_9.setText(loader
		 * .getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE
		 * )); button_9.setBounds(164, 121, 100, 25);
		 * 
		 * Button button_10 = new Button(frontComp, SWT.NONE);
		 * button_10.setText(loader.getValue(LabelConstants.
		 * LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE));
		 * button_10.setBounds(271, 121, 125, 25);
		 * 
		 * Button button_11 = new Button(frontComp, SWT.NONE);
		 * button_11.setText(
		 * loader.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE
		 * )); button_11.setBounds(402, 121, 91, 25);
		 * 
		 * 
		 * Combo combo_5 = new Combo(frontComp, SWT.NONE); combo_5.setBounds(10,
		 * 156, 142, 23);
		 * 
		 * Button button_12 = new Button(frontComp, SWT.NONE);
		 * button_12.setText(loader.getValue(LabelConstants.
		 * LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE));
		 * button_12.setBounds(164, 156, 100, 25);
		 * 
		 * Button button_13 = new Button(frontComp, SWT.NONE);
		 * button_13.setText(loader.getValue(LabelConstants.
		 * LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE));
		 * button_13.setBounds(271, 156, 125, 25);
		 * 
		 * Button button_14 = new Button(frontComp, SWT.NONE);
		 * button_14.setText(
		 * loader.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE
		 * )); button_14.setBounds(402, 156, 91, 25);
		 */

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(10, 399, 93, 36);
		btnCancel.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_CANCEL));

		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(451, 399, 93, 36);
		btnSave.setText(loader
				.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_SAVE));

	}

	private void onCreateTable(int numberOfServer, Composite innerFrontComp) {
		int cordinates = 0;
		for (int i = 1; i <= numberOfServer; i++) {
			System.out.println("in for loop");
			combo = new Combo(innerFrontComp, SWT.NONE);
			combo.setBounds(10, 21 + cordinates, 142, 25);
			combo.setVisible(true);
			btnNewButton_1 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_1.setBounds(164, 21 + cordinates, 100, 25);
			btnNewButton_1.setText("Heat Timecurve");
			btnNewButton_1.setVisible(true);
			btnNewButton_2 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_2.setBounds(271, 21 + cordinates, 125, 25);
			btnNewButton_2.setText("Fanspeed Timecurve");
			btnNewButton_2.setVisible(true);
			btnNewButton_3 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_3.setBounds(402, 21 + cordinates, 91, 25);
			btnNewButton_3.setText("Delete");
			btnNewButton_3.setVisible(true);
			cordinates = cordinates + 32;
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (txtNumberOfServer.getText() != null
				&& !"".equals(txtNumberOfServer.getText())) {
			int numberOfServer = Integer.parseInt(txtNumberOfServer.getText());
			onCreateTable(numberOfServer, innerFrontComp);
			System.out.println("in call");
			innerFrontComp.redraw();
			innerFrontComp.layout(true);
			frontComp.redraw();
			frontComp.layout(true);
			grpServersInRack.redraw();
		}
	}
}
