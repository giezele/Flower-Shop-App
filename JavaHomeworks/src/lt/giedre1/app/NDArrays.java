package lt.giedre1.app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NDArrays {
    public static <BubbleSort> void main(String[] args) {
        int[] Arr1 = {3, 0, 2};
        System.out.println("1. Sukurkite masyvą ir išspausdinkite visus jo narius 3-jų ciklų pagalba");
        System.out.println("1) for");
        for (int i = 0; i < Arr1.length; i++) {
            System.out.println(Arr1[i]);
        }
        System.out.println("2) enchanced for");
        for (int j : Arr1) {
            System.out.println(j);
        }
        System.out.println("3) while");
        int k = 0;
        while(k < Arr1.length){
            System.out.println(Arr1[k]);
            k++;
        }
        System.out.println("2. Taip kaip #1, bet masyvo dydis turi būti nurodomas programos naudotojo, konsolėje.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Įveskite pageidaujamą masyvo dydį: ");
        int arrDydis = sc.nextInt(); sc.nextLine();
        int[] Arr2 = new int[arrDydis];
        Random rand = new Random();
        System.out.println("1) for");
        for (int i = 0; i < Arr2.length; i++) {
            Arr2[i] = rand.nextInt((100 - 1) + 1) + 1;
            System.out.println(Arr2[i]);
        }
        System.out.println("2) enchanced for");
        for (int j : Arr2) {
            System.out.println(j);
        }
        System.out.println("3) while");
        int k1 = 0;
        while(k1 < Arr2.length){
            System.out.println(Arr2[k1]);
            k1++;
        }

        System.out.println("3. Taip kaip #2, bet ir dydis ir reikšmės turi būti suvestos vartotojo.");
        System.out.println("Įveskite pageidaujamą masyvo dydį: ");
        int arrDydis1 = sc.nextInt(); sc.nextLine();
        int[] Arr3 = new int[arrDydis1];
        System.out.println("Įveskite elementus (" + arrDydis1 +"): ");
        for(int a = 0; a < arrDydis1; a++) {
            Arr3[a] = sc.nextInt();
        }
        System.out.println("Masyvas: "+ Arrays.toString(Arr3));

        System.out.println("4. Suskaičiuokite masyvo elementų sumą");
        int sum = 0;
        for (int i : Arr3) {
            sum += i;
        }
        System.out.println("Suma: " + sum);

        System.out.println("5. Suskaičiuokite vidurkį");
        double avrg = (double) sum / Arr3.length;
        System.out.println("Vidurkis: " + avrg);

        System.out.println("6. Bubble sort");
        System.out.println("Prieš rikiavimą: " + Arrays.toString(Arr3));
        int counterIter = 0;
        int counterSwap = 0;
        for (int i = 0; i < Arr3.length - 1; i++) {
            for(int j = 0; j < Arr3.length -i - 1; j++){  //cia iter
                counterIter++;
                if(Arr3[j] > Arr3[j + 1]){       //cia swapina
                    int temporary = Arr3[j + 1];
                    Arr3[j + 1] = Arr3[j];
                    Arr3[j] = temporary;
                    counterSwap++;
                }
            }
        }
        System.out.println("Po rikiavimo: " + Arrays.toString(Arr3));
        System.out.println("Iteracijos: " + counterIter);
        System.out.println("Sukeitimai: " + counterSwap);

        System.out.println("7. Insertion sort");
        System.out.println("Prieš rikiavimą: " + Arrays.toString(Arr2));
        int n = Arr2.length;
        for (int i = 1; i < n; ++i) {
            int key = Arr2[i];
            int j = i - 1;
            while (j >= 0 && Arr2[j] > key) {
                Arr2[j + 1] = Arr2[j];
                j = j - 1;
            }
            Arr2[j + 1] = key;
        }
        System.out.println("Po rikiavimo: " + Arrays.toString(Arr2));
    }

}

