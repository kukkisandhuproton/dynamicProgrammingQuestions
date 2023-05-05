class Solution {
    public int minInsertions(String s) {
        int length = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        int m=s.length();
        int n=m;
        int[][]result = new int[m][n];
        for(int[]rows:result){
            Arrays.fill(rows,-1);
        }
        return length-helper(s,reverse,m-1,n-1,result);
    }
    public int helper(String s, String t, int index1,int index2,int[][]result){
        if(index1<0||index2<0){
            return 0;
        }
        if(result[index1][index2]!=-1){
            return result[index1][index2];
        }
        //pick up
        if(s.charAt(index1)==t.charAt(index2)){
            return result[index1][index2]= 1+helper(s,t,index1-1,index2-1,result);
        }
        //else
        else{
            return result[index1][index2]=Math.max(helper(s,t,index1-1,index2,result),helper(s,t,index1,index2-1,result));
        }
    }
}
