Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

对排序来说，2sum中的双指针法更为方便，因为算法本身就用到排序。双指针排序法本身会去除一些重复的可能性：

(1, 2, 3, 4), target = 6
在扫描1时，解(2, 3, 4)的2sum = 5问题，找到一个解(1, 2, 3)。
在扫描2时，应当只对后面的数解2sum问题，即对(3, 4)解2sum = 4问题。这样避免再次重复找到解(1, 2, 3)。

但当存在重复数字时，光靠排序仍然无法去重：

(1, 2, 2, 2, 3, 4), target = 9
扫描第一个2时，解(2, 2, 3, 4)中的2sum=7问题，得到解(2, 3, 4)
扫描第二个2时，解(2, 3, 4)中的2sum=7问题，仍然会得到(2, 3, 4)

考虑如何去重： 
扫描数组时跳过重复的数字。上例中，只扫描1, 2, 3, 4来求相应的2sum问题。进一步简化，可以只扫描1, 2。因为3已经是倒数第二个数字，不可能有以它为最小数字的解。
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> triples = new ArrayList<List<Integer>>(); 
        if(nums == null || nums.length < 3){
            return triples;
        }
        Arrays.sort(nums);
        for(int i =0; i< nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i -1]){ // to skip duplicate numbers; e.g [0,0,0,0]
                    continue; 
            }
            int sum = 0 - nums[i];
            int start = i+1; 
            int end = nums.length -1; 
            while(start < end ){
                if(nums[start]+nums[end] == sum){
                    List<Integer> triple = new ArrayList<Integer>(); 
                    triple.add(nums[i]);
                    triple.add(nums[start]);
                    triple.add(nums[end]);
                    triples.add(triple); 
                    start ++;
                    end --;
                    // to skip duplicates
                    while( start < end && nums[start] == nums[start-1]  ){start ++;}
                    while(end > start && nums[end] == nums[end+1] ){end --;}
                }
                else if (nums[start]+nums[end] < sum ){
                    start ++;
                }
                else{
                    end --;
                }
            }
        }
        return triples; 
    }
}
