class Solution {
    public boolean uniformArray(int[] nums) {
        int odd = 0;
        int even = 0;

        for(int num : nums){
            if(num%2==0)
            even++;
            else
            odd++;
        }

        return even==nums.length||odd==nums.length||even>0&&odd>0;
    }
}