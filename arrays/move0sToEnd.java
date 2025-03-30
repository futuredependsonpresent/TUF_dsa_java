package arrays;


//Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same.
// This must be done in place, without making a copy of the array.
public class move0sToEnd {
    //brute force


    public void moveZeroes(int[] nums) {
        int n = nums.length;

        // Create a temporary array to store non-zero elements
        int[] temp = new int[n];
        int count = 0;

        // Copy non-zero elements to temp
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[count++] = nums[i];
            }
        }

        // Copy non-zero elements back to nums
        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }

        // Fill the rest with zeroes
        for (int i = count; i < n; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesBest(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[j]=nums[i];
                j+=1;
            }
        }

        while(j<nums.length)
        {
            nums[j]=0;
            j+=1;
        }
    }
}
