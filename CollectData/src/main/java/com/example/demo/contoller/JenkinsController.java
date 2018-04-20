package com.example.demo.contoller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Jenkinsresult;
import com.example.demo.service.JenkinsService;
import com.offbytwo.jenkins.model.Build;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/")
public class JenkinsController {
@Autowired
private JenkinsService jenkinService;
@RequestMapping(value="/jenkins",method=RequestMethod.GET)
public Jenkinsresult jenkinsResult() throws URISyntaxException, IOException {
	
	 return jenkinService.jenkins();
	}
@RequestMapping(value="/jenkinsBuild",method=RequestMethod.GET)
public List<Jenkinsresult> getBuilds() throws IOException, URISyntaxException {
	return jenkinService.Builds();
}
}
