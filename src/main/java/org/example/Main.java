package org.example;

import org.example.expense.ExpenseEnum;
import org.example.manager.ExpenseManager;
import org.example.manager.ExpenseService;
import org.example.modal.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ExpenseManager expenseManager = new ExpenseManager();
        ExpenseService expenseService = new ExpenseService(expenseManager);
        User user1 = new User("1", "PS", "test@gmail.com","101");
        User user2 = new User("2", "NP", "test2@gmail.com", "102");
        User user3 = new User("3", "HS", "test3@gmail.com", "103");
        User user4 = new User("4", "GS", "test4@gmail.com", "104");
        expenseService.addUser(user1);
        expenseService.addUser(user2);
        expenseService.addUser(user3);
        expenseService.addUser(user4);
//        List<User> toPayList = new ArrayList<>(Arrays.asList(user1, user2,user4));
//        List<Integer> amount = new ArrayList<>(Arrays.asList(1200));
//        expenseService.createTransaction(ExpenseEnum.EQUAL, user1, toPayList, amount);
//        List<User> toPayListExact = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
//        List<Integer> amount2 = new ArrayList<>(Arrays.asList(1000, 200,300,400,100));
//        expenseService.createTransaction(ExpenseEnum.EXACT, user3, toPayListExact, amount2);
        List<User> toPayListPercent = new ArrayList<>(Arrays.asList(user1, user3, user4));
        List<Integer> amount3 = new ArrayList<>(Arrays.asList(1000, 10,40,50));
        expenseService.createTransaction(ExpenseEnum.PRECENT, user3, toPayListPercent, amount3);
        System.out.println(expenseService.getTotalAmountDue(user1));
        System.out.println(expenseService.getTotalAmountDue(user2));
        System.out.println(expenseService.getTotalAmountDue(user3));
        System.out.println(expenseService.getTotalAmountDue(user4));
    }
}