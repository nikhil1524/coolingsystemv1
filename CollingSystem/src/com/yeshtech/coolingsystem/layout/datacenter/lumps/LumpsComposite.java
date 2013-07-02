package com.yeshtech.coolingsystem.layout.datacenter.lumps;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.layout.datacenter.printedwindow.PrintedLumpWindow;
import com.yeshtech.coolingsystem.layout.datacenter.printedwindow.PrintedPathWindow;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class LumpsComposite extends Composite implements SelectionListener,LumpsInterface{

	private List listLumpsPLPrintedLumps;
	private List listLumpsPLPrintedPaths;
	private Button btnLumpAddPrintedLump;
	private Button btnLumpAddPrintedPath;
	private PropertiesLoader loader;
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public LumpsComposite(Composite parent, int style, PropertiesLoader loader) {
		super(parent, style);
		this.loader = loader;
		displayLayout(this.loader);
	}

	public void displayLayout(final PropertiesLoader loader) {

		btnLumpAddPrintedLump = new Button(this, SWT.NONE);
		btnLumpAddPrintedLump.addSelectionListener(this);
		btnLumpAddPrintedLump.setBounds(10, 38, 250, 43);

		btnLumpAddPrintedLump.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_ADD_PRINTED_LUMPS));

		btnLumpAddPrintedPath = new Button(this, SWT.NONE);
		btnLumpAddPrintedPath.addSelectionListener(this);
		btnLumpAddPrintedPath.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_ADD_PRINTED_PATH));
		btnLumpAddPrintedPath.setBounds(282, 38, 250, 43);

		Group grpLumpsPrintedLumps = new Group(this, SWT.NONE);
		grpLumpsPrintedLumps.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_PRINTED_LUMPS));
		grpLumpsPrintedLumps.setBounds(10, 87, 250, 206);

		listLumpsPLPrintedLumps = new List(grpLumpsPrintedLumps, SWT.BORDER);
		listLumpsPLPrintedLumps.setBounds(10, 23, 230, 173);

		Group grpLumpsPrintedPaths = new Group(this, SWT.NONE);
		grpLumpsPrintedPaths.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_PRINTED_PATHS));
		grpLumpsPrintedPaths.setBounds(282, 87, 250, 206);

		listLumpsPLPrintedPaths = new List(grpLumpsPrintedPaths, SWT.BORDER);
		listLumpsPLPrintedPaths.setBounds(10, 23, 230, 173);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(btnLumpAddPrintedLump))
		{
			PrintedLumpWindow window = new PrintedLumpWindow(loader);
			window.setLumpsInterface(this);
			window.open();
		}
		else
		{
			PrintedPathWindow window = new PrintedPathWindow(loader);
			window.setLumpsInterface(this);
			window.open();
		}
	}

	@Override
	public void addPrintedLump(String printedLump) {
		// TODO Auto-generated method stub
		if(null != printedLump && !"".equals(printedLump))
		{
			listLumpsPLPrintedLumps.add(printedLump);
		}
	}

	@Override
	public void addPrintedPath(String printedPath) {
		// TODO Auto-generated method stub
		if(null != printedPath && !"".equals(printedPath))
		{
			listLumpsPLPrintedPaths.add(printedPath);
		}
	}

}
