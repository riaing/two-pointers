Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.

相比上题，这里只是多了一个条件，所以用map来存出现的次数即可，
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0; 
        }
        int loc = 0 ; 
        Map< Integer, Integer> map = new HashMap<Integer, Integer>(); 
        
        for( int i = 0; i < nums.length; i ++ ){
            if(map.containsKey(nums[i]) && map.get(nums[i]) == 2){
                continue;
            }
            else if(!map.containsKey(nums[i])){ //如果还没有出现，放入map
                nums[loc] = nums[i];
                loc ++; 
                map.put(nums[i], 1);
            }
            else { //如果出现了一次，update value 到2 
                nums[loc] = nums[i];
                loc ++;
                map.put(nums[i], map.get(nums[i]) + 1); 
                
            }
        }
        return loc; 
    }
}
