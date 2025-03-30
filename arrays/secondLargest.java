package arrays;

import java.util.Arrays;

//Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.
public class secondLargest {

    //Brute-- nLogN,1
    public int secondLargestElement(int[] nums) {
        int n = nums.length;

        // Check if the array has less than 2 elements
        if (n < 2) {
            // Indicating no second largest element is possible
            return -1;
        }

        // Sort the array in ascending order
        Arrays.sort(nums);

        // Largest element will be at last index
        int largest = nums[n - 1];

        int secondLargest = -1;

        // Traverse the sorted array from right to left
        for (int i = n - 2; i >= 0; i--) {

            /* If the current element is not
            equal to the largest element*/
            if (nums[i] != largest) {

                /* Assign the current element
                as the second largest and break*/
                secondLargest = nums[i];
                break;
            }
        }

        // Return the second largest element
        return secondLargest;
    }

    //better--2N,1
    public int secondLargestElementBetter(int[] nums) {
        int n = nums.length;

        // Check if the array has less than 2 elements
        if (n < 2) {
            // If true, return -1
            // Exit the method
            return -1;
        }

        /*Initialize variables to store the
       largest and second largest elements*/
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // First traversal to find the largest element
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, nums[i]);
        }

        // Second traversal to find second largest element
        for (int i = 0; i < n; i++) {
            if (nums[i] > secondLargest  && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        // Return the second largest element
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    //Best--N,1



    public int secondLargestElementBest(int[] nums) {

        // Check if the array has less than 2 elements
        if (nums.length < 2) {
            // If true, return -1 there is no second largest element
            return -1;
        }

        /* Initialize variables to store the
        largest and second largest elements */
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        /*Single traversal to find thelargest
       and second largest elements*/
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            }
            else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }

        }

        // Return the second largest element
        return secondLargest == Integer.MIN_VALUE ?  -1 : secondLargest;
    }

}

