package com.hrms.util;

import java.util.HashMap;
import java.util.Map;

public class JsonMsg {
    private int statusCode;
    private String msg;
    public Map<String, Object> extendInfo = new HashMap<>();

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setExtendInfo(Map<String, Object> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public Map<String, Object> getExtendInfo() {
        return extendInfo;
    }

    public static JsonMsg success() {
        JsonMsg res = new JsonMsg();
        res.setStatusCode(200);
        res.setMsg("请求成功。");
        return res;
    }

    public static JsonMsg fail(){
        JsonMsg res = new JsonMsg();
        res.setStatusCode(400);
        res.setMsg("请求失败。");
        return res;
    }

    public JsonMsg addInfo(String key, Object obj){
        this.extendInfo.put(key, obj);
        return this;
    }
}
