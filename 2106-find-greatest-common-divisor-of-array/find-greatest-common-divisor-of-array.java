class Solution {
    public int findGCD(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = 0;

        for(int num : nums){
            a = Math.min(a,num);
            b = Math.max(b,num);
        }

        return gcd(a,b);
    }public int gcd(int a, int b){
        if(b==0) return a;

        return gcd(b,a%b);
    }
}