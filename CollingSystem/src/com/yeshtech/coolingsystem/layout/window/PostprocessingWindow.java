package com.yeshtech.coolingsystem.layout.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Group;

import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class PostprocessingWindow {

	protected Shell shell;
	private Text txtResultFileName;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PostprocessingWindow window = new PostprocessingWindow();
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
		PropertiesLoader loader = PropertiesLoader
				.getPropertiesLoader("com.yeshtech.coolingsystem.util.layout-label");
		
		shell = new Shell();
		shell.setSize(545, 442);
		shell.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW));
		
		Label lblResultFileName = new Label(shell, SWT.NONE);
		lblResultFileName.setBounds(10, 12, 94, 15);
		lblResultFileName.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_RESULTS_FILE_NAME));
		
		txtResultFileName = new Text(shell, SWT.BORDER);
		txtResultFileName.setBounds(120, 10, 76, 21);
		
		Button btnLoadResults = new Button(shell, SWT.NONE);
		btnLoadResults.setBounds(209, 6, 101, 25);
		btnLoadResults.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_LOAD_RESULTS));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 60, 507, 275);
		
		CTabFolder tabFolder = new CTabFolder(composite, SWT.BORDER);
		tabFolder.setBounds(0, 0, 507, 275);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmDdd = new CTabItem(tabFolder, SWT.NONE);
		tbtmDdd.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_INPUT_PARAMETERS));
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmDdd.setControl(composite_1);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text = new Text(composite_1, SWT.BORDER);
		
		CTabItem tbtmExergyDestruction = new CTabItem(tabFolder, SWT.NONE);
		tbtmExergyDestruction.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_EXERGY_DESTRUCTION));
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmExergyDestruction.setControl(composite_2);
		
		Label label = new Label(composite_2, SWT.WRAP);
		label.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_COMPONENT_NAME));
		label.setBounds(49, 27, 66, 34);
		
		Label label_1 = new Label(composite_2, SWT.WRAP);
		label_1.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_COMPONENT_TYPE));
		label_1.setBounds(157, 27, 66, 34);
		
		Label lblExergyDestruction = new Label(composite_2, SWT.WRAP);
		lblExergyDestruction.setText("Exergy Destruction,");
		lblExergyDestruction.setBounds(259, 27, 103, 24);
		
		Label label_3 = new Label(composite_2, SWT.NONE);
		label_3.setText("2e-4");
		label_3.setBounds(259, 67, 55, 15);
		
		Label label_4 = new Label(composite_2, SWT.NONE);
		label_4.setText("CRAH");
		label_4.setBounds(157, 67, 55, 15);
		
		Label label_5 = new Label(composite_2, SWT.NONE);
		label_5.setText("c1");
		label_5.setBounds(49, 67, 55, 15);
		
		Label lblw = new Label(composite_2, SWT.NONE);
		lblw.setBounds(362, 27, 55, 15);
		lblw.setText("W");
		
		CTabItem tbtmDesignParameter = new CTabItem(tabFolder, SWT.NONE);
		tbtmDesignParameter.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_DESIGN_PARAMETERS));
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmDesignParameter.setControl(composite_3);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text_5 = new Text(composite_3, SWT.BORDER);
		
		CTabItem tbtmGraphics = new CTabItem(tabFolder, SWT.NONE);
		tbtmGraphics.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_GRAPHICS));
		
		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tbtmGraphics.setControl(composite_4);
		
		Group grpComponentExergyDestruction = new Group(composite_4, SWT.NONE);
		grpComponentExergyDestruction.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_COMPONENT_EXERGY_DESTRUCTION));
		grpComponentExergyDestruction.setBounds(36, 10, 313, 108);
		
		Label lblColorScaleMinimum = new Label(grpComponentExergyDestruction, SWT.NONE);
		lblColorScaleMinimum.setBounds(10, 28, 126, 15);
		lblColorScaleMinimum.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_COLOR_SCALE_MINIMUM));
		
		Label lblColorScaleMaximum = new Label(grpComponentExergyDestruction, SWT.NONE);
		lblColorScaleMaximum.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_COLOR_SCALE_MAXIMUM));
		lblColorScaleMaximum.setBounds(10, 68, 126, 15);
		
		text_1 = new Text(grpComponentExergyDestruction, SWT.BORDER);
		text_1.setBounds(158, 28, 133, 21);
		
		text_2 = new Text(grpComponentExergyDestruction, SWT.BORDER);
		text_2.setBounds(158, 62, 133, 21);
		
		Group grpLoopMassFlow = new Group(composite_4, SWT.NONE);
		grpLoopMassFlow.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_LOOP_MASS_FLOW_RATE));
		grpLoopMassFlow.setBounds(36, 134, 313, 102);
		
		Label lblMinimumThickness = new Label(grpLoopMassFlow, SWT.NONE);
		lblMinimumThickness.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_MINIMUM_THICKNESS));
		lblMinimumThickness.setBounds(10, 32, 126, 15);
		
		Label lblMaximumThickness = new Label(grpLoopMassFlow, SWT.NONE);
		lblMaximumThickness.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_MAXIMUM_THICKNESS));
		lblMaximumThickness.setBounds(10, 63, 126, 15);
		
		text_3 = new Text(grpLoopMassFlow, SWT.BORDER);
		text_3.setBounds(158, 26, 133, 21);
		
		text_4 = new Text(grpLoopMassFlow, SWT.BORDER);
		text_4.setBounds(158, 57, 133, 21);
		
		Button btnPlot = new Button(composite_4, SWT.NONE);
		btnPlot.setBounds(377, 167, 86, 57);
		btnPlot.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_PLOT));
		
		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.setBounds(353, 353, 94, 37);
		btnClose.setText(loader.getValue(LabelConstants.LAYOUT_POST_PROCESSING_WINDOW_CLOSE));

	}
}
