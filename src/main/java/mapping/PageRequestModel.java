package mapping;

import java.util.List;

public class PageRequestModel {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private SupportInfo support;

    @Override
    public String toString() {
        return "Page{" + "\n" +
                "page=" + page + ", \n" +
                "per_page=" + per_page + ", \n" +
                "total=" + total + ", \n" +
                "total_pages=" + total_pages + ", \n" +
                "data=" + data + ", \n" +
                "support=" + support +
                '}';
    }
}