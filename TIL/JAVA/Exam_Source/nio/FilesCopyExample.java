package nio;import java.nio.file.Files;import java.nio.file.Path;import java.nio.file.Paths;import java.nio.file.StandardCopyOption;public class FilesCopyExample {    public static void main(String[] args) throws Exception {        Path from = Paths.get("src/exam02_file_copy/house1.jpg");        Path to = Paths.get("src/exam04_file_copy/house2.jpg");        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);        System.out.println("파읿 복사 성공");    }}