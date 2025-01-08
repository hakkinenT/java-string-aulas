package com.hakkinent.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 4 };
        int target = 6;

        int[] result = subarrayWithTargetSum4(arr, target);
        System.out.println(Arrays.toString(result));
    }


    public static int[] subarrayWithTargetSum3(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        int sum = 0;
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            sum = nums[i] + nums[j];
            if(sum == target){
                return new int[]{i,j};
            }

            if(!map.containsKey(sum)){
                map.put(sum, new int[]{i,j});
            }

            if(j != nums.length - 1){
                j++;
            }else{
                j = 0;
                i = i == nums.length - 1 ? 0 : i + 1;
            }

        }
        return map.get(target); // Subarray não encontrado
    }

    public static int[] subarrayWithTargetSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            boolean containsKey = map.containsKey(key);
            int value = map.getOrDefault(key, -1);

            if(containsKey && value != i){
                return new int[]{i, value};
            }
        }

        return new int[]{-1, -1};
    }
}
