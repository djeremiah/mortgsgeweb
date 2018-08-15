package org.jbpm.spring.web;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.jbpm.spring.model.Activity;
import org.jbpm.spring.model.CaseInstance;
import org.jbpm.spring.model.MortgageDetail;
import org.jbpm.spring.model.Task;
import org.kie.server.api.model.instance.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspace.mortgage_app.Applicant;
import com.myspace.mortgage_app.Application;
import com.myspace.mortgage_app.Property;

@Controller
public class CaseController {

	@Autowired
    private ServletContext servletContext;

	
	@RequestMapping(value = "/creditscore", method = RequestMethod.GET)
	
	public @ResponseBody Integer creditScore(@RequestParam("ssn") Integer ssn) {
		
		int lastDigit = ssn - 10 * ( ssn / 10 );
		int score = 600 + ( lastDigit * 20 );
		
		Integer iscore = Integer.valueOf(score);
		System.out.println( "For ssn " + ssn + ", will return credit score of " + score );
		return iscore;
	
	}
	@RequestMapping(value = "/cases", method = RequestMethod.POST,headers="Accept=application/json",produces={"application/json"})
	
	public @ResponseBody List<CaseInstance> getProcessInstances() {
		System.out.println("in all cases");
		List< CaseInstance>  cases = new ArrayList<CaseInstance>();
		
		PAMClient pamClient;
		
		try {
			pamClient = new PAMClient();
			
			List<ProcessInstance> instances = pamClient.getMortgageInstances();
			 for (Iterator iterator = instances.iterator(); iterator.hasNext();) {
				 
					ProcessInstance processInstance = (ProcessInstance) iterator.next();
					
					Long id = processInstance.getId();
					Integer istatus = processInstance.getState();
					String name = processInstance.getProcessInstanceDescription();
					Date dateCreated = processInstance.getDate();
					String status=null;
					if(istatus==1) {
						status = "Active";
					}if(istatus==3) {
						status="Aborted";
					}if(istatus==2) {
						status = "Completed";
					}
					
					System.out.println("status"  + processInstance.getState());
					System.out.println("id"  + processInstance.getId());
					System.out.println("name"  + processInstance.getProcessName());
					CaseInstance instance = new CaseInstance();
					instance.setId(id);
					instance.setStatus(status);
					instance.setName(name);
					instance.setDateCreated(dateCreated.toString());
					cases.add(instance);
				}
			 
			System.out.println("in all cases" + cases.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return cases;

	}
@RequestMapping(value = "/tasks", method = RequestMethod.POST,headers="Accept=application/json",produces={"application/json"})
	
	public @ResponseBody List<Task> getTasks() {
	PAMClient pamClient = null;
	List<Task> tasks = null;
	try {
		pamClient = new PAMClient();
		tasks = pamClient.getTasks();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return tasks;
}
	@RequestMapping(value = "/newCase", method = RequestMethod.POST )
	public @ResponseBody void newCase(@RequestParam("downpayment") String downpayment,
			@RequestParam("yrsofamortization") String yrsofamortization,
			@RequestParam("name") String name,
			@RequestParam("annualincome") String annualincome,
			@RequestParam("ssn") String ssn,
			@RequestParam("ageofproperty") String ageofproperty,
			@RequestParam("addressofproperty") String addressofproperty ,
			@RequestParam("locale") String locale ,
			@RequestParam("saleprice") String saleprice ,
			@RequestParam("smsMobile") String smsMobile ,
			@RequestParam("contactPhone") String contactPhone ,
			@RequestParam("emailId") String emailId 
			){
		
		Integer iyrsofamortization = Integer.valueOf(yrsofamortization);
		Integer idownpayment = Integer.valueOf(downpayment);
		Integer iageofproperty = Integer.valueOf(ageofproperty); 
		Integer isaleprice = Integer.valueOf(saleprice);  
		Random random = new Random(1000);
		System.out.println("in case");
		String caseId = String.valueOf(random.nextInt());
		Map<String,Object> param = new HashMap<String,Object>();
		PAMClient pamClient;
		ssn = ssn == null || "".equals(ssn) ?  "123456789" : ssn ;
		Integer iannualincome = Integer.valueOf(annualincome);
		//Integer issn = Integer.parseInt(ssn);
		Applicant applicant = new Applicant();
		applicant.setName(name);
		applicant.setSsn(ssn);
		applicant.setAnnualincome(iannualincome);
		Application application = new Application();
		Property property = new Property();
		
		property.setAge(iageofproperty);
		property.setAddress(addressofproperty);
		property.setSaleprice(isaleprice);
		property.setLocale(locale);
		
		application.setAmortization(iyrsofamortization);
		application.setApplicant(applicant);
		application.setDownpayment(idownpayment);
		application.setProperty(property);
		
		param.put("application", application);
		param.put("ssn", ssn);
		param.put("appraisalAddress", addressofproperty);
		
		try {
			pamClient = new PAMClient();
			pamClient.startMortgageProcess(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
@RequestMapping(value = "/processTask", method = RequestMethod.POST,headers="Accept=application/json",produces={"application/json"})
	
	public @ResponseBody void processTask(@RequestParam("id") String id,@RequestParam("status") String status) {
	
		PAMClient pamClient;
		long pid = Long.parseLong(id);
		MortgageDetail detail = null;
		try {
			pamClient = new PAMClient();
			
			pamClient.processTask(id, status);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	@RequestMapping(value = "/caseDetail", method = RequestMethod.POST,headers="Accept=application/json",produces={"application/json"})
	
	public @ResponseBody MortgageDetail showCase(@RequestParam("id") String id,@RequestParam("status") String status) {
	
		PAMClient pamClient;
		long pid = Long.parseLong(id);
		MortgageDetail detail = null;
		try {
			pamClient = new PAMClient();
			Application application = null;
			detail = new MortgageDetail();
			System.out.println("status o case" + status);
			System.out.println("status o case" + pid);
			
			if("Active".equals(status)) {
				application = pamClient.getVariableValue(pid, "application");
			
			 
				Integer prpage =  application.getProperty().getAge();
				String strproage = prpage !=null ? prpage.toString() : "";
				Integer iAnnualIncome = application.getApplicant().getAnnualincome();
				String annualincome = iAnnualIncome != null ? iAnnualIncome.toString() : "";
				Integer idownpayment = application.getDownpayment();
				String downpayment = idownpayment !=null ? idownpayment.toString() : "";
				Integer isaleprice = application.getProperty().getSaleprice();
				String saleprice = isaleprice !=null ? isaleprice.toString() : "";
				Integer yrsofamortization = application.getAmortization();
				String syrsofamortization = yrsofamortization !=null ? yrsofamortization.toString() : "";
				detail.setName(application.getApplicant().getName());
				detail.setAddressofproperty(application.getProperty().getAddress());
				detail.setAgeofproperty(strproage);	
				detail.setAnnualincome(annualincome);
				detail.setDownpayment(downpayment);
				detail.setSaleprice(saleprice);
				detail.setYrsofamortization(syrsofamortization);
				detail.setLocale(application.getProperty().getLocale());
				System.out.println("applicaitn" + prpage);

				List<Activity> activities = pamClient.getTaskInfo(pid);
				System.out.println("actitivties" + activities.size());

				detail.setActivities(activities);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return detail;

	}
	@RequestMapping(value = "/image", method = RequestMethod.POST,produces={"application/json"})
	
	public @ResponseBody String getImage(@RequestParam("id") String id) {

		System.out.println("in image service " + id);
		RestClient service;
		String image = null;
		try {
			service = new RestClient();
			image = service.getImage(id);
			System.out.println("in all cases" + image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return image;
	
	}
@RequestMapping(value = "/imagedisplay", method = RequestMethod.GET,produces={"application/svg+xml"})
	
		
	//public @ResponseBody ResponseEntity<byte[]> getImage1(@RequestParam("id") String id,HttpServletResponse response) {
public @ResponseBody void getImage1(@RequestParam("id") String id,HttpServletResponse response) {
		RestClient service;
		InputStream content = null;
		ResponseEntity<byte[]> responseEntity = null;
		try {
			service = new RestClient();
			content = service.getImageStream(id);
			response.addHeader("Content-disposition", "inline");
			response.setContentType("text/html");
			IOUtils.copy(content, response.getOutputStream());
			response.flushBuffer();

		} catch (Exception e) {
				e.printStackTrace();
		}
        
	}
	
}
