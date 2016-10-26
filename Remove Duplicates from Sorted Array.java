Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
Remove Element (E), Move Zeroes 同样的思路

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return 0; 
        }
        int j = 0  ; 
        Set<Integer > map = new HashSet<Integer>();
        for(int i =0; i < nums.length ; i ++){
            if(map.contains(nums[i])){
                continue; 
            }
            else{
                map.add(nums[i]) ; 
                nums[j] = nums[i];
                j ++;  //记录不重复的元素，当遇到重复元素时，j不动
            }
        }
        return j ; 
    }
}
