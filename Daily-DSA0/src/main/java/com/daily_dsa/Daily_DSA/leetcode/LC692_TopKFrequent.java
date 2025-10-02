package com.daily_dsa.Daily_DSA.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC692_TopKFrequent {
    public static void main(String[] args) {
        LC692_TopKFrequent as= new LC692_TopKFrequent();
        String[] words=new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println(as.topKFrequent(words,2));
    }
    // this approach is not optimized well
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldV, newV) -> oldV,
                        LinkedHashMap::new
                ));
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String,Integer> as : sortedMap.entrySet()){
            if(ans.size() == k) break;
            ans.add(as.getKey());
        }
        return ans;
    }

    //TO BE ->  to write optimized approach for it
}
