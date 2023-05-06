class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int length = m+n;
        int[][]result = new int[m][n];
        for(int[]rows:result){
            Arrays.fill(rows,-1);
        }
        int maxlength = maxLCS(word1,word2,m-1,n-1,result);
        return m-maxlength+n-maxlength;
    }
    public int maxLCS(String word1,String word2,int index1, int index2,int[][]result){
        if(index1<0|| index2<0){
            return 0;
        }
        if(result[index1][index2]!=-1){
            return result[index1][index2];
        }
        //pick
        if(word1.charAt(index1)==word2.charAt(index2)){
            return result[index1][index2]=1+ maxLCS(word1,word2,index1-1,index2-1,result);
        }
        //no pick
        else{
            return result[index1][index2]=Math.max(maxLCS(word1,word2,index1-1,index2,result),maxLCS(word1,word2,index1,index2-1,result));
        }
    }
}
