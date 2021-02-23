package com.sam.wms.common.utils;

import com.google.gson.Gson;
import com.sam.wms.common.utils.ResultMassage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BaseController {

    /**
     * @param strSrc md5加密
     * @return
     */
    public static String MD5Encode(String strSrc) {
        return MD5Encode(strSrc, "");
    }

    public static String MD5Encode(String strSrc, String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strSrc.getBytes("UTF8"));
            StringBuilder result = new StringBuilder(32);
            byte[] temp;
            temp = md5.digest(key.getBytes("UTF8"));
            for (int i = 0; i < temp.length; i++) {
                result.append(Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * json 解析
     * @param object
     * @return
     */
    public static String toJson(Object object){
        return new Gson().toJson(object);
    }

    /**
     *
     * @param code
     * @param message
     * @param body
     * @return
     */
    public static String resultMassageTojson(String code, String message, Object body){
        ResultMassage resultMassage = new ResultMassage(code, message, toJson(body));
        return toJson(resultMassage);
    }
}
