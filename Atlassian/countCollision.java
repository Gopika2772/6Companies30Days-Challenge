package Atlassian;


public class countCollision {
    
    public int countCollisions(String directions) {
        int left=0;int right=directions.length()-1;
        int count=0;
        while(left<directions.length() && directions.charAt(left)=='L')left++;
        while(right>=0 && directions.charAt(right)=='R')right--;
        for(int i=left;i<=right;i++){
            if(directions.charAt(i)!='S')count++;
        }
        return count;
    }
}
