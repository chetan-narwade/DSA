class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ds = new ArrayList<>();
		StringBuilder s = new StringBuilder();
		f(n, 0, 0, s, ds);
        return ds;
    }public static void f(int n, int start, int end,StringBuilder s, List<String> ds) {
		if (start == n && end == n) {
			ds.add(s.toString());
			return;
		}
		if (start < n) {
			s=s.append("(");
			f(n, start + 1, end, s, ds);
			s.deleteCharAt(s.length()-1);
		}
		if (end < start) {
			s=s.append(")");
			f(n, start, end + 1, s, ds);
			s.deleteCharAt(s.length()-1);
		}
	}
}