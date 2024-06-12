package faang.school.godbless.lambdas4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

// �������� �������
        Map<String, String> dictionary = new HashMap<>();

// �������� BiConsumer ��� ���������� ����� � ��� �������� � �������
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

// ���������� ���� � �� ���������
        dictionaryProcessor.processWord("������", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("���", "world", addWordToDictionary);
        dictionaryProcessor.processWord("����������������", "programming", addWordToDictionary);

        System.out.println("�������: " + dictionary);
    }
}
