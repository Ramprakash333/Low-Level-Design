package com.splitwise.models;

public class Expense {
    private final String id;
    private final String title;
    private final BalanceMap userBalances;
    private final String groupId;
    public Expense(String id, String title, BalanceMap userBalances, String groupId) {
        this.id = id;
        this.title = title;
        this.userBalances = userBalances;
        this.groupId = groupId;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public BalanceMap getUserBalanceMap() {
        return userBalances;
    }
    public String getGroupId() {
        return groupId;
    }
    
}
