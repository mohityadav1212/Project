package org.myproject.live_chat.controller;

import org.myproject.live_chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ChatController {

    @GetMapping("/")
    public String home() {
        return "chat";
    }
    
@MessageMapping("/chat")
@SendTo("/topic/messages")
    public ChatMessage receiveMessage(ChatMessage message){
        System.out.println("Received message:" +message.getContent());
        return message;
    }

   
    
    
    
}
