package lt.giedre1.app;

public class NamuDarbai1 {
    public static void main(String[] args) {
        // 1. Int kintamojo min ir max reiksmes
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // a) Gyventoju skaicius i int netelpa, bet telpa i Long
        System.out.println(Long.MAX_VALUE);
        Long Population = 7809994444L;
        System.out.println("Planetoje gyvena ~" + Population + " zmones");
        // b) Lt asmens kodas
        Long AsmKodas = 40005020622L;
        System.out.println(AsmKodas);
        // 2. prie maximalios int reikšmės + 1. This is called overflow.
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println("----------");

        // operatoriai
        // 1. 5/2 liekana
        System.out.println(5 % 2);
        // 2. 2/0 kas bus?
        // System.out.println(2 / 0); //runtime error?
        // 3.
        int x = 10;
        int y = 5;
        System.out.println(x == 10 && y <= 5); // true
        System.out.println(x <= y && y > 5); // false
        System.out.println("abc" instanceof String); //  true
        System.out.println("-------");

        // stringai
        //1. Sveiki, Jonai, kaip sekasi?
        System.out.println("Sveiki, Jonai,\nkaip sekasi?");
        // 2.
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        System.out.println(lorem.toLowerCase() );
        System.out.println(lorem.toUpperCase() );
        String newLorem = lorem.replace("o", "z");
        System.out.println(newLorem);
        System.out.println(lorem.endsWith("elit"));

    }
}
