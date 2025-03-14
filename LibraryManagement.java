import java.util.ArrayList;

class Library {

    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Member> memberList = new ArrayList<>();

//    Book book = new Book();
//    Member member = new Member();

    void addBook(String title, String author, String bookID) {
        // creates a new object everytime.
        Book book = new Book(title, author, bookID);
        bookList.add(book);
    }

    void addMember(String name, String memberID) {
        // creates a new object everytime.
        Member member = new Member(name, memberID);
        memberList.add(member);
    }

    void showLibraryBooks() {
        for (Book book : bookList) {
            System.out.println(book.title + " by " + book.author + " (Book ID : " + book.bookID + ") - " + book.isAvailable);
        }
    }

    void showLibraryMembers() {
        for (Member member : memberList) {
            System.out.println(member.name + " ( Member ID : " + member.memberID + ") - Borrowed Books: " + member.borrowedBookTitle);
        }
    }

    static class Book {
        String title;
        String author;
        String bookID;
        String isAvailable;

//        Book() {
//            isAvailable = "Available";
//        }
        
        Book(String title, String author, String bookID) {
            this.title = title;
            this.author = author;
            this.bookID = bookID;
            isAvailable = "Available";
        }

        void borrowBook() {
            isAvailable = "Borrowed";
            System.out.println("Thanks for Borrowing Book" + title + " by " + author + " remember to return it timely.");
        }

        void returnBook() {
            isAvailable = "Available";
            System.out.println("Thanks for returning the book, Hope you enjoyed it.");
        }

    }
    static class Member {

        String name;
        String memberID;
        Book borrowedBook; // creates a reference not object
        String borrowedBookTitle;

//        Member() {
//
//        }

        Member(String name, String memberID) {
            this.name = name;
            this.memberID = memberID;
        }

        void borrow(Book book) {
            if (book.isAvailable.equals("Available")) {
                book.borrowBook();
                borrowedBook = book;
                borrowedBookTitle = borrowedBook.title;
            } else {
                System.out.println("Sorry Book is not Available");
            }
        }

        void returnBorrowedBook() {
            if (borrowedBook != null) {
                borrowedBook.returnBook();
                borrowedBook = null;
            }
        }

    }

}





public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding Books
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "B101");
        library.addBook("1984", "George Orwell", "B102");

        // Adding Members
        library.addMember("Alice", "M201");
        library.addMember("Bob", "M202");

        // Display books and members
        System.out.println("\nLibrary Books:");
        library.showLibraryBooks();

        System.out.println("\nLibrary Members:");
        library.showLibraryMembers();

        // Borrowing a book
        System.out.println("\nAlice borrows 'The Great Gatsby':");
        library.memberList.get(0).borrow(library.bookList.get(0));

        // Display books and members again
        System.out.println("\nLibrary Books After Borrowing:");
        library.showLibraryBooks();

        System.out.println("\nLibrary Members After Borrowing:");
        library.showLibraryMembers();

        // Returning a book
        System.out.println("\nAlice returns 'The Great Gatsby':");
        library.memberList.get(0).returnBorrowedBook();

        // Final status of books and members
        System.out.println("\nLibrary Books After Returning:");
        library.showLibraryBooks();

        System.out.println("\nLibrary Members After Returning:");
        library.showLibraryMembers();
    }
}
