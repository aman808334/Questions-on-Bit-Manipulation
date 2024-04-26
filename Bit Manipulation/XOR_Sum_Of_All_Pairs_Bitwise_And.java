
// Find XOR sum of all pairs bitwise "AND"

/* 
Example - 

Input -> arr1 = [1,2,3] and arr2 = [6,5]
Output -> 0
Explanation -> (1&6)^(1&5)^(2&6)^(2&5)^(3&6)^(3&5) = 0
*/

/*
Approach -

arr1 = [1,2,3] and arr2 = [6,5]

We've to "AND" the numbers and then take XOR. Basically, (1&6)^(1&5)^(2&6)^(2&5)^(3&6)^(3&5)
We can do, (1^2^3) & (6^5)
Both will be same
*/

class XOR_Sum_Of_All_Pairs_Bitwise_And {

    public static int xorSum(int arr1[], int arr2[]) {

        int xor1 = 0; // For arr1
        int xor2 = 0; // For arr2


        for(int i=0; i<arr1.length; i++){
            xor1 = (xor1^arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            xor2 = (xor2^arr2[i]);
        }

        return (xor1 & xor2);
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3};
        int arr2[] = {6,5};
        System.out.println(xorSum(arr1, arr2));
    } 
}