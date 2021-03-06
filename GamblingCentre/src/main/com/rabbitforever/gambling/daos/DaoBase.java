package com.rabbitforever.gambling.daos;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.common.factories.UtilsFactory;
import com.rabbitforever.common.utils.DateUtils;
import com.rabbitforever.common.utils.MiscUtils;
import com.rabbitforever.gambling.factories.DbUtilsFactory;
import com.rabbitforever.gambling.utils.DbUtils;
import com.rabbitforever.gambling.utils.HibernateUtils;

public abstract class DaoBase <T>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	public final static String CONNECTION_TYPE_JDBC = "jdbc";
	public final static String CONNECTION_TYPE_JNDI = "jndi";
	public final static String CONNECTION_TYPE_HIBERNATE = "hibernate";
	protected DbUtilsFactory dbUtilsFactory;
	protected DbUtils dbUtils;
	protected HibernateUtils hibernateUtils;
	protected DateUtils dateUtils;
	protected UtilsFactory generalUtilsFactory;
	protected MiscUtils miscUtils;
	protected Connection connection;
	protected String connectionType;
	protected Session session;
	private String getClassName() {
		String className = this.getClass().getName();
		return className;
	}
	public DaoBase() throws Exception {
		try {
			init();
		} catch (Exception e) {
			logger.error(getClassName() + ".DaoBase() - ", e);
			throw e;
		}
	}

	public DaoBase(String connectionType) throws Exception {
		try {
			init(connectionType);
		} catch (Exception e) {
			logger.error(getClassName() + ".DaoBase() - connectionType=" + connectionType, e);
			throw e;
		}
	}
	public void init() throws Exception {
		try {
			init(null);
		} catch (Exception e) {
			logger.error(getClassName() + ".init() - connectionType=" + connectionType, e);
			throw e;
		}
	}
	public void init(String connectionType) throws Exception {
		try {
			dbUtilsFactory = DbUtilsFactory.getInstanceOfDbUtilsFactory();
			dbUtils = dbUtilsFactory.getInstanceOfMySqlDbUtils();
			hibernateUtils = dbUtilsFactory.getInstanceOfHibernateUtils();
			generalUtilsFactory = UtilsFactory.getInstance();
			miscUtils = generalUtilsFactory.getInstanceOfMiscUtils();
			dateUtils = generalUtilsFactory.getInstanceOfDateUtils();
			if (connectionType == null) {
				this.connectionType = CONNECTION_TYPE_JNDI;
			} else {
				this.connectionType = connectionType;
			}
			
			if (this.connectionType.equals(CONNECTION_TYPE_JDBC)) {

				connection = dbUtils.getConnection();
			} else if (this.connectionType.equals(CONNECTION_TYPE_JNDI)) {
				Context initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/MyLocalDB");
				connection = ds.getConnection();
			} else if (this.connectionType.equals(CONNECTION_TYPE_HIBERNATE)) {
				SessionFactory sessionFactory = hibernateUtils.getSessionFactory();
				session = sessionFactory.getCurrentSession();
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".init() - connectionType=" + connectionType, e);
			throw e;
		}
	}
	public abstract List<T> read(Object so) throws Exception;
	public abstract Integer create(T eo) throws Exception;
	public abstract Integer update(T eo) throws Exception;
	public abstract Integer delete(T eo) throws Exception;

	
}
