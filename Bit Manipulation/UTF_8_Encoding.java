
// UTF-8 Encoding

/*
U r given an array of integer
Check whether the array represent a valid sequence of UTF-8 character

A character in UTF-8 can be of 1 to 4 bytes and follow some rule -

(1) If 1 byte -> 0 _ _ _ _ _ _ _
(2) If 2 bytes -> 1 1 0 _ _ _ _ _ ,  1 0 _ _ _ _ _ _ 
(3) If 3 bytes -> 1 1 1 0 _ _ _ _ ,  1 0 _ _ _ _ _ _ , 1 0 _ _ _ _ _ _ 
(4) If 4 bytes -> 1 1 1 1 0 _ _ _ ,  1 0 _ _ _ _ _ _ , 1 0 _ _ _ _ _ _ ,  1 0 _ _ _ _ _ _
*/

class UTF_8_Encoding { 

    public static boolean check(int arr[]){

        int remainingbytes = 0;

        for(int i=0; i<arr.length; i++){

            if (remainingbytes == 0) { // Check new character
                
                if((arr[i]>>7) == 0b0) // Start of first byte of 1 length UTF-8 character
                   remainingbytes = 0;
            

                else if((arr[i]>>5) == 0b110) // Start of first byte of 2 length UTF-8 character
                   remainingbytes = 1;
            
            
                else if((arr[i]>>4) == 0b1110) // Start of first byte of 3 length UTF-8 character
                   remainingbytes = 2;
            
            
                else if((arr[i]>>3) == 0b11110) // Start of first byte of of 4 length UTF-8 character
                   remainingbytes = 3;

                else
                   return false; // Example Input - [255], etc
                   
            }

            else{ // Check another byte of oid character

                if((arr[i] >> 6) == 0b10)
                    remainingbytes--;
                else
                    return false;   
            }    
        }
        // It may be that remaining byte is left
        if(remainingbytes == 0)
           return true;
        else
           return false;   
    }

    public static void main(String[] args) {
        int arr[] = {239,188,151,223,128,242,149,143,191};
        System.out.println(check(arr));
    } 
}