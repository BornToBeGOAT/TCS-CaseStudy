package com.model_class;

public class customerstatusmodel {
	String customerId,customerSSNId,Status,Message,LastUpdated;

	public customerstatusmodel(String customerId, String customerSSNId, String status, String message,
			String lastUpdated) {
		super();
		this.customerId = customerId;
		this.customerSSNId = customerSSNId;
		this.Status = status;
		this.Message = message;
		this.LastUpdated = lastUpdated;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerSSNId() {
		return this.customerSSNId;
	}

	public void setCustomerSSNId(String customerSSNId) {
		this.customerSSNId = customerSSNId;
	}

	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public String getMessage() {
		return this.Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}

	public String getLastUpdated() {
		return this.LastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.LastUpdated = lastUpdated;
	}
	
}
