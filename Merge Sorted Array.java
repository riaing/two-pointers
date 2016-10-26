Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.

直观思路显然是双指针i, j同时扫描A, B，选min(A[i], B[j])作为下一个元素插入。但是只能利用A后面的空间来插入，这样就很不方便了。
反向思路，merge后的数组一共有m+n个数。i, j从A, B尾部扫描，选max(A[i], B[j])插入从m+n起的尾部。
这样也可以防止插入到A原来数字的范围内时，overwrite掉A原来的数。
重点！ 从尾部比较起

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null ){
            return; 
        }
        
        int i = m-1;
        int j = n-1;
        int index = m+n -1; 
        while (i >= 0 && j >= 0){
            if(nums1[i] < nums2[j] ){
                nums1[index] =nums2[j];
                j--;
                index --; 
            }
            else {
                nums1[index] = nums1[i];
                i --; 
                index --; 
            }
        }
        while(i >=0 ){
            nums1[index] = nums1[i];
            index --;
            i --;
        }
        while( j >= 0 ){
            nums1[index] = nums2[j];
            index --;
            j --;
        }
        
    }
}
