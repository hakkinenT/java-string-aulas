package com.hakkinent.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharact {
    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //System.out.println(lengthOfLongestSubstring("bbbbb"));
        //System.out.println(lengthOfLongestSubstring2("pwwkew"));

        Set<Character> set = lengthOfLongestSubstring3("pwwkew");
        set.forEach(System.out::println);
        
    }

    

    private static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> substringsMap = generateSubstrings(s);
        
        int maxLength = 0;

        /*for (Map.Entry<String, Integer> entry : substringsMap.entrySet()) {
            String key = entry.getKey();
            
            if (key.length() > maxLength) {
                maxLength = key.length();
            }
        }*/


        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (isValid(substring.toCharArray())) {
                    if (substring.length() > maxLength) {
                        maxLength = substring.length();
                    }
                }
            }
        }


        return maxLength;
    }

    

    private static Map<String, Integer> generateSubstrings(String string) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int i = 0;
        int length = string.length();
        int j = length;
        while (i < length) {
            String sub = string.substring(i, j--);
            if(!map.containsKey(sub) && isValid(sub.toCharArray())) {
                map.put(sub, i);
            }
            
            if (j <= i) {
                i++;
                j = length;
            }
            
        }
        return map;
    }

    private static Map<String, Integer> createValidSubstringsMap(Map<String, Integer> substringsMap) {
        Map<String, Integer> validSubstringsMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : substringsMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (isValid(key.toCharArray())) {
                validSubstringsMap.put(key, value);
            }
        }
        return validSubstringsMap;
    }

    private static boolean isValid(char[] chars){
        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {
            for(int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // ALGORITMO Sliding Window (Janela Deslizante)
    private static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    private static Set<Character> lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new LinkedHashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return set;
    }
}
