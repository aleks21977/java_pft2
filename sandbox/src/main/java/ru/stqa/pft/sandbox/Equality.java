package ru.stqa.pft.sandbox;

public class Equality {

    public static void main(String[] args) {
        //смотреть лекцию l3_m4
        String s1 = "firefox 2.0";
        String s2 = new String(s1);
        String s3 = "firefox " + Math.sqrt(4.0);

        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println(s1);
        System.out.println(s3);
    }
}
