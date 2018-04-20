package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.sonarqube.ws.Issues.Issue;
import org.sonarqube.ws.client.HttpConnector;
import org.sonarqube.ws.client.WsClient;
import org.sonarqube.ws.client.WsClientFactories;
import org.sonarqube.ws.client.HttpConnector.Builder;
import org.sonarqube.ws.client.issue.SearchWsRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class SonarService {
	public String sonar()  {
		
		
		
		
		
		 Builder builder = HttpConnector.newBuilder();

		    builder.url("http://127.0.0.1:9000/sonar/");

		    builder.connectTimeoutMilliseconds(10000);

		    HttpConnector httpConnector = builder.build();

		    SearchWsRequest searchWsRequest = new org.sonarqube.ws.client.issue.SearchWsRequest();

		    List<String> projectKeys = new ArrayList<String>(1);

		    projectKeys.add("");

		    searchWsRequest.setProjectKeys(projectKeys);

		    final WsClient wsClient = WsClientFactories.getDefault().newClient(httpConnector);
		    List<Issue> issues = wsClient.issues().search(searchWsRequest).getIssuesList();
		    
		     return issues.toString() ;
	}

	public String sonarpfe () throws IOException {
		
		HttpGet httpGet = new HttpGet("http://127.0.0.1:9000/sonar/api/issues/search");
	    try(CloseableHttpClient httpClient = HttpClients.createDefault();
	        CloseableHttpResponse response = httpClient.execute(httpGet);) {
	        HttpEntity entity = response.getEntity();
	        return EntityUtils.toString(entity);
	    }}
	    
	    public String sonarmetric () throws IOException {
			
	    	HttpGet httpGet = new HttpGet("http://127.0.0.1:9000/sonar/api/measures/component?componentKey=java-sonar-runner-simple&metricKeys=ncloc,coverage,bugs,vulnerabilities");
	        try(CloseableHttpClient httpClient = HttpClients.createDefault();
	            CloseableHttpResponse response = httpClient.execute(httpGet);) {
	            HttpEntity entity = response.getEntity();
	            return EntityUtils.toString(entity);
	        
		    }
	}
}
