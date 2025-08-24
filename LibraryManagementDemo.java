// imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.List;


public class LibraryManagementDemo {
    public static void main (String[] args) throws IOException {

        String filename = "books.txt"; 
        
        List<Map<String, Object>> bookCatalog = new ArrayList<>();
        List<Map<String, Object>> availableBooks = new ArrayList<>();
        List<Map<String, String>> unavailableBooks = new ArrayList<>();
        List<Map<String, String>> intermediate = new ArrayList<>();
        List<Map<String, String>> skip = List.of(Map.of("Tile", "skip", "Author", "skip"));

        File file = new File(filename);
        System.out.println(file);
        Scanner booksList = new Scanner(file);
        Scanner userIn = new Scanner(System.in);
        
        while (booksList.hasNext()) {
            String titleAuthor;
            titleAuthor = booksList.nextLine();
            System.out.println(titleAuthor);
            bookCatalog.add(LibraryManage.createCatalog(titleAuthor));
            availableBooks.add(LibraryManage.createCatalog(titleAuthor));
        }

        System.out.println(bookCatalog);

        boolean loopBreak = true;

        while(loopBreak == true) {
            System.out.print("testtest: ");
            String input = userIn.nextLine();
            System.out.println("testtest");
            if (input.equals("false")) {
                loopBreak = false;
            }

        }

        LibraryManage.listTitles(bookCatalog);

        intermediate = LibraryManage.checkoutBook(availableBooks, unavailableBooks, "Hairy Ponder and the Rock");
        if (intermediate.equals())
        unavailableBooks = LibraryManage.checkoutBook(availableBooks, unavailableBooks, "Hairy Ponder and the Rock");
        availableBooks.removeAll(unavailableBooks);
        LibraryManage.listTitles(availableBooks);
        LibraryManage.listTitles(unavailableBooks);


    }



}