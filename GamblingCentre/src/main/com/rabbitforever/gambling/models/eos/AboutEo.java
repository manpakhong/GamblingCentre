package com.rabbitforever.gambling.models.eos;

import javax.persistence.Column;
import javax.persistence.Id;

public class AboutEo {
	protected Integer id;
	protected String name;
	protected String version;
	protected String createDate;
	protected String updateDate;
	protected String createdBy;
	protected String updatedBy;
	protected String remarks;
	public AboutEo() {
		
	}
	public AboutEo(Integer id, String name, String version, String createDate, String updateDate, String createdBy,
			String updatedBy, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.remarks = remarks;
	}
	@Id
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name", length = 50, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "version", length = 255, nullable = true)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	@Column(name = "create_date", nullable = true)
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Column(name = "update_date", nullable = true)
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Column(name = "created_by", length = 255, nullable = true)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "updated_by", length = 255, nullable = true)
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name = "remarks", length = 255, nullable = true)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
