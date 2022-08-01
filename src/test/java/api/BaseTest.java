package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.AuthToken;
import model.Status;
import model.Ticket;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/**
 * Абстрактный класс, содержащий общие для всех тестов методы
 */
public abstract class BaseTest {
    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));

        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.filters(new ResponseLoggingFilter());
    }

    protected AuthToken login() {
        AuthToken login = new AuthToken();
        login.setUsername(System.getProperty("username"));
        login.setPassword(System.getProperty("password"));
        return given()
                .body(login)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .extract().body().as(AuthToken.class);
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        Ticket newTicket = new Ticket();
        newTicket.setDue_date("2022-07-09");
        newTicket.setAssigned_to(System.getProperty("username"));
        newTicket.setTitle("someTitle");
        newTicket.setCreated("2022-07-09T11:18:34.467Z");
        newTicket.setModified("2022-07-09T11:18:34.467Z");
        newTicket.setSubmitter_email("user@example.com");
        newTicket.setStatus(status.getCode());
        newTicket.setOn_hold(true);
        newTicket.setDescription("someDescription");
        newTicket.setResolution("someResolution");
        newTicket.setPriority(priority);
        newTicket.setSecret_key("someSecretKey");
        newTicket.setQueue(2);
        newTicket.setKbitem(2);
        newTicket.setMerged_to(2);
        return newTicket;
    }

    protected Ticket createTicket(Ticket ticket) {
        return given()
                .body(ticket)
                .when()
                .post("/api/tickets")
                .then()
                .statusCode(201)
                .extract().body().as(Ticket.class);
    }
}
