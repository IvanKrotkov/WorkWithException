package Semi2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnteringAFractionalNum {
    public static void main(String[] args) {
        System.out.println(getFloatNum());
    }
    public static float getFloatNum(){
        System.out.println("Введите число float:");
        Scanner s = new Scanner(System.in);
        float num = -1;
        try {
            num = s.nextFloat();
            return num;
        } catch (InputMismatchException e){
            System.out.println("Неверный формат, повторите ввод:");
            s.next();
            if(!s.hasNextFloat()){
                System.out.println("Oшибка");
            } else {
                return s.nextFloat();
            }
        }finally {
            s.close();
        }
        return num;
    }
}
