/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.xx.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.demon.xx.web.controller.form.XXForm;

/**
 * 
 * http://localhost:8080/lswt/t2/6.j            pojo xml
 * http://localhost:8080/lswt/t2/5.j            pojo json
 * 
 * http://localhost:8080/lswt/t2/4.j not ok     jsonOjbect
 * http://localhost:8080/lswt/t2/3.j            jsonString
 * 
 * http://localhost:8080/lswt/t2/2.j            modelMap
 * http://localhost:8080/lswt/t2/1.j            modelMap
 * 
 * http://localhost:8080/lswt/tool/at.htm       jsp_view
 * 
 * http://localhost:8080/lswt/ls/index.jsp      jsp_direct
 * 
 * http://localhost:8080/lswt/test/show.htm     velocity_view
 * http://localhost:8080/lswt/test/show2.htm    jsp_view
 * 
 * @author lisong
 * @version $Id: T2Controller.java, v 0.1 2016年9月10日 上午10:58:03 lisong Exp $
 */
@Controller
public class T2Controller {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(T2Controller.class);

    @RequestMapping(value = "/t2/1.j", produces = MediaType.APPLICATION_JSON_VALUE)
    public String t1(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "abc");
        map.put("2", "中文");

        modelMap.addAttribute("map", map);

        return "json.vm";
    }

    @RequestMapping(value = "/t2/2.j", produces = MediaType.APPLICATION_JSON_VALUE)
    public void t2(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "abc");
        map.put("2", "中文");

        modelMap.addAttribute("map", map);
        return;
    }

    @RequestMapping(value = "/t2/3.j", produces = MediaType.APPLICATION_JSON_VALUE
                                                  + ";charset=UTF-8")
    @ResponseBody
    public String t3(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        JSONObject jo = new JSONObject();
        jo.put("a", "b");
        jo.put("c", "中文");

        return jo.toString();
    }

    @RequestMapping(value = "/t2/4.j", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONObject t4(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        JSONObject jo = new JSONObject();
        jo.put("a", "b");
        jo.put("c", "中文");

        return jo;
    }

    @RequestMapping(value = "/t2/5.j", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public XXForm json3(ModelMap modelMap, String appId, String appSecret) throws JSONException {
        logger.info("appId={},appSecret={}", appId, appSecret);
        modelMap.addAttribute("1", "abc");
        modelMap.addAttribute("2", "中文");

        XXForm r = new XXForm();
        r.setAppId("aa");
        r.setTest中文("中外那");

        return r;
    }

    @RequestMapping(value = "/t2/6.j", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public XXForm xml1(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);
        modelMap.addAttribute("1", "abc");
        modelMap.addAttribute("2", "中文");

        XXForm r = new XXForm();
        r.setAppId("aa");
        r.setTest中文("中外那");

        return r;
    }
}
