import java.util.*;
class combinations {
    List<List<Integer>> result=new ArrayList<>();
    public void combinations(List<Integer>temp,int k,int n,int intial){
        if(temp.size()==k){
            if(n==0){
                result.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        for(int i=intial;i<=9;i++){
            temp.add(i);
             combinations(temp,k,n-i,i+1);
             temp.remove(temp.size()-1);

        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k>n){
            return result;
        }
        List<Integer> temp=new ArrayList<>();
        combinations(temp,k,n,1);
        return result;

    }
}
