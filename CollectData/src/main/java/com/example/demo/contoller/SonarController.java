package com.example.demo.contoller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SonarService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/")
public class SonarController {
@Autowired
private SonarService sonarService ;
@RequestMapping(value="/sonar",method=RequestMethod.GET)
public String sonarresult()  {

return sonarService.sonar();


}
@RequestMapping(value="/sonarpfe",method=RequestMethod.GET)
public String getsonarResult () throws IOException {
	return sonarService.sonarpfe();
}
@RequestMapping(value="/sonarMetric",method=RequestMethod.GET)
public String getsonarMetric () throws IOException {
	return sonarService.sonarmetric();
}
}
