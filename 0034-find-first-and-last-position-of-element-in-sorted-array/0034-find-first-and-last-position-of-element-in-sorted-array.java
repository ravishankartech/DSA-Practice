class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBoundary(nums, target, true);   // first occurrence
        int right = findBoundary(nums, target, false); // last occurrence
        return new int[]{left, right};
    }
    
    private int findBoundary(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int boundary = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                boundary = mid;
                if (findFirst) {
                    right = mid - 1; // search left half for first occurrence
                } else {
                    left = mid + 1;  // search right half for last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return boundary;
    }
}