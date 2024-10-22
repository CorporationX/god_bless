package school.faang.BJS2_37804;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо " + (i + 1) + " отправлено");
        }
    }
}
