package Semi2;

public class Ex2 {
    public static void main(String[] args) {
        Ex(0);
    }
    public static void Ex(int size) {
        int[] intArray = new int[size];
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array length exception: "+ e);
        }
        catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
