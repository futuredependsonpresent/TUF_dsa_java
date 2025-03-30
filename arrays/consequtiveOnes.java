package arrays;

public class consequtiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int consecutiveOnes = 0;
        for(int i:nums)
        {
            if(i==1)
            {
                ans+=1;
                consecutiveOnes=Math.max(consecutiveOnes,ans);
            }
            else
            {
                ans=0;
            }
        }

        return consecutiveOnes;
    }
}
