package Task8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface
interface FileProcessor {
    void process(Filedata filedata);
}

public class Fileprocessing {
    public static void main(String[] args) {

        Filedata file = new Filedata(
                "students.csv",
                "CSV",
                2.5,
                "id,name,course",
                "Ravi"
        );


        Predicate<Filedata> validateFile = f ->
                f.getFileSizeInMb() < 5
                        && f.getContent() != null
                        && !f.getContent().isEmpty()
                        && f.getUploadedBy() != null;


        Consumer<Filedata> displayFile = f -> {
            System.out.println("File Name: " + f.getFileName());
            System.out.println("File Type: " + f.getFileType());
        };


        BiConsumer<String, String> logger =
                (fileName, status) ->
                        System.out.println(fileName + " : " + status);


        FileProcessor csvProcessor = f ->
                System.out.println("CSV Records Processed Successfully");


        FileProcessor jsonProcessor = f ->
                System.out.println("JSON Processed Successfully");


        FileProcessor xmlProcessor = f ->
                System.out.println("XML Processed Successfully");


        FileProcessor txtProcessor = f ->
                System.out.println("TXT Processed Successfully");

        Map<String, FileProcessor> processors = new HashMap<>();

        processors.put("CSV", csvProcessor);
        processors.put("JSON", jsonProcessor);
        processors.put("XML", xmlProcessor);
        processors.put("TXT", txtProcessor);

        if (!validateFile.test(file)) {
            System.out.println("Validation Failed");
            return;
        }

        System.out.println("Validation: SUCCESS");


        displayFile.accept(file);


        System.out.println("Processor Selected: "
                + file.getFileType() + " Processor");

        processors.get(file.getFileType())
                .process(file);


        logger.accept(
                file.getFileName(),
                "SUCCESS"
        );
    }
}
