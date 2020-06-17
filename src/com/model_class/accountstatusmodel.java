package com.model_class;

public class accountstatusmodel {
	
	String customerId,accountId,accountType,accountStatus,Message,LastUpdated;

	public accountstatusmodel(String customerId, String accountId, String accountType, String accountStatus,
			String message, String lastUpdated) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.Message = message;
		this.LastUpdated = lastUpdated;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
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
