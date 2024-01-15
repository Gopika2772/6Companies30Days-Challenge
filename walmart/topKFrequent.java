import java.util.*;
class topKFrequent {
    class Pair{
    int key;
    String value;
    
    Pair(int key, String value){
        this.key = key;
        this.value = value;
    }
    }
    public List<String> topK(String[] words, int k) 
    {
    Map<String,Integer> map=new HashMap<>();
    for(int i=0;i<words.length;i++)
    {
        map.put(words[i],map.getOrDefault(words[i],0)+1);
    }
    PriorityQueue<Pair> pq = new PriorityQueue<>(
        new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
               
                if((b.key - a.key) == 0)
                    return b.value.compareTo(a.value);
                return a.key - b.key;
            }
    });
      for (Map.Entry<String, Integer> e : map.entrySet()) {
           pq.add(new Pair(e.getValue(),e.getKey()));
           if(pq.size() > k)
            pq.poll();
        }
    List<String> list=new ArrayList<>();
    while(!pq.isEmpty())
    {
        list.add(0,pq.poll().value);
    }
    return list;
    }
}
