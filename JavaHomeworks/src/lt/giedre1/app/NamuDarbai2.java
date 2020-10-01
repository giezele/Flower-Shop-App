package lt.giedre1.app;

import java.util.Scanner;

public class
NamuDarbai2 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        //Salygos teiginiai
        // 1.Leisti balsuoti vyresniems nei 18 metų; >45 m. ir kandidatuoti
        System.out.println("Kiek jums metų?: ");
        int age = sc1.nextInt();
        if (age < 18) {
            System.out.println("Jūs dar negalite balsuoti");
        } else if (age >= 18 && age < 45) {
            System.out.println("Galite balsuoti, bet dar negalite kandidatuoti");
        } else {
            System.out.println("Galite ir balsuoti, ir kandidatuoti");
        }

        //Ciklai
        //1. Neigyvendinamas ciklas
        int x1 = 5;
        while (x1 < 5 && x1 > 5) {
            System.out.println("neįgyvendinamas ciklas");
        }
        ;
        for (x1 = 5; x1 < 0; x1++) {
            System.out.println("neįgyvendinamas ciklas");
        }

        //2. Amžinas ciklas
        // while(true){
        //     System.out.println("Amžinas ciklas");
        // }
        // for(;;){
        //     System.out.println("Amžinas ciklas");
        // }

        //3. Echo
        Scanner sc2 = new Scanner(System.in);
        String userInput = null;
        do {
            System.out.println("Įveskite teisingą žodį:");
            userInput = sc2.nextLine();
            System.out.println("Jūsų žodis yra: " + userInput);
        } while (!userInput.equals("q"));
            System.out.println("q nutraukia prakeiksmą");

        //4.Reverse echo
        StringBuilder userInput1;
        do {
            System.out.println("Įveskite žodį - pamatysite reverse:");
            userInput1 = new StringBuilder(sc2.nextLine());
            System.out.println("Jūsų žodis reverse: " + userInput1.reverse());
        } while (!userInput1.toString().equals("q"));
            System.out.println("q nutraukia prakeiksmą");

        //5.Raides index'as
        System.out.print("Įveskite žodį - pamatysite raidžių indexus: ");
        String inputNew = sc2.nextLine();
        for (int i = 0; i < inputNew.length(); i++) {
            System.out.println(inputNew.charAt(i) + " " + (i + 1));
        }


    }
}
