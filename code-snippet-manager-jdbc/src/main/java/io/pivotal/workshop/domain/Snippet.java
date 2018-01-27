package io.pivotal.workshop.domain;

import java.util.Date;

public class Snippet {
	private String id;

	private String title;
	private String code;

	//Option 2. You can uncomment this as an alternative of the application.properties
	//@JsonFormat(pattern="yyyy-MM-dd")
	private Date created;

	//Option 2. You can uncomment this as an alternative of the application.properties
	//@JsonFormat(pattern="yyyy-MM-dd")
	private Date modified;

	public Snippet() {
		this.id = java.util.UUID.randomUUID().toString();
		this.created = new Date();
		this.modified = new Date();
	}

	public Snippet(String title, String code) {
		this.id = java.util.UUID.randomUUID().toString();
		this.title = title;
		this.code = code;
		this.created = new Date();
		this.modified = new Date();
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setId(String id) {
		this.id = id;

	}

	public String getId() {

		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	public Date getCreated() {
		return created;
	}

	public Date getModified() {
		return modified;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
}
