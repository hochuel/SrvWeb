package com.srv.main.web;

import com.srv.main.service.MainService;
import com.srv.main.vo.TbMsgVO;
import com.srv.util.service.AtomicService;
import com.srv.util.service.PropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private MainService mainService;


    @Autowired(required = false)
    private PropertyService propertyService;

    @Autowired
    private AtomicService atomicService;

    @RequestMapping(value="/index.do")
    public String index(HttpServletRequest httpServletRequest, Model model) throws Exception{


        return "index";
    }


    @RequestMapping(value="/sendMessage.do")
    @ResponseBody
    public Map sendMessage(@RequestBody TbMsgVO vo, HttpServletRequest httpServletRequest, Model model) throws Exception{



        logger.info("file.result ::" + propertyService.getString("file.result"));

        int index = atomicService.getIntData();
        String msgId = "W"+System.currentTimeMillis()+String.format("%05d", index);

        vo.setMsgId(msgId);
        vo.setAppId("1");
        vo.setMsgStatus("00");
        mainService.insertTbMsg(vo);

        Map jsonObject = new HashMap();
        jsonObject.put("msg", "SEND OK...");




        return jsonObject;
    }
}
