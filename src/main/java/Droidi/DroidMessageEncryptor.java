package Droidi;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String cypherMsg(String msg, int cypher);
}
