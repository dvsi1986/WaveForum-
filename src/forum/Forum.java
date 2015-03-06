package forum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Forum {
    private String url;
    private User u;
    
    private List<User> users = new ArrayList<>();
    
    private Topic t; 
    private List<Topic> topics = new ArrayList<>();
    public Forum(String url){
    		this.url=url;
    }
    
    public Forum() {
	}

	public String getUrl(){
        return url;
    }

    public User registerUser(String nick, String first, String last, String email, String password)
        throws DuplicateNickname {
    	u = new User(nick,first,last,email,password);
    	for(Iterator<User> i = users.iterator();i.hasNext();){
    		User u1 = i.next();
    		if(u.compareTo(u1)==0){
    			throw new DuplicateNickname();
    		}
    	}
    	users.add(u);
        return u;
    }
    
    public User login(String nick, String password){
        User user = null;
        for(User u:users){
        	if(u.getNick().equals(nick)&& u.getPassword().equals(password)){
        		user = u;
        	}
        }
    	return user;
    }
    
    public Topic createTopic(String name, String subject, User creator){
        t = new Topic(name,subject,creator);
    	topics.add(t);
        return t;
    }
    
    public Collection<Topic> listTopic(){
        return topics;
    }
    
    public List<User> rankUsers(){
        Collections.sort(users);
        Collections.reverse(users);
    	return users;
    }
    
    public double averageMessages(){
       double result = 0;
  
       double total_m = 0;
       
       for(Topic i:topics){
    	   total_m+=i.getMessagges().size();
    	  
       }
       result = total_m/topics.size();
    	return result;
    }
    
}
