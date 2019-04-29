package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class DashboardPage {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private PageElement productContainer = new PageElement("Product container", FindBy.id("inventory_container"));
    private PageElement addToCartBackPack = new PageElement("Add to Cart Backpack", FindBy.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
    private PageElement shoppingCartCount = new PageElement("Shopping cart count", FindBy.className("shopping_cart_badge"));
    private PageElement backBackInCart = new PageElement("Back Pack in the cart", FindBy.xpath("//*[@id=\"item_4_title_link\"]/div"));

    public boolean productContainerIsVisible() {

        return UIThreadManager.getBrowser().exists(productContainer);
    }

    public void backPack() {
        UIThreadManager.getBrowser().click(addToCartBackPack);
        String cartCount = UIThreadManager.getBrowser().getText(shoppingCartCount);
        Assert.assertEquals(cartCount, "1", "Cart count was not 1");
    }

    public void GoToTheShoppingCart() {
        UIThreadManager.getBrowser().click(shoppingCartCount);
    }

    public String getBackPackInShoppingCartText() {
        return UIThreadManager.getBrowser().getText(backBackInCart);
    }
}

