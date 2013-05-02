package org.noip2.noskamaru.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="documents")
public class Document {
	
	@Id
	@GeneratedValue
	@Column(name="doc_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="filename",unique=true)
	private String filename;
	
	@Column(name="content")
	@Lob
	private Blob content;
	
	@Column(name="content_type")
    private String contentType;
     
    @Column(name="created")
    private Date created;
    
    @Column(name="status")
    private int status;
    
    
    @Column(name="priority")
    private int priority;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.doc", cascade = CascadeType.ALL)
	private Set<DocUser> docUserSet = new HashSet<DocUser>(0);
    
    public Document() {}
    
	public Set<DocUser> getDocUserSet() {
		return docUserSet;
	}

	public void setDocUserSet(Set<DocUser> docUserSet) {
		this.docUserSet = docUserSet;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
    
    

}
