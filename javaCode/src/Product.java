import java.util.ArrayList;
import java.util.Date;

enum TradeOp{
    tradeIn, tradeOut, buy, sell
}

public class Product {

    private String pName;
    private int id;
    private TradeOp tradeChoice;
    private boolean statusBIt ; //open or close; ensures the item is still available for exchange.
    private Date date1 = new Date();
    private ArrayList<AddImage> pImages;
    private AddLocation pLoction;
    private AddLocation loc00;
    private AddLocation loc01;
    private AddLocation loc10;
    private AddLocation loc11;

    // for trade out
    public Product(String pName, int id, TradeOp tradeChoice ,
                   ArrayList<AddImage> pImages, AddLocation location) {
        this.pName = pName;
        this.id = id;
        this.tradeChoice = tradeChoice;
        this.pImages = pImages;
        statusBIt = true;
        this.pLoction = location;
    }
    // for trade in
    public Product(String pName, int id, TradeOp tradeChoice,int distance){
        this.pName = pName;
        this.id = id;
        this.tradeChoice = tradeChoice;
        statusBIt = true;
        // make a method to initialise wrt to distance parameter
        loc00.setLatitude("infinite");
        loc00.setLongitude("infinite");
        loc01.setLatitude("infinite");
        loc01.setLongitude("infinite");
        loc10.setLatitude("infinite");
        loc10.setLongitude("infinite");
        loc11.setLatitude("infinite");
        loc11.setLongitude("infinite");

    }
    public String getpName() {
        return pName;
    }

    public TradeOp getTradeChoice() {
        return tradeChoice;
    }

    public ArrayList<AddImage> getpImages() {
        return pImages;
    }

    public void printProductDetails() {
        System.out.println("the product name is:"+ pName +"\n");
        System.out.println("this product is listed for:"+tradeChoice+"\n");
        System.out.println("there are"+pImages.size()+"images stored so far\n");
        // display all imges
        for (AddImage count: pImages ) {
            System.out.println(count.getFileURL());
        }
    }
}
