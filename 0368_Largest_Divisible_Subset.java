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

// Second solution

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] result = new int[nums.length];
        return construct(nums,result,getLDSize(nums,result));        
    }
    public int getLDSize(int[]nums,int[]result){
        Arrays.sort(nums);
        Arrays.fill(result,1);
        int ldsize=1;
        for(int i=0;i<nums.length;i++){//index
            for(int j=0;j<i;j++){//previous
                if(nums[i]%nums[j]==0){
                    result[i]=Math.max(result[i],1+result[j]);
                    ldsize=Math.max(ldsize,result[i]);
                }
            }
        }
        return ldsize;
    }
    public List<Integer> construct(int[]nums,int[]result,int ldsize){
        int previous = -1;
        var lds = new LinkedList<Integer>();
        for(int i=result.length-1;i>=0;i--){
            if(result[i]==ldsize&&(previous==-1||previous%nums[i]==0)){
                lds.addFirst(nums[i]);
                ldsize--;
                previous=nums[i];
            }
        }
        return lds;
    }
}
