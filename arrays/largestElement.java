package arrays;

public class largestElement {
    public int largestElement(int[] nums) {
        int ans = nums[0];
        for(int i:nums)
        {
            if(i>ans) ans =i;
        }
        return ans;
    }
}
