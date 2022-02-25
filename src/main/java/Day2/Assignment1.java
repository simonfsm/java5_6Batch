package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        //Question13
        diagramProgramme();

        //Question14
        int[] arr1 = new int[]{1,6,7,8,9};
        int[] arr2 = new int[]{5,6,7,3,4,5};
        int[] res = mergeTwoArray(arr1, arr2);

        //Question15
        int[] arr = new int[]{1,6,7,8,9};
        int secondL = findSecondLargest(arr);
    }

    public static void diagramProgramme(){
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        if(number.equals("q")){
            System.out.println("Exit");
            return;
        }
        int n = Integer.parseInt(number);
        if(n <= 0){
            System.out.println("Error input");
            diagramProgramme();
        }else {
            System.out.println(doSomething(n));
        }
    }

    public static int doSomething(int n){
        int res = 0;
        for(int i = 1; i <= n; i++){
            res += i;
        }
        return res;
    }

    //Question14. Write a program to merge two array of int.
    public static int[] mergeTwoArray(int[] arr1, int[]arr2){
        if(arr1.length == 0) return arr2;
        if(arr2.length == 0) return arr1;
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        for(; i < arr1.length; i++){
            res[i] = arr1[i];
        }

        for(int j = 0; j < arr2.length; j++){
            res[i++] = arr2[j];
        }
        return res;
    }

    //Question15. Write a program to find the second largest number inside an array of int.
    public static int findSecondLargest(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }


}
