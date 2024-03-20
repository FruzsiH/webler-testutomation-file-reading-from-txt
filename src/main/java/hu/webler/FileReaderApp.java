package hu.webler;

import hu.webler.util.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderApp {

    public static void main(String[] args) {

        final String DELIMITER = ";";
        final String CATEGORY_FILE_PATH = "src/main/resources/category.txt";
        final String BOOK_FILE_PATH = "src/main/resources/book.txt";

        List<String[]> categories = FileHandler.readTxtFile(CATEGORY_FILE_PATH, DELIMITER);
        List<String[]> books = FileHandler.readTxtFile(BOOK_FILE_PATH, DELIMITER);

        Map<Integer, List<String>> bookCategoryMap = new HashMap<>();

        for (String[] book : books ) {
            String[] bookDetails = new String[book.length -1];
            System.arraycopy(book, 1, bookDetails, 0, bookDetails.length);
            String bookDetailsString = String.join(DELIMITER, bookDetails);

            int category = Integer.parseInt(book[0]);

            //bookCategoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(bookDetailsString);
            List<String> categoryBooks = bookCategoryMap.get(category);
            if(categoryBooks == null) {
                categoryBooks = new ArrayList<>();
                bookCategoryMap.put(category, categoryBooks);
            }
            categoryBooks.add(bookDetailsString);
        }

        for (String[] category : categories) {
            int categoryNumber = Integer.parseInt(category[0]);
            String categoryName = category[1];
            List<String> booksInCategory = bookCategoryMap.get(categoryNumber);
            if (booksInCategory != null) {
                System.out.println(categoryName + ":");
                for (String book : booksInCategory) {
                    System.out.println(book);
                }
                System.out.println();
            }
        }
    }
}
