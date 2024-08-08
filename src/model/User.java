package model;

public class User
{
    private String userName;
    private String idDocument;
    private String licenseNumber;

    User(String userName, String idDocument, String licenseNumber)
    {
        this.userName = userName;
        this.idDocument = idDocument;
        this.licenseNumber = licenseNumber;
    }
    public String getLicenseNumber()
    {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber)
    {
        this.licenseNumber = licenseNumber;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getIdDocument()
    {
        return idDocument;
    }

    public void setIdDocument(String idDocument)
    {
        this.idDocument = idDocument;
    }
}
