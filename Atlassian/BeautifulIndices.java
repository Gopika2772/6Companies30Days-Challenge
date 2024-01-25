package Atlassian;
import java.util.*;

public class BeautifulIndices {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> indices_a = new ArrayList<>();
        List<Integer> indices_b = new ArrayList<>();

        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                indices_a.add(i);
            }
        }

        for (int j = 0; j <= s.length() - b.length(); j++) {
            if (s.substring(j, j + b.length()).equals(b)) {
                indices_b.add(j);
            }
        }

        for (int i : indices_a) {
            for (int j : indices_b) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        ans.sort(null);

        return ans;
    }
}
