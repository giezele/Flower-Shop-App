package giedre.sprint3;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class App {


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String input = null;
        ArrayList<Plant> listOfPlants = new ArrayList<>();
        Plant plant = new Flowering();

        while (true) {
            System.out.println("--------------------------------");
            System.out.println("n - enter new plant");
            System.out.println("c - add to cart");
            System.out.println("l - list of plants (for printing & sorting)");
            System.out.println("q - quit & exit");

            System.out.println("Choose operation:");
            input = userInput.nextLine();
            if (input.equals("q")) {
                System.exit(0);
            } else if (input.equals("n")) {

                // Creating plant object
                System.out.println("Is the plant flowering or not? (y/n):");
                String yn = userInput.nextLine();

                Plant returnedPlant = createInstance(yn);

                System.out.println("Plant added to list: " + returnedPlant);

                // writing plant data to file
                FileWriter fw1 = null;
                try {
                    fw1 = new FileWriter(new File("./data/plants.csv"), true);
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    bw1.write(String.valueOf(returnedPlant));
                    bw1.newLine();
                    bw1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (input.equals("c")) {

                listOfPlants = readFromPlantsFile(listOfPlants);
                ArrayList<Plant> plantCart = new ArrayList<>();
                System.out.println("Choose from list: ");
                for (Plant i : listOfPlants) {
                    System.out.println((listOfPlants.indexOf(i) + 1) + ". " + i);
                }
                System.out.println("Enter plant name to add to cart:");
                input = userInput.nextLine();

                int x = listOfPlants.size();
                for (Plant p : listOfPlants) {
                    x--;
                    if (p.getName().equals(input)) {
                        System.out.println("Plant '" + p.getName() + "' is now in the Cart");
                        plantCart.add(p);
                        writeOneToPlantCart(p);
                        break;
                    } else if (x==0){
                        System.out.println("There is no plant '" + input + "' in the list");
                    }

                }

            } else if (input.equals("l")) {
                System.out.println("------------------------");
                System.out.println("p - print list of plants");
                System.out.println("d - delete from list");
                System.out.println("s - sort list");
                System.out.println("q - quit & exit");
                System.out.println("Choose operation:");
                input = userInput.nextLine();

                if (input.equals("q")) {
                    System.exit(0);
                } else if (input.equals("p")) {

                    listOfPlants = readFromPlantsFile(listOfPlants);

                    System.out.println("Plant list:");
                    for (Plant i : listOfPlants) {
                        System.out.println((listOfPlants.indexOf(i) + 1) + ". " + i);
                    }


                } else if (input.equals("d")) {

                    listOfPlants = readFromPlantsFile(listOfPlants);

                    System.out.println("Choose from list: ");
                    for (Plant i : listOfPlants) {
                        System.out.println((listOfPlants.indexOf(i) + 1) + ". " + i);
                    }
                    System.out.println("Enter plant name to be removed:");
                    input = userInput.nextLine();

                    String finalInput = input;
                    listOfPlants.removeIf(new Predicate<Plant>() {
                        @Override
                        public boolean test(Plant plant) {
                            return plant.getName().equals(finalInput);
                        }
                    });

                    saveToPlantListFile(listOfPlants);

                    listOfPlants = readFromPlantsFile(listOfPlants);

                    System.out.println("Here is the list after removal: ");
                    for (Plant i : listOfPlants) {
                        System.out.println((listOfPlants.indexOf(i) + 1) + ". " + i);
                    }

                } else if (input.equals("s")) {
                    listOfPlants = new ArrayList<>();

                    listOfPlants = readFromPlantsFile(listOfPlants);

                    System.out.println("Before sorting:");
                    for (Plant i : listOfPlants) {
                        System.out.println((listOfPlants.indexOf(i) + 1) + ". " + i);
                    }
                    System.out.println("--------------------");
                    System.out.println("Choose type of sort:");
                    System.out.println("p - price sort");
                    System.out.println("n - name sort");
                    input = userInput.nextLine();
                    switch (input){
                        case "p":
                            listOfPlants.sort(Comparator.naturalOrder());

                            break;

                        case "n":
                            listOfPlants.sort(Comparator.comparing(Plant::getName));
                            break;

                        default:
                            System.out.println("Wrong operation selected!!!");
                    }

                    System.out.println("After sorting:");
                    for (Plant i : listOfPlants) {
                        System.out.println((listOfPlants.indexOf(i) + 1) + ". " + i);
                    }

                } else {
                    System.out.println("Wrong operation selected!!!");
                }
            } else {
                System.out.println("Operation failed successfully!!!");
                break;
            }
        }
    }

    public static Plant createInstance (String yn){
            Scanner userInput = new Scanner(System.in);
            Plant plant = null;

            switch (yn) {
                case "y":
                    plant = new Flowering();
                    System.out.println("Enter plant name:");
                    plant.setName(userInput.nextLine());
                    System.out.println("exposure (sun - full sun/ part - partial shade/ shade - shade):");
                    plant.setExposure(userInput.nextLine());
                    System.out.println("height (cm):");
                    plant.setHeight(userInput.nextInt());
                    System.out.println("price:");
                    plant.setPrice(userInput.nextDouble());
                    userInput.nextLine();
                    System.out.println("color (red / pink / white / purple / yellow):");
                    ((Flowering) plant).setColorPalette(userInput.nextLine());
                    break;
                case "n":
                    plant = new Plant();
                    System.out.println("Enter plant name:");
                    plant.setName(userInput.nextLine());
                    System.out.println("exposure (sun - full sun/ part - partial shade/ shade - shade):");
                    plant.setExposure(userInput.nextLine());
                    System.out.println("height (cm):");
                    plant.setHeight(userInput.nextInt());
                    System.out.println("price:");
                    plant.setPrice(userInput.nextDouble());
                    userInput.nextLine();
                    break;
                default:
                    System.out.println("Please, specify is the plant flowering or not? (y/n):");
            }
            return plant;
        }

    static void writeOneToPlantCart(Plant plant){
        FileWriter fw1 = null;
        try {
            fw1 = new FileWriter(new File("./data/plantCart.csv"), true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(String.valueOf(plant));
            bw1.newLine();
            bw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveToPlantListFile(ArrayList<Plant> listOfPlants){
        File fileName = new File("./data/plants.csv");

        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listOfPlants.size(); i++){
                bw.write(listOfPlants.get(i).toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Plant> readFromPlantsFile(ArrayList<Plant> listOfPlants){
        listOfPlants = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader("./data/plants.csv");
            BufferedReader br = new BufferedReader(fr);
            String fileLine = br.readLine();
            while (fileLine != null) {
                String[] splitString = fileLine.split("(:\\s)|(,\\s)|(\\{\\s)|(\\s})");
                Plant plant = new Flowering();
                plant.setName(splitString[2]);
                plant.setExposure(splitString[4]);
                plant.setHeight(Integer.parseInt(splitString[6]));
                plant.setPrice(Double.parseDouble(splitString[8]));
                if(splitString.length > 9){
                    ((Flowering) plant).setColorPalette(splitString[10]);
                }
                listOfPlants.add(plant);
                fileLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return listOfPlants;
    }
}




