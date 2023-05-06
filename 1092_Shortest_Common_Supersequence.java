class Solution {
    String[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        dp=new String[m+1][n+1];
        int i = 0;
        int j = 0;
        String lcs = helper(str1,str2,m,n);
        StringBuilder sb = new StringBuilder();
         for(char c : lcs.toCharArray()){
            while(str1.charAt(i) != c){
                sb.append(str1.charAt(i++));
            }
            
            while(str2.charAt(j) != c){
                sb.append(str2.charAt(j++));
            }
            
            sb.append(c);
            i++;
            j++;
        }
        sb.append(str1.substring(i));
        sb.append(str2.substring(j));
        
        return sb.toString(); 
    }
    public String helper(String s, String t, int m, int n){
         if(m == 0 || n == 0) {
            return dp[m][n] = "";
        }
        
        if(dp[m][n] != null) {
            return dp[m][n];
        }
        
        if(s.charAt(m-1) == t.charAt(n-1)) {
            return dp[m][n] = helper(s, t, m-1, n-1) + s.charAt(m-1);
        } else {
            String s1 = helper(s, t, m - 1, n);
            String s2 = helper(s, t, m, n - 1);
            if(s1.length() >= s2.length()) {
                return dp[m][n] = s1;
            } else {
                return dp[m][n] = s2;
            }
        }
    }
}
