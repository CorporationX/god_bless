package Synchronization_2;

public class GooglePhoto {

    private String link;

    public GooglePhoto() {
        this.link = generateLink();
    }

    private String generateLink() {
        StringBuilder buffer = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            buffer.append((char) ((int) (Math.random() * 25) + 97));
        }
        return buffer.toString();
    }

    public String getLink() {
        return link;
    }
}
