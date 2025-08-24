// imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.List;


public class LibraryManagementDemo2 {
    public static void main (String[] args) throws IOException {

        String filename = "books.txt"; 
        
        List<Map<String, Object>> bookCatalog = new ArrayList<>();

        File file = new File(filename);
        System.out.println(file);
        Scanner booksList = new Scanner(file);
        Scanner userIn = new Scanner(System.in);
        
        while (booksList.hasNext()) {
            String titleAuthor;
            titleAuthor = booksList.nextLine();
            System.out.println(titleAuthor);
            bookCatalog.add(LibraryManage2.createCatalog(titleAuthor));
            // availableBooks.add(LibraryManage.createCatalog(titleAuthor));
        }

        System.out.println(bookCatalog);

        boolean loopBreak = true;

        while(loopBreak == true) {
            LibraryManage2.listTitles(bookCatalog);
            System.out.print("please enter the title of the book you want to checkout or enter false to leave: ");
            String input = userIn.nextLine();
            bookCatalog = LibraryManage2.checkoutBook(bookCatalog, input);
            if (input.equals("false")) {
                loopBreak = false;
            }

        }


    }

}