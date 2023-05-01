package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.Pages.GearPage;
import com.softwaretestingboard.magento.Pages.HomePage;
import com.softwaretestingboard.magento.Pages.OvernightDuffle;
import com.softwaretestingboard.magento.Pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends BaseTest {
    HomePage homePage = new HomePage();
    GearPage gearPage = new GearPage();
    ShoppingCartPage shoppingcartPage = new ShoppingCartPage();
    OvernightDuffle overnightDuffle = new OvernightDuffle();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        homePage.mouseHoverOnGearMenu();
        homePage.clickOnBags();
        // Click on Product Name ‘Overnight Duffle’
        gearPage.clickOnBagProductName();
        // Verify the text ‘Overnight Duffle’
        Assert.assertEquals(overnightDuffle.verifyTheTextOvernightDuffle(), "Overnight Duffle");
        // Change Qty 3
       overnightDuffle.changeBagQuantity();
        // Click on ‘Add to Cart’ Button.
        overnightDuffle.clickOnAddToCartButton();
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(overnightDuffle.verifyTextYouAdded_ProductNameMessage(), "You added Overnight Duffle to your shopping cart.");
        // Click on Product Name ‘Overnight Duffle’
        overnightDuffle.clickOnShoppingCartInToMessage();
        // Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(shoppingcartPage.verifyTheBagProductName(), "Overnight Duffle");
        //Verify the Qty is ‘3’
        Assert.assertEquals(shoppingcartPage.verifyTheProductQuantity(), "3");

        // Verify the product price ‘$135.00’
        Assert.assertEquals(shoppingcartPage.verifyTheProductPrice(), "$135.00");
        // Change Qty to ‘5’
        shoppingcartPage.changeShoppingCartQuantity();
        // Click on ‘Update Shopping Cart’ button
        shoppingcartPage.updateShoppingCartButton();
        // Verify the product price ‘$225.00’
        Assert.assertEquals(shoppingcartPage.verifyTheFinalProductPrice(), "$225.00");





    }


}
