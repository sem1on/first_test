package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
    }

    public static int getRandomInt(int min, int max)  {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomString(int lenght) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sd = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            sd.append(AB.charAt(rnd.nextInt(AB.length())));
        return sd.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(8) + "@mail.com";
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }
}
