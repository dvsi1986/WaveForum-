package forum;

public class Message {

	private User user;
	private String title;
	private String body;
	
//	private Forum f;
	private Topic t; 
    public Message(User user, String title, String body, Topic to) {
		this.user=user;
		this.title = title;
		this.body = body;
		
		t = to;
	
//		f = new Forum();
	}

	public String getTitle(){
        return title;
    }
    
    public String getBody(){
        return body;
    }
    
    public User getUser(){
        return user;
    }
    
    public Topic getTopic(){ 
    	return t;
    }
    
    public long getTimestamp(){
        return System.currentTimeMillis();
    }
}
