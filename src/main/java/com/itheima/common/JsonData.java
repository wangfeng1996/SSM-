package com.itheima.common;

import lombok.Getter;
import lombok.Setter;

/**
 * json请求的封装
 * jsonData- 作为json返回的结构
 * <p>
 * <p>
 * <p>
 * 后台收到前台的请求时一般分为两种：
 * <p>
 * 1、页面请求：直接把我们准备好的页面返回就好了
 * 2、数据请求：除了要返回前台所需要的数据、还要告诉前台当前的数据是正常处理的还是异常处理的，我们一般都是使用json进行返回
 */

@Getter
@Setter
public class JsonData {

    private boolean ret; //返回结果 --true：数据可以正常处理  false --数据处理异常

    private String msg;  //异常消息(有异常的情况下)

    private Object data; //返回前台的数据

    public JsonData() {


    }


    public JsonData(boolean ret, String msg, Object data) {
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }


    //只传入结果
    public JsonData(boolean ret) {
        this.ret = ret;
    }

    //定义全局方法；
    //成功的方法
    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    // 成功  --直接返回数据
    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }
    //成功了  -也可以不用传递任何的参数
    public static JsonData success() {
        return new JsonData(true);
    }

    //定义请求失败的方法 ---这边只告诉前端的msg就可以，出现了什么样的状况
    public static JsonData fail(String msg) {
        //如果ret是false  我们可以通过msg告知前端后端出现了什么样的原因
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

}
