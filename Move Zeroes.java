Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

双指针法two pointers。第一个指针遇到0就停下（在0之前的位置），
第二个指针继续寻找之后第一个非0的元素，找到之后和第一个指针后面的0交换，
第一个指针移动一位。即第一个指针和第二个指针之间的元素为0。

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return; 
        }
        int nonZero = 0 ;
       
        for( int i = 0 ; i< nums.length ; i ++ ){
            if (nums[i] == 0 ){
                continue;   
            }
            else{
                nums[nonZero] = nums[i]; //只是先赋值，后面的loop再把最后几个该为零
                nonZero ++; 
            }
        }
        
        for( int j = nonZero; j < nums.length; j ++){ //
            nums[j] = 0 ; 
        }
        
    }
}

//解法二
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return; 
        }
        int nonZero = 0 ;
       
        for( int i = 0 ; i< nums.length ; i ++ ){
            if (nums[i] == 0 ){
                continue;   
            }
            else{
                int tmp = nums[i];  //遇到非0就交换一下
                nums[i] = nums[nonZero]; 
                nums[nonZero] = tmp; 
                nonZero ++; 
            }
        }
    }
}
