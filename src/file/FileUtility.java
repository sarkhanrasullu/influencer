package file;

import common.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileUtility {


    public static void writeTextToFile(String message) throws IOException {
        Path path = Paths.get("/myfile.txt");
        Files.write(path, message.getBytes(), StandardOpenOption.CREATE);
    }//NIO Nonblocking Input Output Stream

    public static void writeImageToFile(String imagePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(imagePath));
        Path path = Paths.get("/Users/sarkhanrasullu/Desktop/copy.png");
        Files.write(path, bytes, StandardOpenOption.CREATE);
    }

    public static void readTextFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));

        String text = new String(bytes, StandardCharsets.UTF_8);

        System.out.println(text);
    }

    public static void writeObjToFile(Object obj, String objectFile) throws Exception {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile))) {//try-with-resources
            oos.writeObject(obj);

            oos.flush();
        }
    }

    public static Object readObject(String objectFile) throws Exception {
        try(ObjectInputStream iis =new ObjectInputStream(new FileInputStream(objectFile))) {
            return iis.readObject();
        }
    }

    public static void writeTextToFileIO_1(String text) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("mytextfile1.txt")) {
            fos.write(text.getBytes(StandardCharsets.UTF_8));
        }
    }

    public static void writeImageToFileIO_1(String image) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("myimgfile1.jpg")) {
            byte[] bytes = Files.readAllBytes(Paths.get(image));
            fos.write(bytes);
        }
    }

    public static void writeTextToFileIO_2(String text) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("mytextfile2.txt"))) {
            bw.write(text);
            bw.newLine();
        }
    }

    public static void readFromTextFile(String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void readFromTextFileByByte(String fileName) throws Exception {
            try (FileReader fr = new FileReader(fileName)) {
                int charByte;
                while ((charByte = fr.read()) != -1) {
                    System.out.println(charByte);
                }
            }
    }
}
