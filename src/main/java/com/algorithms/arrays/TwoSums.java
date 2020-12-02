package com.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/173/ Given an array of integers nums and an integer target, return
 * indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the
 * same element twice. Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] + nums[1] == 9, we return [0, 1]. You can return
 * the answer in any order.
 */
public class TwoSums {

    public int[] getTwoSum(final int[] nums, final int target) {
        /**
         *  using HashMap : Time Complexity O(N) space (N)
         *  can use hashSet as well.
         */
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (mp.containsKey(k)) {
                if (k == nums[i]) {
                    if(mp.get(k) != i) {
                        return new int[] { i, mp.get(k)};
                    }
                } else {
                    return new int[] { i, mp.get(k) };

                }
            }
            mp.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {

    }

    public int[] twoSum(final int[] nums, final int target) {
        /**
         * Time complexity O(N^2) and Space Complexity O(1).
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public int binarySearch(final int[] nums, final int b, int low) {
        /**
         * Time Complexity O(LogN) Binary search.
         */
        int hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + ((hi - low) / 2);
            if (nums[mid] == b) {
                return mid;
            } else if (b > nums[mid]) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;

    }

    public int[] twoSumBinarySearch(final int[] nums, final int target) {
        /**
         * This will return the elements that sum up to target. Time : O(NLogN+NLogN) space O(1)
         */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int b = target - nums[i];
            int j = binarySearch(nums, b, i + 1);
            if (j != -1) {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[] {};
    }

}
