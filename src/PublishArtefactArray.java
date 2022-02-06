public class PublishArtefactArray {

    private final MyArrays[] publishingArtifact;

    public PublishArtefactArray(){

        this.publishingArtifact = new MyArrays[3];
        this.publishingArtifact[0] = new MyArrays();
        this.publishingArtifact[1] = new MyArrays();
        this.publishingArtifact[2] = new MyArrays();

     }

    public MyArrays getBooks(){

        return this.publishingArtifact[0];

    }

    public MyArrays getPublishingBrands(){

        return  this.publishingArtifact[1];

    }

    public MyArrays getEditorialGroups(){

        return this.publishingArtifact[2];

    }

}
