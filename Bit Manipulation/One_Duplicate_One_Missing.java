
// One Duplicate and One Missing

/*
U r given a array of the length 'n' containing number 1 to n
One number is present twice in array & one is missing
Find these two numbers

Example -

Input -> [3,6,2,5,1,2,7] (Length of array is '7'. So all nos from 1 to 7 should be in array. But one is repeating and one is missing)
Output -> Repeating no. is '2'
          Missing no. is '4'
*/

class One_Duplicate_One_Missing {

    public static void find(int arr[]){

        int req = 0;

        for(int i: arr)
         req = req ^ i;
        
        for(int i=0; i<=arr.length; i++)
         req = req ^ i;  

        // Now req = repeating no. ^ missing no

        int rmsbmask = req & -req; // Right Most Set Bit Mask

        // Above both loops combine together to form all set of numbers. So to find x and y we should iterate to both
        int x = 0;
        int y = 0;
        for(int i: arr){
            if((i & rmsbmask) == 0 )
              x = x^i;
            else
              y = y^i;   
        }
         
        for(int i=0; i<=arr.length; i++){
            if((i & rmsbmask) == 0 )
              x = x^i;
            else
              y = y^i;   
        }

        // Now we have ur req. number in x & y. But we've to find which is missing and which is repeating
        for(int i: arr){
            if(x == i){ // x is repeating
                System.out.println("Repeating no. is - " + x);
                System.out.println("Missing no. is - " + y);
                break;
            }
            else if(y==i){ // y is missing
                System.out.println("Repeating no. is - " + y);
                System.out.println("Missing no. is - " + x);
                break;
            }
        } 
    }

    public static void main(String[] args) {
        
        int arr[] = {3,6,2,5,1,2,7};
        find(arr);
    }
}