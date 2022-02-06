import java.util.Arrays;

/**
 * Class that help in work with array, that extends MyArrayElement
 **/
public class MyArrays {

    MyArrayElement[] array;

    public MyArrays(MyArrayElement[] array) {

        this.array = array;

    }

    public MyArrays() {

        this.array = new MyArrayElement[0];

    }

    /**
     * Find element with id
     * @param id Element's ID that need to be search
     * @return Element with ID
     */
    public MyArrayElement findByIdInArr(Integer id){

        for (MyArrayElement element: this.array) {

            if(element.getId().equals(id)){

                return element;

            }

        }

        return null;

    }

    /**
     * Insert an element on the end of array
     * @param myArrayElementToAdd Element to be insert
     */
    public void insertEndElement(MyArrayElement myArrayElementToAdd){

        MyArrayElement[] result = Arrays.copyOf(this.array, this.array.length + 1);
        result[result.length - 1] = myArrayElementToAdd;
        this.array = result;

    }

    /**
     * If an element with id, exist in array
     * @param myArrayElementToVerify Element that must be verified
     * @return True if exist, False if not
     */
    public boolean containsElement(MyArrayElement myArrayElementToVerify){

        for (MyArrayElement element : this.array) {

            if(element.id.equals(myArrayElementToVerify.id)) return true;

        }

        return false;

    }

}
