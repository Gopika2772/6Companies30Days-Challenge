import java.util.*;
class wordbreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr=new boolean[s.length()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0||arr[j-1]){
                    if(wordDict.contains(s.substring(j,i+1))){
                        arr[i]=true;
                        break;
                    }
                }
            }
        }
        return arr[arr.length-1];
    }
}