class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastSeen.containsKey(current)) {
                // Jump left past the previous occurrence, never moving left backward
                left = Math.max(left, lastSeen.get(current) + 1);
            }

            lastSeen.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}