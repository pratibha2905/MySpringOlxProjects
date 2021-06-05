package com.Olxmasterdata.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="This is status Details")
public class Status {
	@ApiModelProperty(value=" This is status id")
	private int id;
	@ApiModelProperty(value=" This is status name")
	private String Statusname;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the statusname
	 */
	public String getStatusname() {
		return Statusname;
	}
	/**
	 * @param statusname the statusname to set
	 */
	public void setStatusname(String statusname) {
		Statusname = statusname;
	}
	

}
