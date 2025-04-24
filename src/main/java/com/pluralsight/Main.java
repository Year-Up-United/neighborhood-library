package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    private static void ShowScreenHome() {
        String homeScreenPrompt = "Welcome to the library!\n" +
                "Please select an option from the following:\n" +
                "     1 - Show Available Books\n" +
                "     2 - Show Checked Out Books\n " +
                "    0 - Exit App\n" +
                "(1,2,0): ";

        // define option
        int option;
        do {
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

    private static void ShowScreenAvailableBooks() {
        System.out.println("\nAvailable Books:\n");

        boolean anyAvailable = false;
        for (Book book : library) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getFormattedString());

                //System.out.printf("%-5d %-55s %-23s\n", book.getId(), book.getTitle(), book.getIsbn());
//                System.out.println("ID: " + book.getId());
//                System.out.println("Title: " + book.getTitle());
//                System.out.println("ISBN: " + book.getIsbn());
//                System.out.println();
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


    private static void ShowScreenCheckedOutBooks() {
        System.out.println("\nChecked Out Books:\n");

        boolean anyCheckedOut = false;
        for (Book book : library) {
            if (book.isCheckedOut()) {
                System.out.println(book.getFormattedString());
//                System.out.println("ID: " + book.getId());
//                System.out.println("Title: " + book.getTitle());
//                System.out.println("ISBN: " + book.getIsbn());
//                System.out.println("Checked out to: " + book.getCheckedOutTo());
//                System.out.println();
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

    //
    private static Book[] getPopulatedLibrary() {


        FileReader fr = null;
        try {
            fr = new FileReader("books.txt");
            BufferedReader reader = new BufferedReader(fr);

            Book[] booksTemp = new Book[1000];
            int size = 0;
            String dataString;

            while ((dataString = reader.readLine()) != null) {

                booksTemp[size] = getBookFromEncodedString(dataString);

                size++;
            }
            Book[] booksFinal = Arrays.copyOf(booksTemp, size);
            return booksFinal;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static Book getBookFromEncodedString(String encodedBook) {

        String[] temp = encodedBook.split(Pattern.quote("|"));


        int id = Integer.parseInt(temp[0]);
        String isbn = temp[1];
        String title = temp[2];
        Book result = new Book(id, isbn, title);
        return result;
    }

}