package org.iths.mimicTests.sprint2;

import org.junit.Test;

public class TestDummySprint2 {

	/**
	 * Test for storing a request with response and answer directly
	 */
	@Test
	public void test() {
		DummySprint2 mock = new DummySprint2();
		String response = mock.sendGetRequest("localhost:8080/1+1?storeRequest=2");
		System.out.println(response);
	}
	
	/**
	 * Test for storing a request with the wrong answer and then relearn it.
	 */
	@Test
	public void test2() {
		DummySprint2 mock = new DummySprint2();
		String test = mock.sendGetRequest("localhost:8080/1+1?storeRequest=3");
		String response = mock.sendGetRequest("localhost:8080/1+1?learn");
		System.out.println(response);
	}
	
	/**
	 * Test for storing a request and then checking that we can ask that question.
	 */
	@Test
	public void test3() {
		DummySprint2 mock = new DummySprint2();
		String test = mock.sendGetRequest("localhost:8080/1+1?storeRequest=2");
		String response = mock.sendGetRequest("localhost:8080/1+1");
		System.out.println(response);
	}

}
