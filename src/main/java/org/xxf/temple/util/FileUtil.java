package org.xxf.temple.util;

import java.io.*;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 下午 5:21
 */
public class FileUtil {

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuilder fileContent = new StringBuilder();
        try {
            fis = new FileInputStream(fileName);
            isr = new InputStreamReader(fis, encoding);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    br = null;
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    isr = null;
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    fis = null;
                }
            }
        }
        return fileContent.toString();
    }

    public static void checkFile(File file){
        checkFilePath(file);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkFilePath(File file){
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }

    public static void createNewFile(String fileName,String content){
        String encoding = "UTF-8";

        File file = new File(fileName);
        checkFile(file);

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, encoding);
            osw.write(content);
            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    osw = null;
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    fos = null;
                }
            }
        }
    }

}
