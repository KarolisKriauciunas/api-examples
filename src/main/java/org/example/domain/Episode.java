package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Episode {
    Long id;
    String name;
    String air_date;
    String episode;
    List<String> characters;

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                ", episode='" + episode + '\'' +
                ", characterUrls=" + characters +
                '}';
    }
}
