package org.xxf.temple.util;

/**
 * Author by Winds on 2016/10/18.
 * Email heardown@163.com.
 */
public class ByteUtil {

    /**
     * ASCII码互相转换和十六进制
     * @param str
     * @return
     */
    public static String convertStringToHex(String str){
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }
        return hex.toString();
    }

    /**
     * 十六进制转ASCII码
     * @param hex
     * @return
     */
    public static String convertHexToString(String hex){
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for( int i=0; i<hex.length()-1; i+=2 ){
            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }

    /**
     * 字节数组转换成对应的16进制表示的字符串
     *
     * @param src
     * @return
     */
    public static String bytes2HexStr(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return "";
        }
        char[] buffer = new char[2];
        for (int i = 0; i < src.length; i++) {
            buffer[0] = Character.forDigit((src[i] >>> 4) & 0x0F, 16);
            buffer[1] = Character.forDigit(src[i] & 0x0F, 16);
            builder.append(buffer);
        }
        return builder.toString().toUpperCase();
    }

    /**
     * 十六进制字节数组转字符串
     *
     * @param src 目标数组
     * @param dec 起始位置
     * @param length 长度
     * @return
     */
    public static String bytes2HexStr(byte[] src, int dec, int length) {
        byte[] temp = new byte[length];
        System.arraycopy(src, dec, temp, 0, length);
        return bytes2HexStr(temp);
    }

    /**
     * 16进制字符串转10进制数字
     *
     * @param hex
     * @return
     */
    public static long hexStr2decimal(String hex) {
        return Long.parseLong(hex, 16);
    }

    /**
     * 把十进制数字转换成足位的十六进制字符串,并补全空位
     *
     * @param num
     * @return
     */
    public static String decimal2fitHex(long num) {
        String hex = Long.toHexString(num).toUpperCase();
        if (hex.length() % 2 != 0) {
            return "0" + hex;
        }
        return hex.toUpperCase();
    }
    
    public static String hexStr2Ip(String src){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 5; i++){
            if(i < 3){
                builder.append(String.valueOf(hexStr2decimal(src.substring(2*i, 2*i + 2)))).append(".");
            }else if(i == 3){
                builder.append(String.valueOf(hexStr2decimal(src.substring(2*i, 2*i + 2)))).append(":");
            }else {
                builder.append(String.valueOf(hexStr2decimal(src.substring(2*i, src.length()))));
            }
        }
        return builder.toString();
    }

    public static byte[] hexIp2Bytes(String ipString) {
        byte[] ip = new byte[6];
        int pos1 = ipString.indexOf(".");
        int pos2 = ipString.indexOf(".",pos1 + 1);
        int pos3 = ipString.indexOf(".",pos2 + 1);
        int pos4 = ipString.indexOf(":",pos3 + 1);
        byte[] bytes = hexStr2bytes(decimal2fitHex(Integer.valueOf(ipString.substring(0 , pos1))));
        byte[] bytes1 = hexStr2bytes(decimal2fitHex(Integer.valueOf(ipString.substring(pos1 + 1 , pos2))));
        byte[] bytes2 = hexStr2bytes(decimal2fitHex(Integer.valueOf(ipString.substring(pos2 + 1 , pos3))));
        byte[] bytes3 = hexStr2bytes(decimal2fitHex(Integer.valueOf(ipString.substring(pos3 + 1 , pos4))));
        byte[] bytes4 = hexStr2bytes(decimal2fitHex(Integer.valueOf(ipString.substring(pos4 + 1 , ipString.length()))));
        ip[0] = bytes[0];
        ip[1] = bytes1[0];
        ip[2] = bytes2[0];
        ip[3] = bytes3[0];
        if(bytes4.length == 1){
            byte b = 0;
            ip[4] = b ;
            ip[5] = bytes4[0];
        }else{
            ip[4] = bytes4[0] ;
            ip[5] = bytes4[1];
        }
        return ip;
    }

    /**
     * 把十进制数字转换成足位的十六进制字符串,并补全空位
     *
     * @param num
     * @param strLength 字符串的长度
     * @return
     */
    public static String decimal2fitHex(long num, int strLength) {
        String hexStr = decimal2fitHex(num);
        StringBuilder stringBuilder = new StringBuilder(hexStr);
        while (stringBuilder.length() < strLength) {
            stringBuilder.insert(0, '0');
        }
        return stringBuilder.toString();
    }

    public static String fitDecimalStr(int dicimal, int strLength) {
        StringBuilder builder = new StringBuilder(String.valueOf(dicimal));
        while (builder.length() < strLength) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }

    /**
     * 字符串转十六进制字符串
     *
     * @param str
     * @return
     */
    public static String str2HexString(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();
        byte[] bs = null;
        try {

            bs = str.getBytes("utf8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString();
    }

    /** 
     * @Title:hexString2String 
     * @Description:16进制字符串转字符串 
     * @param src 
     *            16进制字符串 
     * @return 字节数组 
     * @throws 
     */  
    public static String hexString2String(String src) {  
        String temp = "";  
        for (int i = 0; i < src.length() / 2; i++) {  
            temp = temp  
                    + (char) Integer.valueOf(src.substring(i * 2, i * 2 + 2),  
                            16).byteValue();  
        }  
        return temp;  
    } 
    
    /**
     * 把十六进制表示的字节数组字符串，转换成十六进制字节数组
     *
     * @param
     * @return byte[]
     */
    public static byte[] hexStr2bytes(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toUpperCase().toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (hexChar2byte(achar[pos]) << 4 | hexChar2byte(achar[pos + 1]));
        }
        return result;
    }
    /**
     * 
     * @param d
     * @return
     */
    public static byte[] double2Bytes(double d) {
    	long value = Double.doubleToRawLongBits(d);
    	byte[] byteRet = new byte[8];
    	for (int i = 0; i < 8; i++) {
    	byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
    	}
    	return byteRet;
    }
    
    /**
     * 
     * @param arr 16进制字节数组转成double
     * @return
     */
    public static double bytes2Double(byte[] arr) {
    	long value = 0;
    	for (int i = 0; i < 8; i++) {
    	value |= ((long) (arr[i] & 0xff)) << (8 * i);
    	}
    	return Double.longBitsToDouble(value);
    }

    /**
     * 把16进制字符[0123456789abcde]（含大小写）转成字节
     *
     * @param c
     * @return
     */
    private static int hexChar2byte(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'a':
            case 'A':
                return 10;
            case 'b':
            case 'B':
                return 11;
            case 'c':
            case 'C':
                return 12;
            case 'd':
            case 'D':
                return 13;
            case 'e':
            case 'E':
                return 14;
            case 'f':
            case 'F':
                return 15;
            default:
                return -1;
        }
    }
}
