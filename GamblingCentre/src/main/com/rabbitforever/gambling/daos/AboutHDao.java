package com.rabbitforever.gambling.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.gambling.models.eos.AboutEo;

public class AboutHDao extends DaoBase<AboutEo> {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}
	public AboutHDao() throws Exception {
		super(DaoBase.CONNECTION_TYPE_HIBERNATE);
	}
	@Override
	public List<AboutEo> read(Object so) throws Exception {
		List<AboutEo> aboutEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<AboutEo> query = null;
		Transaction trans = null;
		Root<AboutEo> root = null;
		Query<AboutEo> q = null;
		try{
			trans = session.getTransaction();
			trans.begin();
			builder = session.getCriteriaBuilder();
			query = builder.createQuery(AboutEo.class);
			root = query.from(AboutEo.class);
			Predicate predicate = builder.equal(root.get("id"), 1);
			query.select(root).where(predicate);
			q = session.createQuery(query);
			aboutEoList = q.getResultList();
			for (AboutEo aboutEo: aboutEoList) {
				System.out.println(aboutEo.getName());
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		finally {
			if (trans != null) {
				trans.commit();
				trans = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_HIBERNATE)) {
				if (session != null) {
					session.close();
					session = null;
				}
			}
		}
		return aboutEoList;
	}

	@Override
	public Integer create(AboutEo eo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(AboutEo eo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(AboutEo eo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
