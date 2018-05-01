package com.rabbitforever.gambling.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.gambling.models.eos.AboutEo;
import com.rabbitforever.gambling.models.sos.AboutSo;
public class AboutDao extends DaoBase<AboutEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private final String SELECT_SQL=
			"select " + 
			"id " + 
			",name " + 
			",version " + 
			",create_date " + 
			",update_date " + 
			",created_by " + 
			",updated_by " + 
			",remarks " + 
			"from gbl_about ";
	private final String INSERT_SQL=
			"insert " + 
			"into " + 
			"gbl_about " + 
			"( " + 
			"id " + 
			",name " + 
			",version " + 
			",create_date " + 
			",update_date " + 
			",created_by " + 
			",updated_by " + 
			",remarks " + 
			") " + 
			"values" + 
			"( " + 
			"? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			") ";
	private final String UPDATE_SQL=
			"update " + 
			"gbl_about " + 
			"set " + 
			"id= ? " + 
			",name= ? " + 
			",version= ? " + 
			",create_date= ? " + 
			",update_date= ? " + 
			",created_by= ? " + 
			",updated_by= ? " + 
			",remarks= ? " + 
			"where xxx = ? ";
	private final String DELETE_SQL=
			"delete " + 
			"from " + 
			"gbl_about " + 
			"where xxx = ? ";
	private String getClassName(){
		return this.getClass().getName();
	}
	public AboutDao() throws Exception {
		super();
	}
	public AboutDao(String connectionType) throws Exception {
		super(connectionType);
	}
	@Override
	public List<AboutEo> read(Object so) throws Exception{
		List<AboutEo> aboutEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof AboutSo == false) {
				throw new Exception("so is not an instanceof AboutSo");
			}
			AboutSo aboutSo = (AboutSo) so;
			whereSql = new StringBuilder();
			int wcount = 0;
			if(aboutSo.getId() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("id = ? ");
			}
			if(aboutSo.getName() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("name = ? ");
			}
			if(aboutSo.getVersion() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("version = ? ");
			}
			if(aboutSo.getCreateDate() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("create_date = ? ");
			}
			if(aboutSo.getUpdateDate() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("update_date = ? ");
			}
			if(aboutSo.getCreatedBy() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("created_by = ? ");
			}
			if(aboutSo.getUpdatedBy() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("updated_by = ? ");
			}
			if(aboutSo.getRemarks() != null){
				if (wcount == 0) {
					whereSql.append("where ");
				}
				 else if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("remarks = ? ");
			}
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_SQL + whereSql.toString());
			if(aboutSo.getId() != null){
				preparedStatement.setInt(pcount, aboutSo.getId());
				pcount++;
			}
			if(aboutSo.getName() != null){
				preparedStatement.setString(pcount, aboutSo.getName());
				pcount++;
			}
			if(aboutSo.getVersion() != null){
				preparedStatement.setString(pcount, aboutSo.getVersion());
				pcount++;
			}
			if(aboutSo.getCreateDate() != null){
				preparedStatement.setString(pcount, aboutSo.getCreateDate());
				pcount++;
			}
			if(aboutSo.getUpdateDate() != null){
				preparedStatement.setString(pcount, aboutSo.getUpdateDate());
				pcount++;
			}
			if(aboutSo.getCreatedBy() != null){
				preparedStatement.setString(pcount, aboutSo.getCreatedBy());
				pcount++;
			}
			if(aboutSo.getUpdatedBy() != null){
				preparedStatement.setString(pcount, aboutSo.getUpdatedBy());
				pcount++;
			}
			if(aboutSo.getRemarks() != null){
				preparedStatement.setString(pcount, aboutSo.getRemarks());
				pcount++;
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (aboutEoList == null){
					aboutEoList = new ArrayList<AboutEo>();
				}
				AboutEo eo = new AboutEo();
				Integer id = rs.getInt("id");
				eo.setId(id);
				String name = rs.getString("name");
				eo.setName(name);
				String version = rs.getString("version");
				eo.setVersion(version);
				String createDate = rs.getString("create_date");
				eo.setCreateDate(createDate);
				String updateDate = rs.getString("update_date");
				eo.setUpdateDate(updateDate);
				String createdBy = rs.getString("created_by");
				eo.setCreatedBy(createdBy);
				String updatedBy = rs.getString("updated_by");
				eo.setUpdatedBy(updatedBy);
				String remarks = rs.getString("remarks");
				eo.setRemarks(remarks);
				aboutEoList.add(eo);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}
		return aboutEoList;
	} // end select function
	@Override
	public Integer create(AboutEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			if(eo.getId() != null){
				preparedStatement.setInt(pcount, eo.getId());
				pcount++;
			}
			if(eo.getName() != null){
				preparedStatement.setString(pcount, eo.getName());
				pcount++;
			}
			if(eo.getVersion() != null){
				preparedStatement.setString(pcount, eo.getVersion());
				pcount++;
			}
			if(eo.getCreateDate() != null){
				preparedStatement.setString(pcount, eo.getCreateDate());
				pcount++;
			}
			if(eo.getUpdateDate() != null){
				preparedStatement.setString(pcount, eo.getUpdateDate());
				pcount++;
			}
			if(eo.getCreatedBy() != null){
				preparedStatement.setString(pcount, eo.getCreatedBy());
				pcount++;
			}
			if(eo.getUpdatedBy() != null){
				preparedStatement.setString(pcount, eo.getUpdatedBy());
				pcount++;
			}
			if(eo.getRemarks() != null){
				preparedStatement.setString(pcount, eo.getRemarks());
				pcount++;
			}
			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("insert failed! affectedRow=" + noOfAffectedRow);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}
		return noOfAffectedRow;
	} // end create function
	@Override
	public Integer update(AboutEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			if(eo.getId() != null){
				preparedStatement.setInt(pcount, eo.getId());
				pcount++;
			}
			if(eo.getName() != null){
				preparedStatement.setString(pcount, eo.getName());
				pcount++;
			}
			if(eo.getVersion() != null){
				preparedStatement.setString(pcount, eo.getVersion());
				pcount++;
			}
			if(eo.getCreateDate() != null){
				preparedStatement.setString(pcount, eo.getCreateDate());
				pcount++;
			}
			if(eo.getUpdateDate() != null){
				preparedStatement.setString(pcount, eo.getUpdateDate());
				pcount++;
			}
			if(eo.getCreatedBy() != null){
				preparedStatement.setString(pcount, eo.getCreatedBy());
				pcount++;
			}
			if(eo.getUpdatedBy() != null){
				preparedStatement.setString(pcount, eo.getUpdatedBy());
				pcount++;
			}
			if(eo.getRemarks() != null){
				preparedStatement.setString(pcount, eo.getRemarks());
				pcount++;
			}
			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("update failed! affectedRow=" + noOfAffectedRow);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}
		return noOfAffectedRow;
	} // end update function
	@Override
	public Integer delete(AboutEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			if(eo.getId() != null){
				preparedStatement.setInt(pcount, eo.getId());
				pcount++;
			}
			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("delete failed! affectedRow=" + noOfAffectedRow);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".delete() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}
		return noOfAffectedRow;
	} // end delete function
} //end class
