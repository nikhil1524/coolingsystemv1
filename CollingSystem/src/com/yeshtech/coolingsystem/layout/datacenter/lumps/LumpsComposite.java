package com.yeshtech.coolingsystem.layout.datacenter.lumps;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.layout.datacenter.printedwindow.PrintedLumpWindow;
import com.yeshtech.coolingsystem.layout.datacenter.printedwindow.PrintedPathWindow;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class LumpsComposite extends Composite {

	private Text txtLumpsPLPrintedLumps;
	private Text txtLumpsPLPrintedPaths;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public LumpsComposite(Composite parent, int style, PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(final PropertiesLoader loader) {

		Button btnLumpAddPrintedLump = new Button(this, SWT.NONE);
		btnLumpAddPrintedLump.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				PrintedLumpWindow window = new PrintedLumpWindow(loader);
				window.open();
			}
		});
		btnLumpAddPrintedLump.setBounds(10, 38, 250, 43);

		btnLumpAddPrintedLump.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_ADD_PRINTED_LUMPS));

		Button btnLumpAddPrintedPath = new Button(this, SWT.NONE);
		btnLumpAddPrintedPath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				PrintedPathWindow window = new PrintedPathWindow(loader);
				window.open();
			}
		});
		btnLumpAddPrintedPath.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_ADD_PRINTED_PATH));
		btnLumpAddPrintedPath.setBounds(282, 38, 250, 43);

		Group grpLumpsPrintedLumps = new Group(this, SWT.NONE);
		grpLumpsPrintedLumps.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_PRINTED_LUMPS));
		grpLumpsPrintedLumps.setBounds(10, 87, 250, 206);

		txtLumpsPLPrintedLumps = new Text(grpLumpsPrintedLumps, SWT.BORDER);
		txtLumpsPLPrintedLumps.setBounds(10, 23, 230, 173);

		Group grpLumpsPrintedPaths = new Group(this, SWT.NONE);
		grpLumpsPrintedPaths.setText(loader
				.getValue(LabelConstants.LAYOUT_LUMPS_PATHS_PRINTED_PATHS));
		grpLumpsPrintedPaths.setBounds(282, 87, 250, 206);

		txtLumpsPLPrintedPaths = new Text(grpLumpsPrintedPaths, SWT.BORDER);
		txtLumpsPLPrintedPaths.setBounds(10, 23, 230, 173);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
