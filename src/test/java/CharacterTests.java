import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Character;
import org.example.domain.CharacterStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static util.RequestUtil.debug;
import static util.RequestUtil.getResponse;

public class CharacterTests {


    @Test
    @Order(1)
    public void contentTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String url = "https://rickandmortyapi.com/api/character/1";
        HttpResponse<String> response = getResponse(url);
        Character result = mapper.readValue(response.body(), Character.class);
        Character expected = Character.builder()
                .id(1L)
                .name("Rick Sanchez")
                .gender("Male")
                .type("")
                .species("Human")
                .status(CharacterStatus.Alive)
                .build();
        debug(response);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @Order(2)
    public void shouldReturn404ResponseCode(){
        ObjectMapper mapper = new ObjectMapper();
        String url = "https://rickandmortyapi.com/api/character/9999";
        HttpResponse<String> response = getResponse(url);
        Assertions.assertEquals(response.statusCode(), 404);
    }

    @Test
    @Order(3)
    public void shouldReturn200ResponseCode(){
        ObjectMapper mapper = new ObjectMapper();
        String url = "https://rickandmortyapi.com/api/character/124";
        HttpResponse<String> response = getResponse(url);
        Assertions.assertEquals(response.statusCode(), 201);
    }

}
