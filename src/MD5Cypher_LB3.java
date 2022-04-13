import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class MD5Cypher_LB3 {
    public static String getMd5(String input)
    {
        try {

            // Статичний метод getInstance викликається з хешуванням MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Метод digest() викликається для обчислення дайджесту повідомлення
            //  вхідного digest() повертає масив байтів
            byte[] messageDigest = md.digest(input.getBytes());

            // Перетворіть масив байтів у подання знаків
            BigInteger no = new BigInteger(1, messageDigest);

            // Перетворіть дайджест повідомлення в шістнадцяткове значення
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // Вивід помилки неправельних дайджестів
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод запуску
    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        System.out.println("Please enter your word: ");
        Scanner scanner = new Scanner(System.in);
        String inputCons = scanner.nextLine();
        System.out.println("Generated MD5 HashCode: " + getMd5(inputCons));
        System.out.println("For the word: " + inputCons);

    }
}
