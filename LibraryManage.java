import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LibraryManage {

    public static Map createCatalog (String book) {
        Map<String, String> dict = new HashMap<>();
        String title = book.split(": ")[0];
        String author = book.split(": ")[1];
        dict.put("Title", title);
        dict.put("Author", author);
        
        return dict; 
    }

    public static void listTitles (List<Map<String, String>> bookCatalog) {
        int counter = 1;
        for (int i = 0; i < bookCatalog.size(); i++) {
            
            Map<String, String> current = bookCatalog.get(i);
            String title = current.get("Title");
            String author = current.get("Author");
            System.out.println(counter + ": Title: " + title + ", Author: " + author);
            counter++;
        }
    }

    public static List<Map<String, String>> checkoutBook (List<Map<String, String>> availableBooks, List<Map<String, String>> unavailableBooks, String title) {
        boolean loopBreak = true;
        while(true) {
            for (int i = 0; i < availableBooks.size(); i++) {
                Map<String, String> current = availableBooks.get(i);
                if (current.get("Title").equals(title)) {
                    unavailableBooks.add(availableBooks.get(i));
                    // availableBooks.remove(availableBooks.get(i));
                    System.out.println("You are checking out " + title);
                    loopBreak = false;
                    return unavailableBooks;
                }
            } 
            for (int i = 0; i < unavailableBooks.size(); i++) {
                Map<String, String> current = unavailableBooks.get(i);
                if (current.get("Title").equals(title)) {
                    System.out.println("Sorry but " + title + " is checked out already.");
                    loopBreak = false;
                    List<Map<String, String>> skip = List.of(Map.of("Tile", "skip", "Author", "skip"));
                    return skip;
                }
            }
            System.out.println("Incorrect title, please re-enter");
            List<Map<String, String>> skip = List.of(Map.of("Tile", "skip", "Author", "skip"));
            return skip;

        }


    }
}