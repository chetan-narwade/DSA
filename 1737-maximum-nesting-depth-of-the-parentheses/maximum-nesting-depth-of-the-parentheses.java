class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int res = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                cnt++;
            }
            if(ch==')'){
                cnt--;
            }

            res = Math.max(res,cnt);
        }

        return res;
    }
}