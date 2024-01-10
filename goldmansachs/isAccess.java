import java.util.*;

 class isAccessHigh {
    public boolean isAccessHigh(List<Integer> time) {
        int n = time.size();
        for (int i = 2; i < n; i++) {
            int curr = time.get(i);
            int prev = time.get(i - 2);
            if (prev + 99 >= curr) {
                return true;
            }
        }
        return false;
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(access_times.get(i).get(1));
            if (map.containsKey(access_times.get(i).get(0))) {
                map.get(access_times.get(i).get(0)).add(num);
            } else {
                map.put(access_times.get(i).get(0), new ArrayList<>(Arrays.asList(num)));
            }
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> arr = entry.getValue();
            Collections.sort(arr);
            if (isAccessHigh(arr)) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}
