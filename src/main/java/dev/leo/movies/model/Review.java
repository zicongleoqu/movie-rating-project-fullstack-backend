package dev.leo.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;

    private String body;

    @Min(0)
    @Max(5)
    private Integer score;

    private LocalDateTime created;

    private LocalDateTime updated;

    public Review(String body, Integer score, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.score = score;
        this.created = created;
        this.updated = updated;
    }
}