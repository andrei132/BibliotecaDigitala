import java.io.IOException;

/**
 * Class that test project
 **/
public class TestProject {

    Administration administration;

    public TestProject(Administration administration) {

        this.administration = administration;

    }

    /**
     * Test publish function
     * @param path Path to file, where to write return of publish
     * @param array Array that has publish function
     */
    public void testPublish(String path,MyArrays array) throws IOException {

        MyFileWriter fileWriter = new MyFileWriter(path);

        for (MyArrayElement element : array.array) {

            if(element instanceof Book)
                fileWriter.writeInFileInfo(((Book)element).publish());

            if(element instanceof EditorialGroup)
                fileWriter.writeInFileInfo(((EditorialGroup)element).publish());

            if(element instanceof PublishingBrand)
                fileWriter.writeInFileInfo(((PublishingBrand)element).publish());

            fileWriter.writeInFileInfo("\n");

        }

        fileWriter.closeBuffer();

    }

    /**
     * Test getBooksForPublishingRetailerID function
     * @param path Path to file, where to write
     * @param idToTest ID of PublishingRetailer
     */
    public void testGetBooksForPublishingRetailerID(String path, int idToTest) throws IOException {

        MyFileWriter fileWriter = new MyFileWriter(path);
        MyArrays testBooksPR = this.administration.getBooksForPublishingRetailerID(idToTest);

        for (MyArrayElement element : testBooksPR.array) {

            fileWriter.writeInFileInfo(((Book)element).publish());
            fileWriter.writeInFileInfo("\n");

        }

        fileWriter.closeBuffer();

    }

    /**
     * Test getLanguagesForPublishingRetailerID
     * @param path Path to file, where to write
     * @param idToTest ID of PublishingRetailer
     */
    public void testGetLanguagesForPublishingRetailerID(String path, int idToTest) throws IOException {
        MyFileWriter fileWriter = new MyFileWriter(path);
        MyArrays testLanguagesPR = this.administration.getLanguagesForPublishingRetailerID(idToTest);

        if(testLanguagesPR == null) return;

        for (MyArrayElement element : testLanguagesPR.array) {

            fileWriter.writeInFileInfo(element.id + " " + ((Language)element).getCode()+" "+((Language)element).getName());
            fileWriter.writeInFileInfo("\n");

        }

        fileWriter.closeBuffer();

    }

    /**
     *Test getCountriesForBookID
     * @param path Path to file, where to write
     * @param idToTest Book ID
     */
    public void testGetCountriesForBookID(String path, int idToTest) throws IOException {
        MyFileWriter fileWriter = new MyFileWriter(path);
        MyArrays testCountryB = this.administration.getCountriesForBookID(idToTest);

        for (MyArrayElement element : testCountryB.array) {
            fileWriter.writeInFileInfo(element.id + " " + ((Countries)element).getCountryCode());
            fileWriter.writeInFileInfo("\n");
        }

        fileWriter.closeBuffer();

    }

    /**
     * Test getCommonBooksForRetailerIDs
     * @param path Path to file, where to write
     * @param idToTest1 First Publisher Retailer ID
     * @param idToTest2 Second Publisher Retailer ID
     */
    public void testGetCommonBooksForRetailerIDs(String path, int idToTest1, int idToTest2) throws IOException {

        MyFileWriter fileWriter = new MyFileWriter(path);
        MyArrays testCommonPR = this.administration.getCommonBooksForRetailerIDs(idToTest1,idToTest2);

        if(testCommonPR == null) {
            fileWriter.closeBuffer();
            return;
        }

        for (MyArrayElement element : testCommonPR.array) {

            fileWriter.writeInFileInfo(((Book)element).publish());
            fileWriter.writeInFileInfo("\n");

        }

        fileWriter.closeBuffer();

    }

    /**
     * Test getAllBooksForRetailerIDs
     * @param path Path to file, where to write
     * @param idToTest1 First Publisher Retailer ID
     * @param idToTest2 Second Publisher Retailer ID
     */
    public void testGetAllBooksForRetailerIDs(String path,int idToTest1, int idToTest2) throws IOException {

        MyFileWriter fileWriter = new MyFileWriter(path);
        MyArrays testAllPR = this.administration.getAllBooksForRetailerIDs(idToTest1,idToTest2);

        if(testAllPR == null) {
            fileWriter.closeBuffer();
            return;
        }

        for (MyArrayElement element : testAllPR.array) {

            fileWriter.writeInFileInfo(((Book)element).publish());
            fileWriter.writeInFileInfo("\n");

        }

        fileWriter.closeBuffer();

    }

}
