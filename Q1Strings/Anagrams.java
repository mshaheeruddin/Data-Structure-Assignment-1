package Q1Strings;

import java.util.Arrays;

public class Anagrams {

    public void checkAnagram(String str1, String str2) {
        String isAnAnagram = "Anagrams!";
        String notAnAnagram = "Not Anagrams!";
        boolean flag = false;

        if (str1.equalsIgnoreCase(str2)) {
            System.out.println(isAnAnagram);
        } else if (str1.length() != str2.length()) {
            System.out.println(notAnAnagram);
        } else if (str1.length() == str2.length()) {
            char[] charStr1 = str1.toCharArray();
            char[] charStr2 = str2.toCharArray();
            Arrays.sort(charStr1);
            Arrays.sort(charStr2);

            for (int i = 0; i < str1.length(); i++) {
                flag = charStr1[i] == charStr2[i];
            }
            if (flag)
                System.out.println(isAnAnagram);
            else
                System.out.println(notAnAnagram);
        }

    }


    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        anagrams.checkAnagram("anagram", "gmraana");
    }
}

