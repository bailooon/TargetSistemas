package com.targetsistemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        
        // Exercício 1
        System.out.println("--------Exercício 1--------");
        int indice = 13;
        int soma = 0;
        int k = 0;

        while(k < indice){
            k = k +1;
            soma = soma + k;
        }

        System.out.println(soma); //91

        // Exercício 2
        Scanner entrada = new Scanner(System.in);

        int a = 0, b = 1;
        int number = 0;
        
        System.out.println("--------Exercício 2--------");
        System.out.println("Insira um número para verificar se ele pertence à sequência de Fibonacci:");
        number = entrada.nextInt();

        if (number < 0) {
            System.out.println("O número não pertence à sequencia de Fibonacci");
        }

        while(b < number){
            int temp = b;
            b = a + b;
            a = temp;
        }

        if (number == 0 || number == 1 || number == b) {
            System.out.println("O número pertence à sequencia de Fibonacci");
        }else{
            System.out.println("O número não pertence à sequencia de Fibonacci");
        }

        //Exercício 3
         String json = "[{\"dia\":1,\"valor\":22174.1664},{\"dia\":2,\"valor\":24537.6698},{\"dia\":3,\"valor\":26139.6134},{\"dia\":4,\"valor\":0.0},{\"dia\":5,\"valor\":0.0},{\"dia\":6,\"valor\":26742.6612},{\"dia\":7,\"valor\":0.0},{\"dia\":8,\"valor\":42889.2258},{\"dia\":9,\"valor\":46251.174},{\"dia\":10,\"valor\":11191.4722},{\"dia\":11,\"valor\":0.0},{\"dia\":12,\"valor\":0.0},{\"dia\":13,\"valor\":3847.4823},{\"dia\":14,\"valor\":373.7838},{\"dia\":15,\"valor\":2659.7563},{\"dia\":16,\"valor\":48924.2448},{\"dia\":17,\"valor\":18419.2614},{\"dia\":18,\"valor\":0.0},{\"dia\":19,\"valor\":0.0},{\"dia\":20,\"valor\":35240.1826},{\"dia\":21,\"valor\":43829.1667},{\"dia\":22,\"valor\":18235.6852},{\"dia\":23,\"valor\":4355.0662},{\"dia\":24,\"valor\":13327.1025},{\"dia\":25,\"valor\":0.0},{\"dia\":26,\"valor\":0.0},{\"dia\":27,\"valor\":25681.8318},{\"dia\":28,\"valor\":1718.1221},{\"dia\":29,\"valor\":13220.495},{\"dia\":30,\"valor\":8414.61}]";

        JSONArray faturamento = new JSONArray(json);

        double menor = Double.MAX_VALUE;
        double maior = Double.MIN_NORMAL;
        double total = 0;
        int diasComFaturamento = 0;
        double media = 0;
        int diasAcimaDaMedia = 0;

        for(int i = 0; i < faturamento.length(); i++){
            JSONObject dia = faturamento.getJSONObject(i);
            double valor = dia.getDouble("valor");

            if(valor > 0){
                if(valor < menor){
                    menor = valor;
                }

                if(valor > maior){
                    maior = valor;
                }

                soma += valor;
                diasComFaturamento++;
            }
        }

        media = total / diasComFaturamento;

         for (int i = 0; i < faturamento.length(); i++) {
            double valor = faturamento.getJSONObject(i).getDouble("valor");
            if (valor > media) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("---------Exercício 3 ----------");
        System.out.println("menor valor de faturamento ocorrido em um dia do mês: " + menor);
        System.out.println("maior valor de faturamento ocorrido em um dia do mês: " + maior);
        System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + diasAcimaDaMedia);


        //Exercício 4
        System.out.println("---------Exercício 4 ----------");
        double somaTotal = 0;

        Map<String, Double> faturamentoPorEstado = new LinkedHashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        for (double valor : faturamentoPorEstado.values()) {
            somaTotal += valor;
        }

        for (Map.Entry<String, Double> fatura : faturamentoPorEstado.entrySet()) {
            String estado = fatura.getKey();
            double valor = fatura.getValue();
            double percentual = (valor / somaTotal) * 100;
            System.out.printf("%s: %.2f%% | ", estado, percentual);
        }

        System.out.println("");

        //Exercício 5
        System.out.println("---------Exercício 5 ----------");
        String original = "";
        String invertida = "";
        
        System.out.println("Escreva uma string para ser invertida: ");
        original = entrada.next();

        for(int i = original.length() -1; i >= 0; i--){
            invertida += original.charAt(i);
        }

        System.out.println("String invertida: " + invertida);

        entrada.close();
    }
}