public class Game extends Country
{
   private String GameCode;
   private String GameName;
   private String GameType;
   private double GamePrice;
   private String GameDev;
   
   //default constructor
   public Game()
   {
    super();
    GameCode=" ";
    GameName=" ";
    GameType=" ";
    GamePrice=-1;
    GameDev=" ";  
   }
   //normal constructor
   public Game(String GameC,String GameN,String GameTyp,double GamePri,String GameD)
   {
    GameCode=GameC;
    GameName=GameN;
    GameType=GameTyp;
    GamePrice=GamePri;
    GameDev=GameD;  
   }
   //getter
   public String getGameC()
   {return GameCode;}
   public String getGameN()
   {return GameName;}
   public String getGameTyp()
   {return GameType;}
   public double getGamePri()
   {return GamePrice;}
   public String getGameD()
   {return GameDev;}
   //setter
   public void setGameC(String GameC)
   {GameCode = GameC;}
   public void setGameN(String GameN)
   {GameName = GameN;}
   public void setGameTyp(String GameTyp)
   {GameType = GameTyp;}
   public void setGamePri(double GamePri)
   {GamePrice = GamePri;}
   public void setGameD(String GameD)
   {GameDev = GameD;}
}
