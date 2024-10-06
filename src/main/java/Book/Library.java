package Book;

import java.util.HashMap;
import java.util.Map;

public class Library {
    HashMap<Book, String> placebook = new HashMap<>();

    public void addbook(Book book, String place){
        placebook.put(book,place);
    }

    public void removebook(Book book) {
        placebook.remove(book);

    }

    public void findBookPlace(Book book){
        String place = placebook.get(book);
        System.out.println(book + "лежит на полке № " + place);
    }

    public void readMap(HashMap<Book, String> map){
        for(Map.Entry<Book,String> book: placebook.entrySet()){
            System.out.println(book.getKey() + "лежит на полке № " + book.getValue());
        }
    }

}
