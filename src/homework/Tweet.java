package homework;

public class Tweet {

	private String text;
	private String is_quote_status;
	private User user;
	private String geo;
	private String[] hashtags;
	
	public String[] getHashtags(){
		return hashtags;
	}
	
	public setHashtags(String[] hashtags){
		this.hashtags=hashtags;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIs_quote_status() {
		return is_quote_status;
	}
	public void setIs_quote_status(String is_quote_status) {
		this.is_quote_status = is_quote_status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	
}
