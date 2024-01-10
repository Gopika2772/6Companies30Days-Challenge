import java.util.*;
class findRepeatedDnaSequences{
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer>map=new HashMap<>();
        List<String>list=new ArrayList<>();
        for(int i=0;i<s.length()-9;i++){
            String str=s.substring(i,i+10);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(String strg:map.keySet()){
            if(map.get(strg)>1){
                list.add(strg);
            }
        }
        return list;
    }
}
