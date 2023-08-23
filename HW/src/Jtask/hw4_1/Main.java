package Jtask.hw4_1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Чтение файла poem.txt
            BufferedReader reader = new BufferedReader(new FileReader("poem.txt"));

            String line;
            int partNumber = 1;
            StringBuilder paragraph = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {  // Пустая строка - разделитель абзацев
                    writeToFile("part" + partNumber, paragraph.toString());
                    paragraph = new StringBuilder();
                    partNumber++;
                } else {
                    paragraph.append(line).append(System.lineSeparator());
                }
            }

            // Запись последнего абзаца
            if (paragraph.length() > 0) {
                writeToFile("part" + partNumber, paragraph.toString());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String fileName, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}