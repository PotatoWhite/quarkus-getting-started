package me.potato.getting.started;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import java.net.URL;
import javax.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GreetingServiceTest {

  @TestHTTPResource("/hello")          URL HELLO_URL;
  @TestHTTPResource("/hello/greeting") URL GREETING_URL;

  @Test
  public void testHelloEndPoint() {
    given().when()
           .get(HELLO_URL)
           .then()
           .statusCode(Status.OK.getStatusCode())
           .body(containsStringIgnoringCase("hello"));
  }

  @Test
  public void testGreetingEndPoint() {
    String subPath = "/testUser";

    given().when()
           .get(GREETING_URL + subPath)
           .then()
           .statusCode(Status.OK.getStatusCode())
           .body(containsStringIgnoringCase("testUser"));
  }

  @Test
  public void testBadRequest() {

    given().get("/iamdnotexist")
           .then()
           .statusCode(Status.NOT_FOUND.getStatusCode());
  }
}