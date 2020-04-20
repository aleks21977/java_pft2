package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        for (int i = 0; i < langs.length; i++) {
            System.out.println("Я хочу выучить " + langs[i] + "_1");
        }

        System.out.println();

        // для перебора элементов коллекции лучше использовать специальную конструкцию цикла
        for (String l: langs) {
            System.out.println("Я хочу выучить " + l + "_2");
        }

        System.out.println();

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
//        languages.add("Java");
//        languages.add("C#");
//        languages.add("Python");

        for (String l: languages) {
            System.out.println("Я хочу выучить " + l + "_3");
        }
        System.out.println();
        //аналог
        for (int i = 0; i < languages.size(); i++) {
            System.out.println("Я хочу выучить " + languages.get(i) + "_4");
        }
    }
}
