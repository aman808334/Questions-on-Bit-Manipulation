
// Longest Palindromic Substring 

/*
Given a string of digits, find the longest possible palindromic substring with infinite swaps.

Example - 

Input -> "3242415"
Output -> 5
Explanation -> "24342" is a longest possible substring
*/

/*
Approach -

Palindromic substring can be formed -
(1) When all the digits in the substring occurs even times
(2)  When all the digits in the substring occurs even times and one digit should occur 1 time
*/

class Longest_Palindromic_Substring {

    public static int findLongest(String str) {

        Integer arr[] = new Integer[1<<10]; // Won't use HM, will use array for better TC
        arr[0] = -1;

        int prefix = 0;
        int longest = 0;

        // Iterate to the given string
        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);
            int mask = 1<<(c-'0');
            prefix = prefix^mask; // Toggle that bit

            if(arr[prefix] != null){
              // Same digits have occurred b/f also. So it can be ans.(All even condition)
              longest = Math.max(longest,i-arr[prefix]);
            }

            // Now check of one odd digit by toggling the bits and checking
            for(int o=0; o<10; o++){
               if(arr[prefix^(1<<o)] != null)
                 longest = Math.max(longest,i-arr[prefix^(1<<o)]);
            }

            if(arr[prefix] == null){
            // If not exist i.e if the prefix is coming for the 1st time than put the index of the prefix in prefix index
            arr[prefix] = i;
            }
        }

       return longest;
    }

    public static void main(String[] args) {
        String str = "3242415";
        System.out.println(findLongest(str));
    } 
}