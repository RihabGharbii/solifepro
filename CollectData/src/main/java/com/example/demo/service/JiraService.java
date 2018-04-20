package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

@Service
public class JiraService {
	public String jiraService() {
		

		String auth = new String(Base64.encode("mohamedamine.ouertatani@ensi-uma.tn:30101994Amine"));
		Client client = Client.create();
		WebResource webResource = client.resource("https://amine789.atlassian.net/rest/api/2/project");
		ClientResponse response = webResource
				.header("Authorization","Basic "+ auth)
		    .type("application/json")
		    .accept("application/json")
		    .get(ClientResponse.class);
		String res = response.getEntity(String.class);
	return res;
	}
}
