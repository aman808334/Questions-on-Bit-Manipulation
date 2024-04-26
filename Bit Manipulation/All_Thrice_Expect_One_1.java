
// All Thrice Except One

/*
U'r given an array in which every element appears thrice except one element.
Find that one element

Example -

Input -> [0,1,0,1,0,1,6]
Output -> 6

// Note - Will only work if numbers are +ve
*/

class All_Thrice_Expect_One_1 {

    public static int findOne(int arr[]){


        int threen = Integer.MAX_VALUE; // Initially, all are of 3n type
        int threen1 = 0;
        int threen2 = 0;

        for(int i =0; i<arr.length; i++){

            int cwith3n = arr[i] & threen;
            int cwith3n1 = arr[i] & threen1;
            int cwith3n2 = arr[i] & threen2;

            threen = threen & (~cwith3n); // Switch "OFF" the bits in 3n
            threen1 = threen1 | (cwith3n); //Switch "ON" the bits in 3n+1

            threen1 = threen1 & (~cwith3n1); // Switch "OFF" the bits in 3n+1
            threen2 = threen2 | (cwith3n1); //Switch "ON" the bits in 3n+2

            threen2 = threen2 & (~cwith3n2); // Switch "OFF" the bits in 3n+2
            threen = threen | (cwith3n2); //Switch "ON" the bits in 3n
        }

       return threen1;
    }

    public static void main(String[] args) {
        
        int arr[] = {0,1,0,1,0,1,6,6,6,100};
        System.out.println(findOne(arr));
    }
}