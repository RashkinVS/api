package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Создание и проверка тикета
 */
public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        Ticket openTicket = createTicket(buildNewTicket(Status.OPEN, 1));
        Assert.assertEquals(buildNewTicket(Status.OPEN, 1), openTicket, "Тикеты не совпадают");

        Ticket getTicketOnId = getTicket(openTicket.getId());
        Assert.assertEquals(buildNewTicket(Status.OPEN, 1), getTicketOnId, "Тикеты не совпадают");
    }

    protected Ticket getTicket(int id) {
        return given()
                .header("Authorization", "Token " + login().getToken())
                .pathParam("id", id)
                .when()
                .get("/api/tickets/{id}")
                .then()
                .statusCode(200)
                .extract().body().as(Ticket.class);
    }
}
