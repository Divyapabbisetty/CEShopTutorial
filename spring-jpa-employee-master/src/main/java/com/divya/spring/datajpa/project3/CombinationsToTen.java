package com.divya.spring.datajpa.project3;

import java.util.ArrayList;
import java.util.List;

public class CombinationsToTen {

    public static void main(String args[]) {
        if(args.length == 0){
            System.out.println("Need Input");
        }
        try {
            int target = 10;
            Integer[] numbers = new Integer[args.length];
            for (int j = 0; j < args.length; j++) {
                numbers[j] = Integer.parseInt(args[j]);
            }
            for (int i = 0; i < numbers.length; i++) {
                recurseAdd(i, numbers, new ArrayList<Integer>(), 0, target);
            }
        } catch (NumberFormatException e){
            System.out.println("Please don't pass alphabets");
        }
    }

    private static void recurseAdd(int currentIndex, Integer[] numbers, List<Integer> usedNumbers, int sum, int target) {
        if (currentIndex >= numbers.length) {
            return;
        }
        sum = sum + numbers[currentIndex];
        usedNumbers.add(numbers[currentIndex]);
        if (sum == target) {
            System.out.println(usedNumbers);
            return;
        }
       if (sum > target) {
            return;
        }
        for (int i = currentIndex + 1; i < numbers.length; i++) {
            recurseAdd(i, numbers, new ArrayList<>(usedNumbers), sum, target);
        }
    }
}
