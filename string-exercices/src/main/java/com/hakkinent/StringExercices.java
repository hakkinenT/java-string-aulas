package com.hakkinent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExercices {
    public static void main(String[] args) {
        System.out.println(removeNonDigits("949.237.847-99"));

        System.out.println();
        DateData obj = date1("15/10/2024");
        System.out.println("Dia: " + obj.day);
        System.out.println("Mês: " + obj.month);
        System.out.println("Ano: " + obj.year);

        System.out.println();
        System.out.println(formatDate(5, 7, 2024));

        System.out.println();
        EmailInfo emailInfo1 = extractEmailInformation("joao.silva23@yahoo.com.br");
        System.out.println("Usuario: " + emailInfo1.username);
        System.out.println("Dominio: " + emailInfo1.domain);
        System.out.println("Brasileiro: " + (emailInfo1.isBrazilian ? "sim" : "nao"));
        
        System.out.println();
        EmailInfo emailInfo2 = extractEmailInformation("maria123@gmail.com");
        System.out.println("Usuario: " + emailInfo2.username);
        System.out.println("Dominio: " + emailInfo2.domain);
        System.out.println("Brasileiro: " + (emailInfo2.isBrazilian ? "sim" : "nao"));

        System.out.println();
        System.out.println("\"" + longestCommonPrefix(new String[] { "flower", "flow", "flight" }) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[] { "dog","racecar","car" }) + "\"");

        System.out.println();
        System.out.println(validatePassword("amerca1@"));
        System.out.println(validatePassword("amrca154682"));

        System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,100,beijing" }));
		System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,1200,mtv" }));
		System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "bob,50,1200,mtv" }));

        System.out.println(isAnagram("anagram", "nagaram"));
    	System.out.println(isAnagram("batata", "attaba"));
    	System.out.println(isAnagram("rat", "car"));

        System.out.println(isAnagram2("anagram", "nagaram"));
    	System.out.println(isAnagram2("batata", "attaba"));
    	System.out.println(isAnagram2("rat", "car"));
    }

    private static String removeNonDigits(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    private static DateData date1(String date){
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return new DateData(day, month, year);
    }

    private static String formatDate(int day, int month, int year){
        String formatDay = String.format("%02d", day);
        String formatMonth = String.format("%02d", month);

        return formatDay + "/" + formatMonth + "/" + year;
    }

    private static EmailInfo extractEmailInformation(String email){
        String[] parts = email.split("@");
        String username = parts[0];
        String domain = parts[1];

        boolean isBrazilian = domain.endsWith(".br");

        return new EmailInfo(username, domain, isBrazilian);
    }

    private static String longestCommonPrefix(String[] v){
        StringBuilder sb = new StringBuilder();

        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if(first.charAt(i) != last.charAt(i)){
                return sb.toString();
            }

            sb.append(first.charAt(i));
        }

        return sb.toString();
    }

    public static boolean validatePassword(String str) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@&#]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static List<String> invalidTransactions(String[] transactions){
        class Transaction {
        
            String name;
            int time;
            int money;
            String city;

            public Transaction(String csv){
                String[] parts = csv.split(",");
                name = parts[0];
                time = Integer.parseInt(parts[1]);
                money = Integer.parseInt(parts[2]);
                city = parts[3];
            }
        }

        List<String> result = new ArrayList<>();
        boolean[] invalidArray = new boolean[transactions.length];

        for (int i = 0; i < transactions.length; i++) {
            Transaction ti = new Transaction(transactions[i]);
            if(ti.money > 1000){
                invalidArray[i] = true;
            }

            for (int j = i + 1; j < transactions.length; j++) {
                Transaction tj = new Transaction(transactions[j]);
                if(ti.name.equals(tj.name) && Math.abs(ti.time - tj.time) <= 60 && !ti.city.equals(tj.city)){
                    invalidArray[i] = true;
                    invalidArray[j] = true;
                }
            }
        }

        for (int i = 0; i < transactions.length; i++) {
            if(invalidArray[i]){
                result.add(transactions[i]);
            }
        }

        return result;
    }

    public static boolean isAnagram(String s, String t){
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static boolean isAnagram2(String s, String t){
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            count[t.charAt(j) - 'a']--;
        }

        for(int c: count){
            if(c != 0){
                return false;
            }
        }

        return true;
    }
}


class DateData {

    int day;
    int month;
    int year;

    public DateData(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

class EmailInfo{
    String username;
    String domain;
    boolean isBrazilian;

    public EmailInfo(String username, String domain, boolean isBrazilian){
        this.username = username;
        this.domain = domain;
        this.isBrazilian = isBrazilian;
    }
}