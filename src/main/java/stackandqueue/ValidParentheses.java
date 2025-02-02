package stackandqueue;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> matchingBracket = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (matchingBracket.containsValue(c)) {
                stack.push(c);
            }

            if (matchingBracket.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != matchingBracket.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
