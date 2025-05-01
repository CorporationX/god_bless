package school.faang.BJS2_73080;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "Помыть посуду";
        System.out.println(Arrays.toString(text.getBytes(StandardCharsets.UTF_8)));
        System.out.println(text);
        System.out.println("hhh");
    }
}
