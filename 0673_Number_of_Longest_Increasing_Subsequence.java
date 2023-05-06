class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int size =nums.length;
        int[]result=new int[size];
        int[]end=new int[size];
        Arrays.fill(result,1);
        Arrays.fill(end,1);
        int maxi=1;
        for(int i=0;i<size;i++){//index
            for(int j=0;j<i;j++){//previous
// if the result of previous is greater than index then it is worth taking
                if(nums[i]>nums[j]){
                    if(result[i]<=result[j]){
                        result[i]=result[j]+1;
// if the lis of previous is greater than put it in index because now index can be a static point but it can take many combination starting from previous based on count of previous
                        end[i]=end[j];
                    }
                    else if(result[i]==result[j]+1){
                        end[i]=end[i]+end[j];
                    }
                }
            }
            maxi=Math.max(maxi,result[i]);
        }

        // get the count of all the longest lis
        int res=0;
        for(int i=0;i<size;i++){
            if(maxi==result[i]){
                res+=end[i];
            }
        }
    return res;
    }
}
