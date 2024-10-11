package AndrewWebServices;

/**
 * RecSysStub is a stub implementation of the RecSys class for testing purposes.
 */
public class RecSysStub extends RecSys {
    @Override
    public String getRecommendation(String accountName) {
        switch (accountName) {
            case "Scotty":
                return "Animal House";
            case "Alice":
                return "Inception";
            case "Bob":
                return "The Matrix";
            default:
                return "Default Movie";
        }
    }
}
