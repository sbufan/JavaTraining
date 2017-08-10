import flowers.Bouquet;
import flowers.Cactus;
import flowers.Flower;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    public static void main(String args[]) {
        //1) Фібоначчі

        System.out.println("Fibonacci numbers");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input sequence size:");
        int count = 0;
        try {
            count = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please input correct number next time");
            return;
        }
        int searchedNumber = -1;
        while (searchedNumber < 0 || searchedNumber > count)
            try {
                System.out.println("Please input searched number in range 0 .. " + count);
                searchedNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input correct number next time");
                return;
            }
        Fibonacci.fibonacci(count, searchedNumber);

        //2) Створити ієрархію квітів
        Bouquet bouquet = new Bouquet();
        bouquet.addPlant(new Flower("Rose", 50, "red", 50, 3));
        bouquet.addPlant(new Cactus("Sonora barrel", 10, "green", "ball"));
        bouquet.addPlant(new Flower("Chamomile", 10, "white", 40, 4));
        bouquet.addPlant(new Flower("Jasmine", 30, "white", 20, 1));

        System.out.println("Total price for the bouquet is:   " + bouquet.getPrice());
        System.out.println("The longest flower in bouquet is: " + bouquet.getLongestFlower().getName());
        System.out.println("The fresher flower in bouquet is: " + bouquet.getFreshestFlower().getName());


        // 3) Вивести текст
        String inputText = "test test test wergwerg wergwerg HelloWorld! wer, gwe, rgw. erg wergwerg werg. werg werg werg";

        System.out.println("First unique word -  " + TextOperation.getUniqueWord(inputText));

        System.out.println();
        System.out.println("Please find text with changed shortest words to longest words in each sentence below:");
        System.out.println(TextOperation.replaceWord(inputText));

        System.out.println();
        System.out.println("Please find count of words in text below:");
        TextOperation.printWordsCount(inputText);
    }
}
