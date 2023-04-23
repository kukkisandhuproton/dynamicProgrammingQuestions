class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = helper(candidates,target, new HashMap<>());
        return duplicate(result);
    }
    public List<List<Integer>> helper(int[]candidates,int target, Map<Integer,List<List<Integer>>>memo){

        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target==0){
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        }
        if(target<0){
            return new ArrayList<>();
        }
                    List<List<Integer>> result = new ArrayList<>();

        for(int num: candidates){
            int newtarget = target - num;
            List<List<Integer>> finalways = new ArrayList<>();

            List<List<Integer>> subways = helper(candidates,newtarget,memo);
            for(List<Integer> ways : subways){
                List<Integer> temp = new ArrayList<>(ways);
                temp.add(num);
                finalways.add(temp);
            }
            result.addAll(finalways);
        }
    memo.put(target,result);
    return memo.get(target);

    }
    private List<List<Integer>> duplicate(List<List<Integer>> result){
        for(List<Integer> temp: result){
            Collections.sort(temp);
        }
        return new ArrayList<>(new HashSet<>(result));
    }
}
