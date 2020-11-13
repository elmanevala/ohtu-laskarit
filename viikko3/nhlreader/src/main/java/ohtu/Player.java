
package ohtu;

public class Player implements Comparable <Player>{
    private String name;
    private String team;
    private int assists;
    private int goals;
    private String nationality;

    public void setNationality(String nationality){
        this.nationality=nationality;
    }
    
    public String getNationality(){
       return nationality;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setGoals(int goals){
        this.goals=goals;
    }
    public int getGoals() {
        return goals;
    }
    
    public void setAssists(int assists){
        this.assists=assists;
    }
    public int getAssists() {
        return assists;
    }
    public void setTeam(String team){
        this.team = team;
    }
    public String getTeam() {
        return team;
    }
    
    public int getPoints(){
        return this.assists+ this.goals;
    }

    @Override
    public String toString() {
        return name + ", " + team + ": " + this.assists + " + " + this.goals + " = " + this.getPoints();
    }
    
    @Override
    public int compareTo(Player player){
        return player.getPoints()-this.getPoints();
    }
      
}
