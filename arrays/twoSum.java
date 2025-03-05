package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
// Brute force  Approach ,TC: n**2, SC:1

//Iterate in array from 0 to last index of the array (lets call this variable i).
// Now, run another loop say(j) from i+1 to last index of the array.
//If sum of arr[i] and arr[j] equals to target then return the i and j.
// If no such indices are found then return -1 and -1.

    /* Function to find two indices in the array `nums`
       such that their elements sum up to `target`.
    */
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        //create ans array to store ans
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                /* if nums[i] + nums[j] is equal to
                   target put i and j in ans */
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }

            }
        }

        // Return {-1, -1} if no such pair is found
        return new int[]{-1, -1};
    }


// Better force  Approach ,TC: n, SC:n

//Iterate in array from 0 to last index of the array (lets call this variable i).
//Then check if the other required element(i.e. target-arr[i]) exists in the hashMap.
//If that element exists, then return the current index i.e. i, and the index of the element found using map.
//If that element does not exist, then just store the current element in the hashMap along with its index.
// Because in the future, the current element might be a part of our answer.
//If at the end we have traversed whole array and no pair is found, that means that the target is unachievable.
// In this case, return {-1, -1}.

//Time Complexity:O(N), where N is the size of the array. The loop runs N times in the worst case and
// searching in a hashmap takes O(1) generally. So the time complexity is O(N).
// Space Complexity: O(N) for using the map data structure.


    public int[] twoSum1(int[] nums, int target) {

        // Map to store (element, index) pairs
        Map<Integer, Integer> mpp = new HashMap<>();

        // Size of the nums array
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Current number in the array
            int num = nums[i];

            // Number needed to reach the target
            int moreNeeded = target - num;

            // Check if the complement exists in map
            if (mpp.containsKey(moreNeeded)) {
                /* Return the indices of the two
                numbers that sum up to target*/
                return new int[]{mpp.get(moreNeeded), i};
            }

            // Store current number and its index in map
            mpp.put(num, i);
        }

        // If no such pair found, return {-1, -1}
        return new int[]{-1, -1};
    }

//Another Approach ,n+nlogn , n

//Sort the given array and initialize two pointers i.e. left, which points to the 0th index, and right, which points to the last index.
//Now, using a loop, check the sum of arr[left] and arr[right] until left less than right.
//If sum of arr[left] and arr[right] greater than target, decrement the right pointer.
//If sum of arr[left] and arr[right] less than target, increment the left pointer.
//If sum of arr[left] and arr[right] equals to target, return the result. Finally, if no results are found we will return {-1, -1}.


//    Complexity Analysis
//    Time Complexity: O(N) + O(NxlogN), where N is size of the array. As the loop will run at most N times & sorting the array will take N * logN time complexity.
//
//    Space Complexity: O(1) not using any extra space.
//
//    Note: Here we are distorting the given array. So, if we need to consider this change, the space complexity will be O(N).




    public int[] twoSum2(int[] nums, int target) {
        // Size of the nums array
        int n = nums.length;

        // Array to store indices of two numbers
        int[] ans = new int[2];

        // 2D array to store {element, index} pairs
        int[][] eleIndex = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            eleIndex[i][0] = nums[i];
            eleIndex[i][1] = i;
        }

        /* Sort eleIndex by the first
        element in ascending order*/
        Arrays.sort(eleIndex,(int[] a , int[] b) -> Integer.compare(a[0],b[0]));
        /* Two pointers: one starting
        from left and one from right*/
        int left = 0, right = n - 1;

        while (left < right) {
            /* Calculate sum of elements at
            left and right pointers*/
            int sum = eleIndex[left][0] + eleIndex[right][0];

            if (sum == target) {

                /* If sum equals target,
                store indices and return*/
                ans[0] = eleIndex[left][1];
                ans[1] = eleIndex[right][1];
                return ans;

            } else if (sum < target) {

                /* If sum is less than target,
                move left pointer to the right*/
                left++;

            } else {

                /* If sum is greater than target,
                move right pointer to the left*/
                right--;

            }
        }

        // If no such pair found, return {-1, -1}
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11,13,1};
        int target = 14;

        // Create an instance of Solution class
        twoSum sol = new twoSum();

        int[] ans = sol.twoSum2(nums, target);

        // Print the result
        System.out.println("Indices of the two numbers that sum up to " + target + " are: [" + ans[0] + ", " + ans[1] + "]");
    }
}
