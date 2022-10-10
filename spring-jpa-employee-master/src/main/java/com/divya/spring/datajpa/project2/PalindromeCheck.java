package com.divya.spring.datajpa.project2;

public class PalindromeCheck {

    public static boolean isPalindromeReverseTheString(String text) {
        StringBuilder reverse = new StringBuilder();
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        char[] plain = clean.toCharArray();
        for (int i = plain.length - 1; i >= 0; i--) {
            reverse.append(plain[i]);
        }
        return (reverse.toString()).equals(clean);
    }

    public static void main(String[] args)
    {
        // Input string
        String str = args[0];
        if(str == null) {
            System.out.println("Need input to check");
            return;
        }
        boolean A = isPalindromeReverseTheString(str);
        System.out.println(A ? "String passed is palindrome" : "String passed in is not a palindrome");
    }

}
