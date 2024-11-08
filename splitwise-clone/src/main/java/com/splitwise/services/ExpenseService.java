package com.splitwise.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.splitwise.models.*;
public class ExpenseService {
    // select * from expense where group_id='groupId'
    private final Map<String, List<Expense>> groupExpenses;

    public ExpenseService(Map<String, List<Expense>> groupExpenses) {
        this.groupExpenses = groupExpenses;
    }

    public void addExpense(Expense groupExpense) {
        final String groupId = groupExpense.getGroupId();
        if (groupId != null) {
            groupExpenses.putIfAbsent(groupId, new ArrayList<>());
            groupExpenses.get(groupId).add(groupExpense);
        }
    }

    public List<Expense> getGroupExpenses(String groupId) {
        return groupExpenses.get(groupId);
    }
    

}
