package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;


public class ViewTicketPage {
    private By ticketLoc = By.className("issue-link");
    private By ticketFlagLoc = By.xpath("//*[@id='type-val']");

    private String word = "WEBINAR";

    public void clickOnTicket() { $ (ticketLoc).click(); }
    public boolean isViewTicket(){
        $(ticketFlagLoc).shouldBe(Condition.visible);
        return url().contains(word);
    }
}
