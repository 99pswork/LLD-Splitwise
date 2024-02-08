package org.example.expense;

import org.example.modal.Expense;
import org.example.modal.User;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeEXACT extends ExpenseType {

    @Override
    public List<Expense>  executeExpense(User userPaid, List<User> userOwes, List<Integer> expenseList) {
        List<Expense> expenses = new ArrayList<Expense>();
        int amountPaid = expenseList.get(0);
        for(int i=0;i<userOwes.size();i++){
            int amountPerUser = expenseList.get(i+1);
            expenses.add(new Expense(userPaid, userOwes.get(i), amountPerUser));
        }
        return expenses;
    }
}

