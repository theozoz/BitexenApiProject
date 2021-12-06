package steps;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class StepImplementation {


    public StepImplementation()
    {

    }

    @Step("Get request to endpoint")
    public void getRequestEndpoint()
    {
        int  status=200;
        Response response=given().
                when().
                get("https://generator.swagger.io/api/gen/clients").
                then().
                extract().
                response();
        Assert.assertEquals("Beklenen sonuç ve gerçekleşen sonuç birbirine eşit değil",status,response.getStatusCode());
    }


    @Step("Post request to endpoint")
    public void postRequestEndpoint()
    {
        //post için body bilgileri verilmediği için sadece bu şekilde istek atılmıştır
        int  status=200;
        String responseBody="{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\",\n" +
                "    \"urlMatcher\": {}\n" +
                "  },\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}";
        Response response = given()
            .header("Content-type", "application/json")
            .and()
            .body(responseBody)
            .when()
            .post("https://generator.swagger.io/api/gen/clients/go")
            .then()
            .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }
}
