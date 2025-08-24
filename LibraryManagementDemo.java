// imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class LibraryManagementDemo {
    //main program entry point
    public static void main (String[] args) throws IOException {
        //the main library catalog
        String filename = "books.txt";
        //the bookCatalog is used to hold all the quantities of books, titles, and athors 
        List<Map<String, Object>> bookCatalog = new ArrayList<>();
        //file reading object line
        File file = new File(filename);
        //scanner object to read in the file
        Scanner booksList = new Scanner(file);
        //scanner object to read in user entries
        Scanner userIn = new Scanner(System.in);
        //scanner object to read in librarian inputs
        Scanner librarianIn = new Scanner(System.in);
        //while loop to read in the text file line by line
        while (booksList.hasNext()) {
            String titleAuthor;
            titleAuthor = booksList.nextLine();
            bookCatalog.add(LibraryManage.createCatalog(titleAuthor));
        }
        //initial listing of all books for user to see
        LibraryManage.listTitles(bookCatalog);
        //global loop control variable 
        boolean loopBreak = true;

        while(loopBreak == true) {
            System.out.println();
            System.out.print("please enter the title of the book you want to checkout or enter false to leave (enter \"librarian\" for librarian mode): ");
            String input = userIn.nextLine();
            //call to static method in LibraryManage class for user to checkout a book
            bookCatalog = LibraryManage.checkoutBook(bookCatalog, input);
            //user continuation check
            if (input.equals("false")) {
                loopBreak = false;
            }
            //librarian mode check
            String librarianCheck = input.toLowerCase();
            //librarian authentication conditional
            if (librarianCheck.equals("librarian")) {
                System.out.print("Please enter password (note: it is \"pw\"): ");
                input = librarianIn.nextLine();
                //password check conditional
                if (input.equals("pw")) {
                    //String variable holding librarian commands
                    String command;
                    System.out.println("Librarian mode activated");
                    System.out.println("In this mode you can enter command types: ADD, CHECKIN, REMOVE, SEARCH, LIST, EXIT");
                    System.out.print("Please enter your command type: ");
                    command = librarianIn.nextLine();
                    //command to lower case for consistency
                    command = command.toLowerCase();
                    //librarian command to add a book to the library book catalog
                    if (command.equals("add")) {
                        //dictionary to hold new book info in form of Arraylist objects
                        Map<String, Object> dict = new HashMap<>();
                        System.out.print("Please enter the new book title: ");
                        String title = librarianIn.nextLine();
                        System.out.print("Please enter the new book author: ");
                        String author = librarianIn.nextLine();
                        System.out.print("Please enter the new book quantity: ");
                        int quantity = librarianIn.nextInt();
                        //entry of data into the object
                        dict.put("Title", title);
                        dict.put("Author", author);
                        dict.put("quantity", quantity);
                        bookCatalog.add(dict);
                        System.out.println("New library catalog:");
                        //re-list the books after modification
                        LibraryManage.listTitles(bookCatalog);
                        System.out.println("librarian mode deactivated for security");
                    //librarian command to remove a book from the catalog, note this is to remove the book from libary, not decrement the quantity
                    } else if (command.equals("remove")) {
                        System.out.print("Please enter the title of the book to remove: ");
                        String title = librarianIn.nextLine();
                        bookCatalog = LibraryManage.removeBook(bookCatalog, title);
                        System.out.println("librarian mode deactivated for security");
                    //librarian command to search the libary catalog
                    } else if (command.equals("search")) {
                        System.out.print("Please enter a word from the title or author and a search will be conducted: ");
                        String search = librarianIn.nextLine();
                        LibraryManage.searchBook(bookCatalog, search);

                        System.out.println("librarian mode deactivated for security");
                    //librarian command to display all the books in the library catalog as well as onHand quantity
                    }else if (command.equals("list")) {
                        LibraryManage.listTitles(bookCatalog);
                        System.out.println("librarian mode deactivated for security");
                    //librarian command to stop the program
                    } else if (command.equals("exit")) {
                        loopBreak = false;
                        System.out.println("librarian mode deactivated for security");
                    //librarian command to check a book back in for a client, this will increment the book quantity regardless of initial amount of books to account for books from other districts
                    } else if (command.equals("checkin")) {
                        System.out.print("Please enter the title of the book to be returned: ");
                        String returning = librarianIn.nextLine();
                        bookCatalog = LibraryManage.returnBook(bookCatalog, returning);
                        System.out.println();
                    //any entry by librarian not in command structure is rejected
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