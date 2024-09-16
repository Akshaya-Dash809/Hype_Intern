package com.lms;


import java.time.LocalDate;

public class Loan {
    private Book book;
    private Borrower borrower;
    private LocalDate dueDate;

    public Loan(Book book, Borrower borrower, LocalDate dueDate) {
        this.book = book;
        this.borrower = borrower;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue(LocalDate currentDate) {
        return currentDate.isAfter(dueDate);
    }

    public double calculateFine(LocalDate currentDate) {
        if (!isOverdue(currentDate)) return 0.0;
        long overdueDays = java.time.Duration.between(dueDate.atStartOfDay(), currentDate.atStartOfDay()).toDays();
        return overdueDays * 0.50; // $0.50 per day
    }

    @Override
    public String toString() {
        return book + ", Borrower: " + borrower + ", Due Date: " + dueDate;
    }
}

