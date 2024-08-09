import java.util.HashSet;
import java.util.Set;

public class SequentialNonRepeating {
    
    public static void main(String[] args) {
        int output = charSequence("abcc", 2);

        System.out.println(output);
    }

    public static int charSequence(String str, int K) {
        int n = str.length();
        int count = 0;

        if (K>n) {
            return 0;
        }

        for (int i = 0; i <= n - K; i++){
            String substring = str.substring(i, i+K);
            if(hasAllUniqueCharacters(substring)) {
                count++;
            }
        }

        return count;
    }

    public static boolean hasAllUniqueCharacters(String s) {
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            if(!set.add(ch)) {
                return false;
            }
        }

        return true;
    }
}
