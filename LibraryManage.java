import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LibraryManage {
    // List<Map<String, Integer>> bookCatalog = new ArrayList<>();

    public static Map createCatalog (String book) {
        Map<String, String> dict = new HashMap<>();
        String title = book.split(": ")[0];
        String author = book.split(": ")[1];
        dict.put("Title", title);
        dict.put("Author", author);
        
        return dict; 
    }

    public static void listTitles (List<Map<String, String>> bookCatalog) {
        for (int i = 0; i < bookCatalog.size(); i++) {
            System.out.println(bookCatalog.get(i));
            Map<String, String> current = bookCatalog.get(i);
            String title = current.get("Title");
            String author = current.get("Author");
            System.out.println("Title: " + title + ", Author: " + author);
        }
    }
}