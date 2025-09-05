package com.daily_dsa.Daily_DSA.two_pointers_techniques.opposite_end;

import java.util.Arrays;

public class LC167_TwoSumII {

    public static void main(String[] args) {
        //test method
        System.out.println("output -> "+ Arrays.toString(twoSum(new int[]{2, 7, 11, 15},9)));
        System.out.println("output -> "+ Arrays.toString(twoSum(new int[]{2, 7,9, 11, 15},18)));
        System.out.println("output -> "+ Arrays.toString(twoSum(new int[]{2, 7,8, 11, 15},17)));
        System.out.println("output -> "+ Arrays.toString(twoSum(new int[]{2, 7,10, 11, 15},25)));
        System.out.println("output -> "+ Arrays.toString(twoSum(new int[]{2, 7,10, 11, 17},21)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[] { start + 1, end + 1 };
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] { -1, -1 };
    }
}
