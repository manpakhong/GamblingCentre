package com.rabbitforever.gambling.models.sos;

import java.util.Date;

import com.rabbitforever.gambling.models.eos.AboutEo;

public class AboutSo extends AboutEo implements So
{
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
