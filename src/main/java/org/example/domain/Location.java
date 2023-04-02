package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties (ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    String name;
    String url;

}
