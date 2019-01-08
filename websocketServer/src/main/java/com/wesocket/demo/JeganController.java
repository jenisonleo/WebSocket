package com.wesocket.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RestController
public class JeganController {


    @RequestMapping(value = "/jenison", method = RequestMethod.GET)
    public ResponseEntity<String> ping(){
        return new ResponseEntity<String>("jegan".toString(), HttpStatus.OK);
    }



}
