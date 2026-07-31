class Solution {
    public int minimumPushes(String word) {
        int idx = 0;

        int freq[] = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int result = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                continue;

            result += (idx / 8 + 1) * freq[i];
            idx++;
        }

        return result;
    }
}