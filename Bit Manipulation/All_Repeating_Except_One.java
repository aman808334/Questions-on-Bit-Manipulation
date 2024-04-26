
// All Repeating Except One

/*
U'r given an array in which every element appears twice except one element.
Find that one element

Example - 

Input -> [2,2,1]
Output -> 1
*/

class All_Repeating_Except_One {

    public static int findOne(int arr[]){
      
        int req = 0;
        for(int i : arr){
            req = req^i;
        }
      return req;  
    }

    public static void main(String[] args){

        int arr[] = {2,2,1};
        System.out.println(findOne(arr));  
    }  
}