import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that make all connection between 2 classes
 **/
public abstract class MyConnection {

    /**
     * Connect elementA with elementB, if type is right
     * @param elementA First element, type first field
     * @param elementB Second element, type second field
     * @param typeOfConnection Connection type:
     *                         {[0] Book - Author}
     *                         {[1] EditorialGroup - Book}
     *                         {[2] PublishingBrand - Book}
     *                         {[3] PublishingRetailer - Book}
     *                         {[4] PublishingRetailer - Countries}
     *                         {[5] PublishingRetailer - EditorialGroup}
     *                         {[6] PublishingRetailer - PublisherBrand}
     */
    private static void connect(MyArrayElement elementA, MyArrayElement elementB, int typeOfConnection){

        if((elementA == null) || (elementB == null)) return;

        switch (typeOfConnection){

            case 0:
                if((elementA instanceof Book) && (elementB instanceof Author)){

                    ((Book)elementA).getAuthors().insertEndElement(elementB);
                    ((Author)elementB).getBooks().insertEndElement(elementA);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            case 1:
                if((elementA instanceof EditorialGroup) && (elementB instanceof Book)){

                    ((EditorialGroup)elementA).getBooks().insertEndElement(elementB);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            case 2:
                if((elementA instanceof PublishingBrand) && (elementB instanceof Book)){

                    ((PublishingBrand)elementA).getBooks().insertEndElement(elementB);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            case 3:
                if((elementA instanceof PublishingRetailer) && (elementB instanceof Book)){

                    ((PublishingRetailer)elementA).getPublishingArtifacts().getBooks().insertEndElement( elementB);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            case 4:
                if((elementA instanceof PublishingRetailer) && (elementB instanceof Countries)){

                    ((PublishingRetailer)elementA).getCountries().insertEndElement( elementB);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            case 5:
                if((elementA instanceof PublishingRetailer) && (elementB instanceof EditorialGroup)){

                    ((PublishingRetailer)elementA).getPublishingArtifacts().getEditorialGroups().insertEndElement(elementB);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            case 6:
                if((elementA instanceof PublishingRetailer) && (elementB instanceof PublishingBrand)){

                    ((PublishingRetailer)elementA).getPublishingArtifacts().getPublishingBrands().insertEndElement(elementB);

                } else {

                    System.out.println("ERROR: Type is not Right!");

                }

                break;

            default:

                System.out.println("ERROR: Out of command!\nRetry!");

        }

    }

    /**
     * Connect all elements from a with b, from file-path path
     * @param path File path
     * @param a Array a that is used in file
     * @param b Array b that is used in file
     * @param typeOfConnection Connection type [0..6]
     */
    public static void connectionBetweenAB(String path, MyArrays a, MyArrays b,int typeOfConnection){

        File file = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            if((line = br.readLine()) == null){

                return;

            }

            while ((line = br.readLine()) != null) {

                String[] words = line.split("###");

                MyArrayElement elementA = a.findByIdInArr(Integer.parseInt(words[0]));
                MyArrayElement elementB = b.findByIdInArr(Integer.parseInt(words[1]));

                if((elementA == null) || (elementB == null)){

                    System.out.println("ERROR: Something went wrong!");

                }

                connect(elementA,elementB,typeOfConnection);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
