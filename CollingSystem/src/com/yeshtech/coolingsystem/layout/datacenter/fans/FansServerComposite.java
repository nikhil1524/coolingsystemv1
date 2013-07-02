package com.yeshtech.coolingsystem.layout.datacenter.fans;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;

import com.yeshtech.coolingsystem.layout.window.NewFanWindow;
import com.yeshtech.coolingsystem.layout.window.NewServerWindow;
import com.yeshtech.coolingsystem.util.LabelConstants;
import com.yeshtech.coolingsystem.util.PropertiesLoader;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class FansServerComposite extends Composite implements FansServerInterface,SelectionListener{

	private List listFansCFCreatedFans;
	private List listFansCSCreatedServers;
	private Button btnFansAddServer;
	private Button btnFansAddFan;

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
		btnFansAddServer = new Button(this, SWT.NONE);
		btnFansAddServer.addSelectionListener(this);
		btnFansAddServer.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_ADD_SERVER));
		btnFansAddServer.setBounds(316, 10, 201, 43);

		Group grpFansCreatedFans = new Group(this, SWT.NONE);
		grpFansCreatedFans.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_CREATED_FANS));
		grpFansCreatedFans.setBounds(10, 59, 250, 206);

		listFansCFCreatedFans = new List(grpFansCreatedFans, SWT.BORDER);
		listFansCFCreatedFans.setBounds(10, 23, 230, 173);
		
		Group grpFansCreatedServers = new Group(this, SWT.NONE);
		grpFansCreatedServers.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_CREATED_SERVER));
		grpFansCreatedServers.setBounds(282, 59, 250, 206);

		listFansCSCreatedServers = new List(grpFansCreatedServers, SWT.BORDER);
		listFansCSCreatedServers.setBounds(10, 23, 230, 173);

		btnFansAddFan = new Button(this, SWT.NONE);
		btnFansAddFan.addSelectionListener(this);
		btnFansAddFan.setBounds(34, 10, 201, 43);
		btnFansAddFan.setText(loader
				.getValue(LabelConstants.LAYOUT_FAN_SERVER_ADD_FAN));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public String addFan(String fanName) {
		// TODO Auto-generated method stub
		if(null != fanName && !"".equals(fanName))
		{
			listFansCFCreatedFans.add(fanName);
		}
		return null;
	}

	@Override
	public String addServer(String serverName) {
		// TODO Auto-generated method stub
		if(null != serverName && !"".equals(serverName))
		{
			listFansCSCreatedServers.add(serverName);
		}
		return null;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(btnFansAddServer))
		{
			try {
				NewServerWindow window = new NewServerWindow();
				window.setFansServerInterface(this);
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				NewFanWindow window = new NewFanWindow();
				window.setFansServerInterface(this);
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
