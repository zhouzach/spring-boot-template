package org.rabbit.controller;


import org.rabbit.config.ConstansConfig;
import org.rabbit.module.Msg;
import org.rabbit.service.InvokeShellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    ConstansConfig constansConfig;

    @Autowired
    InvokeShellService invokeShellService;

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/test/exception")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

    @GetMapping("")
    public Msg get(HttpServletRequest request, HttpServletResponse response) {
        logger.info("hello spring boot");

        Msg msg = Msg.ok("hello spring boot");


        return msg;
    }

    @GetMapping("/exec/cmd")
    public Msg execCmd(HttpServletRequest request, HttpServletResponse response) {
        String submitShellCmd = constansConfig.getSubmitShellCmd();

        try {
//            val parameter = String.format("%s %s %s %s %s %s",
//                    "type:my-chart",
//                    "begin:" + beginTimeStr,
//                    "end:" + endTimeStr,
//                    "dimension:" + createReq.getDimension(),
//                    "index:" + createReq.getIndex(),
//                    "cid:" + uuid
//            );
//            logger.info("exec bash : {} \"{}\" ", submitShellCmd, String.format("%s", parameter));

//            String[] shell = new String[]{submitShellCmd, String.format("%s", parameter)};
            String[] shell = new String[]{submitShellCmd};

            invokeShellService.execute(shell);
        } catch (IOException | InterruptedException e) {
            logger.error("execute shell fail - " + submitShellCmd, e);
            return Msg.err(e.getMessage());
        }


        return Msg.ok("first cmd has been executed");
    }


}
