Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] returnIndex = new int[2]; 
        int start = 0;
        int end = numbers.length -1;
        while( start <= end){
            int curVal = numbers[start] +numbers[end];
            if(curVal == target){
                returnIndex[0] = start+1;
                returnIndex[1] = end +1;
                break;
            }
            else if ( curVal < target){
                start ++; 
            }
            else{
                end --; 
            }
        }
        return returnIndex; 
    }
}
