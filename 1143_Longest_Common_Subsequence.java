class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][]result = new int[m][n];
        for(int[] row:result){
            Arrays.fill(row,-1);
        }
        return helper(text1,text2,m-1,n-1,result);
    }

    public int helper(String text1,String text2,int index1,int index2,int[][]result){
        

        if(index1<0||index2<0){
            return 0;
        }
        if(result[index1][index2]!=-1){
            return result[index1][index2];
        }
        //pick
        if(text1.charAt(index1)==text2.charAt(index2)){
            return result[index1][index2]= 1+helper(text1,text2,index1-1,index2-1,result);
        }
        //not pick
        else{
            return result[index1][index2]=Math.max(helper(text1,text2,index1-1,index2,result),helper(text1,text2,index1,index2-1,result));
        }
    }
}
