class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {
        
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            
            // skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (candidates[i] > target) {
                break; // no need to continue (array is sorted)
            }
            
            current.add(candidates[i]);
            
            // move to next index (i + 1) because each number can be used once
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            
            // backtrack
            current.remove(current.size() - 1);
        }
    }
}