class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();

        int balance = 0;

        // Pass 1: Remove invalid ')'
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
                sb.append(ch);
            } 
            else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    sb.append(ch);
                }
            } 
            else {
                sb.append(ch);
            }
        }

        // Pass 2: Remove extra '('
        StringBuilder result = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);

            if (ch == '(' && balance > 0) {
                balance--;
            } 
            else {
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }
}
