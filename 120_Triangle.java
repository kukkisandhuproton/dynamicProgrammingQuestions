class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size =triangle.size();
        for(int i=0;i<size;i++){
            result.add(new ArrayList<>());
        }
        for(int i=0;i<triangle.size();i++){
            for(int j=0;j<i+1;j++){
                result.get(i).add(-1);
            }
        }
        return helper(triangle,0,0,result);
    }
    public int helper(List<List<Integer>> triangle,int i,int j,ArrayList<ArrayList<Integer>> result){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(result.get(i).get(j) != -1){
            return result.get(i).get(j);
        }
        int down = triangle.get(i).get(j)+helper(triangle,i+1,j,result);
        int diagonal = triangle.get(i).get(j)+helper(triangle,i+1,j+1,result);
        result.get(i).set(j , Math.min(down , diagonal));    
        return Math.min(down,diagonal);
    }
}
