package com.lms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    List<Book> books = new ArrayList<>();
    List<Borrower> borrowers = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBorrower(Borrower borrower) {
        getBorrowers().add(borrower);
    }

    public void loanBook(Book book, Borrower borrower, LocalDate dueDate) {
        Loan loan = new Loan(book, borrower, dueDate);
        loans.add(loan);
    }

    public void printLoans() {
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    public void printOverdueLoans(LocalDate currentDate) {
        for (Loan loan : loans) {
            if (loan.isOverdue(currentDate)) {
                System.out.println(loan + ", Fine: $" + loan.calculateFine(currentDate));
            }
        }
    }

	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}
}

