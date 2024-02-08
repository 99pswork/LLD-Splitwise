package org.example.manager;

import org.example.expense.ExpenseEnum;
import org.example.modal.Expense;
import org.example.modal.User;

import java.util.HashMap;
import java.util.List;

public class ExpenseService {
    HashMap<User, HashMap<User, Integer>> userExpenses;
    ExpenseManager expenseManager;

    public ExpenseService(ExpenseManager expenseManager){
        userExpenses = new HashMap<>();
        this.expenseManager = expenseManager;
    }

    public void addUser(User user){
        userExpenses.put(user, new HashMap());
    }

    public HashMap<User, Integer> getUserDetails(User user){
        return userExpenses.get(user);
    }

    public void createTransaction(ExpenseEnum expenseType, User userPaid, List<User> userOwes, List<Integer> expenseSplitList){
        HashMap<User, Integer> updatePaidToExpense = userExpenses.get(userPaid);
        List<Expense> expenseList = expenseManager.createExpense(expenseType, userPaid, userOwes, expenseSplitList);
        for(int i=0;i<expenseList.size();i++){
            User currentUser = expenseList.get(i).getUserOwes();
            int userOweAmount = expenseList.get(i).getExpenseAmount();
            if(updatePaidToExpense.containsKey(currentUser)){
                int oldAmount = updatePaidToExpense.get(currentUser);
                updatePaidToExpense.put(currentUser,oldAmount+userOweAmount);
            }
            else{
                updatePaidToExpense.put(currentUser,userOweAmount);
            }

            HashMap<User, Integer> updateToPayExpense = userExpenses.get(currentUser);
            if(updateToPayExpense.containsKey(userPaid)){
                int oldAmount = updateToPayExpense.get(userPaid);
                updateToPayExpense.put(userPaid,oldAmount-userOweAmount);
            }
            else{
                updateToPayExpense.put(userPaid,-userOweAmount);
            }
        }
    }

    public Integer getTotalAmountDue(User user){
        HashMap<User, Integer> userDetails = userExpenses.get(user);
        Integer netVal = 0;
        for (Integer value : userDetails.values()) {
            netVal += value;
        }
        return netVal;
    }
}
