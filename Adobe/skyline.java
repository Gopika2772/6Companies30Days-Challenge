package Adobe;
import java.util.*;
class skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        for (int[] arr : buildings) {
            int st = arr[0];
            int end = arr[1];
            int ht = arr[2];
            list.add(new Pair(st, -ht));
            list.add(new Pair(end, ht));
        }

        Collections.sort(list);
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);  
        int prevMaxHeight = 0;

        for (Pair pair : list) {
            int x = pair.x;
            int ht = pair.ht;

            if (ht < 0) {
                maxHeap.add(-ht);
            } else {
                maxHeap.remove(ht);
            }

            int currentMaxHeight = maxHeap.peek();

            if (prevMaxHeight != currentMaxHeight) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(currentMaxHeight);
                ans.add(temp);

                prevMaxHeight = currentMaxHeight;
            }
        }

        return ans;
    }
}

class Pair implements Comparable<Pair> {
    int x, ht;

    Pair(int x, int ht) {
        this.x = x;
        this.ht = ht;
    }

    public int compareTo(Pair a) {
        if (a.x != this.x) {
            return this.x - a.x;
        } else {
            return this.ht - a.ht;
        }
    }
}

