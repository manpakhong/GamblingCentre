package com.rabbitforever.gambling.factories;

import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rabbitforever.gambling.models.eos.AboutEo;
import com.rabbitforever.gambling.utils.HibernateUtils;

public class DbUtilsFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		HibernateUtils hibernateUtils = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			hibernateUtils = DbUtilsFactory.getInstanceOfHibernateUtils();
			sessionFactory = hibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			List<AboutEo> aboutEoList = (List<AboutEo>) session.createQuery("from " + AboutEo.class.getName()).getResultList();
			for (AboutEo aboutEo: aboutEoList) {
				System.out.println(aboutEo.getName());
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		} finally {
			if(hibernateUtils != null) {
				hibernateUtils = null;
			}
		}
	} 
	@Test
	public void testCriteria() {
		HibernateUtils hibernateUtils = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<AboutEo> query = null;
		Transaction trans = null;
		Root<AboutEo> root = null;
		Query<AboutEo> q = null;
		List<AboutEo> aboutEoList = null;
		try {
			hibernateUtils = DbUtilsFactory.getInstanceOfHibernateUtils();
			sessionFactory = hibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
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
			trans.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
			trans.rollback();
		} finally {
			if(hibernateUtils != null) {
				hibernateUtils = null;
			}
		}
	}
}
