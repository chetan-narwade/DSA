class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        boolean dp[] = new boolean[s.length()];
        int idx = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                st.push(idx);
            }else{
                int temp = st.pop();
                if(st.isEmpty()){
                    dp[temp] = true;
                    dp[idx] = true;
                }
            }
            idx++;
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!dp[i]){
                sb.append(s.charAt(i));
            }
        }
         return sb.toString();
    }
}