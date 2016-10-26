Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
i一直往前走，碰到不用delete的就移到前面来（delete的位置上），用delete记录有多少个element
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int delete = 0; 
        for( int i =0; i < nums.length ; i ++){
            if( nums[i] == val){
                continue;
            }
            else{
                nums[delete] = nums[i];
                delete ++; 
            }
        }
        return delete; 
        
    }
}
