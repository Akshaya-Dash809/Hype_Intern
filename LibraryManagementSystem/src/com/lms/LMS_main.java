package com.lms;
import java.time.LocalDate;
import java.util.Scanner;

public class LMS_main {

	    public static void main(String[] args) {
	        LibraryManager manager = new LibraryManager();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Library Management System");
	            System.out.println("1. Add Book");
	            System.out.println("2. Add Borrower");
	            System.out.println("3. Loan Book");
	            System.out.println("4. Print All Loans");
	            System.out.println("5. Print Overdue Loans");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Book Title: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter Book Author: ");
	                    String author = scanner.nextLine();
	                    System.out.print("Enter Book ISBN: ");
	                    String isbn = scanner.nextLine();
	                    manager.addBook(new Book(title, author, isbn));
	                    System.out.println("Book added.");
	                    break;

	                case 2:
	                    System.out.print("Enter Borrower Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Borrower ID: ");
	                    String borrowerId = scanner.nextLine();
	                    manager.addBorrower(new Borrower(name, borrowerId));
	                    System.out.println("Borrower added.");
	                    break;

	                case 3:
	                    System.out.print("Enter Book ISBN: ");
	                    String bookIsbn = scanner.nextLine();
	                    Book book = manager.books.stream().filter(b -> b.getIsbn().equals(bookIsbn)).findFirst().orElse(null);
	                    if (book == null) {
	                        System.out.println("Book not found.");
	                        break;
	                    }
	                    System.out.print("Enter Borrower ID: ");
	                    String id = scanner.nextLine();
	                    Borrower borrower = manager.borrowers.stream().filter(b -> b.getBorrowerId().equals(id)).findFirst().orElse(null);
	                    if (borrower == null) {
	                        System.out.println("Borrower not found.");
	                        break;
	                    }
	                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
	                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
	                    manager.loanBook(book, borrower, dueDate);
	                    System.out.println("Book loaned.");
	                    break;

	                case 4:
	                    manager.printLoans();
	                    break;

	                case 5:
	                    System.out.print("Enter Current Date (YYYY-MM-DD): ");
	                    LocalDate currentDate = LocalDate.parse(scanner.nextLine());
	                    manager.printOverdueLoans(currentDate);
	                    break;

	                case 6:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}

	
