Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.


public class Solution {
         public boolean isPalindrome(String s) {
        if(s.length() == 0){
        	System.out.println("t");
            return true; 
        }
        s = s.toLowerCase(); 
        int front = 0; 
        int end = s.length() -1;
        while (front < end ) {
            while(front < end && isNotValid(s,front)){
                front++; 
            }
       
            while(front < end  && isNotValid(s, end)){
                end --;
            }
            if(front < end && s.charAt(front)!=s.charAt(end)){
            	return false;
            }
            front ++;
            end --;
        }
        	return true;
    }
    private boolean isNotValid(String s, int num){
        if ((s.charAt(num) <'0' || s.charAt(num) >'9') && 
        ((s.charAt(num)<'a' || s.charAt(num) >'z'))){
            return true;
        }
        else{ 
            return false;
        }
    }
}
