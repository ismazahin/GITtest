//Header
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;

//class Application
public class PlatformAdmiApp
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System. out. print('\u000C');
        //call method Login()
        Login();
        //initialize boolean variable for looping
        boolean cc = false;
        boolean exit = true;
        //Program will Loop if Country Code is Invalid
        while(cc!=true){
            //interface
            System. out. print('\u000C');
            System.out.print("\t");
            for(int i=0;i<60;i++){
                System.out.print("*");
            }
            System.out.println("\n\t*\t\tStarX Platform\t\t   *\t");
            System.out.print("\t");
            for(int i=0;i<60;i++){
                System.out.print("*");
            }
            //Display List of country code
            Table();
            
            System.out.print("\n\tEnter Country Code : ");
            String CC = sc.next();
            
            while(exit!=false) {
                //if user enter Malaysia Code
                if(CC.equalsIgnoreCase("MAL161")) {
                    System.out.print('\u000C');
                    //set the MCODE value
                    String MCODE = "Malaysia";
                    RegisterCountryLL(MCODE);
                    cc = true;
                //if user enter Uk Code
                } else if(CC.equalsIgnoreCase("UK616")) {
                    System.out.print('\u000C');
                    //set the MCODE value
                    String MCODE = "United Kingdom";
                    RegisterCountryLL(MCODE);
                    cc = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Country Code Not Found");
                    cc = false;
                    break;
                }
            
              //Ask user to return main menu or not
              System.out.print("\nDo you want to return to the main menu? (Y = Yes/Any Button = Exit): ");
              String returnToMainMenu = sc.next();
                if (!returnToMainMenu.equalsIgnoreCase("Y")) {
                    exit = false;
                }
            }
        } 
    }
    
    //methods if user want to run with Linked List
    public static void RegisterCountryLL(String MCODE)
    {
         System.out.print("\t");
         for(int i=0;i<60;i++){
            System.out.print("*");
         }
         System.out.println("\n\t*\t\t"+MCODE+" Game Platform\t\t   *\t");
         System.out.print("\t");
         for(int i=0;i<60;i++){
            System.out.print("*");
         }
         System.out.println("\n");
         
         //initialize Object
         Country Cntry = new Country();
         Country Contry = new Country();
         //initialize Linked List
         LinkList CountryG = new LinkList();
         LinkList GameList = new LinkList();
         //free game Linked List
         LinkList GameList1 = new LinkList();
         //paid game Linked List
         LinkList GameList2 = new LinkList();
         
         //initialize counter
         int countAl=0;
         int countFree=0;
         int countPaid=0;
         
        try {
            //initialize filename for scan
            String fileName = "";
            if(MCODE=="Malaysia")
            {
                fileName="MalaysiaList.txt";
            }
            else if(MCODE == "United Kingdom")
            {
              fileName="UKList.txt";
            }
            //File Input
            File file = new File(fileName);
            Scanner scanFile = new Scanner(file);
            StringTokenizer st = null;
            
            //scan file based on the filename
            while (scanFile.hasNext()) {
                String indata = scanFile.nextLine();
                st = new StringTokenizer(indata, ";");
    
                String GameCode = st.nextToken();
                String GameName = st.nextToken();
                String GameType = st.nextToken(); 
                double GamePrice = Double.parseDouble(st.nextToken());
                String CountryC = st.nextToken();
                String GameDev = st.nextToken();
                
                //normal constructor
                Cntry = new Country(GameCode, GameName, GameType, GamePrice, CountryC, GameDev);
                //insert to linked list without any arrangement
                GameList.insertAtFront(Cntry);
                
                //counter to detect number of games registered
                countAl++;
                
                //normal constructor with counter to show row number in game list
                Contry = new Country(countAl,GameCode, GameName, GameType, GamePrice, CountryC, GameDev);
                CountryG.insertAtBack(Contry);
                
                
                // Inserting games into the LinkList based on conditions
                if (Cntry.getGameCode().startsWith("F")) {
                    GameList1.insertAtFront(Cntry);
                    countFree++;
                } else if (Cntry.getGameCode().startsWith("P")) {
                    GameList2.insertAtBack(Cntry);
                    countPaid++;
                }
    
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not Found");
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Problem IO");
        }

        int counter=0;
        Scanner scanmenu = new Scanner(System.in);
        //Main Menu
        System.out.print("\t********** Menu **********");
        System.out.print("\n\t[1] Show List Of Games\n\t[2] Total Game Registered\n\t[3] Modify Game Data");
        System.out.print("\n\n\tEnter Menu Number : ");
        int ans = scanmenu.nextInt();
        
        //if user wants a list of games shown
        if(ans==1)
        {
                //Free games List
                System.out.println("\n\t**********Free Games**********");
                System.out.println("\nTotal Free Game Registered : " + countFree);
                System.out.println(String.format("\n|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s","Game Code","Game Name","Type","Price","Country Code","Developer"));
                System.out.println("=========================================================================================================");
                 
                Object Gdata = GameList1.getFirst();
                while (Gdata != null) {
                    Country M = (Country) Gdata;
                    //Call Display Method from class Country
                    M.printReport();
                    Gdata = GameList1.getNext();
                }
                
                //Paid games list
                System.out.println("=========================================================================================================");
                System.out.println("\n\t**********Paid Games**********");
                System.out.println("\nTotal Paid Game Registered : " + countPaid);
                System.out.println(String.format("\n|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s","Game Code","Game Name","Type","Price","Country Code","Developer"));
                System.out.println("=========================================================================================================");
                 
                Object Gdata2 = GameList2.getFirst();
                while (Gdata2 != null) {
                    Country M = (Country) Gdata2;
                    //Call Display Method from class Country
                    M.printReport();
                    Gdata2 = GameList2.getNext();
                }
                
                //Error message if file is empty
                if(GameList.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"No games has been registered");
                }
                
        }
        //if user want to know total game registered
        else if(ans==2)
        {
            Object GCount = GameList.getFirst();
            while (GCount != null) {
                    GCount = GameList.getNext();
                    counter++;
                }
            if(GameList.isEmpty())
            {
                //if file is Empty
                System.out.println("=========================================================================================================");
                System.out.println("\t\t\tNo Game has been registered");
                System.out.println("\t\t\tTotal Game Registered is : "+counter);
                System.out.println("=========================================================================================================");
            }
            else{
                //If file has data
                System.out.println("=========================================================================================================");
                System.out.println("\t\t\tTotal Game Registered is : "+counter);
                System.out.println("=========================================================================================================");
            }
        }
        //if user want to modify game list
        else if(ans==3)
        {
            System.out.print("\n\t[1] Remove All Game\n\t[2] Remove Selected Games\n\t[3] Register Games\n\t[4] Update Games\n\tEnter Update Menu Number : ");
            int ans3 = scanmenu.nextInt();
            //option to remove all games in the list
            if(ans3==1)
            {
                String RemG=JOptionPane.showInputDialog(null,"Clear All?(Yes/No)");
                //if user want to delete all games
                if(RemG.equalsIgnoreCase("Yes"))
                {
                    try {
                            String fileName = "";
                            if(MCODE=="Malaysia")
                            {
                                fileName="MalaysiaList.txt";
                            }
                            else if(MCODE == "United Kingdom")
                            {
                              fileName="UKList.txt";
                            }
                            //create new file will causes it to overwrite data
                            FileWriter fw = new FileWriter(fileName);
                            fw.close();
                            JOptionPane.showMessageDialog(null, "File cleared successfully");
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "Problem clearing the file: " + e.getMessage());
                        }
                }
            }
            //option to remove selected games
             else if(ans3==2)
            {
                System.out.println("\n=========================================================================================================");
                System.out.println("\n\t**********"+MCODE+" Games List**********");
                System.out.println(String.format("\n|%-11s|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s","No","Game Code","Game Name","Type","Price","Country Code","Developer"));
                System.out.println("=========================================================================================================");
                int countdel=0;
                //traversal through linked list to display data before delete with count row
                Object GSelRem = CountryG.getFirst();
                while (GSelRem != null) {
                    Country Grem = (Country) GSelRem;
                    Grem.printReport2();
                    GSelRem = CountryG.getNext();
                    countdel++;
                }
                System.out.println("=========================================================================================================");
                System.out.println("\nTotal Game List  : "+ countdel);
                
                //User have to enter which game row to delete
                System.out.print("\n\tEnter No Games that you want to remove : ");
                int ansNoG = scanmenu.nextInt();
                System.out.print("\n\t");
                ansNoG--;
                
                //remove games based on row number
                CountryG.removeFromFront(ansNoG);
                if(ansNoG > 0 && ansNoG <= countdel)
                {
                    JOptionPane.showMessageDialog(null, "Game Removed Successfully");
                }
                countdel=0;
                //write the updated game list in the txt file
                try
                {
                     String fileName = "";
                     if(MCODE=="Malaysia")
                        {
                        fileName="MalaysiaList.txt";
                        }
                     else if(MCODE == "United Kingdom")
                        {
                        fileName="UKList.txt";
                        }
                     //Print updated game list into txt file
                     FileWriter fw = new FileWriter(fileName);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw);
                     Object GSelRem2 = CountryG.getFirst();
                      while (GSelRem2 != null) {
                        Country Grem2 = (Country) GSelRem2;
                        GSelRem2 = CountryG.getNext();
                        pw.println(Grem2.toString());
                   
                    }
                   
                   pw.close();
                   }//end try
                catch(FileNotFoundException fnf)
                {System.out.print(fnf.getMessage());}
                        
                catch(EOFException eof)
                {System.out.print(eof.getMessage());}
                        
                catch(IOException io)
                {System.out.print(io.getMessage());}
                        
                finally
                { }
                
                System.out.println("\n\t**********New " +MCODE+" Games List**********");
                System.out.println(String.format("\n|%-11s|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s","No","Game Code","Game Name","Type","Price","Country Code","Developer"));
                System.out.println("=========================================================================================================");
                
                Object GSelRem1 = CountryG.getFirst();
                while (GSelRem1 != null) {
                    Country Grem1 = (Country) GSelRem1;
                    Grem1.printReport2();
                    GSelRem1 = CountryG.getNext();
                    countdel++;
                }
        
                System.out.println("\nTotal Game List  : "+ countdel);
            }
            //register games
            else if(ans3==3)     
            {
                System.out.print("\n\tEnter Game Category (Free/Paid) : ");
                String anscat= scanmenu.next();
                Country RegisterGame = new Country();
                try
                {
                     Scanner Scr=new Scanner(System.in);
                     //declare which file txt to use
                     String fileName = "";
                     if(MCODE=="Malaysia")
                        {
                        fileName="MalaysiaList.txt";
                        }
                     else if(MCODE == "United Kingdom")
                        {
                        fileName="UKList.txt";
                        }
                    //create file output with condition of not to overwrite but just to add
                     FileWriter fw = new FileWriter(fileName,true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw);
                     System.out.print("\n\tEnter How Many Games to Register : ");
                     int RegisN = scanmenu.nextInt();
                     double GamePrice = 0;
                     double GamePr = 0;
                     String GameC;
                     String GameC2 = "";
                     String GameCode;
                     
                     //user registers new game
                      for(int i=0;i<RegisN;i++)
                      {
                       int total=i+1;
                        GameC = JOptionPane.showInputDialog("Enter Game Code(Insert 3 number) : ");
                        if(anscat.equalsIgnoreCase("Paid"))
                         {
                          //Paid game code will started with P
                          GameC2 = "P" + GameC;
                          String GameP = JOptionPane.showInputDialog("Enter Game Price : ");
                          GamePr = Double.parseDouble(GameP);
                         }
                        else if(anscat.equalsIgnoreCase("Free"))
                         {
                          //Free game code will started with F
                          GameC2 = "F" + GameC;
                          GamePr = 0;
                         }
                        GameCode = GameC2;
                        GamePrice = GamePr;
                        String GameName = JOptionPane.showInputDialog("Enter Game Name : ");
                        String GameType = JOptionPane.showInputDialog("Enter Game Type (FPS/RPG/Simulator) : ");
                        String CountryCode = null;
                        if(MCODE=="Malaysia")
                         {
                            CountryCode = "Mal161";
                         }
                         else if(MCODE == "United Kingdom")
                         {
                            CountryCode = "UK616";
                         }
                         String CountryC = CountryCode;;
                        String GameDev = JOptionPane.showInputDialog("Enter Game Developer : ");
                                
                          RegisterGame = new Country(GameCode, GameName, GameType, GamePrice, CountryC, GameDev);
                          CountryG.insertAtFront(RegisterGame);
                          //write to file
                          pw.println(RegisterGame.toString());
                       
                        System.out.println("\n~~~~~Game "+total+" Registered~~~~~");
                          }
                       
                   JOptionPane.showMessageDialog(null, "Your data have been saved into text file");
                   pw.close();
                   }//end try
                    catch(FileNotFoundException fnf)
                        {System.out.println(fnf.getMessage());}
                    
                    catch(EOFException eof)
                    {System.out.println(eof.getMessage());}
                            
                    catch(IOException io)
                    {System.out.println(io.getMessage());}
                            
                    finally
                    {}    
            }
            //user update selected game list
             else if(ans3==4)
             {
                System.out.println("\n=========================================================================================================");
                System.out.println("\n\t**********Update "+MCODE+" Games List**********");
                System.out.println(String.format("\n|%-11s|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s","No","Game Code","Game Name","Type","Price","Country Code","Developer"));
                System.out.println("=========================================================================================================");
                //To declare the linklist for display latest update
                LinkList GUp = new LinkList();
                //traverse through linked list to display list of games with row numbers
                Object GSelRem = CountryG.getFirst();
                while (GSelRem != null) {
                    Country Grem = (Country) GSelRem;
                    Grem.printReport2();
                    GSelRem = CountryG.getNext();
                    counter++;
                }
                System.out.println("=========================================================================================================");
                System.out.print("\n\tEnter No Games that want to be update : ");
                int ansNoG = scanmenu.nextInt();
                ansNoG--;
                //Delete the game row that user want to update
                CountryG.removeFromFront(ansNoG);
                
                System.out.print("\n\tEnter Game Category (Free/Paid) : ");
                String anscat2= scanmenu.next();
                Country UpdateGame = new Country();
                
                double GamePrice = 0;
                     double GamePr = 0;
                     String GameC;
                     String GameC2 = "";
                     String GameCode;                
                
                        GameC = JOptionPane.showInputDialog("Enter Game Code(Insert 3 number) : ");
                        if(anscat2.equalsIgnoreCase("Paid"))
                         {
                          GameC2 = "P" + GameC;
                          String GameP = JOptionPane.showInputDialog("Enter Game Price : ");
                          GamePr = Double.parseDouble(GameP);
                         }
                        else if(anscat2.equalsIgnoreCase("Free"))
                         {
                          GameC2 = "F" + GameC;
                          GamePr = 0;
                         }
                        GameCode = GameC2;
                        GamePrice = GamePr;
                        String GameName = JOptionPane.showInputDialog("Enter Game Name : ");
                        String GameType = JOptionPane.showInputDialog("Enter Game Type (FPS/RPG/Simulator) : ");
                        String CountryCode = null;
                        if(MCODE=="Malaysia")
                         {
                            CountryCode = "Mal161";
                         }
                         else if(MCODE == "United Kingdom")
                         {
                            CountryCode = "UK616";
                         }
                         String CountryC = CountryCode;
                        String GameDev = JOptionPane.showInputDialog("Enter Game Developer : ");
                                
                        UpdateGame = new Country(GameCode, GameName, GameType, GamePrice, CountryC, GameDev);
                        //Insert new updated game inside the linked list
                        CountryG.insertAtFront(UpdateGame);
                        GUp.insertAtFront(UpdateGame);
                        
      
                JOptionPane.showMessageDialog(null, "Game updated successfully");
                //write the new updated game list into txt file
                try
                {
                     System.out.println("\n\t**********New "+MCODE+" Games List**********");
                     System.out.println(String.format("\n|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s","Game Code","Game Name","Type","Price","Country Code","Developer"));
                     System.out.println("=========================================================================================================");
                     String fileName = "";
                     if(MCODE=="Malaysia")
                     {
                        fileName="MalaysiaList.txt";
                     }
                     else if(MCODE == "United Kingdom")
                     {
                        fileName="UKList.txt";
                     }
                     FileWriter fw = new FileWriter(fileName);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw);
                     //traverse through linked list to print new updated data to txt file
                     Object GSelRem2 = CountryG.getFirst();
                      while (GSelRem2 != null) {
                        Country Grem2 = (Country) GSelRem2;
                        GSelRem2 = CountryG.getNext();
                        pw.println(Grem2.toString());
                    }
                   pw.close();
                   }//end try
                catch(FileNotFoundException fnf)
                {System.out.println(fnf.getMessage());}
                        
                catch(EOFException eof)
                {System.out.println(eof.getMessage());}
                        
                catch(IOException io)
                {System.out.println(io.getMessage());}
                        
                finally
                {}
                //Display the updated game changes
                Object GSelRem1 = GUp.getFirst();
                Country Grem1 = (Country) GSelRem1;
                Grem1.printReport();
    
                } 
             }
        } 
    
            
        
    //table to show lists of country
    public static void Table()
    {
        JFrame frame = new JFrame();
     
          String[] columnNames = {"Country Name", "Country Code", "Continent"};
     
          Object[][] data = {
           {"Country Name", "Country Code", "Continent"},
           {"Malaysia", "MAL161", "Asean"},
           {"United Kingdom", "UK616", "Europe"},
       };
        JTable table = new JTable(data, columnNames);
     
       frame.add(table);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400,400);
       frame.setLocationRelativeTo(null);  
       frame.setVisible(true);
    }
    
    //Login method for Admin of the platform
     public static void Login() {
        //declare ArrayList
        ArrayList<PlatformAdmi> adminList = new ArrayList<>();
        try {
            //initialize file
            FileReader reader = new FileReader("Admin.txt");
            BufferedReader in = new BufferedReader(reader);
            String data;
            //scan file
            while ((data = in.readLine()) != null) {
                StringTokenizer input = new StringTokenizer(data, ";");
                int id = Integer.parseInt(input.nextToken());
                String password = input.nextToken();
    
                PlatformAdmi admin = new PlatformAdmi(id, password);
                adminList.add(admin);
            }
    
            in.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not Found");
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Problem IO");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Invalid input. Please enter a valid ID number.");
        }

        boolean loginSuccess = false;
        Scanner scn = new Scanner(System.in);
        //while loginSuccess = false,program will keep looping
        while (!loginSuccess) {
            System.out.println("\t*******************************");
            System.out.println("\t*\t   StarX Platform\t   *");
            System.out.println("\t*******************************");
    
            System.out.print("\t* Please Enter ID (Number) : ");
            int id = scn.nextInt();
    
            System.out.print("\t* Enter Password : ");
            String pass = scn.next();
    
            //Compare data from arrayList
            for (int i = 0; i < adminList.size(); i++) {
                PlatformAdmi admin = adminList.get(i);
                //Compare id by calling getter method from Class Country
                if (id == admin.getID() && pass.equals(admin.getPass())) {
                    JOptionPane.showMessageDialog(null, "Successful!");
                    //set loginSuccess to true,to break from the loop
                    loginSuccess = true;
                    break;
                }
            }

            //If login iss not success,keep looping
            if (!loginSuccess) {
                JOptionPane.showMessageDialog(null, "Invalid ID or Password!");
                System.out.println("\t*******************************");
                 System. out. print('\u000C');
            }
        }
    }
    }