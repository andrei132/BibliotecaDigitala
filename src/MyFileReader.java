import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Class that read info from file
 **/
public abstract class MyFileReader {

    /**
     * Read Book from file path
     * @param path Path to file where to reed
     * @param languages All language that are in system
     * @return Array of all books
     */
    public static MyArrays readFromFileBook(String path, MyArrays languages){

        File file = new File(path);
        MyArrays books = new MyArrays();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {

            String line;

            //Header line read
            if((line = br.readLine()) == null){

                return null;

            }

            while ((line = br.readLine()) != null) {

                String[] words = line.split("###");

                books.insertEndElement(new Book(Integer.parseInt(words[0]),words[1],words[2],words[3],Integer.parseInt(words[4]),
                        words[5].split(";"), (Language) languages.findByIdInArr(Integer.parseInt(words[6])),words[7],new MyArrays(new Author[0])));

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return books;

    }

    /**
     * Create an object an insert it in arrays
     * @param array Array where all element are stored
     * @param typeOfElement Type of element like in readFromFile order
     * @param words All needing info
     */
    private static void allocClass(int typeOfElement, String[] words, MyArrays array){

        switch (typeOfElement) {
            case 0 -> array.insertEndElement(new Author(Integer.parseInt(words[0]), words[1], words[2], new MyArrays(new Book[0])));
            case 1 -> array.insertEndElement(new Language(Integer.parseInt(words[0]), words[1], words[2]));
            case 2 -> array.insertEndElement(new Countries(Integer.parseInt(words[0]), words[1]));
            case 3 -> array.insertEndElement(new EditorialGroup(Integer.parseInt(words[0]), words[1], new MyArrays(new Book[0])));
            case 4 -> array.insertEndElement(new PublishingBrand(Integer.parseInt(words[0]), words[1]));
            case 5 -> array.insertEndElement(new PublishingRetailer(Integer.parseInt(words[0]), words[1]));
            default -> System.out.println("ERROR: Out of command!\nRetry!");
        }

    }

    /**
     * Read from file path a variable of Author, Language, Countries, EditorialGroup, PublishingBrand, PublishingRetailer
     * @param path Path to file where to read
     * @param typeOfElement Type of element like in description
     * @return Array with all element
     */
    public static MyArrays readFromFile(String path, int typeOfElement){

        File file = new File(path);
        MyArrays array = new MyArrays();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {

            String line;

            //Header line read
            if((line = br.readLine()) == null){

                return null;

            }

            while ((line = br.readLine()) != null) {


                String[] words = line.split("###");
                allocClass(typeOfElement,words,array);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return array;

    }

}
