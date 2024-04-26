
// Josephus Problem

/*
N soldiers are standing in a circle with position marks as 1 to n
Everytime alternate soldier is killed
If one soldier is left then stop.
Which soldier with servive till last i.e. won't be killed.
*/

/*
Approach -

No. of soldier = n
Represent 'n' in the form (2^x + l).
Then, the soldier which won't be killed = 2l+1
*/

class Josephus_Problem {

    public static int powerOfTwo(int n){

        int i = 1;
        while(i*2<=n){
            i = i*2;
        }
        
        return i;
    }
    
    public static void main(String[] args) {
        
        int n = 10;
        int powerof2 = powerOfTwo(n);
        int l = n - powerof2;
        System.out.println(2*l+1);

    }
}