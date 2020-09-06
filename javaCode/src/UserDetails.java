//this class ensures that only one user profile is created in an app

import java.util.ArrayList;

public class UserDetails {
    private static UserDetails instance=null;

    private String uName;
    private ArrayList<Product> uProduct;
    private AddLocation uLocation ;

    // for no product
    public static UserDetails getInstance(String name) {
        if (null == instance) {
            instance = new UserDetails(name);
            System.out.println("A new user is created");
        }
        return instance;
    }
    // for new user
    public UserDetails(String name) {
        System.out.println("This is a new registration.\n" +
                "You will be guided to the new-Registration page.\n" +
                "only If we had one ;)\n");
        setuName(name);
        uProduct = new ArrayList<>();
        setuProduct(uProduct);
        AddLocation uLocation ;
        setuLocation();
    }
    // for default product
    public UserDetails(String name, ArrayList<Product> uProduct) {
        uName = name;
        this.uProduct = uProduct;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuProduct(ArrayList<Product> uProduct) {
        this.uProduct = uProduct;
        System.out.println("This is a debug statement. product list is initialised here.");
    }

    public void setuLocation() {
        AddLocation uLocation = new AddLocation("latitude", "longitude");
        System.out.println("here yur latitude and longitude will be store\n" +
                "by default this will be the location for all your products");

        this.uLocation = uLocation;
    }

    public String getName() {
        return uName;
    }

    public ArrayList<Product> getProductList() {
        return uProduct;
    }
    public AddLocation getuLocation() {
        return uLocation;
    }
}
