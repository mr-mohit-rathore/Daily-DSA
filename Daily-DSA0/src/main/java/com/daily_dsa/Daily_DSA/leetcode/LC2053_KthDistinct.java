package com.daily_dsa.Daily_DSA.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC2053_KthDistinct {
    public static void main(String[] args) {

        System.out.println(kthDistinct(new String[]{"a","b","e","c","b","c","d"},2));
        System.out.println(kthDistinctByMohit(new String[]{"a","b","e","c","b","c","d"},2));
    }
    public static String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map=new LinkedHashMap<>();
        for(String a: arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        List<String> filteredList= map.entrySet()
                .stream()
                .filter(as -> as.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if(filteredList.size() >= k){
            return filteredList.get(k-1);
        }
        return "";
    }

    public static String kthDistinctByMohit(String[] arr, int k){
        Map<String,Integer> map= new HashMap<>();

        for(String a: arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(String a: arr){
            if(map.get(a) == 1 && --k == 0){
                return a;
            }
        }
        return "";
    }
}
