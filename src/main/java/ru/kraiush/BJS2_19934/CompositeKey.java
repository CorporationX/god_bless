package ru.kraiush.BJS2_19934;

public record CompositeKey(String key1, Integer key2) {
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if (obj instanceof CompositeKey) {
            return key1.equals(((CompositeKey) obj).key1) && key2.equals(((CompositeKey) obj).key2);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return (key1 + key2).hashCode();
    }
}
