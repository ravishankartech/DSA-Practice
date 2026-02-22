class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse from last digit to first
        for (int i = digits.length - 1; i >= 0; i--) {
            
            if (digits[i] < 9) {
                digits[i]++;      // Add one
                return digits;    // No carry, return immediately
            }
            
            digits[i] = 0;        // If digit is 9, set to 0 and carry continues
        }
        
        // If all digits were 9 (e.g., 9, 99, 999)
        int[] result = new int[digits.length + 1];
        result[0] = 1;            // First digit becomes 1
        return result;
    }
}