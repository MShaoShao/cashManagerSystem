package com.cash.manager.utill;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class Json {
    /**
     * 返回标准的Json格式数据其中包括（是否成功、状态码、消息、内容）
     * @param result 处理的结果
     * @param response 响应结果
    * */
    public static void toJson(Tool result, HttpServletResponse response)throws  Exception{
     response.setContentType("text/json");
     response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String json = JSONObject.toJSONString(result,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect);
        writer.write(json);
        writer.close();
    }
}
