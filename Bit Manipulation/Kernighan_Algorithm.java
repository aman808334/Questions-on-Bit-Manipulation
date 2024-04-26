
// Kernighan's Algorithm

// Kernighan's Algorithm is used to count number of bits which are ON


class Kernighan_Algorithm {
    
    public static void main(String[] args) {
        
        int x = 73;
        int count = 0;

        while(x != 0){
            x = x - (x&-x);
            count++;
        }

        System.out.println(count);
    }
}
