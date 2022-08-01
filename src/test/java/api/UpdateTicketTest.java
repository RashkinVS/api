package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Обновление тикета
 */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        Ticket closedTicket = createTicket(buildNewTicket(Status.CLOSED, 1));
        Assert.assertEquals(buildNewTicket(Status.CLOSED, 1), closedTicket, "Тикеты не совпадают");

        updateTicketNegative(closedTicket);
    }

    private void updateTicketNegative(Ticket ticket) {
        Ticket newTicket = new Ticket();
        newTicket.setStatus(1);
        given()
                .header("Authorization", "Token " + login().getToken())
                .body(newTicket)
                .pathParam("id", ticket.getId())
                .when()
                .patch("/api/tickets/{id}")
                .then()
                .statusCode(422);
    }
}
