
// Right Most Set Bit Mask

class Right_Most_Set_Bit_Mask {
    
    public static void main(String[] args) {
        int x = 72;
        int rmbm = x & -x;
        System.out.println(Integer.toBinaryString(rmbm));
        
    }
}
