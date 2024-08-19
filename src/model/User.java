package model;

/**
 * The {@code User} class represents an abstract model of a user in the system.
 * It holds common properties and behaviors that can be shared across different
 * types of users. This class is designed to be extended by more specific user types.
 * <p>
 * The {@code User} class manages a unique identifier generator, user name,
 * and a flag indicating whether the user is a foreigner.
 * </p>
 */

public abstract class User
{
    /**
     * The user's name.
     */
    private String userName;

    /**
     * A static field used to generate unique IDs for users.
     */
    protected static int idMaker = 2024;

    /**
     * Indicates whether the user is a foreigner.
     */
    private boolean amIForeigner;

    /**
     * Constructs a new {@code User} with the specified user name.
     * The ID maker is incremented by 10 for each new user.
     *
     * @param userName the name of the user.
     */
    protected User(String userName)
    {
        this.userName = userName;
        idMaker += 10;
    }

    /**
     * Returns the user's name.
     *
     * @return the user's name.
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Sets the user's name.
     *
     * @param userName the name to set for the user.
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * Returns the current value of the ID maker.
     *
     * @return the current value of the ID maker.
     */
    public int getIdMaker()
    {
        return idMaker;
    }

    /**
     * Returns whether the user is a foreigner.
     *
     * @return {@code true} if the user is a foreigner, {@code false} otherwise.
     */
    public boolean isAmIForeigner()
    {
        return amIForeigner;
    }

    /**
     * Sets the foreigner status of the user.
     *
     * @param amIForeigner {@code true} to set the user as a foreigner, {@code false} otherwise.
     */
    public void setAmIForeigner(boolean amIForeigner)
    {
        this.amIForeigner = amIForeigner;
    }

    /**
     * Generates the foreigner status based on the current value of {@code idMaker}.
     * If the ID maker is divisible by 3, the user is considered a foreigner.
     */
    private void generateUser()
    {
        this.amIForeigner = (this.getIdMaker() % 3) == 0;
    }

    /**
     * Returns the ID of the user. This method must be implemented by any subclass
     * to provide a unique ID for the user.
     *
     * @return the unique ID of the user.
     */
    public abstract String getID();
}
