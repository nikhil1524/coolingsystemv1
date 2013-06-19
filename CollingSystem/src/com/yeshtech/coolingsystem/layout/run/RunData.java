package com.yeshtech.coolingsystem.layout.run;

import java.io.Serializable;

public class RunData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String simulationType;
	public boolean transientParameter;
	public String finalStep;
	public String finalValue;
	public String timeStepValue;
	public String restartFileName;
	public boolean overriteComponent;

	public String getSimulationType() {
		return simulationType;
	}

	public void setSimulationType(String simulationType) {
		this.simulationType = simulationType;
	}

	public boolean isTransientParameter() {
		return transientParameter;
	}

	public void setTransientParameter(boolean transientParameter) {
		this.transientParameter = transientParameter;
	}

	public String getFinalStep() {
		return finalStep;
	}

	public void setFinalStep(String finalStep) {
		this.finalStep = finalStep;
	}

	public String getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(String finalValue) {
		this.finalValue = finalValue;
	}

	public String getTimeStepValue() {
		return timeStepValue;
	}

	public void setTimeStepValue(String timeStepValue) {
		this.timeStepValue = timeStepValue;
	}

	public String getRestartFileName() {
		return restartFileName;
	}

	public void setRestartFileName(String restartFileName) {
		this.restartFileName = restartFileName;
	}

	public boolean isOverriteComponent() {
		return overriteComponent;
	}

	public void setOverriteComponent(boolean overriteComponent) {
		this.overriteComponent = overriteComponent;
	}

}
