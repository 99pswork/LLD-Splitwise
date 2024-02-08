package org.example.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Expense {
    User userPaid;
    User userOwes;
    int expenseAmount;
}
