package com.zoop.webservice.impl;

import javax.jws.WebService;

import com.zoop.webservice.CXFDemo;

@WebService(serviceName="cxfDemo", targetNamespace="http://impl.demo/")
public class CXFDemoImpl implements CXFDemo{

	public String sayHello(String name) {
		return "name: "+name;
	}

}
