package faang.school.godbless.sprint3.DroneSecrets;

public class Droid {
    public String sendEncryptedMessage(String str, int num){
        DroidMessageEncryptor encryptor = (s,n)->{
            char[] arr = s.toCharArray();
            for (int i=0;i<arr.length;i++){
                arr[i]+=n;
            }
            return String.valueOf(arr);
        };
        return encryptor.act(str,num);
    }

    public String receiveEncryptedMessage(String str, int num){
        DroidMessageEncryptor decoder = (s,n)->{
            char[] arr = s.toCharArray();
            for (int i=0;i<arr.length;i++){
                arr[i]-=n;
            }
            return String.valueOf(arr);
        };
        return decoder.act(str,num);
    }

}
