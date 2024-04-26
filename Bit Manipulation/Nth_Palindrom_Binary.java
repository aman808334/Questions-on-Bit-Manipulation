
// Nth Palindromic Binary

/*
U have to find nth number whose binary representation is a palindrome

Note - First binary number whose  representation is a palindrome is '1'
*/

class Nth_Palindrom_Binary {

    public static int find(int n) {

        // Find the length of palindromic binary of given number 
        int count = 1;
        int length = 1;

        while(count < n){

            length++; // Length will increase one by one
            int elementinlength = (1<< ((length-1)/2));
            count += elementinlength;
        }

        // Move to end of the previous length's group
    
        count -= (1<< ((length-1)/2)); // count - elementinlength

        int offset = n - count -1;
        

        int ans = (1<<(length-1)); // Will start from '1' and all '0'

        // Now, add offset in req. position
        ans = ans | (offset << (length/2));

        //Reverse the number and perform "OR" with ans
        int valforrev = (ans >> (length/2));
        int rev = getReverse(valforrev);

        ans = ans | rev;

      return ans;  

    }

    public static int getReverse(int n){
        int rev = 0;

        while(n != 0){

            int lsb = (n & 1);
            rev = rev | lsb;

            rev = rev << 1; // Reverse will be Left Shifted by 1
            n = n >> 1; // Number will be Right Shifted by 1
        }

        rev = (rev >> 1); // Reverse was left shift one extra time. So one RS

       return rev; 
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(find(n));
    }
}
