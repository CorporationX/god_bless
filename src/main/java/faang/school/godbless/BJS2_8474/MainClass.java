package faang.school.godbless.BJS2_8474;

public class MainClass {
    public static void main(String[] args) {
        Main main = new Main();

        main.findBook("Мастер и Маргарита", "Булгаков", 1928);
        main.findAllBooks();
        main.deleteBook("Мастер и Маргарита", "Булгаков", 1928);
        main.findAllBooks();
    }
}
