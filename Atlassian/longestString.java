package Atlassian;

public class longestString {
    public int longestStr(int x, int y, int z) {
        if (x == y) {
            return (2 * z) + (x * 2) * 2;
        }
        return (2 * z) + (Math.min(x, y) * 2) * 2 + 2;
    }
}

