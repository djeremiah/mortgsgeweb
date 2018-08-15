package org.jbpm.spring.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jbpm.spring.model.Activity;
import org.jbpm.spring.model.Task;
import org.kie.api.task.model.Status;
import org.kie.internal.KieInternalServices;
import org.kie.internal.process.CorrelationKey;
import org.kie.internal.process.CorrelationKeyFactory;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.definition.QueryDefinition;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.api.model.instance.TaskSummary;
import org.kie.server.api.model.instance.VariableInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.QueryServicesClient;
import org.kie.server.client.UserTaskServicesClient;
import org.kie.server.client.admin.UserTaskAdminServicesClient;

import com.myspace.mortgage_app.Application;






public class PAMClient {
	
	private static final String QUERY_NAME = "getAllTasks";
	
	private static String serverUrl ;
	private static String user ;
	private static String password;
	private static String containerId;
	private static String taskUser;
	private static String taskUserpassword;
	static {
		serverUrl = System.getProperty("serverUrl", "http://localhost:8080/kie-server/services/rest/server");
		user = System.getProperty("user", "rhpamAdmin");
		password = System.getProperty("password", "jboss123$");
		containerId = System.getProperty("containerId", "mortgage-process_2.0.0");
		taskUser = System.getProperty("taskUser", "adminUser");
		taskUserpassword = System.getProperty("taskUserpassword", "RedHat");
	}

