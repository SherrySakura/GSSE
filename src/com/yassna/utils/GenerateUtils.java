package com.yassna.utils;

public class GenerateUtils {

    /**
     * 将字节数组转换为十六进制表示的字符串
     * @param bytes:待转换的字节数组
     * @return:十六进制表示的字符串，没有先导0x
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex = Integer.toHexString(bytes[i]);
            if (strHex.length() > 3) {
                sb.append(strHex.substring(6));
            } else {
                if (strHex.length() < 2) {
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return sb.toString();
    }
}
