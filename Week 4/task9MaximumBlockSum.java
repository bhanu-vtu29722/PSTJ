class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // prefix sum array
        int[][] pre = new int[m + 1][n + 1];

        // build prefix sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];

        // calculate block sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                ans[i][j] = pre[r2 + 1][c2 + 1]
                          - pre[r1][c2 + 1]
                          - pre[r2 + 1][c1]
                          + pre[r1][c1];
            }
        }

        return ans;
    }
}
