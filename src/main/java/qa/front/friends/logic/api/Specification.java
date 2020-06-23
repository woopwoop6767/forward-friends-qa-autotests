package qa.front.friends.logic.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import qa.front.friends.logic.GetEnv;

public interface Specification extends GetEnv {


    default RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setContentType(ContentType.JSON)
                .setBaseUri("https://agent-front-ag-test.forward.lc/")
                .build()
                ;
    }

//    default RequestSpecification getRequestSpecificationWhp(String path) {
//        return getRequestSpecification(getPropFromFile("baseUriDev"), path);
//    }

    default ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build()
                ;
    }
}
