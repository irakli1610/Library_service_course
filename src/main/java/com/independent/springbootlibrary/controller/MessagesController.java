package com.independent.springbootlibrary.controller;

import com.independent.springbootlibrary.entity.Message;
import com.independent.springbootlibrary.requestmodels.AdminQuestionReequest;
import com.independent.springbootlibrary.service.MessagesService;
import com.independent.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/messages")
public class MessagesController {
    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage( @RequestHeader(value = "Authorization") String token,
                            @RequestBody Message messageRequest){
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest,userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMapping(@RequestHeader("Authorization")String token,
                           @RequestBody AdminQuestionReequest adminQuestionRequest)throws Exception{
        String userEmail= ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        String admin= ExtractJWT.payloadJWTExtraction(token,"\"userType\"");
        if(admin== null || !admin.equals("admin")){
            throw new Exception("Administration page only");
        }
        messagesService.putMessage(adminQuestionRequest,userEmail);
    }
}
