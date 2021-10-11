package de.tech26.robotfactory.acceptance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Class which is used to
 *
 * @author Tarun Rohila
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderARobotAcceptanceTest {
    @LocalServerPort
    int springBootPort;

    @Test
    public  void shouldOrderArobot() {
        postOrder("{ \"components\": [\"I\",\"A\",\"D\",\"F\"] }"
        ).then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .body("order_id", notNullValue())
                .body("total", equalTo(160.11f));
    }

    @Test
    public  void shouldNotAllowInvalidBody() {
        postOrder("{ \"components\": \"BENDER\" }"
        ).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public  void shouldNotAllowInvalidRobotConfiguration() {
        postOrder("{ \"components\": [\"A\",\"C\",\"I\",\"D\"] }"
        ).then()
                .assertThat()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    private Response postOrder(String body) {
        return RestAssured
                .given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .port(springBootPort)
                .post("/orders");
    }
}
