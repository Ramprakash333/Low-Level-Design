package com.splitwise.models;

import java.util.List;

public class Group {
    private final String name;
    private final String description;
    private final List<String> userList;
    public Group(String name, String description, List<String> userList) {
        this.name = name;
        this.description = description;
        this.userList = userList;
    }
    public String name() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getUserList() {
        return userList;
    }

}
