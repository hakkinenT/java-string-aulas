package com.hakkinent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        // Define a expressão regular
        String regex = "(gato|cachorro)";
        Pattern pattern = Pattern.compile(regex);

        // String de entrada
        String input = "Eu tenho um gato e um cachorro.";
        
        // Cria o matcher
        Matcher matcher = pattern.matcher(input);

        // Encontra e imprime todas as ocorrências
        while (matcher.find()) {
            System.out.println("Encontrado: " + matcher.group());
        }
        
        // Verifica se a string inteira corresponde ao padrão
        String testString = "gato";
        Matcher testMatcher = pattern.matcher(testString);
        if (testMatcher.matches()) {
            System.out.println(testString + " corresponde ao padrão.");
        } else {
            System.out.println(testString + " não corresponde ao padrão.");
        }

        regexNonGrouping();
    }

    private static void regexNonGrouping(){
        // Define a expressão regular
        String regex = "(?:https?|ftp):\\/\\/([^/\\r\\n]+)(\\/[^\\r\\n]*)?";
        Pattern pattern = Pattern.compile(regex);

        // Strings de entrada para teste
        String[] inputs = {
            "http://www.exemplo.com",
            "https://www.exemplo.com/path/to/resource",
            "ftp://ftp.exemplo.com/diretorio/arquivo.txt",
            "http://exemplo.com?query=123",
            "https://subdominio.exemplo.com",
            "ftp://exemplo.com/"
        };

        // Testa cada string de entrada
        for (String input : inputs) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("URL encontrada: " + matcher.group());
                System.out.println("Domínio: " + matcher.group(1)); // captura o domínio
                if (matcher.group(2) != null) {
                    System.out.println("Caminho: " + matcher.group(2)); // captura o caminho
                } else {
                    System.out.println("Caminho: Nenhum");
                }
                System.out.println();
            } else {
                System.out.println("Nenhuma URL encontrada em: " + input + "\n");
            }
        }
    }
}
