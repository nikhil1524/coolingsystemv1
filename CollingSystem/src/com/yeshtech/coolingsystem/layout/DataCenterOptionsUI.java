package com.yeshtech.coolingsystem.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import com.yeshtech.coolingsystem.layout.constants.ConstantsComposite;
import com.yeshtech.coolingsystem.layout.datacenter.DataCenterComposite;

import com.yeshtech.coolingsystem.layout.datacenter.fans.FansServerComposite;
import com.yeshtech.coolingsystem.layout.datacenter.io.IOComposite;
import com.yeshtech.coolingsystem.layout.datacenter.lumps.LumpsComposite;
import com.yeshtech.coolingsystem.layout.datacenter.run.RunComposite;
import com.yeshtech.coolingsystem.layout.datacenter.solution.SolutionComposite;
import com.yeshtech.coolingsystem.layout.datecenter.external.ExternalComposite;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

import org.eclipse.wb.swt.SWTResourceManager;

public class DataCenterOptionsUI {

	protected Shell shell;
	PropertiesLoader loader;

	public DataCenterOptionsUI(PropertiesLoader loader) {
		super();
		this.loader = loader;
	}

	public static void main(String[] args) {
		try {
			PropertiesLoader loader = PropertiesLoader
					.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");
			DataCenterOptionsUI window = new DataCenterOptionsUI(loader);

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
		createContents(display);

		// setting the screen in center

		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();

		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;

		shell.setLocation(x, y);

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
	protected void createContents(Display display) {
		shell = new Shell(SWT.CLOSE | SWT.TITLE);
		shell.setImage(SWTResourceManager.getImage(DataCenterOptionsUI.class,
				"/icon/App.ico"));
		// shell.setImage(new
		// Image(display,"CollingSystem/src/com/dream/layout/coolingsystem.ico"));
		shell.setMaximized(false);
		shell.setSize(572, 413);
		shell.setText(loader.getValue(LabelConstants.DATA_CENTER_OPTIONS));
		shell.setLayout(null);

		CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER);
		tabFolder.setBounds(10, 10, 546, 324);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		CTabItem runTabItem = new CTabItem(tabFolder, SWT.BORDER);
		runTabItem.setText(loader.getValue(LabelConstants.LAYOUT_MENU_RUN));

		CTabItem ioTabItem = new CTabItem(tabFolder, SWT.NONE);
		ioTabItem.setText(loader.getValue(LabelConstants.LAYOUT_MENU_IO));

		CTabItem lumpsTabItem = new CTabItem(tabFolder, SWT.NONE);
		lumpsTabItem.setText(loader
				.getValue(LabelConstants.LAYOUT_MENU_LUMPS_PATH));

		CTabItem solutionTabItem = new CTabItem(tabFolder, SWT.NONE);
		solutionTabItem.setText(loader
				.getValue(LabelConstants.LAYOUT_MENU_SOLUTION));

		CTabItem constantsTabItem = new CTabItem(tabFolder, SWT.NONE);
		constantsTabItem.setText(loader
				.getValue(LabelConstants.LAYOUT_MENU_CONSTANTS));

		CTabItem fansTabItem = new CTabItem(tabFolder, SWT.NONE);
		fansTabItem.setText(loader.getValue(LabelConstants.LAYOUT_MENU_FANS_SERVERS));

		CTabItem dataCenterTabItem = new CTabItem(tabFolder, SWT.NONE);
		dataCenterTabItem.setText(loader
				.getValue(LabelConstants.LAYOUT_MENU_DATA_CENTER));

		CTabItem externalTabItem = new CTabItem(tabFolder, SWT.NONE);
		externalTabItem.setText(loader
				.getValue(LabelConstants.LAYOUT_MENU_EXTERNAL));

		// Composite runComposite = new Composite(tabFolder, SWT.NONE);
		// runTabItem.setControl(runComposite);

		// Composite ioComposite = new Composite(tabFolder, SWT.NONE);
		// ioTabItem.setControl(ioComposite);

		IOComposite ioComposite = new IOComposite(tabFolder, SWT.NONE, loader);
		ioTabItem.setControl(ioComposite);

		RunComposite runComposite = new RunComposite(tabFolder, SWT.NONE,
				loader);
		runTabItem.setControl(runComposite);

		LumpsComposite lumpsComposite = new LumpsComposite(tabFolder, SWT.NONE,
				loader);
		lumpsTabItem.setControl(lumpsComposite);

		SolutionComposite solutionComposite = new SolutionComposite(tabFolder,
				SWT.NONE, loader);
		// Composite solutionComposite = new Composite(tabFolder, SWT.NONE);
		solutionTabItem.setControl(solutionComposite);

		ConstantsComposite constantsComposite = new ConstantsComposite(
				tabFolder, SWT.NONE, loader);
		// Composite constantsComposite = new Composite(tabFolder, SWT.NONE);
		constantsTabItem.setControl(constantsComposite);

		FansServerComposite fansServerComposite = new FansServerComposite(
				tabFolder, SWT.NONE, loader);
		// Composite fansComposite = new Composite(tabFolder, SWT.NONE);
		fansTabItem.setControl(fansServerComposite);

		DataCenterComposite dataCenterComposite = new DataCenterComposite(
				tabFolder, SWT.NONE, loader);
		// Composite dataCenterComposite = new Composite(tabFolder, SWT.NONE);
		dataCenterTabItem.setControl(dataCenterComposite);

		ExternalComposite externalComposite = new ExternalComposite(tabFolder,
				SWT.NONE, loader);
		// Composite externalComposite = new Composite(tabFolder, SWT.NONE);
		externalTabItem.setControl(externalComposite);

		Button btnRunCancel = new Button(shell, SWT.NONE);
		btnRunCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.setVisible(false);
				shell.dispose();
			}
		});
		btnRunCancel.setBounds(10, 340, 94, 36);
		btnRunCancel.setText(loader.getValue(LabelConstants.LAYOUT_CANCEL));

		Button btnRunSave = new Button(shell, SWT.NONE);
		btnRunSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		btnRunSave.setText(loader.getValue(LabelConstants.LAYOUT_SAVE));
		btnRunSave.setBounds(462, 340, 94, 36);

	}
}
