package com.jpa.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
//@JsonIgnoreProperties(value= {"reviews"})
@JsonIgnoreProperties(value= {"students"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    /**
     *  @JoinColumn(name = "course_id")
     *  will tell hibernate to look into Review Table course_id column for mapping.
     *
     *  The JoinColumn is actually fairly complex and it goes through a number of advanced steps to find the desired column.
     *  The table in which it is found depends upon the context.
     *
     * - If the join is for a OneToOne or ManyToOne mapping using a foreign key mapping strategy, the foreign key column
     *   is in the table of the source entity or embeddable.
     *
     * - If the join is for a unidirectional OneToMany mapping using a foreign key mapping strategy, the foreign key
     *   is in the table of the target entity.
     *
     * - If the join is for a ManyToMany mapping or for a OneToOne or bidirectional ManyToOne/OneToMany mapping using a join table,
     * the foreign key is in a join table.
     *
     * - If the join is for an element collection, the foreign key is in a collection table.
     *
     * --
     *
     * So as you can see, it depends on the context.
     *
     * In our training video, we are using @OneToMany uni-directional (course has one-to-many reviews).
     *
     * As a result, the join column / foreign key column is in the target entity. In this case, the target entity is the Review class.
     * So, you will find the join column "course_id" in the "review" table.
     */
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Convenience method for uni-directional link
     * @param review
     */
    public void addReview(Review review){
        if(reviews == null){
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }

    public void addStudent(Student student){
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
