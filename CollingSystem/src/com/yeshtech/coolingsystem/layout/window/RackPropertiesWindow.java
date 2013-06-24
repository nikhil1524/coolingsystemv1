package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
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

import com.yeshtech.coolingsystem.layout.CoolingSystemMain;

public class RackPropertiesWindow implements SelectionListener{

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
		shell.setSize(570, 475);
		shell.setText("Rack Properties Window");
		
		Label lblRackName = new Label(shell, SWT.NONE);
		lblRackName.setBounds(10, 10, 74, 15);
		lblRackName.setText("Rack Name :");
		
		txtRackName = new Text(shell, SWT.BORDER);
		txtRackName.setBounds(103, 10, 135, 21);
		
		Group grpNonServerEquipment = new Group(shell, SWT.NONE);
		grpNonServerEquipment.setText("Non server Equipment");
		grpNonServerEquipment.setBounds(10, 35, 296, 95);
		
		Label lblNewLabel_1 = new Label(grpNonServerEquipment, SWT.NONE);
		lblNewLabel_1.setBounds(10, 27, 75, 15);
		lblNewLabel_1.setText("Heat Output :");
		
		Label lblNewLabel_2 = new Label(grpNonServerEquipment, SWT.NONE);
		lblNewLabel_2.setBounds(10, 62, 117, 15);
		lblNewLabel_2.setText("Thermal Resistance :");
		
		txtHeatOutput = new Text(grpNonServerEquipment, SWT.BORDER);
		txtHeatOutput.setBounds(92, 23, 91, 21);
		
		txtThermalResistance = new Text(grpNonServerEquipment, SWT.BORDER);
		txtThermalResistance.setBounds(133, 58, 118, 21);
		
