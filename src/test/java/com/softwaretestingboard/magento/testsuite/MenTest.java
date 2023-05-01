package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.Pages.HomePage;
import com.softwaretestingboard.magento.Pages.MenPage;
import com.softwaretestingboard.magento.Pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenTest extends BaseTest {
    HomePage homepage = new HomePage();
    MenPage menpage = new MenPage();
    ShoppingCartPage shoppingCart = new ShoppingCartPage();


    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        homepage.mouseHoverOnMenMenu();
        homepage.mouseHoverOnBottom();
        homepage.clickOnPants();

        // Mouse Hover on product name Cronus Yoga Pant and click on size 32.
        menpage.pantSize();

        // Mouse Hover on product name Cronus Yoga Pant and click on size 32.
        menpage.pantColour();
        menpage.addToCart();
        Assert.assertEquals(menpage.verifyAddedItemToTheShoppingCart(),"You added Cronus Yoga Pant to your shopping cart.");
        menpage.clickOnShoppingCartInMessage();
        Assert.assertEquals(shoppingCart.verifyTextShoppingCart(), "Shopping Cart");
        Assert.assertEquals(shoppingCart.verifyTheProductName(), "Cronus Yoga Pant");
        Assert.assertEquals(shoppingCart.verifyTheProductSize(), "32");
        Assert.assertEquals(shoppingCart.verifyTheProductNameColour(), "Black");


    }


}
