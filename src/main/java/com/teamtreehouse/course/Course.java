package com.teamtreehouse.course;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity{

    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    private String url;

    // When course gets deleted, it deletes associated reviews (cascading)
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course() {
        super();
        reviews = new ArrayList<>();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviews.add(review);
    }

    // Don't want users to know the ID, so we keep that in separate constructor
    public Course(String title, String url) {
        this(); // Calls Course() constructor, thus initializing id
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}