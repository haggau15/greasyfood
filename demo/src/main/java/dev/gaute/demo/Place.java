package dev.gaute.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "place")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    private ObjectId id;
    private String name;
    private double score;
    private List<String> reviews;

}
