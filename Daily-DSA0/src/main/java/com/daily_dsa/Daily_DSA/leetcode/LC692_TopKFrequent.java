package com.daily_dsa.Daily_DSA.leetcode;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class LC692_TopKFrequent {
    public static void main(String[] args) {
        LC692_TopKFrequent as= new LC692_TopKFrequent();
        String[] words=new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println(as.topKFrequent(words,2));
        System.out.println(as.topKFrequentOptimized(words,2));
        System.out.println(as.topKFrequentByMohit(words,3));
    }
    // my both approaches are same, topKFrequent,topKFrequentByMohit
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(comparingByKey()))
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
    // Questions is find kth highest elements from String[] that must be non-increasing order
    //of frequence and words must be lexicographical order

    public List<String> topKFrequentByMohit(String[] words,int k){
        Map<String,Integer> map= new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        // now we have frequency of each word and
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(comparingByKey()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();

    }

    private List<String> topKList = null; // stores the final top k words
    public List<String> topKFrequentOptimized(String[] words, int k) {
        final Map<String, Integer> frequencyMap = new HashMap<>();
        final List<String> uniqueWords = new ArrayList<>();

        return new AbstractList<>() {
            @Override
            public String get(int index) {
                initialize();
                return topKList.get(index);
            }

            @Override
            public int size() {
                initialize();
                return topKList.size();
            }

            private void initialize() {
                if (topKList != null) return; // already initialized

                // Count frequency of each word
                for (String word : words) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }

                // Collect all unique words
                uniqueWords.addAll(frequencyMap.keySet());

                // Sort by frequency descending, then lexicographically
                Comparator<String> comparator = (String w1, String w2) -> {
                    int freq1 = frequencyMap.get(w1);
                    int freq2 = frequencyMap.get(w2);

                    if (freq1 < freq2) return 1;      // lower frequency comes later
                    else if (freq1 > freq2) return -1; // higher frequency comes first
                    else return w1.compareTo(w2);      // same frequency -> alphabetical order
                };

                uniqueWords.sort(comparator);

                // Keep only top k words
                topKList = uniqueWords.subList(0, k);
            }
        };
    }
}
