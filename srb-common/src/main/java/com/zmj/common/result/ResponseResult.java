package com.zmj.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseResult {
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    private ResponseResult() {}

    public static ResponseResult success(){
        return setResult(ResponseEnum.SUCCESS);
    }

    public static ResponseResult error(){
        return setResult(ResponseEnum.ERROR);
    }

    /**
     * 设置特定的枚举返回结果
     * @param re
     * @return
     */
    public static ResponseResult setResult(ResponseEnum re){
        ResponseResult result = new ResponseResult();
        result.setCode(re.getCode());
        result.setMessage(re.getMessage());
        return result;
    }

    public ResponseResult data(String key, Object value) {
        this.data.put(key,value);
        return this;
    }

    public ResponseResult data(Map<String,Object> map) {
        this.data = map;
        return this;
    }

    public ResponseResult message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }
}
