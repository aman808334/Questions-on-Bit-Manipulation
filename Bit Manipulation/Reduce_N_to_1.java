
// Reduce N to 1

/*
Reduce a given no 'N' to 1 in minimum steps & return number of steps

Rules -

(1) If the no. is even then u can perform n/2
(2) If the no. is odd, then u can perform n-1 or n+1
*/

/*
Approach -

If no is odd then it can we of 2 types -

(1) 4n+1 -> In this case perform n-1
(2) 4n+3 -> In this case perform n+1

Exception - 3 is of 4n+3 type but in this case we'll perform n-1
*/

class Reduce_N_to_1 {

    public static int reduce(int num){

        int count = 0;
        while(num != 1){

            if(num == 3){
                count = count +2;
                break;
            }

            else if((num & 1) == 0){ // Number is Even
                num = num/2;
            }

            // If odd then 2 cases - 4n+1 & 4n+3
            else if((num & 3) == 1){ // 4n+1 type
                num = num-1;
            }

            else if((num & 3) == 3){ // 4n+3 type
                num = num+1;
            }

            count++;
        }

       return count; 
    }

    public static void main(String[] args) {
        int num = 12;
        System.out.println(reduce(num));
    }
}