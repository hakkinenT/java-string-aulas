package com.hakkinent;

public class Main {
    public static void main(String[] args) {
        String hello = "Hello world!";
        System.out.println(hello);

        System.out.println();
        System.out.println("INFORMAÇÕES BÁSICAS");
        System.out.println("length: " + hello.length());
        String isEmpty = hello.isEmpty() ? "A string é vazia" : "A string não é vazia";
        System.out.println(isEmpty);

        System.out.println();
        System.out.println("COMPARAÇÃO");
        String isEquals = hello.equals("Hello") ? "As string são iguais" : "As strings não são iguais";
        System.out.println(isEquals);

        String isEqualsIgnoreCase = hello.equalsIgnoreCase("HELLO WORLD!") ? "As strings são iguais" : "As strings não são iguais";
        System.out.println(isEqualsIgnoreCase);

        System.out.println(hello.compareTo("Hello world!"));
        System.out.println(hello.compareToIgnoreCase(
            "HELLO WORLD!"
        ));

        System.out.println(hello.startsWith("He"));
        System.out.println(hello.endsWith("!"));
        System.out.println(hello.contains("l"));

        System.out.println();
        System.out.println("BUSCA");
        System.out.println(hello.indexOf("l"));
        System.out.println(hello.indexOf("l", 5));
        System.out.println(hello.indexOf("llo"));
        System.out.println(hello.indexOf("llo", 5));
        System.out.println(hello.lastIndexOf("l"));
        System.out.println(hello.lastIndexOf("l", 10));
        System.out.println(hello.lastIndexOf("hallo"));
        System.out.println(hello.lastIndexOf("hallo", 10));

        System.out.println();
        System.out.println("EXTRAÇÃO");
        System.out.println(hello.charAt(4));
        System.out.println(hello.substring(3));
        System.out.println(hello.substring(3, 8));

        String[] newString = hello.split(" ");
        for(int i = 0; i < newString.length; i++){
            System.out.println(newString[i].toString());
        }
        System.out.println();
        String fruits = "maça,laranja,mamão,limão,morango,uva";
        newString = fruits.split(",", 4);
        for(int i = 0; i < newString.length; i++){
            System.out.println(newString[i].toString());
        }

        System.out.println();
        System.out.println("MODIFICAÇÃO");
        String name = " José ";
        System.out.println(name);
        System.out.println(name.trim());
        System.out.println(hello.replace("l", "L"));
        System.out.println(hello.replaceAll(" ", "-"));
        System.out.println(fruits.replaceAll(",", "--"));
        System.out.println(fruits.replaceFirst(",", "--"));

        System.out.println();
        System.out.println("CONVERSÃO");
        char[] array = hello.toCharArray();
        array[1] = 'a';
        hello = new String(array);
        System.out.println(hello);
        System.out.println(String.valueOf(10));
        System.out.println(String.valueOf(10.0));

        System.out.println();
        System.out.println("OUTROS");
        String flora = "flora";
        System.out.println(flora.matches("flora|gordo|luna"));
        
        System.out.println(fruits.concat(",mirtilho"));
        
        String[] cities = new String[]{"São Paulo", "Belo Horizonte", "Aracaju"};
        String citiesj = String.join(", ", cities);
        System.out.println(citiesj);
        
        String myStr = "Hello %s! One kilobyte is %,d bytes.";
        String result = String.format(myStr, "World", 1024);
        System.out.println(result);

    }
}