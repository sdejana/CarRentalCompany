package model;

public abstract class User
{
    private String userName;
    protected static int idMaker = 2024;

    protected User(String userName)
    {
        this.userName = userName;
        this.idMaker += 10;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public abstract String getID();
}
