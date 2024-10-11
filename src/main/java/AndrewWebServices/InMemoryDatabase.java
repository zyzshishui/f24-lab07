package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database {
    private Map<String, Integer> userPasswords = new HashMap<>();

    public InMemoryDatabase() {
        userPasswords.put("Scotty", 17214);
        userPasswords.put("Alice", 12345);
        userPasswords.put("Bob", 54321);
    }

    @Override
    public int getPassword(String accountName) {
        return userPasswords.getOrDefault(accountName, -1);
    }

    public void addUser(String accountName, int password) {
        userPasswords.put(accountName, password);
    }

    public void removeUser(String accountName) {
        userPasswords.remove(accountName);
    }
}