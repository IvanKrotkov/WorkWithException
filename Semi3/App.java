package Semi3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        getMenu();
    }
    public static void getMenu() {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Введите фамилию, имя, отчество и номер телефона отделяя данные пробелом");
            String data = s.nextLine();
            String[] dataArray;
            try {
                dataArray = tryParse(data);
                writeInFile(dataArray);
            } catch (DataException e) {
                System.out.println(e.getMessage() +"cимвол "+ e.getaChar() + "\nПовторите попытку");
                data = s.nextLine();
                try {
                    dataArray = tryParse(data);
                    writeInFile(dataArray);
                } catch (DataException de){
                    System.out.println(de.getMessage());
                }
            }
        }
    }
    public static void writeInFile(String[] data){
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(String.format("/%s.txt",data[0]));
        try (FileWriter fw = new FileWriter(pathFile,true)){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append('<');
                sb.append(data[i]);
                sb.append('>');
            }
            sb.append("\n");
            fw.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Что то пошло не так при записи в файл...");
            e.printStackTrace();
        }
    }
    private static boolean tryParse(String[] data) throws DataException {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                if (i == data.length - 1){
                    if (!Character.isDigit(data[i].charAt(j))){
                        throw new DataException("Неверный формат телефона",data[i].charAt(j));
                    }
                }
                else if (!Character.isLetter(data[i].charAt(j))) {
                    throw new DataException("Неверный формат ФИО",data[i].charAt(j));
                }
            }
        }
        return true;
    }

    public static String[] tryParse(String data) throws DataException {
        String[] dataFromUser = data.split(" ");
        if (dataFromUser.length != 4) {
            throw new DataException("Вы ввели больше или меньше данных, чем нужно");
        }
        tryParse(dataFromUser);
        return dataFromUser;
    }
}

class DataException extends Exception{
    private Character aChar;
    public DataException(String message, Character aChar) {
        super(message);
        this.aChar = aChar;
    }
    public DataException(String message){
        this(message, null);
    }
    public char getaChar() {
        return aChar;
    }
}
