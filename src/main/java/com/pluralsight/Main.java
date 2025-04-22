package com.pluralsight;

public class Main {
    public static void main(String[] args) {

// create new book
        Book[] library = getPopulatedLibrary();

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