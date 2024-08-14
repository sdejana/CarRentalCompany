package model;

public class DomesticUser extends User
{
    private String ID;
    private String licenceNumber;

    public DomesticUser(String userName, String id, String licenceNumber)
    {
        super(userName);
        this.ID = id;
        this.licenceNumber = licenceNumber;
    }
    public DomesticUser(String userName)
    {
        super(userName);

        this.ID = idMaker();
        this.licenceNumber = licenceNumberMaker();
    }

    private String idMaker()
    {
        return "D/" + User.idMaker + "/U";
    }
    private String licenceNumberMaker()
    {
        return "LN/" + User.idMaker + "/" + "BIH";
    }
    @Override
    public  String getID()
    {
        return this.ID;
    }
    public void print()
    {
        System.out.println(this.ID+ " domestic "+ this.licenceNumber);
    }
}
