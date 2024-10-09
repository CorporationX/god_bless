package org.example.model.droidSecrets;
@FunctionalInterface
public interface DroidMessageEncryptor {
    String doIt(String message, Integer key);
}
