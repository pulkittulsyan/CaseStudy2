package bean;

public class ApplicationDetails {
	
	private int id;
	private String appid;
	private String appname;
	private String upstream;
	private String downstream;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getUpstream() {
		return upstream;
	}
	public void setUpstream(String upstream) {
		this.upstream = upstream;
	}
	public String getDownstream() {
		return downstream;
	}
	public void setDownstream(String downstream) {
		this.downstream = downstream;
	}
	public ApplicationDetails(int id, String appid, String appname, String upstream, String downstream) {
		super();
		this.id = id;
		this.appid = appid;
		this.appname = appname;
		this.upstream = upstream;
		this.downstream = downstream;
	}
	public ApplicationDetails() {
		super();
	}

}
