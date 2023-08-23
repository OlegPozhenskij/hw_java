package Jtask.hw1;

public abstract class Animal {
    private int runLimit;
    private int swimLimit;

    public Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
    }

    public void run(int distance) {
        if(distance <= runLimit) {
            System.out.println(this + " пробежал/а " + distance + " Метров");
        } else {
            System.out.println(this + " не может пробежать " + distance + " метров");
        }
    }

    public void swim(int distance) {
        if(distance <= runLimit) {
            System.out.println(this + " проплыл/а " + distance + " Метров");
        } else {
            System.out.println(this + " не может проплыть " + distance + " метров");
        }
    }
}
