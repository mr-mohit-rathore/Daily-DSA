package com.daily_dsa.Daily_DSA.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSumI {

    public static void main(String[] args) {

        int[] arr= new int[]{1,2,4,3,2,5,2};
        int target=5;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSumOptimized(arr, target)));
    }

    private static int[] twoSum(int[] arr, int target) {
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                    return new int []{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    private static int[] twoSumOptimized(int[] arr , int target){
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int complement=target-arr[i];
            if(map.containsKey(complement)){
                return new int []{map.get(complement),i};
            }
            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }
}
