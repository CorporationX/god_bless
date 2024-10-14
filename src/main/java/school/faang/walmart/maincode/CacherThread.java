package school.faang.walmart.maincode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CacherThread extends Thread {
    private String casherId;
    private int[] customerItems;

    @Override
    public void run() {

    }
}
