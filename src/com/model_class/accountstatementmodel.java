package com.model_class;

public class accountstatementmodel {
	String transcationId,transcationDescription,transcationDate,transcationAmount;

	public accountstatementmodel(String transcationId, String transcationDescription, String transcationDate,
			String transcationAmount) {
		super();
		this.transcationId = transcationId;
		this.transcationDescription = transcationDescription;
		this.transcationDate = transcationDate;
		this.transcationAmount = transcationAmount;
	}

	public String getTranscationId() {
		return transcationId;
	}

	public void setTranscationId(String transcationId) {
		this.transcationId = transcationId;
	}

	public String getTranscationDescription() {
		return transcationDescription;
	}

	public void setTranscationDescription(String transcationDescription) {
		this.transcationDescription = transcationDescription;
	}

	public String getTranscationDate() {
		return transcationDate;
	}

	public void setTranscationDate(String transcationDate) {
		this.transcationDate = transcationDate;
	}

	public String getTranscationAmount() {
		return transcationAmount;
	}

	public void setTranscationAmount(String transcationAmount) {
		this.transcationAmount = transcationAmount;
	}
	
}
