package Adobe;
import java.util.*;
class encoding {
    public int minimumLengthEncoding(String[] words) {
            Set<String> s1 = new HashSet<>();
            Set<String> s2 = new HashSet<>();
    
            for (String word : words) {
                s1.add(word);
                s2.add(word);
            }
    
            for (String word : s1) {
                for (int i = 1; i < word.length(); i++) {
                    s2.remove(word.substring(i));
                }
            }
    
            int sum = 0;
            for (String word : s2) {
                sum += word.length() + 1;
            }
    
            return sum;
        }
    }
