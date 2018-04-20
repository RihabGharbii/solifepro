package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.JiraService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/")
public class JiraController {
	@Autowired
	private JiraService jiraService ;
	@RequestMapping(value="/jira",method=RequestMethod.GET)
	public String getReultJira() {
		return jiraService.jiraService();
	}
}
