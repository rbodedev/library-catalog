// imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.List;


public class LibraryManagementDemo {
    public static void main (String[] args) throws IOException {

        String filename = "books.txt"; 
        
        List<Map<String, String>> bookCatalog = new ArrayList<>();

        File file = new File(filename);
        System.out.println(file);
        Scanner booksList = new Scanner(file);
        Scanner userIn = new Scanner(System.in);
        
        while (booksList.hasNext()) {
            String titleAuthor;
            titleAuthor = booksList.nextLine();
            System.out.println(titleAuthor);
            bookCatalog.add(LibraryManage.createCatalog(titleAuthor));

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
    }



}