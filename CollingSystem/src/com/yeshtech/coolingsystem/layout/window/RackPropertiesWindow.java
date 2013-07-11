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
		DisplayMonitor dm = new DisplayMonitor(shell, display);
		shell.setLocation(dm.getMonitorCenterXCoordinate(),
				dm.getMonitorCenterYCoordinate());

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
				TimeCurveSpecification tmeCureve = new TimeCurveSpecification();
				tmeCureve.open();
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
		comp_grpSerinRack.setBounds(10, 163, 534, 230);

		grpServersInRack = new Group(comp_grpSerinRack, SWT.NONE);
		grpServersInRack.setText("Servers in Rack ");
		grpServersInRack.setBounds(0, 10, 534, 210);
		grpServersInRack.setVisible(false);
		frontComp = new ScrolledComposite(grpServersInRack, SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		frontComp.setBounds(0, 25, 533, 185);
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
					Combo[] arr_combo_servers = new Combo[numberOfServer];
					Button[] arr_btn_heat_timeCurve = new Button[numberOfServer];
					Button[] arr_btn_FanspeedTimeCurve = new Button[numberOfServer];
					Button[] arr_btn_delete = new Button[numberOfServer];

					for (int i = 0; i < numberOfServer; i++) {
						arr_combo_servers[i] = new Combo(innerFrontComp,
								SWT.NONE);
						arr_combo_servers[i].setBounds(10, 21 + cordinates,
								245, 23);
						arr_btn_heat_timeCurve[i] = new Button(innerFrontComp,
								SWT.NONE);
						arr_btn_heat_timeCurve[i].setText(loader
								.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_HEAT_TIMECURVE));
						arr_btn_heat_timeCurve[i].setBounds(271,
								21 + cordinates, 100, 25);
						arr_btn_heat_timeCurve[i]
								.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(
											SelectionEvent arg0) {
										TimeCurveSpecification window = new TimeCurveSpecification();
										window.open();
									}
								});

						arr_btn_FanspeedTimeCurve[i] = new Button(
								innerFrontComp, SWT.NONE);
						arr_btn_FanspeedTimeCurve[i].setText(loader
								.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_FANSPEED_TIMECURVE));
						arr_btn_FanspeedTimeCurve[i].setBounds(380,
								21 + cordinates, 125, 25);
						arr_btn_FanspeedTimeCurve[i]
								.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(
											SelectionEvent arg0) {
										TimeCurveSpecification window = new TimeCurveSpecification();
										window.open();
									}
								});

//						arr_btn_delete[i] = new Button(innerFrontComp, SWT.NONE);
//						arr_btn_delete[i].setText(loader
//								.getValue(LabelConstants.LAYOUT_RACK_PROPERTIES_WINDOW_DELETE));
//						arr_btn_delete[i].setBounds(402, 21 + cordinates, 91,
//								25);
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

		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
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
			btnNewButton_1.setBounds(271, 21 + cordinates, 100, 25);
			btnNewButton_1.setText("Heat Timecurve");
			btnNewButton_1.setVisible(true);
			btnNewButton_2 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_2.setBounds(402, 21 + cordinates, 125, 25);
			btnNewButton_2.setText("Fanspeed Timecurve");
			btnNewButton_2.setVisible(true);
//			btnNewButton_3 = new Button(innerFrontComp, SWT.NONE);
//			btnNewButton_3.setBounds(402, 21 + cordinates, 91, 25);
//			btnNewButton_3.setText("Delete");
//			btnNewButton_3.setVisible(true);
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
