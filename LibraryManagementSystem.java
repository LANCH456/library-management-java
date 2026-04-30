import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + (isIssued ? "Issued" : "Available"));
    }
}

// Library class
class Library {
    ArrayList<Book> books = new ArrayList<>();
    int nextId = 1;

    // Add a book
    void addBook(String title, String author) {
        books.add(new Book(nextId++, title, author));
        System.out.println("Book added successfully!");
    }

    // View all books
    void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book b : books) {
            b.displayBook();
        }
    }

    // Search book by title
    void searchBook(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.displayBook();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    // Issue a book
    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    System.out.println("Book is already issued.");
                } else {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    // Return a book
    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    System.out.println("Book was not issued.");
                } else {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    // Delete a book
    void deleteBook(int id) {
        books.removeIf(b -> b.id == id);
        System.out.println("Book deleted successfully!");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Library Management System");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String search = scanner.nextLine();
                    library.searchBook(search);
                    break;
                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();
                    library.issueBook(issueId);
                    break;
                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 6:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    library.deleteBook(deleteId);
                    break;
                case 0:
                    System.out.println("Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
