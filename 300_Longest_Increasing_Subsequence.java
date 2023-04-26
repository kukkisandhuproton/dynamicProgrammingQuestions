class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int length = nums.length;
        int[][] result = new int[nums.length][nums.length+1];
        for(int[] row:result){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,-1,result);    
    }
    public int helper(int[] nums, int index,int previous, int[][] result){
        if(index == nums.length){
            return 0;
        }
        // not to pick up
        if(result[index][previous+1]!=-1){
            return result[index][previous+1];
        }
        int notPick = helper(nums,index+1,previous,result);
        int pick = -1;
        if(previous == -1 || nums[index]>nums[previous]){
            pick = 1 + helper(nums,index+1,index,result);
        }
        
        return result[index][previous+1] = Math.max(pick,notPick);
    }

}
