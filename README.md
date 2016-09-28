# two-pointers

A special type of algorithm. We have seen it before in the Linked List related problems.
Idea: 不用扫描多余的状态

1. 对撞型 (一个数组, 从两边向中间移动)
Example: Valid Palindrome (E), Container With Most Water (M), Two Sum II - Input array is sorted (M), 3Sum (M), 3Sum Closest (M), 4Sum (M), Sort Colors (M)

2. 前向型 (一个数组, 同时向前移动)
Two pointers with different properties

(1) Maintain a window with specific property
Example: Longest Substring Without Repeating Characters (M), Minimum Size Subarray Sum (M), Minimum Window Substring (H)
(2) One faster, one slower
Example: Remove Element (E), Move Zeroes (E), Remove Duplicates from Sorted Array I/II

3. 并行型 (两个数组)
Example: Implement strStr() (E), Merge Sorted Array (E)
