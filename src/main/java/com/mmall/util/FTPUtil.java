package com.mmall.util;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.ftp.FtpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FTPUtil {

    private static Logger logger= LoggerFactory.getLogger(FTPUtil.class);

    public static FTPUtil FTPInstance;

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");


    private String ip;
    private int port;
    private String user;
    private String pwd;


    public FTPUtil() {
        ip=ftpIp;
        port=21;
        user=ftpUser;
        pwd=ftpPass;
    }

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }


    private FTPClient connectServer() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(ip,port);
        ftpClient.login(user,pwd);
        return ftpClient;
    }

    public boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        FTPClient ftpClient = connectServer();;
        FileInputStream fis=null;
        boolean uploaded=true;
        try{
            boolean res=ftpClient.changeWorkingDirectory(remotePath);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            for(File fileItem : fileList){
                fis = new FileInputStream(fileItem);
                res=ftpClient.storeFile(fileItem.getName(),fis);
            }
        }catch(IOException e){
            logger.error("上传文件异常",e);
            uploaded=false;
            e.printStackTrace();
        }finally{
            fis.close();
            ftpClient.disconnect();
        }
        return uploaded;
    }
}
