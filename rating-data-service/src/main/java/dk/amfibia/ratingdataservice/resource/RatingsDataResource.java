package dk.amfibia.ratingdataservice.resource;

import dk.amfibia.ratingdataservice.models.Rating;
import dk.amfibia.ratingdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("ratingsdata")
public class RatingsDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("12", 4),
                new Rating("34", 5),
                new Rating("56", 2)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setRatings(ratings);
        return userRatings;
    }

}
