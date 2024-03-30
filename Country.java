public class Country {
    private String countryName;
    private String countryCode;
    private String continent;
    private Game game;
    private int uniqueId;
    //default constructor
    public Country() {
        countryCode = "";
        countryName = "";
        continent = "";
        game = null;
    }
    //normal constructor
    public Country(String countryC, String countryN, String cont) {
        countryCode = countryC;
        countryName = countryN;
        continent = cont;
        game = null;
    }
    public Country(String gameC, String gameN, String gameTyp, double gamePri, String countryC, String gameD) {
        game = new Game(gameC, gameN, gameTyp, gamePri, gameD);
        countryCode = countryC;
    }
     public Country(int Uid,String gameC, String gameN, String gameTyp, double gamePri, String countryC, String gameD) {
        game = new Game(gameC, gameN, gameTyp, gamePri, gameD);
        countryCode = countryC;
        uniqueId = Uid;
    }
    //getter
    public int getUnique()
    {return uniqueId;}
    public String getCountryCode() 
    {return countryCode;}
    public String getCountryName() 
    {return countryName;}
    public String getContinent() 
    {return continent;}
    public String getGameCode() 
    {return game.getGameC();}
    //setter
    public void setCountry(String countryC, String countryN, String cont) {
        countryCode = countryC;
        countryName = countryN;
        continent = cont;
    }
    public void setUnique(int ui)
    {uniqueId = ui;}
    //method to write in txt file
    public String toString()
    {return game.getGameC()+";"+game.getGameN()+";"+game.getGameTyp()+";"+game.getGamePri()+";"+countryCode+";"+game.getGameD();}
    //method to show list of games
    public void printReport() {
        if (game != null) {
            System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s",game.getGameC(), game.getGameN(), game.getGameTyp(), game.getGamePri(), countryCode, game.getGameD()));
        }
    }
    //method to show list of games with unique row number
    public void printReport2() {
        if (game != null) {
            System.out.println(String.format("|%-11s|%-11s|%-25s|%-11s|%-15s|%-25s|%-10s",uniqueId,game.getGameC(), game.getGameN(), game.getGameTyp(), game.getGamePri(), countryCode, game.getGameD()));
        }
    }
}