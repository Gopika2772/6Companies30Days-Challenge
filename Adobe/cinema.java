package Adobe;
import java.util.*;
class cinema {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int[] seat:reservedSeats){
            map.putIfAbsent(seat[0],new ArrayList<>());
            map.get(seat[0]).add(seat[1]);
        }
        int res=(n-map.size())*2;
        for(Integer row:map.keySet()){
            boolean right=true,
            left=true,
            middle=true;
            for(int num:map.get(row)){
                if(num>=2 && num<=5)left=false;
                if(num>=4 && num<=7)middle=false;
                if(num>=6 && num<=9)right=false;
                
            }
            if(left && right)res+=2;
            else if(left || right || middle)res+=1;
        }
        return res;
    }
}
