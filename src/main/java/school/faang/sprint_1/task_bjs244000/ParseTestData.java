package school.faang.sprint_1.task_bjs244000;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@UtilityClass
public class ParseTestData {

    public List<User> getUsersFromData(String data, String delimiterForStrings, String delimiterForValues) {
        return parseStringsFromDataSkipHeader(data, delimiterForStrings).stream()
                .map(userDataString -> {
                    List<String> dataForCurrentUser = parseDataString(userDataString, delimiterForValues);
                    try {
                        int id = Integer.parseInt(dataForCurrentUser.get(0));
                        String name = dataForCurrentUser.get(1);
                        int age = Integer.parseInt(dataForCurrentUser.get(2));
                        Set<String> hobbies = getHobbies(dataForCurrentUser.subList(3, dataForCurrentUser.size()));
                        return new User(id, name, age, hobbies);
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        throw new IllegalArgumentException("data format is incorrect");
                    }
                })
                .toList();
    }

    public List<Set<String>> getHobbiesFromData(String data, String delimiterForStrings, String delimiterForValues) {
        return parseStringsFromDataSkipHeader(data, delimiterForStrings).stream()
                .map(hobbyDataString -> {
                    List<String> hobbiesList = parseDataString(hobbyDataString, delimiterForValues);
                    return getHobbies(hobbiesList);
                })
                .toList();
    }

    private List<String> parseStringsFromDataSkipHeader(String data, String fileDelimiter) {
        if (data.isBlank() || fileDelimiter.isBlank()) {
            throw new IllegalArgumentException("data and delimiter cannot be empty");
        }

        return Stream.of(data.split(fileDelimiter))
                .skip(1)
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .toList();
    }

    private static List<String> parseDataString(String s, String stringDelimiter) {
        return Stream.of(s.split(stringDelimiter))
                .map(String::trim)
                .toList();
    }

    private static Set<String> getHobbies(List<String> data) {
        return new HashSet<>(data);
    }
}
