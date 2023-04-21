class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int fib(int n) {
        /*
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n ==0 ){
            return 0;
        }
        if(n<=2){
            return 1;
        }
        int result = fib(n-1)+fib(n-2);
        map.put(n, result);
        return result;
        */
        /*
        if(n==0){
            return 0;
        }
        if(n<=2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
        */
        if(n==0){
            return 0;
        }
        if(n<=2){
            return 1;
        }
        int previous1 = 0;
        int previous2 = 1;
        //int prev=1,prev2=0;
        for(int i=1;i<n;i++){
            int sum = previous1+previous2;
            previous1 = previous2;
            previous2 = sum;
        }
        return previous2;
    }
}
