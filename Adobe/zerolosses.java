package Adobe;
import java.util.*;

class zerolosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < matches.length; i++) {
            hm.put(matches[i][1], hm.getOrDefault(matches[i][1], 0) + 1);
            hm.put(matches[i][0], hm.getOrDefault(matches[i][0], 0));
        }

        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 0)
                ans.get(0).add(entry.getKey());
            else if (entry.getValue() == 1)
                ans.get(1).add(entry.getKey());
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));

        return ans;
    }
}
