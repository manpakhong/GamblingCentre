package com.rabbitforever.gambling.daos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rabbitforever.gambling.models.eos.AboutEo;
import com.rabbitforever.gambling.models.sos.AboutSo;
import com.rabbitforever.gambling.services.AboutMgr;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
public class AboutHDaoTest {

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
		try {
			AboutHDao dao = new AboutHDao();
			AboutSo so = new AboutSo();
			so.setId(1);
			List<AboutEo> aboutEoList = dao.read(so);
			Assert.assertTrue(aboutEoList != null && aboutEoList.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
