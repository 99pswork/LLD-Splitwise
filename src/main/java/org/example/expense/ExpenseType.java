package org.example.expense;

import org.example.modal.Expense;
import org.example.modal.User;

import java.util.List;

public abstract class ExpenseType {
    public abstract List<Expense> executeExpense(User userPaid, List<User> userOwes, List<Integer> expenseList);
}
