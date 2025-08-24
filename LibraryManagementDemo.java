// imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.List;
import java.util.HashMap;


public class LibraryManagementDemo {
    public static void main (String[] args) throws IOException {

        String filename = "books.txt"; 
        
        List<Map<String, Object>> bookCatalog = new ArrayList<>();

        File file = new File(filename);
        // System.out.println(file);
        Scanner booksList = new Scanner(file);
        Scanner userIn = new Scanner(System.in);
        Scanner librarianIn = new Scanner(System.in);

        while (booksList.hasNext()) {
            String titleAuthor;
            titleAuthor = booksList.nextLine();
            // System.out.println(titleAuthor);
            bookCatalog.add(LibraryManage.createCatalog(titleAuthor));
            // availableBooks.add(LibraryManage.createCatalog(titleAuthor));
        }

        LibraryManage.listTitles(bookCatalog);

        boolean loopBreak = true;

        while(loopBreak == true) {
            System.out.println();
            System.out.print("please enter the title of the book you want to checkout or enter false to leave (enter \"librarian\" for librarian mode): ");
            String input = userIn.nextLine();
            bookCatalog = LibraryManage.checkoutBook(bookCatalog, input);
            System.out.println();
            if (input.equals("false")) {
                loopBreak = false;
            }
            String librarianCheck = input.toLowerCase();
            if (librarianCheck.equals("librarian")) {
                System.out.print("Please enter password (note: it is \"pw\"): ");
                input = librarianIn.nextLine();
                if (input.equals("pw")) {
                    String command;
                    System.out.println("Librarian mode activated");
                    System.out.println("In this mode you can enter command types: ADD, CHECKIN, REMOVE, SEARCH, LIST, EXIT");
                    System.out.print("Please enter your command type: ");
                    command = librarianIn.nextLine();
                    command = command.toLowerCase();
                    if (command.equals("add")) {
                        Map<String, Object> dict = new HashMap<>();
                        System.out.print("Please enter the new book title: ");
                        String title = librarianIn.nextLine();
                        System.out.print("Please enter the new book author: ");
                        String author = librarianIn.nextLine();
                        System.out.print("Please enter the new book quantity: ");
                        int quantity = librarianIn.nextInt();
                        dict.put("Title", title);
                        dict.put("Author", author);
                        dict.put("quantity", quantity);
                        bookCatalog.add(dict);
                        System.out.println("New library catalog:");
                        LibraryManage.listTitles(bookCatalog);
                        System.out.println("librarian mode deactivated for security");

                    } else if (command.equals("remove")) {
                        System.out.print("Please enter the title of the book to remove: ");
                        String title = librarianIn.nextLine();
                        bookCatalog = LibraryManage.removeBook(bookCatalog, title);
                        System.out.println("librarian mode deactivated for security");

                    } else if (command.equals("search")) {
                        System.out.print("Please enter a word from the title or author and a search will be conducted: ");
                        String search = librarianIn.nextLine();
                        LibraryManage.searchBook(bookCatalog, search);

                        System.out.println("librarian mode deactivated for security");

                    }else if (command.equals("list")) {
                        LibraryManage.listTitles(bookCatalog);
                        System.out.println("librarian mode deactivated for security");
                    } else if (command.equals("exit")) {
                        loopBreak = false;
                        System.out.println("librarian mode deactivated for security");
                    } else if (command.equals("checkin")) {
                        System.out.print("Please enter the title of the book to be returned: ");
                        String returning = librarianIn.nextLine();
                        bookCatalog = LibraryManage.returnBook(bookCatalog, returning);
                        System.out.println();
                    } else {
                        System.out.println("Illegal or no command entered, deactivating librarian mode for security. If this problem persists contact support.");
                        continue;
                    }

                } else {
                    System.out.println("Incorrect password, client mode returned");
                }

            }

        }

    }

}