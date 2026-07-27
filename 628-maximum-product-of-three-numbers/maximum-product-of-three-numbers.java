class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int res =Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],Math.max(nums[0]*nums[1]*nums[2],Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[0]*nums[nums.length-2]*nums[nums.length-1])));

        return res;
    }
}