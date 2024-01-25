package Atlassian;
import java.util.*;
class ThroneInheritance {
    HashMap<String,ArrayList<String>> h;//parent-->child
    String king="";
    HashSet<String> hset=new HashSet<String>();
    public ThroneInheritance(String kingName) {
        h=new HashMap<String,ArrayList<String>>();
        king=kingName;
    }
    
    public void birth(String parentName, String childName) {
        if(!h.containsKey(parentName))
        {
            ArrayList<String> l=new ArrayList<String>();
            l.add(childName);
            h.put(parentName,l);
        }
        else
        {
             ArrayList<String> l=h.get(parentName);
            l.add(childName);
            h.put(parentName,l);
        }
    }
    
    public void death(String name) {
        hset.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        ArrayList<String> result=new ArrayList<String>();
        Stack<String> stck=new Stack<String>();
        stck.add(king);
        while(stck.size()>0)
        {
            String s=stck.pop();
            if(!hset.contains(s))
            {
                result.add(s);
            }
            if(h.containsKey(s))
            {
                ArrayList<String> l=h.get(s);
                for(int j=l.size()-1;j>=0;j--)
                {
                    stck.push(l.get(j));
                }
            }
        }

        return result;
        
    }
}


