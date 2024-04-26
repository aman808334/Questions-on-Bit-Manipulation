
// Basic Bitwise Operation

class Bitwise_Operation {

    public static int switchon(){

        int x = 57;
        int position = 2;
        int onmask = (1<<position);
        return (x|onmask);
    }

    public static int switchoff(){

        int x = 57;
        int position = 3;
        int offmask = ~(1<<position);
        return (x&offmask);
    }

    public static int toogle(){

        int x = 57;
        int position = 6;
        int togglemask = (1<<position);
        return (x^togglemask);
    }

    public static boolean checking(){
    // Checking bit is on or off, If on then true otherwise false

        int x = 57;
        int position = 3;
        int checkingmask = (1<<position);
        return (x&checkingmask) == 0 ? false : true;
    
    }

    public static void main(String[] args) {

        System.out.println(switchon());
        System.out.println(switchoff());
        System.out.println(toogle());
        System.out.println(checking());
        
    }
    
}
