package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddCommentPage {

    private By waitCommentLoc = By.id("footer-comment-button");
    private By btnCommentLoc = By.id("footer-comment-button");
    private By waitCommentFieldLoc = By.id("comment-wiki-edit");
    private By txtCommentLoc = By.id("comment");
    private By btnCommentOkLoc = By.id("issue-comment-add-submit");
    private By commentViewLoc = By.xpath("//*[@id='issue_actions_container']//child::*[contains(text(), 'Comment')]");
    private By btnCommentDeleteLoc = By.id("delete_comment_20325");
    private By deleteLoc = By.id("comment-delete-submit");
    private By waitFlagPopLoc = By.id("aui-flag-container");
    private By deleteTextLoc = By.xpath("//*[contains(text(), 'has been updated.')]");
    private String word = "has been updated.";

    public void clickBtnComment() { $(btnCommentLoc).shouldBe(Condition.visible).click(); }
    public void enterComment(String comment) {
        $(waitCommentFieldLoc).shouldBe(Condition.visible);
        $(txtCommentLoc).sendKeys(comment);
    }
    public void clickBtnCommentOk() {
        $(btnCommentOkLoc).click();
    }
    public boolean isCommentPresent(){
        $(commentViewLoc).shouldBe(Condition.visible);
        return $(commentViewLoc).isDisplayed();
    }
    public void clickBtnDelete() {
        $(btnCommentDeleteLoc).shouldBe(Condition.visible).click();
    }
    public void clickDeleteSubmit() {
        $(deleteLoc).shouldBe(Condition.visible).click();
    }
    public boolean isCommentDeleted() {
        $(waitFlagPopLoc).shouldBe(Condition.visible);
        return $(deleteTextLoc).getText().contains(word);
    }
}
