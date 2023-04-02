import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Character;
import org.example.domain.Episode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.RequestUtil;

import java.net.http.HttpResponse;

public class EpisodeTests {

    @Test
    public void shouldReturnCharacterAmountinEpisode() throws JsonProcessingException {
        String url = "https://rickandmortyapi.com/api/episode/1";
        HttpResponse<String> response = RequestUtil.getResponse(url);
        ObjectMapper mapper = new ObjectMapper();
        Episode result = mapper.readValue(response.body(),Episode.class);
        System.out.println(result);
        Assertions.assertEquals(result.getCharacters().size(), 19);
    }

    @Test
    public void TestIfEpisodeContainsASpecificCharacterByUrl() throws JsonProcessingException {
        String url = "https://rickandmortyapi.com/api/episode/1";
        HttpResponse<String> response = RequestUtil.getResponse(url);
        ObjectMapper mapper = new ObjectMapper();
        Episode result = mapper.readValue(response.body(),Episode.class);
        Character character = mapper.readValue(RequestUtil.getResponse(result.getCharacters().get(0)).body(), Character.class);
        Assertions.assertTrue(result.getCharacters().contains("https://rickandmortyapi.com/api/character/1"));
    }
//
//Easy (Characters) ->
//#Task to test 404 and 200 response
//#Task to test response equals a json file
//
//Medium (Characters) ->
//# Create the Objects of responses
//# Rewrite the second task to test objects instead of json files
//
//#Hard (Episode)
//#write all the tasks for the Episode Get endpoint
//#write a test to see if a specific character was in an episode
}
