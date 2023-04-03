import javafx.scene.transform.Scale;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyIOStream {
    private void copyFileUsingjava7File(File source,File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private void copyFileUsingStream(File source,File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new  FileInputStream(source);
            os = new FileOutputStream(dest);
byte[] buffer = new byte[1024];
int length;
while ((length = is.read(buffer)) > 0){
    os.write(buffer,0,length);
}
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        CopyIOStream copyIOStream = new CopyIOStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source path");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter destPath");
        String destPath = scanner.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyIOStream.copyFileUsingjava7File(sourceFile,destFile);
            System.out.println("copy is completed");
        } catch (IOException ioe){
            System.err.println("File not found");
        }
    }
}
