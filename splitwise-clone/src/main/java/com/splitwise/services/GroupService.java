package com.splitwise.services;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

import com.splitwise.models.*;

public class GroupService {
    private final ExpenseService expenseService;
    private final Map<String, Group> groups;

    public GroupService(ExpenseService expenseService, Map<String, Group> groups) {
        this.expenseService = expenseService;
        this.groups = groups;
    }
    
    public PaymentGraph getGroupPaymentGraph(String groupId, String userId) throws IllegalAccessException {
        BalanceMap groupBalance = getGroupBalanceMap(groupId, userId);
        return new PaymentGraph(null);
    }
    public BalanceMap sumExpenses(List<Expense> groupExpenses) {
        final BalanceMap resultBalance = new BalanceMap();
        for(Expense expense : groupExpenses) {
            for (Entry<String, Amount> balances : expense.getUserBalanceMap().getBalances().entrySet()) {
                String user = balances.getKey();
                Amount amount = balances.getValue();
                resultBalance.getBalances().put(user, resultBalance.getBalances().getOrDefault(user, new Amount(Currency.USD, 0)).add(amount));
            }
        }
        return resultBalance;
    }

    public BalanceMap getGroupBalanceMap(String groupId, String userId) throws IllegalAccessException {
        if (!groups.get(groupId).getUserList().contains(userId)) {
            throw new IllegalAccessException();
        }
        return sumExpenses(expenseService.getGroupExpenses(groupId));
    }

}
