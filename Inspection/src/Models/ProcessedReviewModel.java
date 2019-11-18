package Models;

public class ProcessedReviewModel {

	 	String review_id;
	    String user_id;
	    String business_id;
	    Integer stars;
	    
	    

	    public ProcessedReviewModel() {
			super();
		}

		public ProcessedReviewModel(String review_id, String user_id, String business_id, Integer stars) {
	        this.review_id = review_id;
	        this.user_id = user_id;
	        this.business_id = business_id;
	        this.stars = stars;
	    }

	    public String getReview_id() {
	        return review_id;
	    }

	    public void setReview_id(String review_id) {
	        this.review_id = review_id;
	    }

	    public String getUser_id() {
	        return user_id;
	    }

	    public void setUser_id(String user_id) {
	        this.user_id = user_id;
	    }

	    public String getBusiness_id() {
	        return business_id;
	    }

	    public void setBusiness_id(String business_id) {
	        this.business_id = business_id;
	    }

	    public Integer getStars() {
	        return stars;
	    }

	    public void setStars(Integer stars) {
	        this.stars = stars;
	    }
}
