package Jtask.hw2;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Иван Иванов", "i.ivanov@email.com", 'м');
        Book book = new Book("Моя книга", author, 250.50, 100);

        System.out.println(author);
        // Выведет "Иван Иванов (м) i.ivanov@email.com"

        System.out.println(book);
        // Выведет ""Моя книга" by Иван Иванов (м) i.ivanov@email.com"
    }
}