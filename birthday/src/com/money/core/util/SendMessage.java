package com.money.core.util;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SendMessage {
	
	public void Send(String name, String gender, String mobile) {
		System.out.println("Send...");
		SendMessage sendMessage = new SendMessage();
		String httpResponse = sendMessage.testSend(name, gender, mobile);
		try {
			JSONObject jsonObject = new JSONObject(httpResponse);
			int error_code = jsonObject.getInt("error");
			String error_msg = jsonObject.getString("msg");
            if(error_code==0){
                System.out.println("Send message success.");
            }else{
                System.out.println("Send message failed,code is "+error_code+",msg is "+error_msg);
            }
        } catch (JSONException ex) {
            
        }
		
		
	}
	private String testSend(String name, String gender, String mobile){
        // just replace key here
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
            "api","key-57d5effd19dd27cbb2e9694c6bf12205"));
        WebResource webResource = client.resource(
            "http://sms-api.luosimao.com/v1/send.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", mobile);
        formData.add("message", "验证码：199534【铁壳测试】");
        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
        post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        System.out.print("发送短信1" + textEntity);
        System.out.print("发送短信2" + status);
        return textEntity;
    }
	
}
