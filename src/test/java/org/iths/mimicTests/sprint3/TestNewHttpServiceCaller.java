package org.iths.mimicTests.sprint3;

import static org.junit.Assert.*;

import org.iths.mimicTests.HttpServiceCaller;
import org.iths.mimicTests.sprint2.MimicJarHelper;
import org.junit.Test;

public class TestNewHttpServiceCaller {

	private HttpServiceCaller service = new HttpServiceCaller();
	private String host = "https://proud-quasar-201909.appspot.com/";
	private MimicJarHelper helper = new MimicJarHelper();

	@Test
	public void testTextMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=TestTextMime&mime=application/text");
			service.executeGetRequest(host+"TEXT");
			assertEquals("TestTextMime", service.executeGetRequest(host+"TEXT"));
			assertTrue(service.getMimeType(host+"TEXT").contains("application/text;"));
		}else {
			fail(helper.errorString());
		}
	}

	@Test
	public void testHtmlMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=TestHtmlMime&mime=application/html");
			service.executeGetRequest(host+"HTML");
			assertEquals("TestHtmlMime", service.executeGetRequest(host+"HTML"));
			assertTrue(service.getMimeType(host+"HTML").contains("application/html;"));
		}else {
			fail(helper.errorString());
		}
	}

	@Test
	public void testJsonMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=testJsonMime&mime=application/json");
			service.executeGetRequest(host+"JSON");
			assertEquals("testJsonMime", service.executeGetRequest(host+"JSON"));
			assertTrue(service.getMimeType(host+"JSON").contains("application/json;"));
		}else {
			fail(helper.errorString());
		}
	}

	@Test
	public void testXmlMime() {
		if(helper.jarIsRunning()) {
			service.executeGetRequest(host+"learnNextResponse?text=testXmlMime&mime=application/xml");
			service.executeGetRequest(host+"XML");
			assertEquals("testXmlMime", service.executeGetRequest(host+"XML"));
			assertTrue(service.getMimeType(host+"XML").contains("application/xml;"));
		}else {
			fail(helper.errorString());
		}
	}

}
