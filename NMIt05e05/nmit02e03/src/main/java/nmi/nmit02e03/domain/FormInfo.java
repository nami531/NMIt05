package nmi.nmit02e03.domain;

import jakarta.annotation.sql.DataSourceDefinition;

public class FormInfo {
    private String name; 
    private String dni; 
    private String email; 
    private String address; 
    private ProductType productType; 
    private boolean conditionsAccepted;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public ProductType getProductType() {
        return productType;
    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    public boolean isConditionsAccepted() {
        return conditionsAccepted;
    }
    public void setConditionsAccepted(boolean conditionsAccepted) {
        this.conditionsAccepted = conditionsAccepted;
    }


    @Override
    public String toString() {
        return "FormInfo [name=" + name + ", dni=" + dni + ", email=" + email + ", address=" + address
                + ", productType=" + productType + ", conditionsAccepted=" + conditionsAccepted + "]";
    } 


}
