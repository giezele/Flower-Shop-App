package lt.giedre1.app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NDFunctions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Įveskite pageidaujamą masyvo ilgį: ");
        int arrLen = sc.nextInt(); sc.nextLine();
        int[] Arr1 = new int[arrLen];
        Random rand = new Random();

        // pasidarom masyva is random skaiciu nuo 0 iki 100
        for (int i = 0; i < Arr1.length; i++) {
            Arr1[i] = rand.nextInt((100 - 0) + 0) +1;
        }
        System.out.println("Masyvas:" + Arrays.toString(Arr1));

        //kvieciam f-cija rasti min
        int minValueInArray = findMin(Arr1);
        System.out.println("Elementas min:"+minValueInArray);

        //kvieciam f-cija rasti max
        int maxValueInArray = findMax(Arr1);
        System.out.println("Elementas max:"+maxValueInArray);

        // //kvieciam f-cija rasti sumai
        int sumValuesInArray = sumValues(Arr1);
        System.out.println("Elementų suma:"+sumValuesInArray);


        //kvieciam f-cija sortinimui
        String sortedValuesInArray = sortValues(Arr1);
        System.out.println("Po rikiavimo:" + sortedValuesInArray);
    }

    public static int findMin(int[] Arr1) {
        int min = 10000;
        for (int i = 0; i < Arr1.length; i++) {
            if (Arr1[i] <= min) {
                min = Arr1[i];
            }
        }
        return min;
    }

    public static int findMax(int[] Arr1) {
        int max = 0;
        for (int i = 0; i < Arr1.length; i++) {
            if (Arr1[i] >= max) {
                max = Arr1[i];
            }
        }
        return max;
    }

    public static int sumValues(int[] Arr1) {
        int sum = 0;
        for (int i = 0; i < Arr1.length; i++) {
            sum += Arr1[i];
        }
        return sum;
    }
    public static String sortValues(int[] Arr1) {
        for (int i = 0; i < Arr1.length - 1; i++) {
            for(int j = 0; j < Arr1.length -i - 1; j++){
                if(Arr1[j] > Arr1[j + 1]){
                    int temporary = Arr1[j + 1];
                    Arr1[j + 1] = Arr1[j];
                    Arr1[j] = temporary;
                }
            }
        }
       return Arrays.toString(Arr1);
    }
}
