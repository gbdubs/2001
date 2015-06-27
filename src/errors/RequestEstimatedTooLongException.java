package errors;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class RequestEstimatedTooLongException extends Exception {
	
	private String estimatedCompletionTime;
	private String message;
	
	public RequestEstimatedTooLongException(String message, long estimatedMilliseconds){
		Date estimate = new Date(System.currentTimeMillis() + estimatedMilliseconds);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY HH:MM:SS");
		estimatedCompletionTime = sdf.format(estimate);
		this.message = message;
	}
	
	public String toString(){
		return "RequestEstimatedTooLongException: estimated would be completed at " 
				+ estimatedCompletionTime + 
				".  " + message;
	}
}
