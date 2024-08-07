import java.util.ArrayList;
import java.util.List;

// Define the Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private List<String> lendingHistory;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.lendingHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<String> getLendingHistory() {
        return lendingHistory;
    }

    // Method to add to lending history
    public void addToLendingHistory(String entry) {
        lendingHistory.add(entry);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable;
    }
}

// Define the Library class
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add books
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Method to search for books by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Method to search for books by author
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to check out a book
    public void checkOutBook(String title, String borrower) {
        Book book = searchBookByTitle(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            book.addToLendingHistory("Borrowed by: " + borrower);
            System.out.println("Book checked out: " + book);
        } else {
            System.out.println("Book not available for checkout.");
        }
    }

    // Method to return a book
    public void returnBook(String title, String borrower) {
        Book book = searchBookByTitle(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            book.addToLendingHistory("Returned by: " + borrower);
            System.out.println("Book returned: " + book);
        } else {
            System.out.println("Book not found or already returned.");
        }
    }

    // Method to display all books
    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Main class to demonstrate library operations
public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("king of jungle is lion", "george boll", "123456789"));
        library.addBook(new Book("the nightangle", "einstin", "987654321"));
        library.addBook(new Book("1984", "alammask", "1122334455"));

        // Display all books
        System.out.println("All books in the library:");
        library.displayAllBooks();

        // Search for a book by title
        Book book = library.searchBookByTitle("1984");
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        // Check out a book
        library.checkOutBook("1984", "Alice");
        library.displayAllBooks();

        // Return a book
        library.returnBook("1984", "Alice");
        library.displayAllBooks();

        // Search for books by author
        System.out.println("Books by george boll:");
        List<Book> booksByAuthor = library.searchBooksByAuthor("alammask");
        for (Book b : booksByAuthor) {
            System.out.println(b);
        }
    }
}
