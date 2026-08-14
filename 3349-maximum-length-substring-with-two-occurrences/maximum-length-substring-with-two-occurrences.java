class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int freq[]= new  int[26];

        int left = 0;
        int res = 0;

        for(int right = 0; right<n; right++){
            while(freq[s.charAt(right)-'a']==2){
                freq[s.charAt(left++)-'a']--;
            }

            freq[s.charAt(right)-'a']++;
            res=Math.max(res,right-left+1);
        }

        return res;
    }
}