package school.faang.bjs246624;

public class DroidMessageMutatorEncrypt implements DroidMessageMutator {

    @Override
    public String mutate(String message, Integer key) {
        key %= 26;
        StringBuilder result = new StringBuilder();
        for (char element : message.toCharArray()) {
            if (element >= 65 && element <= 90) {
                element += key;
                if (element > 90) {
                    element -= 26;
                }
            } else if (element >= 97 && element <= 122) {
                element += key;
                if (element > 122) {
                    element -= 26;
                }
            }
            result.append(element);
        }
        return result.toString();
    }

}
