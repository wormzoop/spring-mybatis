package com.zoop.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zoop.entity.ResponseObject;

@Controller
public class FileUploadUtil {

	private static String filePath = "F:/upload/";//文件路径一定要存在不然会文件io异常
	
	/**
	 * 上传多个文件
	 * @param files 文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/upload.do")
	@ResponseBody
	public ResponseObject upload(@RequestParam(value="files", required=false) MultipartFile[] files,
			HttpServletRequest request){
		ResponseObject responseObj = new ResponseObject();
		if(files == null || files.length == 0){
			responseObj.setCode("10000");
			responseObj.setBody(null);
		}else{
			for(MultipartFile file : files){
				try{
					file.transferTo(new File(filePath + file.getOriginalFilename()));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			responseObj.setCode("10000");
			responseObj.setBody("上传成功");
		}
		return responseObj;
	}
	
}
