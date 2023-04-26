class Solution {
    List<Integer> result;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>();
        result = new ArrayList<>();
        helper(nums,0,1,ans);
        return result;
    }
    public static void helper(int[]nums,int index, int previous,List<Integer>ans){

        if(index<=nums.length){
            if(ans.size>result.size()){
                result.clear();
                result.addAll(ans);
            }
            return;
        }
         // conisdering into our list ...
        if(nums[i]%prev==0||prev%nums[i]==0){
            ans.add(nums[i]);
            helper(nums,index+1,previous,ans);
            ans.remove(ans.size()-1);
        }
        //not considering into list......
        solve(nums,index+1,previous,answer);
    }
}
