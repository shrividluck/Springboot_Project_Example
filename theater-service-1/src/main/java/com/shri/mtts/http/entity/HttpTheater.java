/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.http.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.shri.mtts.entity.Theater;



@JsonInclude(value=Include.NON_NULL)
public class HttpTheater {	
	//public long id;
	
	public String Name;
	
	//public long pincode;
	

	public HttpTheater() {
		
	}

	public HttpTheater(Theater t) {
		//this.id=t.getId();
		this.Name = t.getTheaterName();
		//this.pincode = t.getPincode();
		//not setting PIN
	}
}