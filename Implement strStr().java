Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Solution {
    public int strStr(String haystack, String needle) {
        if ( haystack == null || needle == null ){
            return -1; 
        }
        
        for ( int i  = 0 ; i < haystack.length()- needle.length() +1;  i ++ ){ //重点！这里的i只要到hay - needle+1的位置即可，needle长度必须小余haystack
            //if(haystack.charAt(i) == needle.charAt(0)){
                int nPtr = 0;
                while ( nPtr + i < haystack.length() && nPtr < needle.length()){
                    if(haystack.charAt(i+nPtr) != needle.charAt(nPtr)){
                        break; 
                    }
                    nPtr ++; 
                }
                if(nPtr == needle.length()){
                    return i;
                }
            //}
        }
        return -1;
    }
}
