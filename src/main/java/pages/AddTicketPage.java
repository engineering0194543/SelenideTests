package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddTicketPage {

    private By waitLinkLoc = By.xpath("//*[@id='create_link']");
    private By btnCreateLoc = By.id("create_link");
    private By waitDescriptionLoc = By.xpath("//*[@id='summary']");
    private By txtProjectLoc = By.id("project-field");
    private By txtIssuetLoc = By.id("issuetype-field");
    private By txtDescriptionLoc = By.id("summary");
    private By btnCreateOkLoc = By.id("create-issue-submit");
    private By createFlagLoc = By.id("aui-flag-container");
    private By ticketNameLoc = By.xpath("//*[contains(text(), 'WEBINAR')]");

    public void clickOnCreate() {
        $(waitLinkLoc).shouldBe(Condition.visible);
        $(btnCreateLoc).click();
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
    public void enterDescription(String description) {
        $(txtDescriptionLoc).clear();
        $(txtDescriptionLoc).sendKeys(description);
    }
    public void clickOnCreateOK() {
        $(btnCreateOkLoc).click();
    }
    public boolean isFlagPresent(){
        $(createFlagLoc).shouldBe(Condition.visible);
        return $(createFlagLoc).isDisplayed();
    }
    public boolean isTicketNameCorrect(String word) {
       return $$(ticketNameLoc).get(0).getText().contains(word);
    }
}
