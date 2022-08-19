package org.example;

public class Company {

    private String CompanyName;
    private String CompanyAddress;

    public Company(String companyName, String companyAddress) {
        CompanyName = companyName;
        CompanyAddress = companyAddress;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }
}
