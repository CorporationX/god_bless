package faang.school.godbless.bjs2_9576;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

  private static final String DICTIONARY = "Словарь: ";

  public static void main(String[] args) {

    DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

    Map<String, String> dictionary = new HashMap<>();

    BiConsumer<String, String> addWordToDictionary = dictionary::put;

    dictionaryProcessor.processWord("Привет", "Hello", addWordToDictionary);
    dictionaryProcessor.processWord("Мир", "World", addWordToDictionary);
    dictionaryProcessor.processWord("Программирование", "Programming", addWordToDictionary);

    System.out.println(DICTIONARY + dictionary);

  }

}
