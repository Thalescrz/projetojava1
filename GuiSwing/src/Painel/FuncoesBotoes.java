package Painel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thales
 */
public class FuncoesBotoes {
    String texto;
    
    protected void executarIpconfig() {
        try {
           
            String comando = "ipconfig"; 

            // Inicar o processo e executar o comando
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            // Ler a saída do processo
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));    
             StringBuilder output = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output.append(line).append("\n");
             }
            // Armazenar a saída em uma variável
            texto = output.toString();
            
            // Aguardar o término do processo
            int exitCode = process.waitFor();
            System.out.println("Comando executado com código de saída: " + exitCode);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void executarCmd() {
        try {
            // Abrir o CMD usando o comando Runtime.getRuntime().exec()
            Runtime.getRuntime().exec("cmd.exe /c start");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
    protected void executarPowerCfg(){
         try {
           
            String comando = "Powercfg -duplicatescheme e9a42b02-d5df-448d-aa00-03f14749eb61\n" +
"Powercfg /list"; 

            // Inicar o processo e executar o comando
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            // Ler a saída do processo
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));    
             StringBuilder output = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output.append(line).append("\n");
             }
            // Armazenar a saída em uma variável
            texto = output.toString();
            
            // Aguardar o término do processo
            int exitCode = process.waitFor();
            System.out.println("Comando executado com código de saída: " + exitCode);

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
     
     }
     
    protected void botaoVerificarCfg(){
    try {
           
            String comando = "Powercfg /l"; 

            // Inicar o processo e executar o comando
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            // Ler a saída do processo
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));    
             StringBuilder output = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output.append(line).append("\n");
             }
            // Armazenar a saída em uma variável
            texto = output.toString();
            
            // Aguardar o término do processo
            int exitCode = process.waitFor();
            System.out.println("Comando executado com código de saída: " + exitCode);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

  
