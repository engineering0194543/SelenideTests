package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddCancelTicketPage {

    private By waitLinkLoc = By.xpath("//*[@id='create_link']");
    private By btnCreateLoc = By.id("create_link");
    private By waitDescriptionLoc = By.xpath("//*[@id='summary']");
    private By txtProjectLoc = By.id("project-field");
    private By txtIssuetLoc = By.id("issuetype-field");
    private By txtSummaryLoc = By.id("summary");
    private By btnCancelLoc = By.xpath("//*[contains(text(), 'Cancel')]");

    public void clickOnCreate() {
        $(waitLinkLoc).shouldBe(Condition.visible);
        $(btnCreateLoc).click();
        $(waitDescriptionLoc).shouldBe(Condition.visible);
    }
    public void enterProject(String project) {
        $(waitDescriptionLoc).shouldBe(Condition.visible);
        $(txtProjectLoc).clear();
        $(txtProjectLoc).sendKeys(project);
    }
    public void enterIssue(String issue) {
        $(txtIssuetLoc).clear();
        $(txtIssuetLoc).sendKeys(issue);
    }
    public void enterSummary(String summary) {
        $(txtSummaryLoc).shouldBe(Condition.visible);
        $(txtSummaryLoc).clear();
        $(txtSummaryLoc).sendKeys(summary);
    }
    public void clickCancel() {
        $(btnCancelLoc).click();
    }
    public boolean isFlagPresent(){
       return $(txtSummaryLoc).isDisplayed();
    }

    public void acceptAlert(){
        Selenide.switchTo().alert().accept();
    }
}
