package forum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Topic {

	private String name;
	private String subject;
	private User creator;
	private Message m;
	
	private List<Message> messages = new ArrayList<Message> ();
	
    public Topic(String name, String subject, User creator) {
		this.name=name;
		this.subject=subject;
		this.creator=creator;
	}
    
	public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public User getUser(){
        return creator;
    }
    
    public Message submitMessage(User user, String title, String body){
        m = new Message(user,title,body,this);
        messages.add(m);
    	return m;
    }
    
    public Collection<Message> getMessagges(){
        return messages;
    }
    
    public long numMessages(){
    	long count = 0;
    	for(Message i: messages){
    		if(i.getTopic().name.equals(this.name)){
    			count++;
    		}
    	}
        return count;
    }
}
