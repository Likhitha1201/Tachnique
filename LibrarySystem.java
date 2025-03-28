/***

    @Author: Likhitha S
    @Date: 28-03-2025 09:00
    @Last Modified by: Likhitha S
    @Last Modified time: 28-03-2025 09:00
    @Title: Develop an application system to enable librarians to efficiently add, update, search and remove books while maintaining their availability status.

***/


    // def attendance(self):
        /***
        
        Description: 
           This function is used to check attendance of all employees.
        Parameters:
           attend is container used to strore the random values.
        Return:
            It returns wheather employees present or not. 
        
        ***/
       
        import java.util.Scanner;
        import java.util.HashMap;
        import java.util.Map;
        
        class Book {
        
            private String id, title, author, genre, availability;
        
            public Book(String id, String title, String author, String genre, String availability) {
                this.id = id;
                this.title = title;
                this.author = author;
                this.genre = genre;
                this.availability = availability;
            }
        
            public String getId() { 
                return id;
            }
            public String getTitle() {
                return title; 
            }
            public String getAuthor() { 
                return author; 
            }
            public String getGenre() { 
                return genre; 
            }
            public String getAvailability() { 
                return availability; 
            }
        
            public void setTitle(String title) { 
                this.title = title; 
            }
            public void setAuthor(String author) { 
                this.author = author; 
            }
            public void setAvailability(String availability) { 
                this.availability = availability; 
            }
        
            public void display() {
                System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author +
                        " | Genre: " + genre + " | Availability: " + availability);
            }
        }
        
        class LibrarySystem {
            private static Map<String, Book> books = new HashMap<>();
            private static Scanner scanner = new Scanner(System.in);
        
            public static void main(String[] args) {
                while (true) {
                    System.out.println("\nLibrary Management System");
                    System.out.println("1. Add Book\n2. View Books\n3. Search Book\n4. Update Book\n5. Delete Book\n6. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  
        
                    switch (choice) {
                    case 1: addBook(); 
                    break;
                    case 2: viewBooks();
                    break;
                    case 3: searchBook(); 
                    break;
                    case 4: updateBook(); 
                    break;
                    case 5: deleteBook(); 
                    break;
                    case 6: System.out.println("Exiting...Thank you Visit Again");
                    return;
                    default: System.out.println("Invalid choice! Try again.");
                    }
                }
            }
        
            private static void addBook() {
                System.out.print("Enter Book ID: ");
                String id = scanner.nextLine();
                if (books.containsKey(id)) {
                    System.out.println("Book ID must be unique!");
                    return;
                }
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter Genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter Availability (Available/Checked Out): ");
                String availability = scanner.nextLine();
        
                books.put(id, new Book(id, title, author, genre, availability));
                System.out.println("Book added successfully!");
            }
        
            private static void viewBooks() {
                if (books.isEmpty()) {
                    System.out.println("No books available.");
                } else {
                    books.values().forEach(Book ::display);
                }
            }
        
            private static void searchBook() {
                System.out.print("Search by (1) ID or (2) Title? ");
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option == 1) {
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    if (books.containsKey(id)) {
                        books.get(id).display();
                    } else {
                        System.out.println("Book not found.");
                    }
                } 
                else if(option == 2) {
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    books.values().stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .findFirst().ifPresentOrElse(Book::display, () -> System.out.println("Book not found."));
                }
            }
        
            private static void updateBook() {
                System.out.print("Enter Book ID to update: ");
                String id = scanner.nextLine();
                if (!books.containsKey(id)) {
                    System.out.println("Book not found.");
                    return;
                }
                Book book = books.get(id);
                System.out.print("Enter new Title (press enter to keep current): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) book.setTitle(title);
        
                System.out.print("Enter new Author (press enter to keep current): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) book.setAuthor(author);
        
                System.out.print("Enter new Availability (Available/Checked Out): ");
                String availability = scanner.nextLine();
                if (!availability.isEmpty()) book.setAvailability(availability);
        
                System.out.println("Book updated successfully!");
            }
        
            private static void deleteBook() {
                System.out.print("Enter Book ID to delete: ");
                String id = scanner.nextLine();
                if (books.remove(id) != null) {
                    System.out.println("Book deleted successfully!");
                } else {
                    System.out.println("Book not found.");
                }
            }
        }
        
        