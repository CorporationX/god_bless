package school.faang.spring2.task_45433;

public class Main {
    public static void main(String[] args) {
        User alex = new User("Alex");
        User ben = new User("Ben");
        DictionaryProcessor.processWord("привет", "hello", alex.addWord());
        DictionaryProcessor.processWord("мир", "world", ben.addWord());
        System.out.println(alex.getDictionary());
        System.out.println(ben.getDictionary());
    }
}
