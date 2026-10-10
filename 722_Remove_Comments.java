class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        String line = "";
        boolean block = false;
        for (String s : source) {
            int i = 0;
            if (!block) {
                line = "";
            }

            while (i < s.length()) {
                if (!block && i + 1 < s.length() &&
                    s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                    block = true;
                    i += 2;
                }
                else if (block && i + 1 < s.length() &&
                         s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                    block = false;
                    i += 2;
                }
                else if (!block && i + 1 < s.length() &&
                         s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                    break;
                }
                else if (!block) {
                    line += s.charAt(i);
                    i++;
                }
                else {
                    i++;
                }
            }
            if (!block && !line.isEmpty()) {
                ans.add(line);
            }
        }
        return ans;
    }
}
