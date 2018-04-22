package newscenter;

public class Feed {

    public Feed() {
    }

    private Articles[] articles;

    private String totalResults;

    private String status;

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String articlesToString = "\n";
        for(Articles a : articles) {
            articlesToString += a.toString() + "\n";
        }
        return "Feed [articles = " + articlesToString + ", totalResults = " + totalResults + ", status = " + status + "]";
    }
}