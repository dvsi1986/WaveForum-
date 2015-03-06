package forum;

public class User implements Comparable<User> {

    private String nick;
    private String first;
    private String last;
    private String email;
    private String password;
    private Topic t;
    public User(String nick, String first, String last, String email,
			String password) {
		this.nick=nick;
		this.first=first;
		this.last=last;
		this.email=email;
		this.password=password;
		 t= new Topic(null,null,this);
	}

	public String getNick(){
        return nick;
    }

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public String getEmail(){
        return email;
    }
    
    public Topic getT() {
		return t;
	}

	public String getPassword() {
		return password;
	}

	public long numSubmitted(){
        long count = 0;
        for(Message m: t.getMessagges()){
        	if(m.getUser().equals(this)){
        		count++;
        	}
        }
		return count;
    }

    public int compareTo(User arg0) {
    	
        return Integer.compare(this.hashCode(),arg0.hashCode() );
    }
}
