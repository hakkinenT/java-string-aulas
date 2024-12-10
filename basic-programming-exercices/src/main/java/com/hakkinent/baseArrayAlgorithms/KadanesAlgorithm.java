package com.hakkinent.baseArrayAlgorithms;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,10,7,9,15};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
}
