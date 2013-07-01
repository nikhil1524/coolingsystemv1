package com.yeshtech.coolingsystem.layout.datacenter.io;

import java.io.Serializable;

public class IOData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String notifyEvery;
	public String informationLevel;
	public boolean printResults;
	public String printEveryForSteps;
	public String printEveryForS;
	public String baseName;
	public String numberOfSteps;

	public String getNotifyEvery() {
		return notifyEvery;
	}

	public void setNotifyEvery(String notifyEvery) {
		this.notifyEvery = notifyEvery;
	}

	public String getInformationLevel() {
		return informationLevel;
	}

	public void setInformationLevel(String informationLevel) {
		this.informationLevel = informationLevel;
	}

	public boolean isPrintResults() {
		return printResults;
	}

	public void setPrintResults(boolean printResults) {
		this.printResults = printResults;
	}

	public String getPrintEveryForSteps() {
		return printEveryForSteps;
	}

	public void setPrintEveryForSteps(String printEveryForSteps) {
		this.printEveryForSteps = printEveryForSteps;
	}

	public String getPrintEveryForS() {
		return printEveryForS;
	}

	public void setPrintEveryForS(String printEveryForS) {
		this.printEveryForS = printEveryForS;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(String numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

}
