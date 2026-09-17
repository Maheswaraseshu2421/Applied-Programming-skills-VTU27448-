import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision can happen only when:
            // top asteroid moves right and current moves left
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                int top = stack.peek();

                if (Math.abs(top) < Math.abs(asteroid)) {
                    // Top asteroid explodes
                    stack.pop();
                } 
                else if (Math.abs(top) == Math.abs(asteroid)) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}
