package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static Console console = new Console();
    // add scanner
    private static Scanner scanner = new Scanner(System.in);
    // create class level variable for the library
    private static Book[] library = getPopulatedLibrary();

    public static void main(String[] args) {

        ShowScreenHome();
        // Book book = new Book(1, "ISBN: abcdefg", "The Book Title"
        // book.checkOut("Jayla")
        
    }
    private static void ShowScreenHome(){
        String homeScreenPrompt = "Welcome to the library!\n" +
                "Please select an option from the following:\n" +
                "     1 - Show Available Books\n" +
                "     2 - Show Checked Out Books\n " +
                "    0 - Exit App\n" +
                "(1,2,0): ";
 
        // define option
        int option;
        do {
            System.out.print(homeScreenPrompt);
            option = scanner.nextInt();
            scanner.nextLine();
            option = console.promptForInt(homeScreenPrompt);
            if (option == 1) {
                ShowScreenAvailableBooks();
            } else if (option == 2) {
                ShowScreenCheckedOutBooks();
            } else if (option == 0) {
                System.out.println("Exiting the library, have a nice day!");
            } else {
                System.out.println("Not a valid option, please try again.");
            }
        } while (option != 0); 
        
    }
    private static void ShowScreenAvailableBooks(){
        System.out.println("\nAvailable Books:\n");

        boolean anyAvailable = false;
        for (Book book : library) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println();
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No books are currently available.\n");
            return;
        }

        System.out.print("Enter the ID of the book to check out, or 0 to return: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (id == 0) return;

        for (Book book : library) {
            if (book.getId() == id && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Your book is checked out successfully.\n");
                return;
            }
        }

        System.out.println("Invalid ID or book is already checked out.\n");



    }


    private static void ShowScreenCheckedOutBooks(){
        System.out.println("\nChecked Out Books:\n");

        boolean anyCheckedOut = false;
        for (Book book : library) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Checked out to: " + book.getCheckedOutTo());
                System.out.println();
                anyCheckedOut = true;
            }
    }
        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.\n");
            return;
        }

        System.out.print("Enter 'C' to check in a book, or 'X' to return: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            for (Book book : library) {
                if (book.getId() == id && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Your book has been checked in successfully.\n");
                    return;
                }
            }

            System.out.println("Invalid ID or the book is not checked out.\n");
        }
    }


            private static Book[] getPopulatedLibrary(){
    Book[]library = new Book[20];

        library[0] = new Book(1, "ISBN 978-0-679-73232-2", "Their Eyes Were Watching God by Zora Neale Hurston");
        library[1] = new Book(2, "ISBN 978-0-307-27778-6", "The Bluest Eye by Toni Morrison");
        library[2] = new Book(3, "ISBN 978-1-4000-3341-6", "Between the World and Me by Ta-Nehisi Coates");
        library[3] = new Book(4, "ISBN 978-0-307-74113-3", "The Underground Railroad by Colson Whitehead");
        library[4] = new Book(5, "ISBN 978-0-385-72011-5", "Americanah by Chimamanda Ngozi Adichie");
        library[5] = new Book(6, "ISBN 978-0-14-118591-0", "Native Son by Richard Wright");
        library[6] = new Book(7, "ISBN 978-1-4767-2766-7", "An American Marriage by Tayari Jones");
        library[7] = new Book(8, "ISBN 978-0-385-72102-0", "The Warmth of Other Suns by Isabel Wilkerson");
        library[8] = new Book(9, "ISBN 978-0-345-80378-0", "Kindred by Octavia E. Butler");
        library[9] = new Book(10, "ISBN 978-1-5247-4180-0", "The Vanishing Half by Brit Bennett");
        library[10] = new Book(11, "ISBN 978-0-307-38841-3", "The Water Dancer by Ta-Nehisi Coates");
        library[11] = new Book(12, "ISBN 978-0-14-313185-4", "How We Fight for Our Lives by Saeed Jones");
        library[12] = new Book(13, "ISBN 978-0-385-72230-0", "You Should See Me in a Crown by Leah Johnson");
        library[13] = new Book(14, "ISBN 978-1-9848-9833-9", "Such a Fun Age by Kiley Reid");
        library[14] = new Book(15, "ISBN 978-0-374-26514-0", "Red at the Bone by Jacqueline Woodson");
        library[15] = new Book(16, "ISBN 978-1-250-30656-3", "The Prophets by Robert Jones Jr.");
        library[16] = new Book(17, "ISBN 978-0-06-236258-3", "Black Leopard, Red Wolf by Marlon James");
        library[17] = new Book(18, "ISBN 978-0-385-53730-0", "The Hate U Give by Angie Thomas");
        library[18] = new Book(19, "ISBN 978-0-525-65617-5", "Legendborn by Tracy Deonn");
        library[19] = new Book(20, "ISBN 978-0-525-57575-9", "Children of Blood and Bone by Tomi Adeyemi");


        return library;

    }


}