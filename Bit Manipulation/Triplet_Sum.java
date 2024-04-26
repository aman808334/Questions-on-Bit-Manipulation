
// Triplet Sum

/*
Given an array

Given 0 <= i < j <= k < arr.length

Such that -  

(1) X = arr[i]^arr[i+1]^arr[i+2]^.....^arr[j-1]
(2) Y = arr[j]^arr[j+1]^arr[j+2]^.....^arr[k]
(3) X = Y

How many such triplets are there of i, j & k which satisfy this condition         
*/

class Triplet_Sum {

    public static int count(int arr[]){

        int count = 0;

        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            for(int k=i+1; k<arr.length; k++){
                val = val^arr[k];

                if(val == 0){ // XOR is '0' then we have triplet 
                   count += (k-i);
                }
            }
        }
        
      return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,5,7,2,7,5,6,4};
        System.out.println(count(arr));
    }
}
