  class Solution {
    private HashMap<String,Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        /* recursion solution 
        if(m ==0 || n ==0){
            return 0;
        }
        if(m == 1 || n== 1){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
        */
        /*memoization code
        if(m ==0 || n ==0 ){
            return 0;
        }
        String cell = new String(m+","+n);
        if(map.containsKey(cell)){
            return map.get(cell);
        }
        if(m ==1 || n == 1){
            return 1;
        }
        int down = uniquePaths(m-1,n);
        int up = uniquePaths(m,n-1);
        map.put(cell,down+up);
        return down+up;
        */
        int [][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i ==0 || j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
