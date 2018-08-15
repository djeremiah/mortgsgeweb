package org.jbpm.spring.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	private static String serverUrl ;
	private static String user ;
	private static String password;
	private static String containerId;
	private static String origHost;
	private static int origport;
	static {
		serverUrl = System.getProperty("serverUrl", "http://localhost:8080/kie-server/services/rest/server");
		user = System.getProperty("user", "rhpamAdmin");
		password = System.getProperty("password", "jboss123$");
		containerId = System.getProperty("containerId", "mortgage-process_2.0.0");
		origHost  = System.getProperty("origHost", "localhost");
		String port = System.getProperty("origport", "8080");
		origport = Integer.parseInt(port);
	}
	public String getImage(String id){
		System.out.println("RestClient-getImage" + id );
		//String deployment = System.getProperties().getProperty("containerId","mortgage-process_2.0.0");

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		Credentials credi = (Credentials) new UsernamePasswordCredentials(user, password);
	    //credsProvider.setCredentials( new AuthScope("localhost", 8080),credi);
		credsProvider.setCredentials( new AuthScope(origHost, origport),credi);
	    CloseableHttpClient httpClient = HttpClients.custom()
	            .setDefaultCredentialsProvider(credsProvider)
	            .build();
	    HttpGet httGet = null;
	    CloseableHttpResponse response1 = null;
	    StringBuilder builder=new StringBuilder();
	    String filename = null;
	    String fileNameIndex = null;
	    String imageurl =  serverUrl+"/containers/"+containerId+"/images/processes/instances/" + id;
	    System.out.println("RestClient-getImage-url" + imageurl );
	    try {
	    	httGet =  new  HttpGet(imageurl);
	    	//httGet.addHeader("content-type", "image");	
	    	response1 = httpClient.execute(httGet);
	    	System.out.println("----------------------------------------");
            System.out.println(response1.getStatusLine());
            StatusLine statusline = response1.getStatusLine();
            int statusCode = statusline.getStatusCode();
            if (statusCode == 200) {
            HttpEntity  entity = response1.getEntity();
            fileNameIndex =  new Random().nextInt() + ".html"; 
            InputStream content=entity.getContent();
            filename = "/Users/jpaulraj/EAP7-1/standalone/deployments/mortgageweb.war/" + fileNameIndex;
            File svgfile = new File(filename);
            OutputStream outputStream = new FileOutputStream(svgfile);
            IOUtils.copy(content, outputStream);
            outputStream.close();
        
            }
            System.out.println("rest output" + filename);
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      
	    return fileNameIndex;
		}
	
	public InputStream getImageStream(String id){
		System.out.println("RestClient-getImage" + id );
		//String deployment = System.getProperties().getProperty("deploymentId","mortgage-process_2.0.0");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		Credentials credi = (Credentials) new UsernamePasswordCredentials(user, password);
	   // credsProvider.setCredentials( new AuthScope(origHost, 8080),credi);
	    //credsProvider.setCredentials( new AuthScope(origHost, origport),credi);
		credsProvider.setCredentials( new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT) , 
				new UsernamePasswordCredentials(user, password));
	    CloseableHttpClient httpClient = HttpClients.custom()
	            .setDefaultCredentialsProvider(credsProvider)
	            .build();
	    HttpGet httGet = null;
	    CloseableHttpResponse response1 = null;
	 
	    String imageurl = serverUrl+"/containers/"+containerId+"/images/processes/instances/" + id;
	    System.out.println("RestClient-getImage-url" + imageurl );
	    InputStream content = null;
	    try {
	    	httGet =  new  HttpGet(imageurl);
	    	response1 = httpClient.execute(httGet);
	    	System.out.println("----------------------------------------");
            System.out.println(response1.getStatusLine());
            StatusLine statusline = response1.getStatusLine();
            int statusCode = statusline.getStatusCode();
            if (statusCode == 200) {
            	HttpEntity  entity = response1.getEntity();
            	content=entity.getContent();
        
            }
           // System.out.println("rest output" + filename);
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      
	    return content;
		}


}
