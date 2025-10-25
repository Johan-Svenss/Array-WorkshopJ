package se.lexicon;


/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param newNames The array of names to set.
     */
    public static void setNames(final String[] newNames) {
        //todo: PART 1: implement setNames method

        // Checking if the params(newNames) are empty
        if(newNames == null){
            names = new String[0];
        }

        // Creating a new array and override the old one
        names = new String[newNames.length];
        // int = 0 (starting point); i < newNames.length (condition); incrementor after the loop is completed
        for(int i = 0; i < newNames.length; i++){
            // setting values into the array by index
            names[i] = newNames[i];
        }
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: PART 1: implement clear method
        // Creating a new array two override the existing one
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method
        // Create anew array with the size of the global array
        String[] newStringArray = new String[getSize()];
        // starting point; condition; incrementor(short way to write i = i + 1) after the loop is done
        for(int i = 0; i < getSize(); i++){
            newStringArray[i] = names[i];
        }

        return newStringArray;
    }


    /**
     * Finds a name that matches the given fullName case-+.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        //todo: PART 2: implement find method
        // Starting point; condition; incrementor after loop
        for (int i = 0; i < getSize(); i++) {
            // condition: if array has a name case-insensitively from the param
            // if name is there, return it
            if(names[i].equalsIgnoreCase(fullName))
                // returns the name, because condition was true
                return names[i];
        }
        // if name is not there, return "not found"
        return "Not found";
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        //todo: PART 2: implement add method
        // Step 1: Check if the element is already in the array 'names'
        if (find(fullName).equals("Not found")){
            // Create a new array with one more index
            String[] addToArray = new String[getSize()+1];
            // copy the old array into a new one until it is done, but if
            // size is smaller then. keep the old names
            // if above (+1) add the new fullname
            for (int i = 0; i <= getSize(); i++) {
                if(i < getSize()){
                    addToArray[i] = names[i];
                } else {
                    addToArray[i] = fullName;
                }
            }
            setNames(addToArray);

            return true;
        } else {
            return false;
        }
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        //todo: PART 3: findByFirstName method
        // Step 1: Compare the param string with the array
        // string.equals("Erik") Erik Johan Svensson == Erik Johan Svensson | true

        // Step 1a: seperapte the first name from the last name while looping
        // Step 1b: store all names which has the same first name into a new array, if, the name is existend

        String[] foundNameList = new String[getSize()];
        int newIndex = 0;

        for (int i = 0; i < getSize(); i++) {
            if (names[i].split(" ")[0].equals(firstName)){
                foundNameList[newIndex] = names[i];
                newIndex++;
            }
        }
        // Create a new array with the size of the found indexes
        String[] toReturnList = new String[newIndex];

        for (int i = 0; i < newIndex; i++) {
            toReturnList[i] = foundNameList[i];
        }
        // Step 2: filter all first names from the array into the return array
        return toReturnList;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        //todo: PART 3: implement findByLastName method
        // Step 1: Compare the param string with the array

        //-----------------------------
        // Step 1b: store all names which has the same last name into a new array, if, the name is existend
        String[] foundNameList = new String[getSize()];
        int newIndex = 0;

        for (int i = 0; i < getSize(); i++) {
            String[] tempName =names[i].split(" ");
            if (tempName[tempName.length-1].equals(lastName)){
                foundNameList[newIndex] = names[i];
                newIndex++;
            }
        }
        // Create a new array with the size of the found indexes
        String[] toReturnList = new String[newIndex];

        for (int i = 0; i < newIndex; i++) {
            toReturnList[i] = foundNameList[i];
        }
        // Step 2: filter all first names from the array into the return array
        return toReturnList;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        //todo: PART 3: implement update method
        // Step 1: loop through the name list
        // Step 2: if exists, update by index
        // Step 3: if updated return true, else false
        for (int i = 0; i < getSize(); i++) {
            if (original.equals(names[i])){
                names[i] = updatedName;
                return true;
            }
        }

        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        //todo: PART 4: implement remove method
        int newlength = getSize();
        boolean isExistend = false;
        String[] temp = new String[newlength];

        for (int i = 0; i < newlength; i++) {
            if (isExistend) {
                newlength--;
            }
            if (fullName.equals(names[i])) {
                temp[i] = names[i + 1];
                isExistend = true;
            } else {
                if(isExistend){
                    temp[i] = names[i + 1];
                } else {
                    temp[i] = names[i];
                }
            }
        }

        String[] newArray = new String[newlength];
        for (int i = 0; i < newlength; i++) {
            newArray[i] = temp[i];
        }

        setNames(newArray);

        return isExistend;
    }

    public static String[] getNames() {
        return names;
    }
}