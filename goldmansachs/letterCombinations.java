import java.util.*;
class letterCombinations {
    private Map<Character,String> map=new HashMap<>();
    private List<String> arr=new ArrayList<String>();
       
    public List<String> letterCombinations(String digits) {
         if(digits==null || digits.length()==0){
            return arr;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        generateCombo(digits,0,new StringBuilder());
        return arr;
       
   }
    public void generateCombo(String digits,int currIdx,StringBuilder currStr){
        if(currIdx==digits.length()){
            arr.add(currStr.toString());
            return;
        }
        
        char curnum=digits.charAt(currIdx);
        String letters=map.get(curnum);
        
       if(letters!=null){
            for(int i=0;i<letters.length();i++){
            currStr.append(letters.charAt(i));
            generateCombo(digits,currIdx+1,currStr);
            currStr.deleteCharAt(currStr.length()-1);
        }
       }
    }
}