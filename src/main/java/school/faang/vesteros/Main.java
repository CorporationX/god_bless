package school.faang.vesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bock bock1 = new Bock();
        bock1.setTitle("The Lord of the Rings");
        bock1.setAuthor("J.R.R. Tolkien");
        bock1.setYear("1954");
        Bock bock2 = new Bock();
        bock2.setTitle("Harry Potter");
        bock2.setAuthor("J.K. Rowling");
        bock2.setYear("1997");

        Map<Bock, String> bocks = new HashMap<>();
        bocks.put(bock1, "2");
        bocks.put(bock2, "15");

        bock1.deleteBock(bocks, "The Lord of the Rings", "J.R.R. Tolkien", "1954");
        bock1.addBoock(bocks, "Sergeya Kniga", "J.R.R. Tolkien", "1937");


        for (Map.Entry<Bock, String> bock : bocks.entrySet()) {
            System.out.println(bock.getKey());
        }
    }
}
