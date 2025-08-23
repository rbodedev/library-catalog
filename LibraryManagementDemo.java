// imports
import java.util.Scanner;

import java.io.*;



public class LibraryManagementDemo {
    public static void main (String[] args) throws IOException {

        String filename = "books.txt"; 
        
        File file = new File(filename);
        System.out.println(file);
        Scanner catalog = new Scanner(file);
        
        
        while (catalog.hasNext()) {
            String titleAuthor;
            titleAuthor = catalog.nextLine();
            System.out.println(titleAuthor);
        }
    }



}