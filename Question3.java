public class Question3 {
    public long countPairs(String[] words) {
        String[] str = words;

        Map<String, Long> freqMap = new HashMap<>();

        for (String word : str) {
            String normalized = normalize(word);
            freqMap.put(normalized, freqMap.getOrDefault(normalized, 0L) + 1);
        }

        long res = 0;
        for (long count : freqMap.values()) {
            if (count > 1) {
                res += count * (count - 1) / 2;
            }
        }

        return res;
    }

    private String normalize(String word) {
        int shift = word.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            char normalizedChar = (char) ((c - shift - 'a' + 26) % 26 + 'a');
            sb.append(normalizedChar);
        }

        return sb.toString();
    }
}