	public static void main(String[] s){
		
		PAMClient el = new PAMClient();
		
		try {
			//el.startProcess(null, "+16083584153", "jpaulraj@redhat.com");
			el.getMortgageInstances();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//el.execute();
		//el.payload();
	        
	}
	public void sendSignal(long id, String event){
			String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
			String user = "rhpamAdmin";
	     
			String password = "jboss123$";
			String containerId = "NotificationProcess";
	        KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	        ProcessServicesClient processServiceClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
	        processServiceClient.signalProcessInstance(containerId, id, "customerResponse", event);
	}
	public List<ProcessInstance> getMortgageInstances() {
		
			//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    	//String user = "rhpamAdmin";
	     
	       	//String password = "jboss123$";
	       //String containerId = "mortgage-process_2.0.0";
	        KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	        //ProcessServicesClient processServiceClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
	        QueryServicesClient queryClient  = kieServicesClient.getServicesClient(QueryServicesClient.class);
	        //processServiceClient.findProcessInstances(containerId, page, pageSize);
	        //List<ProcessInstance> instances  = queryClient.findProcessInstances(0, 10);
	        List<Integer> status = new ArrayList<Integer>();
	        status.add(org.kie.api.runtime.process.ProcessInstance.STATE_ABORTED);
	        status.add(org.kie.api.runtime.process.ProcessInstance.STATE_ACTIVE);
	        status.add(org.kie.api.runtime.process.ProcessInstance.STATE_COMPLETED);
	        status.add(org.kie.api.runtime.process.ProcessInstance.STATE_PENDING);
	        status.add(org.kie.api.runtime.process.ProcessInstance.STATE_SUSPENDED);

	        
	        List<ProcessInstance> instances  = queryClient.findProcessInstancesByContainerId(containerId, status, 0, 30);
	        System.out.println("# of instances" + instances.size() );
	        for (Iterator iterator = instances.iterator(); iterator.hasNext();) {
				ProcessInstance processInstance = (ProcessInstance) iterator.next();
				System.out.println("status"  + processInstance.getState());
				System.out.println("id"  + processInstance.getId());
				System.out.println("name"  + processInstance.getProcessName());
			
			}
	        return instances;
	}
	
	public void processTask(String id , String Status) {
		
		long tid = Long.parseLong(id);
		KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
		UserTaskServicesClient userService = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		
		if("Ready".equals(Status)) {
			claimTask( tid);
			startTask( tid);
			completeTask( tid);
		}else if("Reserved".equals(Status)){
			startTask( tid);
			completeTask( tid);
		
		}else if("InProgress".equals(Status)){
			//userService.startTask(containerId, tid, userId);
			completeTask( tid);
	}
		//claim(containerId, tid, userId);
		
		
	}
	public void claimTask(long tid) {
		KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
		UserTaskServicesClient userService = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	
		userService.claimTask(containerId, tid, user);
	}
	
	public void completeTask(long tid) {
		KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
		UserTaskServicesClient userService = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		Map<String, Object> par = new HashMap<String, Object>();
		par.put("inlimit",  new Boolean(false));
		userService.completeTask(containerId, tid, user,par);
	}
	public void startTask(long tid) {
		KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
		UserTaskServicesClient userService = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	
		userService.startTask(containerId, tid, user);
	}
public List<Task> getTasks() {
		
			//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    	//String user = "rhpamAdmin";
	     
	       	//String password = "jboss123$";
	       //String containerId = "mortgage-process_2.0.0";
	        KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	       // ProcessServicesClient processServiceClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
	        QueryServicesClient queryClient =  kieServicesClient.getServicesClient(QueryServicesClient.class);
	        //String wid = "Mortgage_Process.MortgageApprovalProcess";
	       QueryDefinition queryDefinition =  queryClient.getQuery(QUERY_NAME);
	       
	       if(queryDefinition==null) {
	    	   queryDefinition  = QueryDefinition.builder().name(QUERY_NAME)
					.expression("select * from Task t where t.processid='Mortgage_Process.MortgageApprovalProcess'")
					.source("java:jboss/datasources/ExampleDS")
					.target("TASK").build();
	       queryClient.getQuery(QUERY_NAME);
	       queryClient.registerQuery(queryDefinition);
	       }
			// getister the query
	      
			
			// executes the query

			List<TaskInstance> query = queryClient.query(QUERY_NAME, QueryServicesClient.QUERY_MAP_TASK, 0, 100, TaskInstance.class);
			System.out.println( "no of tasks" + query.size() );
			List<Task> tasklist = new ArrayList<Task>();
			for (TaskInstance taskInstance : query) {
				System.out.println("task infor " + taskInstance.getName());
				System.out.println("task infor " + taskInstance.getId());
				System.out.println("task infor " + taskInstance.getStatus());
		        
		    	Task task = new Task();
				task.setCaseId(taskInstance.getProcessInstanceId());
				task.setDescription(taskInstance.getName());
				task.setId(taskInstance.getId());
				task.setStatus(taskInstance.getStatus());
				task.setActualOwnerId(taskInstance.getActualOwner());
				tasklist.add(task);

			}

	        return tasklist;
}

	public void startMortgageProcess(Map<String,Object> param ) {
			//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    	//String user = "rhpamAdmin";
	     
	       //String password = "jboss123$";
	       //String containerId = "mortgage-process_2.0.0";
	       KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	       ProcessServicesClient processServiceClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
	       
	       long pid = processServiceClient.startProcess(containerId, "Mortgage_Process.MortgageApprovalProcess",param);
	       System.out.println("\t######### Process instance" + pid);
	}
	
	public long startProcess(Object event,String phone,String email) throws UnsupportedEncodingException{
			//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    	//String user = "rhpamAdmin";
	     
	       	//String password = "jboss123$";
	       	String containerId = "NotificationProcess";
	        KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	        ProcessServicesClient processServiceClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
	       // Account acount = event.getAccount() ;
	        String accountId = null ;//;event.getAccountId();
	        String message = URLEncoder.encode("Your address have been changed multiple time with in a few minutes. Please enter Yes to confirm that the changes were made by you or No", "UTF-8");
	        
	        Map param =new HashMap();
	        param.put("accountId", accountId);
	       
	        param.put("email", email);
	        param.put("mphone", phone);
	        param.put("message", message);
	        //CorrelationKeyFactory factory = KieInternalServices.Factory.get().newCorrelationKeyFactory(); 
	        
	       // CorrelationKey key  = factory.newCorrelationKey(accountId);
	        
	        //long pid = processServiceClient.startProcess(containerId, "NotificationProcess.NotificationProcess", key,param);
	        long pid = processServiceClient.startProcess(containerId, "NotificationProcess.NotificationProcess",param);
	       
	        System.out.println("\t######### Process instance" + pid);
	        return pid;
	       
	}
	
	public Application getVariableValue(long piid, String varName) {
		
		//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    //String user = "rhpamAdmin";
	    //String password = "jboss123$";
	    //String containerId = "mortgage-process_2.0.0";
	    KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	    ProcessServicesClient processServiceClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
	   
	    Application application = processServiceClient.getProcessInstanceVariable(containerId, piid, varName, Application.class);

	    return application;
	}
public Application getVariable(long piid, String varName,String status) {
		
		//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    //String user = "rhpamAdmin";
	    //String password = "jboss123$";
	    //String containerId = "mortgage-process_2.0.0";
	    KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
        QueryServicesClient queryClient  = kieServicesClient.getServicesClient(QueryServicesClient.class);
        List<VariableInstance> instance = queryClient.findVariableHistory(piid, varName, 0, 10);
     
	    Application application = null;//queryClient.(containerId, piid, varName, Application.class);

	    return application;
	}
	public List<Activity> getTaskInfo(long id){
		//String serverUrl = "http://localhost:8080/kie-server/services/rest/server";
	    //String user = "rhpamAdmin";
	    //String password = "jboss123$";
	    //String containerId = "mortgage-process_2.0.0";
	    List<String> status = new ArrayList<String>();
	      status.add("Reserved");
	      status.add("InProgress");
	      status.add("Created");
	      status.add("Ready");
	      status.add("Completed");
	    KieServicesClient  kieServicesClient = PAMClient.configure(serverUrl, user, password);
	    UserTaskServicesClient userTaskServicesClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	    List<TaskSummary> taskSummary = userTaskServicesClient.findTasksByStatusByProcessInstanceId(id, status, 0, 10);
	    List<Activity> activites = new ArrayList<Activity>();
	    for (Iterator iterator = taskSummary.iterator(); iterator.hasNext();) {
			TaskSummary taskSummary2 = (TaskSummary) iterator.next();
			String owner = taskSummary2.getActualOwner();
			Long taskId = taskSummary2.getId();
			Activity activity = new Activity();
			activity.setName(taskSummary2.getName());
			activity.setStatus(taskSummary2.getStatus().toString());
			activity.setDate(taskSummary2.getCreatedOn().toString());
			activity.setUser(owner);
			activity.setTaskId(taskId);
			activites.add(activity);
			
	    }
		return activites;
	    
	}
	/*public void payload(){
		String serverUrl = "http://localhost:8080/kie-execution-server/services/rest/server";
	    String user = "rhdmAdmin";
	     
	       String password = "jboss123$";
	       String containerId = "dm7test";
	       KieServicesClient  kieServicesClient = Mortgage.configure(serverUrl, user, password);
	        RuleServicesClient ruleClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
	        KieCommands commandsFactory =
	         		KieServices.Factory.get().getCommands();
	        EligibilityCriteria eligiblity = new EligibilityCriteria();
	        eligiblity.setCritrria("BMI");
	        eligiblity.setValue(151);
	        Command<?> insertEmp = commandsFactory.newInsert(eligiblity, "eligibilityResponse");
	        
	        Command<?> fireAllRules = commandsFactory.newFireAllRules();
	        Command<?> batchCommand =
	      			 commandsFactory.newBatchExecution(Arrays.asList(insertEmp,fireAllRules));
	        Marshaller marshaller = MarshallerFactory.getMarshaller( MarshallingFormat.JSON, getClass().getClassLoader() );
	        String result = marshaller.marshall( batchCommand );
	        //String result = BatchExecutionHelper.newXStreamMarshaller().toXML(batchCommand);
	      //  String result = BatchExecutionHelper.newJSonMarshaller().toXML(batchCommand);
	        		//newJSonMarshaller().toXML(batchCommand);

        
	}*/
public static KieServicesClient configure(String url, String username, String password) {
		
		//default marshalling format is JAXB
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(url, username, password);
		
	
		config.setMarshallingFormat(MarshallingFormat.XSTREAM);
		//config.setMarshallingFormat(MarshallingFormat.JSON);
		return KieServicesFactory.newKieServicesClient(config);
		//
	}


}
