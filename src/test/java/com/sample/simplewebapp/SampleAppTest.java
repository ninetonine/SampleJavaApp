package com.sample.simplewebapp;

import javax.ws.rs.core.Response;

import junit.framework.TestCase;

import org.junit.Test;

public class SampleAppTest extends TestCase {

	@Test
	public void testGetMsg() {
		SampleApp app = new SampleApp();
		Response response = app.getMsg("itari");
		assertEquals(200, response.getStatus());
		assertEquals("Hello: itari", response.getEntity().toString());
	}
}
