import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LibraryManage {

    public static Map createCatalog (String book) {
        Map<String, Object> dict = new HashMap<>();
        Integer onHand = 1;
        String title = book.split(": ")[0];
        String author = book.split(": ")[1];
        dict.put("Title", title);
        dict.put("Author", author);
        dict.put("quantity", onHand);
        return dict; 
    }

    public static void listTitles (List<Map<String, Object>> bookCatalog) {
        for (int i = 0; i < bookCatalog.size(); i++) {
            
            Map<String, Object> current = bookCatalog.get(i);
            Object title = current.get("Title");
            Object author = current.get("Author");
            Object quantity = current.get("quantity");
            System.out.println(quantity + " available of " + "Title: " + title + ", Author: " + author);

        }
    }

    public static List<Map<String, Object>> checkoutBook (List<Map<String, Object>> bookCatalog, String bookTitle) {
        for (int i = 0; i < bookCatalog.size(); i++) {
            Map<String, Object> book = bookCatalog.get(i);
            if (book.get("Title").equals(bookTitle) && ((Integer) book.get("quantity")) == 0) {
                System.out.println("Sorry none of that book available");
            } else if (book.get("Title").equals(bookTitle) && ((Integer) book.get("quantity")) > 0) {
                int onHandNow = ((Integer) book.get("quantity")) - 1;
                book.put("quantity", onHandNow);
                bookCatalog.remove(i);
                bookCatalog.add(0, book);
                System.out.println("You have checked out " + bookTitle);
            } else {
                continue;
            }
        }
        return bookCatalog;
    }

    public static List<Map<String, Object>> removeBook (List<Map<String, Object>> bookCatalog, String bookTitle) {
        for (int i = 0; i < bookCatalog.size(); i++) {
            Map<String, Object> book = bookCatalog.get(i);
            if (book.get("Title").equals(bookTitle)) {
                bookCatalog.remove(i);
                System.out.println(bookTitle + " removed!");
                return bookCatalog;
            } else {
                continue;
            }
        }
        return bookCatalog;
    }

    public static void searchBook (List<Map<String, Object>> bookCatalog, String search) {
        
        for (int i = 0; i < bookCatalog.size(); i++) {
            Map<String, Object> book = bookCatalog.get(i);
            
            String currentString;

            currentString = ((String) book.get("Title"));
            String[] words = currentString.split(" ");
            for (int j = 0; j < words.length; j++) {
                if (words[j].equals(search)) {
                    System.out.print("Found: " + book);
                }
            }
        }

    }

    public static List<Map<String, Object>> returnBook (List<Map<String, Object>> bookCatalog, String bookTitle) {
        for (int i = 0; i < bookCatalog.size(); i++) {
            Map<String, Object> book = bookCatalog.get(i);
            if (book.get("Title").equals(bookTitle)) {
                int onHandNow = ((Integer) book.get("quantity"));
                onHandNow++;
                book.put("quantity", onHandNow);
                bookCatalog.remove(i);
                bookCatalog.add(0, book);
                System.out.println(book.get("Title") + " has been returned!");
            } else {
                continue;
            }
        }
        return bookCatalog;
    }





}
