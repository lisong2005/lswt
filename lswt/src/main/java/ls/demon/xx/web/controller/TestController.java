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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.demon.xx.web.controller.form.XXForm;

/**
 * 
 * http://localhost:8080/lswt/test/show.htm         vm
 * http://localhost:8080/lswt/test/showJson.json 
 * http://localhost:8080/lswt/test/showJson.htm     vm
 * 
 * http://localhost:8080/lswt/test/json1.json not_ok
 * http://localhost:8080/lswt/test/json2.json
 * 
 * http://localhost:8080/lswt/test/json3.json
 * 
 * http://localhost:8080/lswt//test/xml1.xml
 * 
 * 
 * @author lisong
 * @version $Id: TestController.java, v 0.1 2016年9月9日 下午7:51:41 lisong Exp $
 */
@Controller
public class TestController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test/show.htm")
    public String doGet(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);
        modelMap.addAttribute("name", "hello 你好");
        return "test.vm";
    }

    @RequestMapping(value = "/test/show2.htm")
    public String doGet2(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);
        modelMap.addAttribute("message", "hello 你好");
        return "index";
    }

    @RequestMapping(value = "/test/showJson.htm")
    public String showJson(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "abc");
        map.put("2", "中文");

        modelMap.addAttribute("map", map);
        return "json.vm";
    }

    @RequestMapping(value = "/test/showJson.json")
    public void showJson2(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "abc");
        map.put("2", "中文");

        modelMap.addAttribute("map", map);
        return;
    }

    @RequestMapping(value = "/test/json1.json")
    @ResponseBody
    public JSONObject json1(ModelMap modelMap, String appId,
                            String appSecret) throws JSONException {
        logger.info("appId={},appSecret={}", appId, appSecret);
        modelMap.addAttribute("1", "abc");
        modelMap.addAttribute("2", "中文");

        JSONObject jo = new JSONObject();
        jo.put("a", "b");
        jo.put("c", "中文");

        return jo;
    }

    @RequestMapping(value = "/test/json2.json")
    @ResponseBody
    public String json2(ModelMap modelMap, String appId, String appSecret) throws JSONException {
        logger.info("appId={},appSecret={}", appId, appSecret);
        modelMap.addAttribute("1", "abc");
        modelMap.addAttribute("2", "中文");

        JSONObject jo = new JSONObject();
        jo.put("a", "b");
        jo.put("c", "中文");

        return jo.toString();
    }

    @RequestMapping(value = "/test/json3.json")
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

    @RequestMapping(value = "/test/xml1.xml")
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
