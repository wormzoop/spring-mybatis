package com.zoop.webservice;

import javax.jws.WebService;

@WebService
public interface CXFDemo {
	String sayHello(String name);
}
