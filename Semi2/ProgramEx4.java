package Semi2;

import java.util.Scanner;

public class ProgramEx4 {
    public static void main(String[] args) {
        enterString();
    }
    public static void enterString(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the string");
            String s = scanner.nextLine();
            if (s.isEmpty()){
                throw new EmptyStringException("String is empty, fix it");
            } else {
                System.out.printf("Your enter '%s'", s);
            }
        } catch (EmptyStringException e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
class EmptyStringException extends Exception{
    public EmptyStringException(String message) {
        super(message);
    }
}

