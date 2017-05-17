package com.zoop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zoop.entity.ResponseObject;

@Controller
public class FileUploadUtil {

	@RequestMapping(value = "/upload.do")
	@ResponseBody
	public ResponseObject upload(@RequestParam(value="file", required=false) MultipartFile file,
			HttpServletRequest request){
		ResponseObject responseObj = new ResponseObject();
		
		return responseObj;
	}
	
}
