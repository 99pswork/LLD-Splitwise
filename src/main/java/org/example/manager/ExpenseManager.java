package org.example.manager;

import org.example.expense.ExpenseEnum;
import org.example.expense.ExpenseTypeEQUAL;
import org.example.expense.ExpenseTypeEXACT;
import org.example.expense.ExpenseTypePERCENT;
import org.example.modal.Expense;
import org.example.modal.User;

import java.util.List;

public class ExpenseManager {
    public List<Expense> createExpense(ExpenseEnum expenseType, User userPaid, List<User> userOwes, List<Integer> expenseSplitList){
        List<Expense> expenseList = null;
        if(expenseType.equals(ExpenseEnum.EQUAL)){
            expenseList = new ExpenseTypeEQUAL().executeExpense(userPaid,userOwes,expenseSplitList);
        }
        else if(expenseType.equals(ExpenseEnum.EXACT)){
            expenseList = new ExpenseTypeEXACT().executeExpense(userPaid,userOwes,expenseSplitList);
        }
        else if(expenseType.equals(ExpenseEnum.PRECENT)){
            expenseList = new ExpenseTypePERCENT().executeExpense(userPaid,userOwes,expenseSplitList);
        }
        return expenseList;
    }
}
