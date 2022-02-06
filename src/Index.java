import java.io.IOException;

/**
 * Executable class
 **/
public class Index {

    public static void main(String[] args) throws IOException {

        //Read from file
        MyArrays languages = MyFileReader.readFromFile("./init/languages.in",1);
        MyArrays books = MyFileReader.readFromFileBook("./init/books.in", languages);
        MyArrays authors = MyFileReader.readFromFile("./init/authors.in",0);
        MyArrays countries = MyFileReader.readFromFile("./init/countries.in",2);
        MyArrays editorialGroups = MyFileReader.readFromFile("./init/editorial-groups.in",3);
        MyArrays publishingBrands = MyFileReader.readFromFile("./init/publishing-brands.in", 4);
        MyArrays publishingRetailers = MyFileReader.readFromFile("./init/publishing-retailers.in",5);

        //Connect classes
        MyConnection.connectionBetweenAB("./init/books-authors.in",books,authors,0);
        MyConnection.connectionBetweenAB("./init/editorial-groups-books.in",editorialGroups,books,1);
        MyConnection.connectionBetweenAB("./init/publishing-brands-books.in",publishingBrands,books,2);
        MyConnection.connectionBetweenAB("./init/publishing-retailers-books.in",publishingRetailers,books,3);
        MyConnection.connectionBetweenAB("./init/publishing-retailers-countries.in",publishingRetailers,countries,4);
        MyConnection.connectionBetweenAB("./init/publishing-retailers-editorial-groups.in",publishingRetailers,editorialGroups,5);
        MyConnection.connectionBetweenAB("./init/publishing-retailers-publishing-brands.in",publishingRetailers,publishingBrands,6);


        Administration administration = new Administration(publishingRetailers);
        TestProject testProject = new TestProject(administration);

        //Test publish from book
        assert books != null;
        testProject.testPublish("./testOut/testPublishBook.out",books);
        assert editorialGroups != null;
        testProject.testPublish("./testOut/testPublishEditorialGroup.out",editorialGroups);
        assert publishingBrands != null;
        testProject.testPublish("./testOut/testPublishPublicationBrands.out",publishingBrands);

        //Test getBooksForPublishingRetailerID()
        testProject.testGetBooksForPublishingRetailerID("./testOut/testGetBooksForPublishingRetailerID13.out",13);
        testProject.testGetBooksForPublishingRetailerID("./testOut/testGetBooksForPublishingRetailerID31.out",31);
        testProject.testGetBooksForPublishingRetailerID("./testOut/testGetBooksForPublishingRetailerID4.out",4);
        testProject.testGetBooksForPublishingRetailerID("./testOut/testGetBooksForPublishingRetailerID26.out",26);
        testProject.testGetBooksForPublishingRetailerID("./testOut/testGetBooksForPublishingRetailerID16.out",16);

        //Test getLanguagesForPublishingRetailerID()
        testProject.testGetLanguagesForPublishingRetailerID("./testOut/testGetLanguagesForPublishingRetailerID18.out",18);
        testProject.testGetLanguagesForPublishingRetailerID("./testOut/testGetLanguagesForPublishingRetailerID28.out",28);
        testProject.testGetLanguagesForPublishingRetailerID("./testOut/testGetLanguagesForPublishingRetailerID2.out",2);
        testProject.testGetLanguagesForPublishingRetailerID("./testOut/testGetLanguagesForPublishingRetailerID26.out",26);
        testProject.testGetLanguagesForPublishingRetailerID("./testOut/testGetLanguagesForPublishingRetailerID9.out",9);

        //Test getCountriesForBookID()
        testProject.testGetCountriesForBookID("./testOut/testGetCountriesForBookID2674.out",2674);
        testProject.testGetCountriesForBookID("./testOut/testGetCountriesForBookID11012.out",11012);
        testProject.testGetCountriesForBookID("./testOut/testGetCountriesForBookID4595.out",4595);
        testProject.testGetCountriesForBookID("./testOut/testGetCountriesForBookID8183.out",8183);
        testProject.testGetCountriesForBookID("./testOut/testGetCountriesForBookID1301.out",1301);

        //Test getCommonBooksForRetailerIDs()
        assert publishingRetailers != null;
        ((PublishingRetailer)publishingRetailers.findByIdInArr(6)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(8)).getPublishingArtifacts().getBooks().array[0]);
        ((PublishingRetailer)publishingRetailers.findByIdInArr(6)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(8)).getPublishingArtifacts().getBooks().array[1]);
        ((PublishingRetailer)publishingRetailers.findByIdInArr(6)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(8)).getPublishingArtifacts().getBooks().array[2]);
        testProject.testGetCommonBooksForRetailerIDs("./testOut/testGetCommonBooksForRetailerIDs6 8.out",6,8);

        ((PublishingRetailer)publishingRetailers.findByIdInArr(30)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(7)).getPublishingArtifacts().getBooks().array[0]);
        ((PublishingRetailer)publishingRetailers.findByIdInArr(30)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(7)).getPublishingArtifacts().getBooks().array[1]);
        ((PublishingRetailer)publishingRetailers.findByIdInArr(30)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(7)).getPublishingArtifacts().getBooks().array[2]);
        testProject.testGetCommonBooksForRetailerIDs("./testOut/testGetCommonBooksForRetailerIDs30 7.out",30,7);

        testProject.testGetCommonBooksForRetailerIDs("./testOut/testGetCommonBooksForRetailerIDs15 8.out",15,8);

        ((PublishingRetailer)publishingRetailers.findByIdInArr(28)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(16)).getPublishingArtifacts().getBooks().array[0]);
        ((PublishingRetailer)publishingRetailers.findByIdInArr(16)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(28)).getPublishingArtifacts().getBooks().array[1]);
        ((PublishingRetailer)publishingRetailers.findByIdInArr(16)).getPublishingArtifacts().getBooks().insertEndElement(
                ((PublishingRetailer)publishingRetailers.findByIdInArr(28)).getPublishingArtifacts().getBooks().array[2]);
        testProject.testGetCommonBooksForRetailerIDs("./testOut/testGetCommonBooksForRetailerIDs16 28.out",16,28);

        testProject.testGetCommonBooksForRetailerIDs("./testOut/testGetCommonBooksForRetailerIDs12 12.out",12,12);

        testProject.testGetCommonBooksForRetailerIDs("./testOut/testGetCommonBooksForRetailerIDs1 2.out",1,2);

        //Test getAllBooksForRetailerIDs()
        testProject.testGetAllBooksForRetailerIDs("./testOut/testGetAllBooksForRetailerIDs15 20.out",15,20);
        testProject.testGetAllBooksForRetailerIDs("./testOut/testGetAllBooksForRetailerIDs6 8.out",6,8);
        testProject.testGetAllBooksForRetailerIDs("./testOut/testGetAllBooksForRetailerIDs28 16.out",28,16);
        testProject.testGetAllBooksForRetailerIDs("./testOut/testGetAllBooksForRetailerIDs33 20.out",33,20);
        testProject.testGetAllBooksForRetailerIDs("./testOut/testGetAllBooksForRetailerIDs1 12.out",1,12);

   }

}
