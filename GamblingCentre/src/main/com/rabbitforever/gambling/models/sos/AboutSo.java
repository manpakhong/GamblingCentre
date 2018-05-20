package com.rabbitforever.gambling.models.sos;

import java.util.Date;

import com.rabbitforever.gambling.models.eos.AboutEo;

public class AboutSo extends AboutEo implements So
{
	public AboutSo() {
		
	}
	public AboutSo(Integer id, String name, String version, String createDate, String updateDate, String createdBy,
			String updatedBy, String remarks) {
		super(id, name, version, createDate, updateDate, createdBy, updatedBy, remarks);
	}
	protected Date createDateTimeFrom;
	protected Date createDateTimeTo;
	protected Date lastModifyDateTimeFrom;
	protected Date lastModifyDateTimeTo;
	@Override
	public void setCreateDateTimeFrom(Date createDateTimeFrom){
		this.createDateTimeFrom = createDateTimeFrom;
	}
	@Override
	public void setCreateDateTimeTo(Date createDateTimeTo){
		this.createDateTimeTo = createDateTimeTo;
	}
	@Override
	public void setLastModifyDateTimeFrom(Date lastModifyDateTimeFrom){
		this.lastModifyDateTimeFrom = lastModifyDateTimeFrom;
	}
	@Override
	public void setLastModifyDateTimeTo(Date lastModifyDateTimeTo){
		this.lastModifyDateTimeTo = lastModifyDateTimeTo;
	}
	@Override
	public Date getCreateDateTimeFrom(){
		return this.createDateTimeFrom;
	}
	@Override
	public Date getCreateDateTimeTo(){
		return this.createDateTimeTo;
	}
	@Override
	public Date getLastModifyDateTimeFrom(){
		return this.lastModifyDateTimeFrom;
	}
	@Override
	public Date getLastModifyDateTimeTo(){
		return this.lastModifyDateTimeTo;
	}
}
