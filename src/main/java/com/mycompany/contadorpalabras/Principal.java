/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contadorpalabras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Fer
*/

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        
        try {
            System.out.print("Escribe el nombre del archivo: ");
            String archivoTXT = teclado.nextLine() + ".txt";
            
            Map<String, Integer> contadorPalabras = new TreeMap<>();
            FileReader archivo = new FileReader(archivoTXT);
            
            try (BufferedReader lector = new BufferedReader(archivo)) {
                String linea;
                
                while ((linea = lector.readLine()) != null) {                
                    String[] palabras = linea.split("\\s+");
                    
                    for (String palabra : palabras) {
                        palabra = palabra.toLowerCase().replaceAll("[^a-zñáéíóú]", "");
                        
                        if (!palabra.isEmpty()) { // verifica que la palabra no esté vacia
                            if (contadorPalabras.containsKey(palabra)) { // si la palabra ya esta en el mapa
                                contadorPalabras.put(palabra, contadorPalabras.get(palabra) + 1); // le sumamos uno
                            } else {
                                contadorPalabras.put(palabra, 1); // si no la añadimos al mapa iniciando su contador en 1
                            }
                        }
                    }
                }
            }

            // cada entrada del mapa va a iterar sobre cada entrada del contador
            for (Map.Entry<String, Integer> entradaMapa : contadorPalabras.entrySet()) {
                System.out.println(entradaMapa.getKey() + ": " + entradaMapa.getValue() + " veces.");
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
