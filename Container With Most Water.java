Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.


移动短的那块板。 
left = 0, right = n-1
(1) a[left] < a[right], left++
(2) a[left] > a[right], right--
(3) a[left] = a[right], left++, right--
终止条件：left>-right

public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length ==0 || height.length == 1){
            return 0; 
        }
        int start = 0; 
        int end = height.length - 1; 
        int area = 0; 
        
        while(start < end){
                int l = end - start ;
                int h = Math.min(height[start], height[end]);
                int tmpArea = l*h;
                area = Math.max(area, tmpArea); 
                if(height[start] < height[end]){
                    start ++;
                }
                
                else if(height[start]> height[end]){
                    end--;
                }
                else{
                    start++;
                    end --; 
                }
        }
        return area; 
    }
}
