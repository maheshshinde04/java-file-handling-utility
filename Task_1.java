import java.io.*;

    public class Task_1 {

        // File path (can be relative or absolute)

        static String filePath = "sample.txt";

        public static void main(String[] args) {
            writeToFile();
            readFromFile();
            modifyFile();
            readFromFile();
        }

        // 1. Write to a file

        public static void writeToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("Hello, i am Mahesh task 1 text file.");
                writer.newLine();
                writer.write("This file is created.");
                System.out.println("✔ File written success.\n");
            } catch (IOException e) {
                System.out.println("❌ Error writing to file: " + e.getMessage());
            }
        }

        // 2. Read from a file

        public static void readFromFile() {
            System.out.println("📖 Reading file content:");
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println();
            } catch (IOException e) {
                System.out.println("❌ Error reading file: " + e.getMessage());
            }
        }

        // 3. Modify the file

        public static void modifyFile() {
            File originalFile = new File(filePath);
            File tempFile = new File("temp.txt");

            try (
                    BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {

                    // Replace a specific word

                    writer.write(line.replace("text", "modified"));
                    writer.newLine();
                }
                System.out.println("✏ File modified successfully.\n");

            } catch (IOException e) {
                System.out.println("❌ Error modifying file: " + e.getMessage());
            }

            // Replace original file with modified file
            if (!originalFile.delete()) {
                System.out.println("Delete failed");
            }

            if (!tempFile.renameTo(originalFile)) {
                System.out.println("Rename failed");
            }
        }
    }


