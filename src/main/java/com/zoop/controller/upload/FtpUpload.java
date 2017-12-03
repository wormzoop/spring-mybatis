package com.zoop.controller.upload;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FtpUpload {

	@RequestMapping(value="/ftp")
	@ResponseBody
	public void ftp(@RequestParam(value="file") MultipartFile file) {
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("59.110.239.123",21);
			ftp.login("test1", "123456");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.enterLocalActiveMode();
			boolean flag = ftp.storeFile(new String(file.getOriginalFilename().getBytes("UTF-8"),"iso-8859-1"),file.getInputStream());
			System.out.println(":::::::::::::::::::::::::::::::::::"+flag);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ftp.disconnect();
			}catch(Exception e) {
				
			}
		}
	}
	
}
