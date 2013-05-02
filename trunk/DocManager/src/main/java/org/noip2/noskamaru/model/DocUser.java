package org.noip2.noskamaru.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;


@Entity
@AssociationOverrides({
	@AssociationOverride(name="pk.document", joinColumns = @JoinColumn(name = "doc_id")),
	@AssociationOverride(name="pk.user", joinColumns = @JoinColumn(name = "user_id"))
})
public class DocUser {
	
	@EmbeddedId
	private DocUserId pk = new DocUserId();
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "line")
	private int line;

	public DocUserId getPk() {
		return pk;
	}

	public void setPk(DocUserId pk) {
		this.pk = pk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}
	
	 @Transient
	    public Document getDocument() {
	        return pk.getDocument();
	    }
	 
	    public void setDocument(final Document document) {
	        pk.setDocument(document);
	    }
	 
	    @Transient
	    public User getUser() {
	        return pk.getUser();
	    }
	 
	    public void setUser(final User user) {
	        pk.setUser(user);
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null || !(obj instanceof DocUser))
	            return false;
	        DocUser other = (DocUser) obj;
	        if (pk != null ? !pk.equals(other.getPk()) : other.getPk() != null)
	            return false;
	        return true;
	    }
	 
	    @Override
	    public int hashCode() {
	        return (pk != null ? pk.hashCode() : 0);
	    }
}
