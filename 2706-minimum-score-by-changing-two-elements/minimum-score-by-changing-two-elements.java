class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        
        if(nums.length<=3) return 0;

        int score = Math.min(nums[nums.length - 1] - nums[2], Math.min(nums[nums.length - 2] - nums[1],nums[nums.length - 3] - nums[0]));


        return score;
    }
}