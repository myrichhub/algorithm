class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] res = new int[N];
        for (int[] item : trust) {
            res[item[0]-1] = -1;
            res[item[1]-1]++;
        }
        for (int i = 0; i < N; i++) {
            if (res[i] == N-1) {
                return i+1;
            }
        }
        return -1; 
    }
}
