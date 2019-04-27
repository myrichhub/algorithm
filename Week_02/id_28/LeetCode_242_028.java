class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int[] stat = new int[26];
        if (s1.length != s2.length) {
            return false;
        }
        for (char item : s1) {
            stat[item - 'a']++;
        }
        for (char item : s2) {
            stat[item - 'a']--;
        }
        for (int cnt : stat) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;

    }
}
