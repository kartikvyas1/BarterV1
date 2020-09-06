import java.util.ArrayList;
import java.util.Scanner;

public class JavaCode {

    private static Scanner scan1;

    public static void main(String[] args) {

        welcome();
        firstPage();

    }

    public static void welcome(){
        System.out.println("\t\t\tWelcome to Barter Simulation.\n" +
                "We are currently running the Beta version.\n" +
                "the app icon will be displayed here.\n" +
                "and then we will directly go to app functions.\n" +
                "\t\t1.\tif this is the first installation, the registration page will pop up.\n" +
                "\t\t2.\tElse the user profile will be displayed.\n" +
                "Your location will be saved with each product you list so please grant access to Location API\n");
    }

    public static void firstPage() {
        scan1 = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String user1 = scan1.nextLine();
        UserDetails initUser = UserDetails.getInstance(user1);
        System.out.println("****************************\n" +
                "Hopefully  the login/registration should be done at this point.");
        performOp(initUser);

    }

    private static void performOp(UserDetails user1) {
        System.out.println("\n\nWhat would you like to do with this app:\n" +
                "\t1.List your Product for exchange or selling.\n" +
                "\t2.View your profile.\n" +
                "\t3.View products for buying.\n");
        int choice1 = scan1.nextInt();

        switch (choice1){
            case 1:
                Product p1 = addNewProduct(user1);
                ArrayList<Product> pList = user1.getProductList();
                boolean add = pList.add(p1);
                if (add) System.out.println("product added successfully");
                else System.out.println("ERROR adding product");
                performOp(user1);
                break;

            case 2:
                viewSelfProfile(user1);
                performOp(user1);
                break;
            case 3:
                viewProducts();
                performOp(user1);
                break;
        }
    }

    private static void viewProducts() {
        // this needs to be implemented
        System.out.println("Enter the distance you are willing to go to exchange your product:");
        int distance = scan1.nextInt();
        // using this distance + user location, we will vary the loc00, loc01, loc10, loc11
        // for each product for each product ad decide whether it will be diplayed or not.
        // this is not yet complete.
    }

    private static void viewSelfProfile(UserDetails user1) {
        System.out.println("this page will display users profile\n");
        System.out.println("user name:" + user1.getName()+ "\n");
        System.out.println("Located at (this will be the default for all apps):"+user1.getuLocation()+"\n");
        for (Product count: user1.getProductList()){
            count.printProductDetails();
        }

    }

    private static Product addNewProduct(UserDetails user1) {
        System.out.println("We will be adding a new Product to list.\n" +
                "You are requested to enter a few fields first.\n" +
                "\t1.Name your Product:");
        String pname1 = scan1.nextLine();
        System.out.println("Enter your choice for the product i.e.\n" +
                "\t1.For exchange\n\t2.For selling");
        ArrayList<AddImage> imageList = addImage();
        AddLocation plocation = user1.getuLocation();
        Product p1 = new Product(pname1,1, TradeOp.tradeOut , imageList, plocation);
        return p1;
    }

    private static ArrayList<AddImage> addImage() {
        boolean choice1 = false;
        ArrayList<AddImage> imageList = new ArrayList<>() ;
        do {
            System.out.println("Enter file location, (later a drop down window will be implemented here):\n");
            String imagename = "tradeOut_pid_imageCount";
            String fileURL = scan1.nextLine();
            AddImage addimage1 = new AddImage(imagename, fileURL);
            imageList.add(addimage1);
            System.out.println("do you want to add more images, (TRUE or FALSE):\n");
            choice1 = scan1.nextBoolean();
        }
        while (choice1);
        return imageList;
    }
}
