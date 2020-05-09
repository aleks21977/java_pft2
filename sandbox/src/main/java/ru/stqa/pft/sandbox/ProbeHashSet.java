package ru.stqa.pft.sandbox;

import java.util.HashSet;

public class ProbeHashSet {
    public static void main(String[] args) {

        java.util.HashSet<Integer> intSet = new java.util.HashSet<>();
        intSet.add(10);
        intSet.add(15);
        intSet.add(18);
        intSet.add(10);

        System.out.println(intSet);

        for (Integer integer : intSet) {
            System.out.println(integer + 100);
        }

        if (intSet.contains(15))
            intSet.clear();

        System.out.println(intSet);
    }
}
