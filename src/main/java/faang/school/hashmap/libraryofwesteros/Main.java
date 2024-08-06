package faang.school.hashmap.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap <Book, String> mapBooks = new HashMap<>();
    public static void main(String[] args) {
        mapBooks.put(new Book("Вишневый сад","Антон Чехов",1904),"A1-1");
        mapBooks.put(new Book("Дом с мезонином","Антон Чехов",1896),"A1-2");
        mapBooks.put(new Book("Чайка","Антон Чехов",1896),"A1-2");
        mapBooks.put(new Book("Человек в футляре","Антон Чехов",1898),"A2-4");
        mapBooks.put(new Book("Исповедь","Лев Толстой",1882),"А1-2");

        addBook(new Book("Воскресение","Лев Толстой",1889),"А2-4");
        listBook();
        infoShelfNumb("Воскресение","Лев Толстой",1889);
        deleteBook("Воскресение","Лев Толстой",1889);
        listBook();

    }
    public static void addBook (Book book, String shelfNumb){
        mapBooks.put(book,shelfNumb);
    }
    public static void deleteBook (String bTitle, String bAuthor, int bYear){
        mapBooks.remove(new Book(bTitle,bAuthor,bYear));
    }
    public static void infoShelfNumb (String bTitle, String bAuthor, int bYear){
        System.out.println(mapBooks.get(new Book(bTitle,bAuthor,bYear)));
    }
    public static void listBook () {
        for (Map.Entry entry: mapBooks.entrySet()){
            System.out.println(entry);
        }
    }

}
