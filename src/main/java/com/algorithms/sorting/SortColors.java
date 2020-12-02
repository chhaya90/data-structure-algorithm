package com.algorithms.sorting;

public class SortColors {

    public void sortColors(final int[] nums) {
        /**
         * Time Complexity  O(N + 3*N)  approximately O(N)
         * Space Complexity : O(3)   constant O(1)
         *
         */
        int[] cnt = new int[3];
        for (int i = 0; i <nums.length ; i++) {
             cnt[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i <3 ; i++) {
            int k = cnt[i];
            while (k-->0) {
                nums[j++] = i;
            }
        }
    }
}
