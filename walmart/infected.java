
 
import java.util.*;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class infected {
   
       int ans;

    public void buildGraph(TreeNode root, List<List<Integer>> adj) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
        }
        if (root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
        }
        buildGraph(root.left, adj);
        buildGraph(root.right, adj);
    }

    public void bfs(int start, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int k = q.size();

            while (k-- > 0) {
                int u = q.poll();
                vis[u] = true;
                for (int i : adj.get(u)) {
                    if (!vis[i]) {
                        q.add(i);
                    }
                }
            }
            ans++;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> adj = new ArrayList<>(100001);
        for (int i = 0; i < 100001; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[100001];

        buildGraph(root, adj);
        ans = 0;
        bfs(start, adj, vis);
        return ans - 1;
    }
}
