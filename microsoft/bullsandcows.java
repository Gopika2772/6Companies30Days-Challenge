import java.util.HashMap;

class bullsandcows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> s = new HashMap<>();
        HashMap<Character, Integer> g = new HashMap<>();
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char schr = secret.charAt(i);
            char gchr = guess.charAt(i);

            if (schr == gchr) {
                bulls++;
            } else {
                s.put(schr, s.getOrDefault(schr, 0) + 1);
                g.put(gchr, g.getOrDefault(gchr, 0) + 1);
            }
        }

        for (char ch : s.keySet()) {
            if (g.containsKey(ch)) {
                cows += Math.min(s.get(ch), g.get(ch));
            }
        }

        return bulls + "A" + cows + "B";
    }
}
