package org.noip2.noskamaru.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class DocUserId implements Serializable	{
	
	@ManyToOne
	private Document document;
	
	@ManyToOne
	private User user;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null || !(obj instanceof DocUserId))
	            return false;
	        DocUserId that = (DocUserId) obj;
	        if (user != null ? !user.equals(that.getUser()) : that.getUser() != null)
	            return false;
	        if (document != null ? !document.equals(that.getDocument()) : that.getDocument() != null)
	            return false;
	        return true;
	    }
	 
	    @Override
	    public int hashCode() {
	        int result;
	        result = (user != null ? user.hashCode() : 0);
	        result = 17 * result + (document != null ? document.hashCode() : 0);
	        return result;
	    }
}
