
// Add two numbers without using '+' operator

/*
Approach -

We'll use one property of XOR  and one concept of "AND -

(1) If two numbers don't have set bits at the same position then the "XOR" of these two numbers will give the sum
of these two nos.

(2) If we are doing the "AND" operation of '1' and '1' it will give as one. We know, in binary addition "1+1"
gives carry as '1'. So we can use "AND" for carry.
*/

public class Add_Two_Number {

    public static int add(int a, int b) {

        int carry = 10; // Initialize with any number except '0'
        int sum = 0;

         while (carry != 0) // Means repeat this till both nos. have set bits at the same position.

         // If numbers have set bits at same position, till then "AND" i.e carry can't be '0'
        {
            sum = a ^ b;
            carry = a & b;
            carry = carry << 1;

            a = sum;
            b = carry;
        }
        
        return sum;
    }   
    
    public static void main(String[] args) {
        int a = -10;
        int b = -10;
        System.out.println(add(a, b));
    }
}