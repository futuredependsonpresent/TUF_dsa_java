package arrays;

public class linearSearch {
    public int linearSearch(int nums[], int target) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target) return i;
        }
        return -1;
    }
}
