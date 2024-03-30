public class PlatformAdmi
{
   private int ID;
   private String password;
   //default constructor
   public PlatformAdmi()
   {
       ID = 0;
       password = null;
   }
   //normal constructor
   public PlatformAdmi(int id,String pass)
   {
      ID=id;
      password=pass;
   }
   //setter
   public void setPlatformAdmi(int id,String pass)
   {
      ID=id;
      password=pass;
   }
   //getter
   public int getID()
   {return ID;}
      public String getPass()
   {return password;}
}
