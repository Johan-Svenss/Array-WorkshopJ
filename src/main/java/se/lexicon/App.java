package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Michael Erik Fleig","Erik Svensson", "Mehrdad Javan", "Michael Fleig", "Erik Tombrock"});
        System.out.println(NameRepository.getSize());
        //NameRepository.clear();
        //System.out.println(NameRepository.getSize());

        String[] storedNames = new String[0];
        loopArrayOut("\nFirst Loop", storedNames);

        storedNames = NameRepository.findAll();

        loopArrayOut("\nSecond Loop", storedNames);
        System.out.println(NameRepository.getSize());

        String foundName = NameRepository.find("Erik svensson");

        System.out.println(foundName);

        for (int i = 0; i < storedNames.length; i++) {
            NameRepository.find(storedNames[i]);
        }

        boolean doesNotNameAlreadyExist = false;

        doesNotNameAlreadyExist = NameRepository.add("Michael Fleig");


        System.out.println("Was name already in the array? Result: " + !doesNotNameAlreadyExist);
        loopArrayOut("\nThird Loop", storedNames);

        doesNotNameAlreadyExist = NameRepository.add("Roman Vanoyan");


        String[] newStoredNames = NameRepository.getNames();

        System.out.println("\nWas name already in the array? Result: " + !doesNotNameAlreadyExist);
        loopArrayOut("\nFourth Loop", newStoredNames);

        String[] foundFirstNames = NameRepository.findByFirstName("Erik");
        loopArrayOut("\nFifth Loop", foundFirstNames);

        String[] foundLastNames = NameRepository.findByLastName("Svensson");
        loopArrayOut("\nSixth Loop", foundLastNames);

        boolean isUpdated = NameRepository.update("Michael Fleig", "Mikael Larsson");
        String[] updatedNames = NameRepository.getNames();
        System.out.println("\nWas a name updated? Result: " + isUpdated);
        loopArrayOut("\nSeventh Loop", updatedNames);

        boolean hasRemovedElement = NameRepository.remove("Erik Svensson");
        String[] remainingNames = NameRepository.getNames();
        System.out.println("\nWas a name removed? Result: " + hasRemovedElement);
        loopArrayOut("\nEigth Loop", remainingNames);

        // call more methods as needed

    }

    private static void loopArrayOut(String Second_Loop, String[] storedNames) {
        System.out.println(Second_Loop);
        for (int i = 0; i < storedNames.length; i++) {
            System.out.println("Index " + i + " has value " + storedNames[i]);
        }
    }
}
