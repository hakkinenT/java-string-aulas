package com.hakkinent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String[] args) {
        validaCep("12345-678");
        validaCep("12345678");
        validaCep("1234-5678");

        removeNonDigits("94923784799");
        removeNonDigits("213.445.034-82");

        validateBrDomain("batata.com.br");
        validateBrDomain("batata.com");

        findEmails("Para mains informações, contate-nos em contato@example.com ou suporte@example.com.br");
    }

    private static void validaCep(String cep){
        String regex = "^\\d{5}-?\\d{3}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(cep);
        if(matcher.matches()){
            System.out.println(cep + " - Corresponde ao padrão");
        }else{
            System.out.println(cep + " - Não corresponde ao padrão");
        }

    }

    private static void removeNonDigits(String text){
        String regex = "\\D";
        
        System.out.println(text.replaceAll(regex, ""));
    }

    private static void validateBrDomain(String domain){
        String regex = "\\.br$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(domain);

        if(matcher.find()){
            System.out.println("é domínio brasileiro");
        }else{
            System.out.println("não é domínio brasileiro");
        }
    }

    private static void findEmails(String email){
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
