//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Iterator;
///**
// * Holds the list of literatures.
// * You are able to print out the list alphabeticaly or by price
// * You can search for literatures by  author name, surname and/or last name,
// * by literature title, partial title allowed, and by publisher.
// * Generic search searches within author, title and publisher. 
// * 
// * @author Kristoffer Rogne, Kay Sindre Lorgen & Asbjørn Frostad 
// * @version 0.2, 2016-03-04
// */
//public class LiteratureRegisterOLD
//{
//    private final ArrayList<Literature> literatureList;
//    /**
//     * Creates a list of the current literatures that re being sold.
//     */
//    public LiteratureRegisterOLD()
//    {
//        literatureList = new ArrayList<>();
//    }
//
//    /**
//     * Adds a new literature to the register.
//     * @param literatureToAdd The literature you want to add to the register.
//     */
//    public void addNewLiterature(Literature literatureToAdd)
//    {
//        literatureList.add(literatureToAdd);
//    }
//    /*
//    /**
//     * Prints out a list containing all literatures, complete with author name, title and price.
//
//    public void listAllLiteratures()
//    {
//    System.out.println();
//    if (literatureList.size() <= 0)
//    {
//    System.out.println("There is no literatures.");
//    }
//    for(Literature literature : literatureList)
//    {
//    System.out.println("Title: " + literature.getTitle() + ", Author: " 
//    + literature.getAuthor() + ". Price: " + literature.getPrice() + ",-");
//    }
//    }
//     */
//    /**
//     * Prints out the list of literatures, from cheapest to most expensive.
//     * @return 
//     */
//    public String listAllLiteraturesByPrice()
//    {
//        String a = null;
//        if (literatureList.size() <= 0)
//        {
//            a = "There is no literature.";
//        }
//        ArrayList<Double> literaturePriceList = new ArrayList<Double>();
//        for(Literature literature : literatureList)
//        {
//            literaturePriceList.add(literature.getPrice());
//        }
//        Collections.sort(literaturePriceList);
//        for(double price : literaturePriceList)
//        {
//            for(Literature literature: literatureList)
//            {
//                if(price == literature.getPrice())
//                {
//                    a = "Title: " + literature.getTitle() + ", Author: " 
//                    + literature.getAuthor() + ". Price: " + literature.getPrice() + ",-";
//                }
//            }
//        }
//        return a;
//    }
//
//    //     /**
//    //      * Prints out the list of literatures, alphabeticaly.
//    //      */
//    //     public void listAllLiteratures()
//    //     {
//    //         System.out.println();
//    //         if (literatureList.size() <= 0)
//    //         {
//    //             System.out.println("There is no literatures.");
//    //         }
//    //         ArrayList<String> sortedLiteratureList = new ArrayList<String>();
//    //         for(Literature literature : literatureList)
//    //         {
//    //             sortedLiteratureList.add(literature.getTitle());
//    //         }
//    //         Collections.sort(sortedLiteratureList);
//    //         for(String title : sortedLiteratureList)
//    //         {
//    //             for(Literature literature: literatureList)
//    //             {
//    //                 if(title.equals(literature.getTitle()))
//    //                 {
//    //                     System.out.println("Title: " + literature.getTitle() + ", Author: " 
//    //                         + literature.getAuthor() + ". Price: " + literature.getPrice() + ",-");
//    //                 }
//    //             }
//    //         }
//    //     }
//
//    /**
//     * Returns the list of literatures.
//     * @return the list of literatures.
//     */
//    public ArrayList<Literature> listAllLiteratures()
//    {
//        ArrayList<Literature> listToReturn = new ArrayList<Literature>();
//        for(Literature literature : literatureList)
//        {
//           listToReturn.add(literature);
//        }
//        return listToReturn;
//    }
//
//        /**
//     * Searches for the literature by title.
//     * @param title The title of the literature you want. 
//     */
//
//    public String searchByTitle(String title)
//    {
//        String literatureTitle = ("Matching literatures with the title " + title + ":");
//        Boolean found = false;
//        for(Literature literature : literatureList)
//        {
//            if(literature.getTitle().toLowerCase().contains(title.toLowerCase()))
//            {
//                literatureTitle += (" Title: " + literature.getTitle() + ", Author: " 
//                    + literature.getAuthor() + ", Price: " + literature.getPrice() + ",-");
//                found = true;
//            }
//        }
//        if (!found)
//        {
//            literatureTitle += ("No literatures found searching for " + title + ".");
//        }
//
//        return literatureTitle;
//    }
//
//    /**
//     * Searches for the author name.
//     * @param authorName The name of the author you want. 
//     */
//
//    public String searchAuthor(String authorName)
//    {
//
//        String a = ("Matching literatures from author " + authorName + ":");
//        Boolean found = false;
//        for(Literature literature : literatureList)
//        {
//            if(literature.getAuthor().toLowerCase().contains(authorName.toLowerCase()))
//            {
//                a += ("Title: " + literature.getTitle() + ", Author: " 
//                    + literature.getAuthor() + ". Price: " + literature.getPrice() + ",-");
//                found = true;
//            }
//        }
//        if (!found)
//        {
//            a += ("No literatures found searching for " + authorName + ".");
//        }
//
//        return a;
//    }
//
//    /**
//     * Searches for the publisher.
//     * @param publisher The name of the publisher you want.
//     */
//    public String searchPublisher(String publisher)
//    {
//        String a = ("Matching literatures from publisher " + publisher + ":");
//        Boolean found = false;
//        for(Literature literature : literatureList)
//        {
//            if(literature.getPublisher().toLowerCase().contains(publisher.toLowerCase()))
//            {
//                a += ("Title: " + literature.getTitle() + ", Author: " 
//                    + literature.getAuthor() + ". Price: " + literature.getPrice() + ",-");
//                found = true;
//            }
//        }
//        if (!found)
//        {
//            a += ("No literatures found searching for " + publisher + ".");
//        }
//
//        return a;
//    }
//
//    /**
//     * Generic search for literatures with title, publisher or author
//     * matching search word.
//     * @param search The word to search for.
//     */
//    public String genericSearch(String search)
//    {
//        String a = ("Matching literatures searching for " + search + ":");
//        Boolean found = false;
//        for(Literature literature : literatureList)
//        {
//            if(literature.getPublisher().toLowerCase().contains(search.toLowerCase()) || literature.getTitle().toLowerCase().contains(search.toLowerCase())
//            || literature.getAuthor().toLowerCase().contains(search.toLowerCase()))
//            {
//                a += ("Title: " + literature.getTitle() + ", Author: " 
//                    + literature.getAuthor() + ". Price: " + literature.getPrice() + ",-");
//                found = true;
//            }
//        }
//        if (!found)
//        {
//            a += ("No literatures found searching for " + search + ".");
//        }
//
//        return a;
//    }
//
//    /**
//     * Removes the literature from the list.
//     * @param literatureTitle The title of the literature you want to remove.
//     */
//    public String removeLiteratureFromList(String literatureTitle)
//    {
//        String removedLiteratureTitle = null;
//        Boolean removed = false;
//        Iterator<Literature> it = literatureList.iterator();
//        while(it.hasNext())
//        {
//            Literature literatureToRemove = it.next();
//            if(literatureToRemove.getTitle().equals(literatureTitle))
//            {
//                removedLiteratureTitle = ("Removed " + literatureToRemove.getTitle() + ", by " 
//                    + literatureToRemove.getAuthor() + " from our listings.");
//                removed = true;
//                it.remove();
//            }
//        }
//        if(!removed)
//        {
//            removedLiteratureTitle = ("There was no literature with the title of " + literatureTitle);
//        }
//
//        return removedLiteratureTitle;
//    }
//
//}