		Button btnNewButton = new Button(grpNonServerEquipment, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		btnNewButton.setBounds(213, 19, 75, 25);
		btnNewButton.setText("Timecurve");
		
		Label lblW = new Label(grpNonServerEquipment, SWT.NONE);
		lblW.setBounds(189, 25, 18, 15);
		lblW.setText("W");
		
		Label lblKW = new Label(grpNonServerEquipment, SWT.NONE);
		lblKW.setBounds(257, 60, 31, 15);
		lblKW.setText("K/W");
		
		Group grpRackDimension = new Group(shell, SWT.NONE);
		grpRackDimension.setText("Rack Dimension");
		grpRackDimension.setBounds(313, 28, 230, 103);
		
		Label lblXdimension = new Label(grpRackDimension, SWT.NONE);
		lblXdimension.setBounds(10, 22, 72, 15);
		lblXdimension.setText("x-dimension");
		
		Label lblYdimension = new Label(grpRackDimension, SWT.NONE);
		lblYdimension.setBounds(10, 46, 72, 15);
		lblYdimension.setText("y-dimension");
		
		Label lblZdimension = new Label(grpRackDimension, SWT.NONE);
		lblZdimension.setBounds(10, 70, 72, 15);
		lblZdimension.setText("z-dimension");
		
		txtXDimension = new Text(grpRackDimension, SWT.BORDER);
		txtXDimension.setBounds(101, 18, 97, 21);
		
		txtYDimension = new Text(grpRackDimension, SWT.BORDER);
		txtYDimension.setBounds(101, 43, 97, 21);
		
		txtZDimension = new Text(grpRackDimension, SWT.BORDER);
		txtZDimension.setBounds(101, 70, 97, 21);
		
		Label lblM1 = new Label(grpRackDimension, SWT.NONE);
		lblM1.setBounds(204, 22, 19, 15);
		lblM1.setText("m");
		
		Label lblM2 = new Label(grpRackDimension, SWT.NONE);
		lblM2.setText("m");
		lblM2.setBounds(204, 43, 19, 15);
		
		Label lblM3 = new Label(grpRackDimension, SWT.NONE);
		lblM3.setText("m");
		lblM3.setBounds(204, 70, 19, 15);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(10, 142, 108, 15);
		lblNewLabel_3.setText("Number Of Server :");
		
		txtNumberOfServer = new Text(shell, SWT.BORDER);
		txtNumberOfServer.setBounds(121, 140, 51, 21);
		
		grpServersInRack = new Group(shell,  SWT.NONE);
		grpServersInRack.setText("Servers in Rack");
		grpServersInRack.setBounds(10, 180, 529, 159);
		grpServersInRack.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		frontComp = new ScrolledComposite(grpServersInRack, SWT.H_SCROLL
		        | SWT.V_SCROLL);
		
	    innerFrontComp = new Composite(frontComp, SWT.NONE);
	    innerFrontComp.setBounds(10, 180, 529, 159);
		//frontComp.setAlwaysShowScrollBars(true);
		frontComp.setExpandHorizontal(true);
		frontComp.setExpandVertical(true);
	    //frontComp.setLayout(new FillLayout());

	    //innerFrontComp.setLayout(new FillLayout());
		Button btnCreateTable = new Button(shell, SWT.NONE);
		System.out.println("in cdd");
		//btnCreateTable.addSelectionListener(this);
		
		btnCreateTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(txtNumberOfServer.getText() != null && !"".equals(txtNumberOfServer.getText()))
				{
					
					
				    int numberOfServer = Integer.parseInt(txtNumberOfServer.getText());
				    int cordinates = 0;
				    for(int i = 1; i <= numberOfServer; i++)
					{
				    	Combo combo_1 = new Combo(innerFrontComp, SWT.NONE);
						combo_1.setBounds(10, 21+cordinates , 142, 23);
						Button button = new Button(innerFrontComp, SWT.NONE);
						button.setText("Heat Timecurve");
						button.setBounds(164, 21+cordinates, 100, 25);
						
						Button button_1 = new Button(innerFrontComp, SWT.NONE);
						button_1.setText("Fanspeed Timecurve");
						button_1.setBounds(271, 21+cordinates, 125, 25);
						
						Button button_2 = new Button(innerFrontComp, SWT.NONE);
						button_2.setText("Delete");
						button_2.setBounds(402, 21+cordinates, 91, 25);
						cordinates = cordinates + 32;
					}
					
					
				}
			}
		});
		
		
		btnCreateTable.setBounds(182, 136, 75, 25);
		btnCreateTable.setText("Create Table");
		
		Combo combo_1 = new Combo(innerFrontComp, SWT.NONE);
		combo_1.setBounds(10, 21 , 142, 23);
		Button button = new Button(innerFrontComp, SWT.NONE);
		button.setText("Heat Timecurve");
		button.setBounds(164, 21, 100, 25);
		
		Button button_1 = new Button(innerFrontComp, SWT.NONE);
		button_1.setText("Fanspeed Timecurve");
		button_1.setBounds(271, 21, 125, 25);
		
		Button button_2 = new Button(innerFrontComp, SWT.NONE);
		button_2.setText("Delete");
		button_2.setBounds(402, 21, 91, 25);
		
		Combo combo_2 = new Combo(innerFrontComp, SWT.NONE);
		combo_2.setBounds(10, 88, 142, 23);
		
		Button button_3 = new Button(innerFrontComp, SWT.NONE);
		button_3.setText("Heat Timecurve");
		button_3.setBounds(164, 85, 100, 25);
		
		Button button_4 = new Button(innerFrontComp, SWT.NONE);
		button_4.setText("Fanspeed Timecurve");
		button_4.setBounds(271, 85, 125, 25);
		
		Button button_5 = new Button(innerFrontComp, SWT.NONE);
		button_5.setText("Delete");
		button_5.setBounds(402, 85, 91, 25);
		
		Combo combo_3 = new Combo(innerFrontComp, SWT.NONE);
		combo_3.setBounds(10, 121, 142, 23);
		
		Button button_6 = new Button(innerFrontComp, SWT.NONE);
		button_6.setText("Heat Timecurve");
		button_6.setBounds(164, 118, 100, 25);
		
		Button button_7 = new Button(innerFrontComp, SWT.NONE);
		button_7.setText("Fanspeed Timecurve");
		button_7.setBounds(271, 118, 125, 25);
		
		Button button_8 = new Button(innerFrontComp, SWT.NONE);
		button_8.setText("Delete");
		button_8.setBounds(402, 118, 91, 25);
		
		Combo combo_4 = new Combo(innerFrontComp, SWT.NONE);
		combo_4.setBounds(10, 153, 142, 23);
		
		Button button_9 = new Button(innerFrontComp, SWT.NONE);
		button_9.setText("Heat Timecurve");
		button_9.setBounds(164, 150, 100, 25);
		
		Button button_10 = new Button(innerFrontComp, SWT.NONE);
		button_10.setText("Fanspeed Timecurve");
		button_10.setBounds(271, 150, 125, 25);
		
		Button button_11 = new Button(innerFrontComp, SWT.NONE);
		button_11.setText("Delete");
		button_11.setBounds(402, 150, 91, 25);
		
		
		Combo combo_5 = new Combo(innerFrontComp, SWT.NONE);
		combo_5.setBounds(10, 185, 142, 23);
		
		Button button_12 = new Button(innerFrontComp, SWT.NONE);
		button_12.setText("Heat Timecurve");
		button_12.setBounds(164, 182, 100, 25);
		
		Button button_13 = new Button(innerFrontComp, SWT.NONE);
		button_13.setText("Fanspeed Timecurve");
		button_13.setBounds(271, 182, 125, 25);
		
		Button button_14 = new Button(innerFrontComp, SWT.NONE);
		button_14.setText("Delete");
		button_14.setBounds(402, 182, 91, 25);


		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(10, 391, 93, 36);
		btnCancel.setText("Cancel");
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(429, 391, 93, 36);
		btnSave.setText("Save");
		
				
		//innerFrontComp = innerFrontComp2;
		frontComp.setMinHeight(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
	    frontComp.setMinWidth(innerFrontComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
	    frontComp.setContent(innerFrontComp);
	    frontComp.setExpandHorizontal(true);
	    frontComp.setExpandVertical(true);

	}

	private void onCreateTable(int numberOfServer, Composite innerFrontComp)
	{
		int cordinates = 0;
		for(int i = 1; i <= numberOfServer; i++)
		{
			System.out.println("in for loop");
			combo = new Combo(innerFrontComp, SWT.NONE);
			combo.setBounds(10, 21+cordinates, 142, 25);
			combo.setVisible(true);
			btnNewButton_1 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_1.setBounds(164, 21+cordinates, 100, 25);
			btnNewButton_1.setText("Heat Timecurve");
			btnNewButton_1.setVisible(true);
			btnNewButton_2 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_2.setBounds(271, 21+cordinates, 125, 25);
			btnNewButton_2.setText("Fanspeed Timecurve");
			btnNewButton_2.setVisible(true);
			btnNewButton_3 = new Button(innerFrontComp, SWT.NONE);
			btnNewButton_3.setBounds(402, 21+cordinates, 91, 25);
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
		if(txtNumberOfServer.getText() != null && !"".equals(txtNumberOfServer.getText()))
		{
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
