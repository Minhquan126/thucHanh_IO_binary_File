import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        String PATH_FILE = "C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\thucHanh_IO_BinaryFile\\src\\student.txt";
        studentList.add(new Student(1,"quan","Nghe An"));
        studentList.add(new Student(2,"mung","Nghe An"));
        studentList.add(new Student(3,"ngan","Ha Noi"));
writeToFile(PATH_FILE,studentList);
List<Student> listFormFile = readObjectFormFile("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\thucHanh_IO_BinaryFile\\src\\Student.java");
        for (Student student:listFormFile) {
            System.out.println(student);
        }
    }
    public static void writeToFile(String path, List<Student> list){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
oos.close();
fos.close();
        } catch (IOException ioe){
ioe.printStackTrace();
        }
    }
public static List<Student> readObjectFormFile(String path){
        List<Student> listStudents = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listStudents = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ioe){
            ioe.printStackTrace();
        }
        return listStudents;
}
}
