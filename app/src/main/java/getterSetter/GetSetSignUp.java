package getterSetter;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class GetSetSignUp
{
    public String getEdtusername() {
        return edtusername;
    }

    public void setEdtusername(String edtusername) {
        this.edtusername = edtusername;
    }

    public String getEdtupassword() {
        return edtupassword;
    }

    public void setEdtupassword(String edtupassword) {
        this.edtupassword = edtupassword;
    }

    public String getEdtfullname() {
        return edtfullname;
    }

    public void setEdtfullname(String edtfullname) {
        this.edtfullname = edtfullname;
    }

    public String getEdtphonenumber() {
        return edtphonenumber;
    }

    public void setEdtphonenumber(String edtphonenumber) {
        this.edtphonenumber = edtphonenumber;
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    String edtusername, edtupassword, edtfullname, edtphonenumber,farmer, customer;
}
