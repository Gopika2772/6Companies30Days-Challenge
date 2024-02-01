package Google;
import java.util.*;



class merge {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    class Pair implements Comparable<Pair>{
        int val;
        ListNode node;
        Pair(int val,ListNode node){
            this.val=val;
            this.node=node;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.val, other.val);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(ListNode head:lists){
            if(head!=null){
                pq.add(new Pair(head.val,head));
            }
        }
         ListNode dnode = new ListNode(-1);
        ListNode temp = dnode;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.node.next != null) {
                pq.add(new Pair(curr.node.next.val, curr.node.next));
            }
            temp.next = curr.node;
            temp = temp.next;
        }
        return dnode.next;
    }
}
