
// Bitwise "AND" of numbers in range

/*
Example -

Input -> left = 8 and right = 10
Output -> 8
Explanation -

8 = 1000
9 = 1001
10 = 1010

1000 & 1001 & 1010 = 1000
*/

class Bitwise_And_In_Range {

public static int andRange(int left, int right){

    int count = 0;

    while(left != right){

        left = left >> 1;
        right = right >> 1;
        count++;
    }

return left<<count; 
} 

public static void main(String[] args) {
            
    int left = 2147483645;
    int right = 2147483646;
    System.out.println(andRange(left, right));
}
}