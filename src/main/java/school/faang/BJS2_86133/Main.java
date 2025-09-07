package school.faang.BJS2_86133;

public class Main {
    public static void main(String[] args) {
        LibrarySystem ls = new LibrarySystem();
        ls.removeBook("«Властелин колец»", "Джон Р. Р. Толкин", 1937);
        ls.addBook("«Властелин колец»", "Джон Р. Р. Толкин", 1937, "13 ряд 12 полка");
        System.out.println(ls.findBook("«Тёмные начала»", "Филип Пулман", 1995));
        ls.addBook("«Гордость и предубеждение»", "Джейн Остин", 1797, "4 ряд 1 полка");
        ls.printAllBooks();
        ls.addBook("«Тёмные начала»", "Филип Пулман", 1995, "3 ряд 6 полка");
        ls.addBook("«Автостопом по галактике»", "Дуглас Адамс", 1979, "13 ряд 12 полка");
        ls.findBook("«Властелин колец»", "Джон Р. Р. Толкин", 1937);
        ls.findBook("«Властелин колец»", "Джон Р. Р. Толкин", 1937);
        ls.removeBook("«Властелин колец»", "Джон Р. Р. Толкин", 1937);
        ls.addBook("«Гарри Поттер и Кубок огня»", "Джоан Роулинг", 200, "8 ряд 8 полка");
        ls.printAllBooks();
    }
}
