package br.com.interfile.interflow.core.commons.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.logging.log4j.Level;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.impl.util.json.JSONArray;
import org.camunda.bpm.engine.impl.util.json.JSONObject;

import br.com.interfile.interflow.core.exception.BpmException;

public class RestTool {

	private static final String HTTP_GET = "GET";
	private static final String HTTP_POST = "POST";
	private static final String APP_JSON = "application/json";
	private static final String HTTP_ERROR = "Failed : HTTP error code : ";

	/**
	 * 
	 * @param endpoint
	 * @return
	 * @throws Exception
	 */
	public static JSONObject callRestJsonObjectHttpGet(DelegateExecution execution, String endpoint)
			throws BpmException {
		BpmLogger logger = new BpmLogger(RestTool.class.getName(), execution);
		logger.start("callRestJsonObjectHttpGet", execution, endpoint);

		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(endpoint);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(HTTP_GET);
			conn.setRequestProperty("Accept", APP_JSON);

			if (!String.valueOf(conn.getResponseCode()).startsWith("2")) {
				throw new RuntimeException(HTTP_ERROR + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			JSONObject jsonReturn = null;
			while ((output = br.readLine()) != null) {
				jsonReturn = new JSONObject(output);
			}

			return jsonReturn;
		} catch (Exception e) {
			logger.log(Level.ERROR, "endpoint: " + endpoint);
			logger.log(Level.ERROR, "erro inexperado: ", e);
			throw new BpmException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			logger.end();
		}
	}

	/**
	 * 
	 * @param jsonString
	 * @param endpoint
	 * @return
	 * @throws Exception
	 */
	public static JSONObject callRestJsonObjectHttpPost(DelegateExecution execution, JSONObject jsonObject,
			String endpoint) throws BpmException {
		BpmLogger logger = new BpmLogger(RestTool.class.getName(), execution);
		logger.start("callRestJsonObjectHttpPost", execution, jsonObject, endpoint);

		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(endpoint);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(HTTP_POST);
			conn.setRequestProperty("Content-Type", APP_JSON);

			OutputStream os = conn.getOutputStream();
			os.write(jsonObject.toString().getBytes("UTF-8"));
			os.flush();

			if (!String.valueOf(conn.getResponseCode()).startsWith("2")) {
				throw new RuntimeException(HTTP_ERROR + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			JSONObject jsonReturn = null;
			while ((output = br.readLine()) != null) {
				jsonReturn = new JSONObject(output);
			}

			return jsonReturn;
		} catch (Exception e) {
			logger.log(Level.ERROR, "endpoint: " + endpoint);
			logger.log(Level.ERROR, "payload: " + jsonObject.toString());
			logger.log(Level.ERROR, "erro inexperado: ", e);
			throw new BpmException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			logger.end();
		}

	}

	/**
	 * 
	 * @param endpoint
	 * @return
	 * @throws Exception
	 */
	public JSONArray callRestJsonArrayHttpGet(DelegateExecution execution, String endpoint) throws BpmException {
		BpmLogger logger = new BpmLogger(RestTool.class.getName(), execution);
		logger.start("callRestJsonArrayHttpGet", execution, endpoint);

		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(endpoint);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(HTTP_GET);
			conn.setRequestProperty("Accept", APP_JSON);

			if (!String.valueOf(conn.getResponseCode()).startsWith("2")) {
				throw new RuntimeException(HTTP_ERROR + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			JSONArray jsonArray = null;
			while ((output = br.readLine()) != null) {
				jsonArray = new JSONArray(output);
			}

			return jsonArray;
		} catch (Exception e) {
			logger.log(Level.ERROR, "endpoint: " + endpoint);
			logger.log(Level.ERROR, "erro inexperado: ", e);
			throw new BpmException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			logger.end();
		}

	}

	/**
	 * 
	 * @param jsonString
	 * @param endpoint
	 * @return
	 * @throws Exception
	 */
	public JSONArray callRestJsonArrayHttpPost(DelegateExecution execution, JSONObject jsonObject, String endpoint)
			throws BpmException {
		BpmLogger logger = new BpmLogger(RestTool.class.getName(), execution);
		logger.start("callRestJsonArrayHttpPost", execution, jsonObject, endpoint);

		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(endpoint);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(HTTP_POST);
			conn.setRequestProperty("Content-Type", APP_JSON);

			OutputStream os = conn.getOutputStream();
			os.write(jsonObject.toString().getBytes("UTF-8"));
			os.flush();

			if (!String.valueOf(conn.getResponseCode()).startsWith("2")) {
				throw new RuntimeException(HTTP_ERROR + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			JSONArray jsonArray = null;
			while ((output = br.readLine()) != null) {
				jsonArray = new JSONArray(output);
			}

			return jsonArray;
		} catch (Exception e) {
			logger.log(Level.ERROR, "endpoint: " + endpoint);
			logger.log(Level.ERROR, "payload: " + jsonObject.toString());
			logger.log(Level.ERROR, "erro inexperado: ", e);
			throw new BpmException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			logger.end();
		}

	}

}
