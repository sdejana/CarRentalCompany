package model;

public class ForeignUser extends User
{
    private final String passportNumber;

    public ForeignUser(String userName, String passportNumber)
    {
        super(userName);
        this.passportNumber = passportNumber;
    }

    public ForeignUser(String userName)
    {
        super(userName);

        this.passportNumber = idMaker();
    }

    private String idMaker()
    {
        return "F/" + User.idMaker + "/U";
    }
    public String getID()
    {
        return this.passportNumber;
    }

    public void print()
    {
        System.out.println(this.passportNumber+ " foreign ");
    }
}
