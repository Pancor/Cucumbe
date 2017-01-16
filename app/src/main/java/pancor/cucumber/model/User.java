package pancor.cucumber.model;


import java.io.Serializable;

public class User implements Serializable {

    private String mName, mAuthKey;

    public User(){

    }

    public User(String name, String authKey){

        mName = name;
        mAuthKey = authKey;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAuthKey() {
        return mAuthKey;
    }

    public void setmAuthKey(String mAuthKey) {
        this.mAuthKey = mAuthKey;
    }
}
