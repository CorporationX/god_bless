package school.faang.task_45432;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        // Добавление слов и их переводов
        dictionaryProcessor.addWord("привет", "hello");
        dictionaryProcessor.addWord("мир", "world");
        dictionaryProcessor
                .addWord("программирование", "programming");

        System.out.println(dictionaryProcessor.getDictionary());
    }
}
