
package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;
import statistics.matcher.*;


public class QueryBuilder {
    
    Matcher query;
    
    public QueryBuilder() {
        query = new All();
        
    }
    
    public Matcher matcher() {
        return query;
    }
    
    public Matcher build() {
        Matcher m = query;
        query = new All();
        return m;
    }
    
    public QueryBuilder playsIn(String team) {
        query = new And(new PlaysIn(team), query);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int number, String type) {
        query = new And(new HasAtLeast(number, type), query);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int number, String type) {
        query = new And(new HasFewerThan(number, type), query);
        return this;
    }
    
}
