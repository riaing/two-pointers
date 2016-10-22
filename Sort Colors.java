Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

巧用本题中只有三个数。 这道题one pass的方法需要用two pointer的技巧。 用两个指针，一个指针x指向数组头便是0和1的区分的位置， 
另一个指针y指向尾表示1和2的区分的位置，然后我们在遍历一遍数组，如果当前遇到的元素是0，那么我们就把它和x指向位置的元素调换，
并且x前进一步，更新边界；如果是1，那么不变；如果是2，那么把它y指向的位置的元素调换，并且y后退一步，这样就可以保证x是0和1区分的位置，
y是1和2区分的位置。 这种方法时间复杂度O(n)，空间复杂度O(1)

public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <=1 ){
            return;
        }
        int red = 0;
        int blue = nums.length -1;
        for( int i = 0 ; i < nums.length ; i ++){
            if(nums[i] == 0 ){
              
                    swap(nums,i, red);
                    red ++;
                
            }
            else if(nums[i] == 2){
                if(i < blue){ //corner case, 考虑【2，2】
                    swap (nums, i, blue);
                    blue --;
                    i --;  //swap后，仍然要检查一遍 当前的值
                }
 
            }
        }
    }
    private int[] swap(int[] nums, int x, int y){
        int z = nums[x];
        nums[x] = nums[y];
        nums[y] = z;
        return nums;
        
    }
    
}
