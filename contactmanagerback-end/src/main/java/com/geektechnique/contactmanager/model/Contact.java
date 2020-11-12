package com.geektechnique.contactmanager.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
	@NotBlank
	private String ownerEmail;
	
	@NotBlank
	private String contactName;
	
	@NotBlank
	private String contactEmail;

	public Contact(@NotBlank @JsonProperty("owner_user_name") String ownerEmail, @NotBlank @JsonProperty("contact_name") String contactName, @NotBlank @JsonProperty("contact_email") String contactEmail) {
		super();
		this.ownerEmail = ownerEmail;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	

}
