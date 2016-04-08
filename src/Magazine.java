
/**
 * Holds the title, number of pages, the cost, 
 * issue number and the published date of a magazine
 *
 * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
 * @version 0.4, 2016-04-08
 */
 public class Magazine extends Literature 
{
private final int issue;
private final String datePublished;
        
/** 
 * Creates a new magazine with the given title, number of pages, 
 * the publish date, which issue the magazine is, 
 * the cost of the magazine and the name of the publisher.
 * @param issue Which issue the magazine is.
 * @param datePublished Publish date of the magazine.
 * @param title title of the magazine.
 * @param price price of the magazine.
 * @param publisher the publisher of the magazine.
 * @param numberOfPages the number of pages in the magazine.
*/
   public Magazine(String title, double price, String publisher, int numberOfPages, 
           int issue, String datePublished)
   {
     super(title, price, publisher, numberOfPages);
     this.issue = issue;
     this.datePublished = datePublished;
   }
   
   /**
    * Returns the issue number.
    * @return the issue number as an int.
    */
   public int issue()
   {
       return issue;
   }
   
   /**
    * Return the publish date of the magazine.
    * @return the publish year of the magazine as a String
    */
   public String datePublished()
   {
       return datePublished;
   }
   /**
    * 
    * @return 
    */
@Override
   public String getInfo()
   {
      MagazineView view = new MagazineView();
        String infoString = view.getInfo(this);
        return infoString;
   }
   /**
    * 
    * @return 
    */
@Override
   public String getDetails()
    {
        MagazineView view = new MagazineView();
        String infoString = view.getDetails(this);
        return infoString;
    }
}
