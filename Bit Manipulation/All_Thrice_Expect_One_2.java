
// All Thrice Except One

/*
U'r given an array in which every element appears thrice except one element.
Find that one element

Example -

Input -> [0,1,0,1,0,1,6]
Output -> 6
*/

class All_Thrice_Expect_One_2 {

    public static int findUnique(int arr[]){

        int o = 0;
        int t = 0;

        for(int x: arr){

            int oo = ((~t)&(o)&(~x)) | ((~t)&(~o)&(x));
            int tt = ((t)&(~o)&(~x)) | ((~t)&(o)&(x));

            o = oo;
            t = tt;
        }
      return o; 
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,1,0,1,6,6,6,100};
        System.out.println(findUnique(arr));
    }
}