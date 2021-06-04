package com.example.pvp_knights.dataBase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ChatMessageModel {
	    private MessageType type;
	    private String content;
	    private String sender;
	    public enum MessageType {
	        CHAT,
	        JOIN,
	        LEAVE
	    }
	    public MessageType getType() {
	        return type;
	    }
	    public void setType(MessageType type) {
	        this.type = type;
	    }
	    public String getContent() {
	        return content;
	    }
	    public void setContent(String content) {
	        this.content = content;
	    }
	    public String getSender() {
	        return sender;
	    }
	    public void setSender(String sender) {
	        this.sender = sender;
	    }
	}