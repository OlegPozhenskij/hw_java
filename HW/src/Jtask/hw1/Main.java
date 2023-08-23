package Jtask.hw1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        Animal[] animals = new Animal[rand.nextInt(7) + 1];
        int catsCount = 0;
        int dogsCount = 0;
        int tigersCount = 0;

        for (int i = 0; i < animals.length; i++) {
            int randValue = rand.nextInt(3);
            if (randValue == 0) {
                animals[i] = new Cat();
                catsCount++;
            } else if (randValue == 1) {
                animals[i] = new Dog();
                dogsCount++;
            } else {
                animals[i] = new Tiger();
                tigersCount++;
            }
        }

        for (Animal animal : animals) {
            animal.run(rand.nextInt(1000));
            animal.swim(rand.nextInt(1000));
        }

        System.out.println("Создано котов: " + catsCount);
        System.out.println("Создано собак: " + dogsCount);
        System.out.println("Создано тигров: " + tigersCount);

    }
}
