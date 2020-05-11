package ru.stqa.pft.sandbox;

import java.util.*;

public class Iterrator {

    public static void main(String[] args) {

        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        Iterator<String> iter = states.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}