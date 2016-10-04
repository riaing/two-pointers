3sum问题的变种。一样的遍历每个数，对剩余数组进行双指针扫描。区别仅仅在于当：
sum = A[left] + A[right]
(1) sum = target时直接返回
(2) sum != target时，在相应移动left/right指针之前，先计算abs(sum-target)的值，并更新结果。

注意：这里每次找到相差的值后，不听更新diff，最后用target+ diff即可

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <3 ){
            return -1 ;
        }
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for( int i = 0; i < nums.length -2; i ++){
            if( i > 0 && nums[i] == nums[i-1]){
                continue; 
            } //get rid of duplicat, dont need her actually 
            
             int start = i + 1 ;
             int end = nums.length - 1; 
             while(start < end ){
                  int curVal = nums[start]+ nums[end]+ nums[i];
                  int curDiff = curVal - target; //注意这里顺序不可以反。 
                  
                  if(Math.abs(curDiff) < Math.abs(diff)){
                      diff = curDiff;
                  }
                 
                 if( curVal == target ){
                     return curVal;
                 }
                 else if ( curVal > target ){
                     end -- ;
                 }
                 else {
                     start ++ ; 
                 }
             }
        }
        return target + diff;  //！ 在最后加上相差的值即可，不用
    }
}
