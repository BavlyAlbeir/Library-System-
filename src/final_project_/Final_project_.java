package final_project_;

import java.util.Scanner;

public class Final_project_ {

    public static void main(String[] args) {
        // take Maximum number of books
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The maximum Book : ");
        int MaximumBook = input.nextInt();

        //Validate that the number of books is greater than 0
        while (MaximumBook <= 0) {
            System.out.print("Enter a valid number (more than 0): ");
            MaximumBook = input.nextInt();
        }

        // Create arrays for Books :titles , descriptions , Id and issued statue
        String[] BookTitles = new String[MaximumBook];
        String[] bookDescriptions = new String[MaximumBook];
        String[] ID = new String[MaximumBook];
        boolean[] bookIssued = new boolean[MaximumBook];

        int BookCount = 0; // Counter for books
        boolean complete = true;     // decide weather the program complete of exit for infinit loop

        do {
            // Main  Menu 
            System.out.println("Welcome To Libaray System List :");
            System.out.println("(1) Add a Book ");
            System.out.println("(2) Search For a Book ");
            System.out.println("(3) Issue a Book ");
            System.out.println("(4) Return a Book ");
            System.out.println("(5) Delete a Book ");
            System.out.println("(6) Edit Book Details ");
            System.out.println("(7) View All Book ");
            System.out.println("(8) Exit ");
            System.out.print("Enter a Number 1 TO 8 : ");

            int Number = input.nextInt();
            input.nextLine();  // Consume left over new line
            System.out.println();

            // Validate menu input
            while (Number > 8 || Number < 1) {
                System.out.print("Enter a valid number between 1 and 8: ");
                Number = input.nextInt();
                input.nextLine();  // Consume left over new line
            }

            switch (Number) {
                case 1 -> {
                    // Add a book
                    // Check the libarary space
                    if (BookCount >= MaximumBook) {
                        System.out.println("The libarary Full and You can not Add Books. ");
                        // Input the choice (validate non-empty and yes or no)
                        String capacity;
                        System.out.println("Do you want to increase the library capacity ?");
                        System.out.print("Enter Yes or No: ");
                        capacity = input.nextLine();

                        while (!capacity.equalsIgnoreCase("yes") && !capacity.equalsIgnoreCase("no")) {
                            System.out.print("Invalid choice! Enter Yes or No: ");
                            capacity = input.nextLine();
                        }

                        // if they want to increase the maximum number.
                        if (capacity.equalsIgnoreCase("yes")) {
                            System.out.print("Enter new maximum number of books : ");
                            int MaxB = input.nextInt();
                            // check the new max is more than the old one
                            while (MaxB <= MaximumBook) {
                                System.out.print("The new maximum shoud be more the " + MaximumBook + " :");
                                MaxB = input.nextInt();
                            }
                            // make the maximum book number is the new one
                            MaximumBook = MaxB;
                            System.out.print("The new maximum is: " + MaximumBook + "\n");

                            // Create New arrays with the new size
                            String[] newBookTitle = new String[MaximumBook];
                            String[] newBookDescriptions = new String[MaximumBook];
                            String[] newID = new String[MaximumBook];
                            boolean[] newBookIssued = new boolean[MaximumBook];

                            // Move books information from the old array to the new array
                            for (int i = 0; i < BookCount; i++) {
                                newBookTitle[i] = BookTitles[i];
                                newBookDescriptions[i] = bookDescriptions[i];
                                newID[i] = ID[i];
                                newBookIssued[i] = bookIssued[i];
                            }
                            // assagin the new information to the old array
                            BookTitles = newBookTitle;
                            bookDescriptions = newBookDescriptions;
                            ID = newID;
                            bookIssued = newBookIssued;

                            input.nextLine(); // Consume left over new line
                        } else {
                            System.out.println("\n-------------------***********-------------------\n");
                            break;
                        }
                    }

                    // Input book's title (validate non-empty)
                    String title;
                    do {
                        System.out.print("Enter book's title: ");
                        title = input.nextLine();
                        if (title.isEmpty()) {
                            System.out.println("Invalid title! Titles cannot be empty.");
                        }
                    } while (title.isEmpty());
                    BookTitles[BookCount] = title;

                    // Input book's descriptions (validate non-empty)
                    String Descriptions;
                    do {
                        System.out.print("Enter book's descriptions: ");
                        Descriptions = input.nextLine();
                        if (Descriptions.isEmpty()) {
                            System.out.println("Invalid description! Description cannot be empty.");
                        }
                    } while (Descriptions.isEmpty());

                    bookDescriptions[BookCount] = Descriptions;

                    // Input book's ID (validate non-empty)
                    String bookID;
                    do {
                        System.out.print("Enter book's ID: ");
                        bookID = input.nextLine();
                        if (bookID.isEmpty()) {
                            System.out.println("Invalid ID! ID cannot be empty.");
                        }
                    } while (bookID.isEmpty());
                    ID[BookCount] = bookID;

                    // Mark the book as 'Available'
                    bookIssued[BookCount] = false;

                    // Increase the book count
                    BookCount++;

                    System.out.println("\n-------------------***********-------------------\n");
                }
                case 2 -> {
                    // Search 
                    if (BookCount == 0) {
                        System.out.println("There is not any book to search");
                        break;
                    }
                    System.out.println("What do you want to serch by:");
                    System.out.println("(1) Book's title");
                    System.out.println("(2) Book's ID");
                    System.out.println("(3) Exit");
                    System.out.print("Enter a Number from 1 to 3: ");

                    int search = input.nextInt();
                    while (search > 3 || search < 1) {
                        System.out.print("Enter a valid number between 1 and 3 : ");
                        search = input.nextInt();
                    }
                    input.nextLine(); // Consume left over new line

                    boolean condetion = false;
                    switch (search) {
                        case 1 -> {
                            // Search book title
                            System.out.print(" Enter book title: ");
                            String title = input.nextLine();
                            System.out.println();

                            for (int i = 0; i < BookCount; i++) {
                                if (title.equalsIgnoreCase(BookTitles[i])) {
                                    System.out.println("book title: " + BookTitles[i]);
                                    System.out.println("book descriptions: " + bookDescriptions[i]);
                                    System.out.println("book ID: " + ID[i]);
                                    // Print book state
                                    if (bookIssued[i] == false) {
                                        System.out.println("status: Available ");
                                    } else {
                                        System.out.println("status: issued ");
                                    }
                                    condetion = true;
                                }
                            }

                            if (condetion == false) {
                                System.out.println("The book not found");
                            }
                        }
                        case 2 -> {
                            // Search book's ID
                            System.out.print(" Enter book's ID: ");
                            String bookID = input.nextLine();
                            System.out.println();

                            for (int i = 0; i < BookCount; i++) {
                                if (bookID.equals(ID[i])) {
                                    System.out.println("book title: " + BookTitles[i]);
                                    System.out.println("book descriptions: " + bookDescriptions[i]);
                                    System.out.println("book ID: " + ID[i]);
                                    if (bookIssued[i] == false) {
                                        System.out.println("status: Available ");
                                    } else {
                                        System.out.println("status: issued");
                                    }
                                    condetion = true;
                                }
                            }
                            if (condetion == false) {
                                System.out.println("The book not found");
                            }
                        }
                        case 3 -> {
                            System.out.println("Exiting search...");
                        }
                        default ->
                            System.out.println("The book not found");
                    }
                    System.out.println("\n-------------------***********-------------------\n");

                }
                case 3 -> {
                    if (BookCount == 0) {
                        System.out.println("There is not any book");
                        break;
                    }
                    // Make the book  borrowed
                    boolean condetion = false;
                    System.out.print(" Enter book's ID: ");
                    String bookID = input.nextLine();
                    // Search the book by ID
                    for (int i = 0; i < BookCount; i++) {
                        if (bookID.equals(ID[i])) {
                            bookIssued[i] = true;
                            condetion = true;
                            System.out.print("The book \" " + BookTitles[i] + " \" now is borrowed");
                        }
                    }
                    // if not found
                    if (condetion == false) {
                        System.out.println("The book not found");
                    }

                    System.out.println("\n-------------------***********-------------------\n");
                }
                case 4 -> {
                    // Return a Book
                    if (BookCount == 0) {
                        System.out.println("There is not any book");
                        break;
                    }
                    boolean condetion = false;

                    System.out.print(" Enter book's ID: ");
                    String bookID = input.nextLine();
                    // Search the book by ID
                    for (int i = 0; i < BookCount; i++) {
                        if (bookID.equals(ID[i])) {
                            bookIssued[i] = false;
                            condetion = true;
                            System.out.println("The book \" " + BookTitles[i] + " \" now is Available");

                        }
                    }
                    if (condetion == false) {
                        System.out.println("The book not found");
                    }
                    System.out.println("\n-------------------***********-------------------\n");
                }
                case 5 -> {
                    // Delete a book 
                    if (BookCount == 0) {
                        System.out.println("There is not any book to delete");
                        break;
                    }
                    boolean condetion = false;

                    System.out.print(" Enter book's ID: ");
                    String bookID = input.nextLine();

                    // Delete the book form the arrays then shift all next books  one position backward
                    for (int i = 0; i < BookCount; i++) {
                        if (bookID.equals(ID[i])) {
                            System.out.println("The book: \"" + BookTitles[i] + "\" is deleted.");
                            BookTitles[i] = null;
                            bookDescriptions[i] = null;
                            bookIssued[i] = true;
                            ID[i] = null;

                            condetion = true;
                            // decrease the count  of the books
                            BookCount--;
                            // take all next book and move them one step back
                        for (int j = i; j < BookCount; j++) {
                            BookTitles[j] = BookTitles[j + 1];
                            bookDescriptions[j] = bookDescriptions[j + 1];
                            bookIssued[j] = bookIssued[j + 1];
                            ID[j] = ID[j + 1];
                        }
                        }

                    }
                    if (condetion == false) {
                        System.out.println("The book not found");
                    }

                    System.out.println("\n-------------------***********-------------------\n");
                }
                case 6 -> {
                    // Edit book details
                    if (BookCount == 0) {
                        System.out.println("There is not any book to edite the data");
                        break;
                    }
                    boolean condetion = false;
                    // Input book's ID
                    System.out.print(" Enter book's ID: ");
                    String bookID = input.nextLine();

                    for (int i = 0; i < BookCount; i++) {
                        if (bookID.equals(ID[i])) {
                            System.out.println("The old book's details:");
                            System.out.println("book title: " + BookTitles[i]);
                            System.out.println("book descriptions: " + bookDescriptions[i]);
                            System.out.println("book ID: " + ID[i]);
                            if (bookIssued[i] == false) {
                                System.out.println("status: Available ");
                            } else {
                                System.out.println("status: issued");
                            }
                            System.out.println();

                            //Enter new values
                            // Input book's title (validate non-empty)
                            String title;
                            do {
                                System.out.print("Enter book's title: ");
                                title = input.nextLine();
                                if (title.isEmpty()) {
                                    System.out.println("Invalid title! Titles cannot be empty.");
                                }
                            } while (title.isEmpty());
                            BookTitles[i] = title;

                            // Input book's descriptions (validate non-empty)
                            String Descriptions;
                            do {
                                System.out.print("Enter book's descriptions: ");
                                Descriptions = input.nextLine();
                                if (Descriptions.isEmpty()) {
                                    System.out.println("Invalid description! Description cannot be empty.");
                                }
                            } while (Descriptions.isEmpty());

                            bookDescriptions[i] = Descriptions;

                            // Input book's ID (validate non-empty)
                            String BookID;
                            do {
                                System.out.print("Enter book's ID: ");
                                BookID = input.nextLine();
                                if (BookID.isEmpty()) {
                                    System.out.println("Invalid ID! ID cannot be empty.");
                                }
                            } while (BookID.isEmpty());
                            ID[i] = BookID;

                            System.out.print("The new details is saved");
                            condetion = true;
                        }
                    }
                    if (condetion == false) {
                        System.out.println("The book not found");
                    }
                    System.out.println("\n-------------------***********-------------------\n");
                }
                case 7 -> {
                    if (BookCount == 0) {
                        System.out.println("There is not any book");
                        break;
                    }
                    for (int i = 0; i < BookCount; i++) {
                        System.out.println("Book number " + (i + 1) + " :");
                        System.out.println("book title: " + BookTitles[i]);
                        System.out.println("book descriptions: " + bookDescriptions[i]);
                        System.out.println("book ID: " + ID[i]);
                        if (bookIssued[i] == false) {
                            System.out.println("status: Available \n");
                        } else {
                            System.out.println("status: issued\n");
                        }

                    }

                    System.out.println("\n-------------------***********-------------------\n");
                }
                case 8 -> {
                    System.out.println("Exiting The libarary System");
                    complete = false;
                }
                default ->
                    System.out.println("Please Try Again");
            }
        } while (complete == true);
    }
}
