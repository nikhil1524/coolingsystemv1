package com.yeshtech.coolingsystem.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.yeshtech.coolingsystem.layout.window.PostprocessingWindow;
import com.yeshtech.coolingsystem.layout.window.RunWindow;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

import org.eclipse.wb.swt.SWTResourceManager;

public class CoolingSystemMain {

	protected Shell shell;
	PropertiesLoader loader;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CoolingSystemMain window = new CoolingSystemMain();
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

		loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");

		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(CoolingSystemMain.class,
				"/icon/App.ico"));
		shell.setSize(699, 415);
		shell.setMaximized(true);
		shell.setText(loader.getValue(LabelConstants.COOLING_CENTER));

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem menuFile = new MenuItem(menu, SWT.CASCADE);
		menuFile.setText(loader.getValue(LabelConstants.COOLING_CENTER_FILE));

		Menu menu_1 = new Menu(menuFile);
		menuFile.setMenu(menu_1);

		MenuItem menuItemOpenProject = new MenuItem(menu_1, SWT.NONE);
		menuItemOpenProject.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_FILE_OPEN_PROJECT));

		MenuItem menuItemNewProject = new MenuItem(menu_1, SWT.NONE);
		menuItemNewProject.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_FILE_NEW_PROJECT));

		MenuItem menuItemSaveProject = new MenuItem(menu_1, SWT.NONE);
		menuItemSaveProject.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_FILE_SAVE_PROJECT));

		MenuItem menuOption = new MenuItem(menu, SWT.CASCADE);
		menuOption.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_OPTIONS));

		Menu menu_2 = new Menu(menuOption);
		menuOption.setMenu(menu_2);

		MenuItem menuItemDataCenterOption = new MenuItem(menu_2, SWT.NONE);
		menuItemDataCenterOption.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					DataCenterOptionsUI window = new DataCenterOptionsUI(loader);
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		menuItemDataCenterOption.setText(loader
				.getValue(LabelConstants.DATA_CENTER_OPTIONS));

		MenuItem menuItemRun = new MenuItem(menu, SWT.CASCADE);
		menuItemRun.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_EXECUTE));

		Menu menu_3 = new Menu(menuItemRun);
		menuItemRun.setMenu(menu_3);

		MenuItem mntmRun = new MenuItem(menu_3, SWT.NONE);
		mntmRun.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				RunWindow window = new RunWindow();
				window.open();
			}
		});
		mntmRun.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_EXECUTE_RUN));

		MenuItem menuItemPostProcess = new MenuItem(menu_3, SWT.NONE);
		menuItemPostProcess.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				PostprocessingWindow window = new PostprocessingWindow();
				window.open();
			}
		});
		menuItemPostProcess.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_EXECUTE_POST_PROCESS));

		MenuItem menuHelp = new MenuItem(menu, SWT.CASCADE);
		menuHelp.setText(loader.getValue(LabelConstants.COOLING_CENTER_HELP));

		Menu menu_4 = new Menu(menuHelp);
		menuHelp.setMenu(menu_4);

		MenuItem menuItemVTASManual = new MenuItem(menu_4, SWT.NONE);
		menuItemVTASManual.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_HELP_VTAS_MANUAL));

		MenuItem menuItemAbout = new MenuItem(menu_4, SWT.NONE);
		menuItemAbout.setText(loader
				.getValue(LabelConstants.COOLING_CENTER_HELP_ABOUT));

	}
}
