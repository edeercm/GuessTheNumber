import java.util.Random;   // Importa la clase Random para generar números aleatorios
import java.util.Scanner;  // Importa la clase Scanner para leer datos desde el teclado

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Crea un objeto para leer entrada del usuario
        Random random = new Random();              // Crea un objeto para generar números aleatorios
        String playAgain;                          // Variable para saber si el usuario quiere jugar de nuevo

        // Establecemos los límites del número a adivinar y la cantidad de intentos
        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 7;

        // Mensaje inicial de bienvenida
        System.out.println("¡Bienvenido al juego Adivina el Número!");
        System.out.println("Debes adivinar un número entre " + MIN + " y " + MAX + ".");

        // Bucle principal para repetir el juego si el usuario quiere jugar otra vez
        do {
            // Generar un número aleatorio entre MIN y MAX
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;

            int attempts = 0;               // Contador de intentos
            boolean guessedCorrectly = false;  // Bandera para saber si el número fue adivinado

            // Bucle para permitir hasta MAX_ATTEMPTS intentos
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Ingresa tu intento #" + (attempts + 1) + ": ");

                // Verifica si la entrada es un número
                if (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    scanner.next(); // Limpia la entrada incorrecta
                    continue;       // Vuelve al inicio del bucle
                }

                int guess = scanner.nextInt(); // Lee el número ingresado

                // Verifica si el número está dentro del rango permitido
                if (guess < MIN || guess > MAX) {
                    System.out.println("El número debe estar entre " + MIN + " y " + MAX + ".");
                    continue;
                }

                attempts++; // Aumenta el número de intentos

                // Verifica si el usuario adivinó correctamente
                if (guess == numberToGuess) {
                    System.out.println("¡Correcto! Adivinaste el número en " + attempts + " intento(s).");
                    guessedCorrectly = true;
                    break; // Sale del bucle si adivinó
                } else if (guess < numberToGuess) {
                    System.out.println("El número es mayor.");
                } else {
                    System.out.println("El número es menor.");
                }
            }

            // Si no adivinó el número dentro de los intentos permitidos
            if (!guessedCorrectly) {
                System.out.println("Lo siento, has agotado tus intentos. El número era: " + numberToGuess);
            }

            // Pregunta si quiere jugar de nuevo
            System.out.print("¿Quieres jugar otra vez? (y/n): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("y")); // Se repite si el usuario escribe "s"

        // Mensaje final al salir del juego
        System.out.println("¡Gracias por jugar! Hasta luego.");
        scanner.close(); // Cierra el objeto scanner
    }
}
