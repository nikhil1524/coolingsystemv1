package com.yeshtech.coolingsystem.layout.datacenter.fans;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;

public class FansServerComposite extends Composite {

	private Text txtFansCFCreatedFans;
	private Text txtFansCSCreatedServers;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public FansServerComposite(Composite parent, int style,
			PropertiesLoader loader) {
		super(parent, style);
		displayLayout(loader);
	}

	public void displayLayout(PropertiesLoader loader) {
		Button btnFansAddServer = new Button(this, SWT.NONE);
		btnFansAddServer.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_ADD_SERVER));
		btnFansAddServer.setBounds(316, 10, 201, 43);

		Group grpFansCreatedFans = new Group(this, SWT.NONE);
		grpFansCreatedFans.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_CREATED_FANS));
		grpFansCreatedFans.setBounds(10, 59, 250, 206);

		txtFansCFCreatedFans = new Text(grpFansCreatedFans, SWT.BORDER);
		txtFansCFCreatedFans.setBounds(10, 23, 230, 173);

		Group grpFansCreatedServers = new Group(this, SWT.NONE);
		grpFansCreatedServers.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_CREATED_SERVER));
		grpFansCreatedServers.setBounds(282, 59, 250, 206);

		txtFansCSCreatedServers = new Text(grpFansCreatedServers, SWT.BORDER);
		txtFansCSCreatedServers.setBounds(10, 23, 230, 173);

		Button btnFansAddFan = new Button(this, SWT.NONE);
		btnFansAddFan.setBounds(34, 10, 201, 43);
		btnFansAddFan.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_ADD_FAN));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
