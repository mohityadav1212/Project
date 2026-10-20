package org.myproject.live_chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ChatMessage
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private String sender;
    private String content;
    private MessageType type;
    private String timeStamp;



//     public String getSender(){
//         return sender;
//     }

//     public void setSender(String sender){
//         this.sender = sender;
//     }

//      public String getContent(){
//         return content;
//     }

//     public void setContent(String content){
//         this.content = content;
//     }

//      public MessageType getType(){
//         return type;
//     }

//     public void setType(MessageType type){
//         this.type = type;
//     }

 }
