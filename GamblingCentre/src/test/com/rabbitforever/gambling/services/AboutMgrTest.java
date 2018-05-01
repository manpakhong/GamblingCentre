package com.rabbitforever.gambling.services;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.rabbitforever.gambling.daos.DaoBase;
import com.rabbitforever.gambling.models.eos.AboutEo;
import com.rabbitforever.gambling.models.sos.AboutSo;


public class AboutMgrTest {

	@Test
	public void testRead() {
		try {
			AboutMgr mgr = new AboutMgr(DaoBase.CONNECTION_TYPE_JDBC);
			AboutSo so = new AboutSo();
			
			List<AboutEo> aboutEoList = mgr.read(so);
			Assert.assertTrue(aboutEoList != null && aboutEoList.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
