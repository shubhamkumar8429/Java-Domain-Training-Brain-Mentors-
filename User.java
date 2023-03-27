public class User {
    private String name;
    private String password;
    private int loginCount;

    User() {
        this.name = "";
        this.password = "";
        loginCount = 0;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public void setName( String name ){
        this.name = name;
    }

    public int getLoginCount(){
        return this.loginCount;
    }

    public void setLoginCount( int loginCount ){
        this.loginCount = loginCount;
    }
}
