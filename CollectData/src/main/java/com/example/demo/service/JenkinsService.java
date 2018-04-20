package com.example.demo.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.Jenkinsresult;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildResult;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

@Service
public class JenkinsService {
	/*List<Build> builds= job.getAllBuilds();
	for(int i =0; i<builds.size(); i++) {
		builds.get(i).getTestReport().getTotalCount();
	}*/
	public Jenkinsresult jenkins() throws URISyntaxException, IOException {
		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:9090/"), "amine789", "30101994Amine");
		Map<String, Job> jobs = jenkins.getJobs();
		JobWithDetails job = jobs.get("pfeprojet").details();
		
		List<Build> builds= job.getAllBuilds();
		String b =builds.toString() ;
		 Jenkinsresult jesre = new Jenkinsresult();
		 jesre.setName(job.getName());
		 jesre.setBuild(b);
		 return jesre;
}
	public List<Jenkinsresult> Builds () throws IOException, URISyntaxException {
		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:9090/"), "amine789", "30101994Amine");
		Map<String, Job> jobs = jenkins.getJobs();
		JobWithDetails job = jobs.get("pfeprojet").details();
		List<Build> builds= job.getAllBuilds();
		List<Jenkinsresult> descriptions = new ArrayList<>();
		Jenkinsresult jesre = new Jenkinsresult();

		for(int i=0;i<builds.size();i++) {
			jesre.setName(builds.get(i).details().getResult().toString());
			
			descriptions.add(jesre);
		}
		
		return descriptions;
	}
}