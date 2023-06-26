package Semi1;

import java.util.Arrays;

public class Homework {
    public static class Node {
        int root;
        Node next;
    }

    public static void main(String[] args) {
//        getError1(new int[1]);
//        getError2(new Node());
//        getError3("sadasda");
//        diffArrays(new int[]{1,2,3},new int[]{1,2,3});
        diffArraysThrowsExceptions(new int[]{1,2,3},new int[]{1,0,3});

    }
    public static void getError1(int[] arr) {
        for (int i = 0; i < arr.length + 1; i++) {
            arr[i] = 0;
        }
    }

    public static Node getError2(Node node) {
        Node res = node.next.next;
        return res;
    }

    public static int getError3(String value) {
        return Integer.parseInt(value);
    }

    public static int[] diffArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length){
            System.out.println("Длины массивов не равны");
            return null;
        }
        int[] resArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            resArr[i] = arr1[i] - arr2[i];
        }
        return resArr;
    }
    public static int[] diffArraysThrowsExceptions(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length){
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] resArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) throw new RuntimeException("Не может быть деления на ноль");
            resArr[i] = arr1[i]/arr2[i];
        }
        return resArr;
    }
}
