package org.example.model.droidSecrets;
@FunctionalInterface
public interface CaesarCipher  {
    String applyCipher(String message, Integer key);
}
