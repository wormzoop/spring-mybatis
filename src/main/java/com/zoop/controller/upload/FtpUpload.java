package com.zoop.controller.upload;

import java.io.UnsupportedEncodingException;

import org.apache.commons.net.ftp.FTP;
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
			//ftp.connect("59.110.239.123",21);
			//ftp.login("test1", "123456");
			ftp.connect("118.190.152.221",21);
			ftp.login("admin", "123456");
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			//ftp.enterLocalPassiveMode();
			//ftp.setControlEncoding("gb2312");
			System.out.print(":::::::::::::::::::::::::::::::::::"+ftp.getReplyCode());
			boolean flag = ftp.storeFile(new String(file.getOriginalFilename().getBytes("utf8"),"iso-8859-1"),file.getInputStream());
			//boolean flag = ftp.storeFile(file.getOriginalFilename(),file.getInputStream());
			//System.out.print(new String(file.getOriginalFilename().getBytes("utf8"),"gbk"));
			System.out.print(":::::::::::::::::::::::::::::::::::"+ftp.getReplyCode());
			System.out.print(":::::::::::::::::::::::::::::::::::"+ftp.getReplyString());
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
	
	public static void main(String[]args) throws UnsupportedEncodingException {
		String str = "找那个.jar";
		System.out.print(new String(str.getBytes("utf8"),"gb2312"));
	}
	
}
