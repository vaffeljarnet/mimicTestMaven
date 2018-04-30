package org.iths.mimicTests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServiceCaller
{
	private String responseMessage = "";

	private HttpURLConnection connect(String url) {
		HttpURLConnection conn = null;
		try
		{
			URL u = new URL(url);
			conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("GET");

			return conn;
		}
		catch (Exception e)
		{
			responseMessage = "Failed: " + e.toString();
			return null;
		}
	}

	/**
	 * Executes a HTTP GET request
	 * @param url
	 * @return Text returned from the request or error message
	 */
	public String executeGetRequest(String url)
	{
		HttpURLConnection conn = connect(url);
		try
		{
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			StringBuffer result = new StringBuffer();
			for (int i = 0; (line = rd.readLine()) != null; i++)
			{
				if (i > 0)
				{
					result.append("\r\n");
				}
				result.append(line);
			}
			rd.close();

			return result.toString();
		}
		catch (Exception e)
		{
			responseMessage = "Failed: " + e.toString();
			return "Error";
		}
	}

	public String getMimeType(String url) {
		HttpURLConnection conn = connect(url);
		if(conn==null) {
			return "Error";
		}else {		
			String mimeType = conn.getContentType();
			return mimeType;
		}
	}

	/**
	 * @return The response returned from the request
	 */
	public String getResponse()
	{
		return responseMessage;
	}
}
