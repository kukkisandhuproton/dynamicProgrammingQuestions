class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(o1,o2)->o1[1]-o2[1]);
        int rows = pairs.length;
        int[]result = new int[rows];
        Arrays.fill(result,1);
        int answer = Integer.MIN_VALUE;
        for(int i =0;i<rows;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    result[i]=Math.max(result[i],result[j]+1);
                }
            }
            answer = Math.max(answer,result[i]);
        }
        return answer;
    }
}
