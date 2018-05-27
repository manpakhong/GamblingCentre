package com.rabbitforever.gambling.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.gambling.daos.AboutDao;
import com.rabbitforever.gambling.daos.AboutHDao;
import com.rabbitforever.gambling.daos.DaoBase;
import com.rabbitforever.gambling.models.eos.AboutEo;
public class AboutMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private DaoBase<AboutEo> dao;
	
	
	private String getClassName(){
		return this.getClass().getName();
	}
	public AboutMgr() throws Exception{
		try{
			init(null);
		} catch (Exception e){
			logger.error(getClassName() + ".AboutMgr() - connectionType=null", e);
			throw e;
		}
	} // end constructor
	public AboutMgr(String connectionType) throws Exception{
		try{
			init(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + ".AboutMgr() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public void init(String connectionType) throws Exception{
		try{
			if (connectionType.equals(CONNECTION_TYPE_HIBERNATE)) {
				dao = new AboutHDao();
			} else {
				dao = new AboutDao(connectionType);
			}
		} catch (Exception e){
			logger.error(getClassName() + "init() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public List<AboutEo> read(Object so) throws Exception{
		List<AboutEo> gblAboutEoList = null;
		try{
			gblAboutEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return gblAboutEoList;
	} // end select function
	public Integer create(AboutEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.create(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
	public Integer update(AboutEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.update(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".update() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
	public Integer delete(AboutEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.delete(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".delete() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
} //end class
