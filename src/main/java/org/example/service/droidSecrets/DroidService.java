package org.example.service.droidSecrets;

import org.example.model.droidSecrets.Droid;

public class DroidService {
    public static void main(String[] args) {
        Droid Artur = new Droid("Artur");
        Droid Zhubanysh = new Droid("Zhubanysh");

        Artur.sendMessage(Zhubanysh, "Zhubanysh hello!", 3, Droid::encryptMessage);
    }
}
