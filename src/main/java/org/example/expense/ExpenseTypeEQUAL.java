package org.example.expense;

import org.example.modal.Expense;
import org.example.modal.User;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeEQUAL extends ExpenseType {

    @Override
    public List<Expense> executeExpense(User userPaid, List<User> userOwes, List<Integer> expenseList) {
        List<Expense> expenses = new ArrayList<Expense>();
        int amountPaid = expenseList.get(0);
        int amountPerUser = amountPaid/userOwes.size();
        for(int i=0;i<userOwes.size();i++){
            expenses.add(new Expense(userPaid, userOwes.get(i), amountPerUser));
        }
        return expenses;
    }
}
