package qa.front.friends.logic.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import qa.front.friends.logic.GetEnv;

public interface Specification extends GetEnv {


    default RequestSpecification getRequestSpecification(String url, String path) {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .setBasePath(path)
                .build()
                ;
    }

    default RequestSpecification getRequestSpecification(String url) {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .build()
                ;
    }

    default RequestSpecification getRequestSpecificationWhp(String path) {
        return getRequestSpecification(getPropFromFile("baseUriDev"), path);
    }

    default ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build()
                ;
    }
}
