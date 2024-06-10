package HDFC.PR;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class PR {

    Page page;
    Properties properties;

    private PR() {
    }

    //TODO Constructor
    public PR(Properties properties, Page page) {
        this.page = page;
        this.properties = properties;
    }

   public void PRCreate(){

       page.locator("//span[text()='Purchase Requisitions Infra']").click();
       Locator PRCreate = page.locator("//button[@class='mat-focus-indicator mr-2 headButton mat-raised-button mat-button-base mat-primary ng-tns-c320-7 ng-star-inserted']");
       PRCreate.first().click();
       page.locator("//body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-purchase-requisition-type[1]/mat-dialog-content[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/button[1]").click();
       Locator Location = page.locator("#mat-input-4").first();
       Location.fill(properties.getProperty("LocationCode"));




    }



}
