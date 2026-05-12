package com.quynh.vieccanlam;

import java.io.Serializable;
import java.util.HashMap;

public class TASK implements Serializable {
    String name, date, message, priority;

    public TASK(String name, String date, String message, String priority) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.priority = priority;
    }

    public TASK() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public HashMap<String, String> toFireBaseObject(){
        HashMap<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("date", date);
        result.put("message", message);
        result.put("priority", priority);
        return result;
    }

}
