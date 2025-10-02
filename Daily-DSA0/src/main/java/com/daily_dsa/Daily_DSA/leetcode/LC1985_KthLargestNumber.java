package com.daily_dsa.Daily_DSA.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class LC1985_KthLargestNumber {
    public static void main(String[] args) {
        String[] arr= new String[]{"3","6","7","10"};
        int k=4;
        System.out.println(kthLargestNumber(arr,k));
    }
    public static String kthLargestNumber(String[] nums, int k) {

        System.out.println(Arrays.stream(nums)
                .sorted(Comparator.comparingInt(as-> Integer.parseInt((String) as)).reversed())
                .toList());
        //Arrays.sort(nums,Comparator.comparing(BigInteger::new));
        //return nums[nums.length-k];

    return Arrays.stream(nums)
                .sorted(Comparator.comparing(BigInteger::new))
                .toList()
                .get(nums.length -k);
    }
}
